package model.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class ChooseFirstChampionsController implements ActionListener {
	Game game;
	ChooseChampionsView ChooseChampionsView;
	ArrayList<JButton> btnsChampions;
	int i = 0;
	public ChooseFirstChampionsController(String playerOneName, String playerTwoName) throws IOException {
		Player p1 = new Player(playerOneName);
		Player p2 = new Player(playerTwoName);
		game = new Game(p1, p2);
		game.loadAbilities("Abilities.csv");
		game.loadChampions("Champions.csv");

		ChooseChampionsView = new ChooseChampionsView(playerOneName);
		btnsChampions = new ArrayList<>();

		for (final Champion champion : game.getAvailableChampions()) {
			JButton btnChampion = new JButton(champion.getName());
			btnChampion.addActionListener(this);
			ChooseChampionsView.addChampion(btnChampion);
			btnsChampions.add(btnChampion);
		}

	}

	
	public void actionPerformed(ActionEvent e) {
		JButton btnChampion = (JButton) e.getSource();
		int ChampionIndex = btnsChampions.indexOf(btnChampion);
		Champion champion = game.getAvailableChampions().get(ChampionIndex);
		int choice = JOptionPane.showConfirmDialog(null, champion.toString(), "Add Champion", 0);
		if (choice == 0) {
			btnChampion.setVisible(false);
			game.getFirstPlayer().getTeam().add(champion);			
			i++;
			if (i > 2) {
				ChooseChampionsView.setVisible(false);
				for(int i=0;i<game.getFirstPlayer().getTeam().size();i++) {
					 game.getAvailableChampions().remove(game.getFirstPlayer().getTeam().get(i));
				}
				FirstLeader first = new FirstLeader(game);				
			}	
		}
	}

}
