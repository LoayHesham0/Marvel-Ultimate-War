package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class ChooseChampionsView extends JFrame {
	JLabel text1;
	JPanel name;
	JPanel champions;	
	String data;
	public ChooseChampionsView(String name1) throws IOException {
		super();
		setSize(800, 600);
    	setLocation(250,100);
    	setLayout(null);
    	setResizable(false);
    	setTitle("Marvel");
    	setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                        
        text1 = new JLabel(name1);
		text1.setBounds(300,0,500,50);
		text1.setBackground(Color.blue);
		add(text1);
        
	       
        champions = new JPanel();
        champions.setBounds(0,50,785,520);
        champions.setLayout(new GridLayout(3,5));
        add(champions);
	   				
        this.revalidate();
		this.repaint();
	}
	
	public void addChampion(JButton Champion) {
		champions.add(Champion);
	}
			
}