import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Labib
 * Class For Menu and Modes
 * 
 */
public class Play extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2856119320522263835L;
	private JButton startEasyButton, startMediumButton, quitButton;
    public Play() {
        setTitle("15 Puzzle Game Menu");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));
     // Create Start button
        startEasyButton = new JButton("Text Mode");
        startEasyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(0);
            }
        });
        add(startEasyButton);
        
     // Create Start button
        startMediumButton = new JButton("Button Mode");
        startMediumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(1);
            }
        });
        add(startMediumButton);
        
     // Create Quit button
        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });
        add(quitButton);
    }

    private void startGame(int x) {
    	if(x==0) {
    	Main main = new Main();
        SwingUtilities.invokeLater(() -> {
            new Grid();
        });
        main.Start();
    	}
    	else if(x==1) {
            Main main = new Main();
            SwingUtilities.invokeLater(() -> {
                new GridButtons();
            });
        main.Start();
    	}
    }
}
