import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridLogos extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = -637265566064585749L;
	private JButton[][] gridButtons;
    private JButton doneButton, startButton, cheatButton, quitButton;
    private Main main;
    private Game myGame;

    public GridLogos() {
        main = new Main();
        myGame = new Game(main);
        setTitle("15 Puzzle");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 4));

        gridButtons = new JButton[4][4];

        // Initialize grid buttons with images according to the game board
        initializeGrid();

        startButton = new JButton("Random");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.Start();
                updateGrid();
            }
        });
        add(startButton);

        doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean gameResult = myGame.gameRules();
                if (!gameResult) {
                    JOptionPane.showMessageDialog(GridLogos.this, "Failed, Try Again!");
                } else {
                    JOptionPane.showMessageDialog(GridLogos.this, "Solved!");
                }
            }
        });
        add(doneButton);

        cheatButton = new JButton("Cheat");
        cheatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.cheatList();
                updateGrid();
            }
        });
        add(cheatButton);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(quitButton);

        setVisible(true);
    }

    private void initializeGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = main.getData(i * 4 + j); // Get number from the board
                String imagePath = "C:\\Users\\labib\\git\\repository4\\15 Puzzle\\src\\Numbers Lavender\\" + number + ".jpeg";
                ImageIcon icon = new ImageIcon(imagePath);
                Image originalImage = icon.getImage();
                Image scaledImage = originalImage.getScaledInstance(145, 130, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                gridButtons[i][j] = new JButton(scaledIcon);
                gridButtons[i][j].addActionListener(new ButtonClickListener(i, j)); // Pass grid coordinates to identify the button
                add(gridButtons[i][j]);
            }
        }
    }

    private void updateGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = main.getData(i * 4 + j);
                String imagePath = "C:\\Users\\labib\\git\\repository4\\15 Puzzle\\src\\Numbers Lavender\\" + number + ".jpeg";
                ImageIcon icon = new ImageIcon(imagePath);
                Image originalImage = icon.getImage();
                Image scaledImage = originalImage.getScaledInstance(145, 130, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                gridButtons[i][j].setIcon(scaledIcon);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            int clickedValue = main.getData(row * 4 + col);
            Main.Node clickedNode = main.findNode(clickedValue);
            Main.Node zeroNode = main.findNode(0);
            int zeroIndex = main.findIndex(0);
            int nodeIndex = main.findIndex(clickedNode.data);

            if (myGame.isValidMove(zeroIndex, nodeIndex)) {
                int temp = clickedNode.data;
                clickedNode.data = zeroNode.data;
                zeroNode.data = temp;
                updateGrid();
            } else {
                JOptionPane.showMessageDialog(GridLogos.this, "Action not Allowed");
            }
        }
    }
}
