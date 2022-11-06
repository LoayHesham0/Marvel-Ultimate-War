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

public class ChooseSecondChampionsController implements ActionListener {
	Game game;
	ChooseChampionsView ChooseChampionsView;
	ArrayList<JButton> btnsChampions;
	int i = 0;
	String playerTwoName;
	public ChooseSecondChampionsController(Game game) throws IOException {
		this.game=game;
		playerTwoName = game.getSecondPlayer().getName();
		ChooseChampionsView = new ChooseChampionsView(playerTwoName);
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
			game.getSecondPlayer().getTeam().add(champion);			
			i++;
			if (i > 2) {
				ChooseChampionsView.setVisible(false);
				for(int i=0;i<game.getSecondPlayer().getTeam().size();i++) {
					 game.getAvailableChampions().remove(game.getSecondPlayer().getTeam().get(i));
				}
				SecondLeader second = new SecondLeader(game);
			}	
		}
	}

}
