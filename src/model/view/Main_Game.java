package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import engine.Game;

public class Main_Game extends JFrame {
	JPanel board;
	JPanel Info;
	JPanel players;
	JPanel PlayerOne;
	JPanel PlayerOneChampions;
	JPanel PlayerOneData;
	JPanel PlayerTwo;
	JPanel PlayerTwoChampions;
	JPanel PlayerTwoData; 
	JLabel PlayerOneDataLabelOne;
	JLabel PlayerOneDataLabelTwo;
	JTextArea playerOneChampionsChampionOne;
	JTextArea playerOneChampionsChampionTwo;
	JTextArea playerOneChampionsChampionThree;
	JLabel PlayerTwoDataLabelOne;
	JLabel PlayerTwoDataLabelTwo;
	JTextArea playerTwoChampionsChampionOne;
	JTextArea playerTwoChampionsChampionTwo;
	JTextArea playerTwoChampionsChampionThree;	
	JScrollPane scrollv1;
	JScrollPane scrollv2;
	JScrollPane scrollv3;
	JScrollPane scrollv11;
	JScrollPane scrollv22;
	JScrollPane scrollv33;
	JTextArea order;
	JTextArea currentChampion;
	JPanel abilities;
	JTextArea ability1;
	JTextArea ability2;
	JTextArea ability3;
	JPanel championTurn;
	JPanel championButtons;
	JButton attack;
	JButton move;
	JButton useLeaderAbility;
	JButton castAbility;
	JButton castAbilityDirectional;
	JButton castAbilitySingleTarget;
	JButton endTurn;
	JPanel gameTurns;
	JScrollPane scrollvChampion;
	public Main_Game() {
		super();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setLayout(new BorderLayout());
		setTitle("Marvel");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		board = new JPanel();
		board.setLayout(new GridLayout(5, 5));
		add(board,BorderLayout.CENTER);
		
		Info = new JPanel();
		Info.setLayout(new GridLayout(0,1));
		add(Info,BorderLayout.EAST);
		
		
		gameTurns = new JPanel();
		gameTurns.setLayout(new BorderLayout());
		Info.add(gameTurns);
		
		order = new JTextArea();
		order.setEditable(false);
		gameTurns.add(order,BorderLayout.EAST);
		
		endTurn = new JButton("End turn");
		gameTurns.add(endTurn,BorderLayout.CENTER);

		championTurn = new JPanel();
		championTurn.setLayout(new BorderLayout());
		Info.add(championTurn);
		
		currentChampion = new JTextArea();
		currentChampion.setEditable(false);
		championTurn.add(currentChampion,BorderLayout.EAST);
		
		scrollvChampion = new JScrollPane(currentChampion,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		championTurn.add(scrollvChampion,BorderLayout.EAST);
		
		championButtons = new JPanel();
		championButtons.setLayout(new GridLayout(3,2));
		championTurn.add(championButtons,BorderLayout.CENTER);
		
		attack = new JButton("attack");
		championButtons.add(attack);
		
		move = new JButton("move");
		championButtons.add(move);
		
		useLeaderAbility = new JButton("use leader ability");
		championButtons.add(useLeaderAbility);
		
		castAbility = new JButton("cast ability");
		championButtons.add(castAbility);
		
		castAbilityDirectional = new JButton("cast ability directional");
		championButtons.add(castAbilityDirectional);
		
		castAbilitySingleTarget = new JButton("cast ability singletarget");
		championButtons.add(castAbilitySingleTarget);
		
		abilities = new JPanel();
		abilities.setLayout(new GridLayout(1,0));
		Info.add(abilities);
		
		ability1 = new JTextArea();
		ability1.setEditable(false);
		abilities.add(ability1);
		
		ability2 = new JTextArea();
		ability2.setEditable(false);
		abilities.add(ability2);
		
		ability3 = new JTextArea();
		ability3.setEditable(false);
		abilities.add(ability3);
						
		players = new JPanel();
		players.setLayout(new GridLayout(2,1));
		players.setPreferredSize(getMinimumSize());
		add(players,BorderLayout.WEST);
		
		PlayerOne = new JPanel();
		PlayerOne.setLayout(new BorderLayout());
		players.add(PlayerOne);
		
		PlayerOneData = new JPanel();
		PlayerOneData.setLayout(new GridLayout(0,1));
		PlayerOne.add(PlayerOneData,BorderLayout.NORTH);
		
		PlayerOneDataLabelOne = new JLabel();
		PlayerOneData.add(PlayerOneDataLabelOne);
		
		PlayerOneDataLabelTwo = new JLabel();
		PlayerOneData.add(PlayerOneDataLabelTwo);
		
		PlayerOneChampions = new JPanel();
		PlayerOneChampions.setLayout(new GridLayout(1,0));
		PlayerOne.add(PlayerOneChampions,BorderLayout.CENTER);
		
		playerOneChampionsChampionOne = new JTextArea();
		playerOneChampionsChampionOne.setEditable(false);
		PlayerOneChampions.add(playerOneChampionsChampionOne);
		
		playerOneChampionsChampionTwo = new JTextArea();
		playerOneChampionsChampionTwo.setEditable(false);
		PlayerOneChampions.add(playerOneChampionsChampionTwo);
		
		playerOneChampionsChampionThree = new JTextArea();
		playerOneChampionsChampionThree.setEditable(false);
		PlayerOneChampions.add(playerOneChampionsChampionThree);
		
		scrollv11 = new JScrollPane(playerOneChampionsChampionOne,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		PlayerOneChampions.add(scrollv11);
		
		scrollv22 = new JScrollPane(playerOneChampionsChampionTwo,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		PlayerOneChampions.add(scrollv22);
		
		scrollv33 = new JScrollPane(playerOneChampionsChampionThree,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		PlayerOneChampions.add(scrollv33);
			
		PlayerTwo = new JPanel();
		PlayerTwo.setLayout(new BorderLayout());
		players.add(PlayerTwo);
		
		PlayerTwoData = new JPanel();
		PlayerTwoData.setLayout(new GridLayout(0,1));
		PlayerTwo.add(PlayerTwoData,BorderLayout.NORTH);
		
		PlayerTwoDataLabelOne = new JLabel();
		PlayerTwoData.add(PlayerTwoDataLabelOne);
		
		PlayerTwoDataLabelTwo = new JLabel();
		PlayerTwoData.add(PlayerTwoDataLabelTwo);
				
		PlayerTwoChampions = new JPanel();
		PlayerTwoChampions.setLayout(new GridLayout(1,0));
		PlayerTwo.add(PlayerTwoChampions,BorderLayout.CENTER);
		
		playerTwoChampionsChampionOne = new JTextArea();
		playerTwoChampionsChampionOne.setEditable(false);
		PlayerTwoChampions.add(playerTwoChampionsChampionOne);
		
		playerTwoChampionsChampionTwo = new JTextArea();
		playerTwoChampionsChampionTwo.setEditable(false);
		PlayerTwoChampions.add(playerTwoChampionsChampionTwo);
		
		playerTwoChampionsChampionThree = new JTextArea();
		playerTwoChampionsChampionThree.setEditable(false);
		PlayerTwoChampions.add(playerTwoChampionsChampionThree);
		
		scrollv1 = new JScrollPane(playerTwoChampionsChampionOne,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		PlayerTwoChampions.add(scrollv1);
		
		scrollv2 = new JScrollPane(playerTwoChampionsChampionTwo,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		PlayerTwoChampions.add(scrollv2);
		
		scrollv3 = new JScrollPane(playerTwoChampionsChampionThree,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		PlayerTwoChampions.add(scrollv3);
		
		this.revalidate();
		this.repaint();
	}

}
