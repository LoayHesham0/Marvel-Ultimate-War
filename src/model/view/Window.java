package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener{
	JPanel firstPanel;
	JButton startButton;
	JButton rulesButton;	
    public Window() throws IOException, InterruptedException{
    	super(); 
    	setSize(800, 600);
    	setLayout(new FlowLayout(FlowLayout.CENTER,100,225));
    	setLocation(250,100);
    	setResizable(false);
    	setTitle("Marvel");
    	setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         	      
		startButton = new JButton("Start Game");
		startButton.setPreferredSize(new Dimension(150,100));
		startButton.addActionListener(this);
		add(startButton);	
		
		rulesButton = new JButton("Game Rules");
		rulesButton.setPreferredSize(new Dimension(150,100));
		rulesButton.addActionListener(this);
		add(rulesButton);  
			
        this.revalidate();
        this.repaint();  
    }
    
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start Game")) {
			this.setVisible(false);
	        gameView g = new gameView();
		}
		else{
			JOptionPane.showMessageDialog(null,"Marvel: Ultimate War is a 2 player battle game. Each player picks 3 champions to form his team\r\n"
					+ "and fight the other player’s team. The players take turns to fight the other player’s champions.\r\n"
					+ "The turns will keep going back and forth until a player is able to defeat all of the other player’s\r\n"
					+ "champions which will make him the winner of the battle.\r\n");
		}		
	}
	
	public static void main(String [] args) throws IOException, InterruptedException {
		Window w = new Window();
		
	}
}
