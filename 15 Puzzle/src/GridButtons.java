import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 
 * @author Labib
 * CLass for Button Mode Layout
 */
public class GridButtons extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2848022455804918821L;
	private JButton[][] gridButtons;
    private JButton doneButton, startButton, cheatButton, quitButton;
    private Main main;
    private Game myGame;

    public GridButtons() {
        main = new Main();
        myGame = new Game(main);
        setTitle("15 Puzzle");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 4));

        gridButtons = new JButton[4][4];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gridButtons[i][j] = new JButton(String.valueOf(main.getData(count)));
                gridButtons[i][j].addActionListener(new ButtonClickListener(i,j));
                add(gridButtons[i][j]);
                count++;
            }
        }

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
                    JOptionPane.showMessageDialog(GridButtons.this, "Failed, Try Again!");
                } else {
                    JOptionPane.showMessageDialog(GridButtons.this, "Solved!");
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

    private void updateGrid() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gridButtons[i][j].setText(String.valueOf(main.getData(count)));
                count++;
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
                JOptionPane.showMessageDialog(GridButtons.this, "Action not Allowed");
            }
        }
    }
}
