import javax.swing.*;
//import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class Grid extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8885100601854879830L;
	
	private JTextField[][] grid;
    private JButton doneButton, startButton, cheatButton, quitButton;
    private Main main;
    private Game myGame;

	public Grid() {
		main = new Main(); // Create instance of Main class
        myGame = new Game(main); // Create instance of Game class with Main instance
        setTitle("15 Puzzle");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 4));

        grid = new JTextField[4][4];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = new JTextField(String.valueOf(main.getData(count)));
                grid[i][j].setHorizontalAlignment(JTextField.CENTER);
                grid[i][j].setEditable(true);
                grid[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTextField textField = (JTextField) e.getSource();
                        Main.Node clickedNode = main.findNode(Integer.parseInt(textField.getText()));
                        applyChanges(clickedNode);
                    }
                });
                add(grid[i][j]);
                count++;
            }
        }
     // Create Start button
        startButton = new JButton("Random");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.Start();
                updateGrid();
            }
        });
        add(startButton);
        
     // Done button
        doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(myGame.checkGameRules());
                main.printList();
                boolean gameResult = myGame.gameRules();
                if (!gameResult) {
                    JOptionPane.showMessageDialog(Grid.this, "Failed, Try Again!");
                } else {
                    JOptionPane.showMessageDialog(Grid.this, "Solved!");
                }
            }
        });
        add(doneButton);
        
     // Create Cheat button
        cheatButton = new JButton("Cheat");
        cheatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.cheatList(); //Cheat button to check work is working
                updateGrid();
            }
        });
        add(cheatButton);
        
     // Create Quit button
        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });
        add(quitButton);
        
        setVisible(true);
	}
	/**
	 * Update Grid after making changes in the Board.
	 */
	private void updateGrid() {
		int count = 0;
		for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            grid[i][j].setText(String.valueOf(main.getData(count)));
	            count++; // Move to the next node
	        }
	    }
    }
	/**
	 * Update Board after making changes in the Grid.
	 */
	private void applyChanges(Main.Node node) {
		if(node == null) return;
		Main.Node zeroNode = main.findNode(0);
		int zeroIndex = main.findIndex(0);
		int nodeIndex = main.findIndex(node.data);
		
        if (myGame.isValidMove(zeroIndex, nodeIndex)) {
            int temp = node.data;
            node.data = zeroNode.data;
            zeroNode.data = temp;
            updateGrid();
        } else {
            JOptionPane.showMessageDialog(this, "Action not Allowed");
        }
	}
	
	public static void main (String[] args) {
		SwingUtilities.invokeLater(() -> {
            new Grid();
        });
	}
}
