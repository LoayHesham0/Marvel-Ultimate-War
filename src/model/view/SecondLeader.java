package model.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Game;

public class SecondLeader extends JFrame implements ActionListener{
	Game game;
	JLabel text1;
	JButton Champion1Button;
	JButton Champion2Button;
	JButton Champion3Button;
	String FirstChampion;
	String SecondChampion;
	String ThirdChampion;
	public SecondLeader(Game game)  {
		super(); 
		this.game=game;		
    	setSize(800, 600);
    	setLayout(null);
    	setLocation(250,100);
    	setResizable(false);
    	setTitle("Marvel");
    	setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        FirstChampion=game.getSecondPlayer().getTeam().get(0).getName();
        SecondChampion=game.getSecondPlayer().getTeam().get(1).getName();
        ThirdChampion=game.getSecondPlayer().getTeam().get(2).getName();
        
        JLabel text1 = new JLabel("Choose Second Player Leader :");
        text1.setBounds(10,200,200,100);
      	add(text1);
        
        Champion1Button = new JButton(FirstChampion);
        Champion1Button.setBounds(230,200,100,100);
        Champion1Button.addActionListener(this);
        Champion1Button.setActionCommand(FirstChampion);
		add(Champion1Button);	
		
		Champion2Button = new JButton(SecondChampion);
		Champion2Button.setBounds(450,200,100,100);
		Champion2Button.addActionListener(this);
		Champion2Button.setActionCommand(SecondChampion);
		add(Champion2Button);  
		
		Champion3Button = new JButton(ThirdChampion);
		Champion3Button.setBounds(670,200,100,100);
		Champion3Button.addActionListener(this);
		Champion3Button.setActionCommand(ThirdChampion);
		add(Champion3Button); 
			
        this.revalidate();
        this.repaint();  
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(FirstChampion)) {
			game.getSecondPlayer().setLeader(game.getSecondPlayer().getTeam().get(0));
		}
		else if(e.getActionCommand().equals(SecondChampion)) {
			game.getSecondPlayer().setLeader(game.getSecondPlayer().getTeam().get(1));
		}
		else {
			game.getSecondPlayer().setLeader(game.getSecondPlayer().getTeam().get(2));
		}
		setVisible(false);
		Main_Game_Controller window = new Main_Game_Controller(new Game(game.getFirstPlayer(),game.getSecondPlayer()));
		
	}
}	
	