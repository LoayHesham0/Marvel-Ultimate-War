package model.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Player;

public class Final_Game extends JFrame {
	Player player;

	JLabel Win;
	public Final_Game(Player player) {
		super(); 
		this.player=player;
    	setSize(800, 600);
    	setLayout(new FlowLayout(FlowLayout.CENTER,100,225));
    	setLocation(250,100);
    	setResizable(false);
    	setTitle("Marvel");
    	setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
        Win = new JLabel(player.getName()+", congrates!!!!");
		Win.setPreferredSize(new Dimension(150,100));
		add(Win);  
			
        this.revalidate();
        this.repaint();
	}
	
}
