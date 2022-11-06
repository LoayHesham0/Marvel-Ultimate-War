package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gameView extends JFrame implements  ActionListener  {
	JLabel text1;
	JLabel text2;
	JTextField textField1;
	JTextField textField2;
	JButton startButton;
	String playerOneName = "";
	String playerTwoName = "";
	public gameView() {
		super();
		setSize(800, 600);
    	setLocation(250,100);
    	setLayout(null);
    	setResizable(false);
    	setTitle("Marvel");
    	setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        		
		JLabel text1 = new JLabel("Enter First Player name :");
		text1.setBounds(200,80,150,100);
		add(text1);
		
		textField1 = new JTextField();
		textField1.setBounds(380,110,150,50);
		add(textField1);


		JLabel text2 = new JLabel("Enter Second Player name :");
		text2.setBounds(200,140,170,100);
		add(text2);

		textField2 = new JTextField();
		textField2.setBounds(380,170,150,50);
		add(textField2);
		
		JButton startButton = new JButton("Choose Champions");
		startButton.setBounds(320,250,150,100);
		startButton.addActionListener(this);
		add(startButton);

		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		playerOneName = textField1.getText();
		playerTwoName = textField2.getText();
		if (playerOneName.equals("") || playerTwoName.equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Your Name.", null, JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				ChooseFirstChampionsController c = new ChooseFirstChampionsController(playerOneName,playerTwoName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.setVisible(false);
		}		
	}
	
}
