package model.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.effects.Disarm;
import model.effects.Effect;
import model.world.*;

public class Main_Game_Controller implements ActionListener {
	Game game;
	Main_Game Main_Game_View;
	Object[][] board;
	Cell[][] Board;
	String firstleaderName;
	String secondleaderName;

	public Main_Game_Controller(Game game) {
		Main_Game_View = new Main_Game();
		this.game = game;
		board = game.getBoard();
		Board = new Cell[5][5];
		firstleaderName = game.getFirstPlayer().getLeader().getName();
		secondleaderName = game.getSecondPlayer().getLeader().getName();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] instanceof Damageable) {
					if (board[i][j] instanceof Cover) {
						Cover cover = (Cover) board[i][j];
						Board[i][j] = new Cell("Cover: " + cover.getCurrentHP());
						Board[i][j].setFocusable(false);
						Main_Game_View.board.add(Board[i][j]);
					} else {
						Champion c = (Champion) board[i][j];
						Board[i][j] = new Cell(c.getName());
						Board[i][j].setFocusable(false);
						Main_Game_View.board.add(Board[i][j]);
					}
				} else {
					Board[i][j] = new Cell("     ");
					Board[i][j].setFocusable(false);
					Main_Game_View.board.add(Board[i][j]);
				}
			}
		}
		addData(game, Main_Game_View, firstleaderName, secondleaderName);

		Main_Game_View.attack.addActionListener(this);
		Main_Game_View.attack.setActionCommand("attack");

		Main_Game_View.move.addActionListener(this);
		Main_Game_View.move.setActionCommand("move");

		Main_Game_View.useLeaderAbility.addActionListener(this);
		Main_Game_View.useLeaderAbility.setActionCommand("useLeaderAbility");

		Main_Game_View.castAbility.addActionListener(this);
		Main_Game_View.castAbility.setActionCommand("castAbility");

		Main_Game_View.castAbilityDirectional.addActionListener(this);
		Main_Game_View.castAbilityDirectional.setActionCommand("castAbilityDirectional");

		Main_Game_View.castAbilitySingleTarget.addActionListener(this);
		Main_Game_View.castAbilitySingleTarget.setActionCommand("castAbilitySingleTarget");

		Main_Game_View.endTurn.addActionListener(this);
		Main_Game_View.endTurn.setActionCommand("endTurn");

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("move")) {
			String[] buttons = { "Right", "Left", "Down", "Up" };
			int choice = JOptionPane.showOptionDialog(null, "Which Direction you want to move?", "Choose a Direction",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);
			if (choice == 0) {
				try {
					game.move(Direction.RIGHT);
					Main_Game_View.setVisible(false);
					Main_Game_Controller g = new Main_Game_Controller(game);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
				}
			} else if (choice == 1) {
				try {
					game.move(Direction.LEFT);
					Main_Game_View.setVisible(false);
					Main_Game_Controller g = new Main_Game_Controller(game);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
				}
			} else if (choice == 2) {
				try {
					game.move(Direction.UP);
					Main_Game_View.setVisible(false);
					Main_Game_Controller g = new Main_Game_Controller(game);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
				}
			} else if (choice == 3) {
				try {
					game.move(Direction.DOWN);
					Main_Game_View.setVisible(false);
					Main_Game_Controller g = new Main_Game_Controller(game);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
				}
			}

		} else if (e.getActionCommand().equals("attack")) {
			String[] buttons = { "Right", "Left", "Down", "Up" };
			int choice = JOptionPane.showOptionDialog(null, "Which Direction you want to move?", "Choose a Direction",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);
			if (choice == 0) {
				try {
					game.attack(Direction.RIGHT);
					Main_Game_View.setVisible(false);
					Main_Game_Controller g = new Main_Game_Controller(game);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
				}
			} else if (choice == 1) {
				try {
					game.attack(Direction.LEFT);
					Main_Game_View.setVisible(false);
					Main_Game_Controller g = new Main_Game_Controller(game);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
				}
			} else if (choice == 2) {
				try {
					game.attack(Direction.UP);
					Main_Game_View.setVisible(false);
					Main_Game_Controller g = new Main_Game_Controller(game);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
				}
			} else if (choice == 3) {
				try {
					game.attack(Direction.DOWN);
					Main_Game_View.setVisible(false);
					Main_Game_Controller g = new Main_Game_Controller(game);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
				}
			}

		} else if (e.getActionCommand().equals("castAbility")) {
			ArrayList<Ability> buttonsAL = new ArrayList<Ability>();
			for (int i = 0; i < game.getCurrentChampion().getAbilities().size(); i++) {
				if (game.getCurrentChampion().getAbilities().get(i).getCastArea().equals(AreaOfEffect.SELFTARGET)
						|| game.getCurrentChampion().getAbilities().get(i).getCastArea().equals(AreaOfEffect.SURROUND)
						|| game.getCurrentChampion().getAbilities().get(i).getCastArea()
								.equals(AreaOfEffect.TEAMTARGET)) {
					buttonsAL.add(game.getCurrentChampion().getAbilities().get(i));
				}
			}
			String[] buttons = new String[buttonsAL.size()];
			for (int i = 0; i < buttonsAL.size(); i++) {
				buttons[i] = buttonsAL.get(i).getName();
			}
			if (buttons.length == 0) {
				JOptionPane.showMessageDialog(null, "You dont have these type of abilities", null,
						JOptionPane.WARNING_MESSAGE);
			} else {
				int choice = JOptionPane.showOptionDialog(null, "Which Ability you want to cast?", "Choose an Ability",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);
				if (choice == 0) {
					try {
						game.castAbility(buttonsAL.get(0));
						Main_Game_View.setVisible(false);
						Main_Game_Controller g = new Main_Game_Controller(game);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
					}
				} else if ((buttonsAL.size() > 1) && choice == 1) {
					try {
						game.castAbility(buttonsAL.get(1));
						Main_Game_View.setVisible(false);
						Main_Game_Controller g = new Main_Game_Controller(game);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
					}
				} else if ((buttonsAL.size() > 2) && choice == 2) {
					try {
						game.castAbility(buttonsAL.get(2));
						Main_Game_View.setVisible(false);
						Main_Game_Controller g = new Main_Game_Controller(game);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		} else if (e.getActionCommand().equals("castAbilityDirectional")) {
			ArrayList<Ability> buttonsAL = new ArrayList<Ability>();
			for (int i = 0; i < game.getCurrentChampion().getAbilities().size(); i++) {
				if (game.getCurrentChampion().getAbilities().get(i).getCastArea().equals(AreaOfEffect.DIRECTIONAL)) {
					buttonsAL.add(game.getCurrentChampion().getAbilities().get(i));
				}
			}
			String[] buttons = new String[buttonsAL.size()];
			for (int i = 0; i < buttonsAL.size(); i++) {
				buttons[i] = buttonsAL.get(i).getName();
			}
			if (buttons.length == 0) {
				JOptionPane.showMessageDialog(null, "You dont have these type of abilities", null,
						JOptionPane.WARNING_MESSAGE);
			} else {
				int choice = JOptionPane.showOptionDialog(null, "Which Ability you want to cast?", "Choose an Ability",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);
				if (choice == 0) {
					String[] button = { "Right", "Left", "Down", "Up" };
					int choices = JOptionPane.showOptionDialog(null, "Which Direction you want to cast?",
							"Choose a Direction", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							button, null);
					if (choices == 0) {
						try {
							game.castAbility(buttonsAL.get(0), Direction.RIGHT);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					} else if (choices == 1) {
						try {
							game.castAbility(buttonsAL.get(0), Direction.LEFT);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					} else if (choices == 2) {
						try {
							game.castAbility(buttonsAL.get(0), Direction.UP);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					} else if (choices == 3) {
						try {
							game.castAbility(buttonsAL.get(0), Direction.DOWN);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					}

				} else if ((buttonsAL.size() > 1) && choice == 1) {

					String[] button = { "Right", "Left", "Down", "Up" };
					int choices = JOptionPane.showOptionDialog(null, "Which Direction you want to cast?",
							"Choose a Direction", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							button, null);
					if (choices == 0) {
						try {
							game.castAbility(buttonsAL.get(1), Direction.RIGHT);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					} else if (choices == 1) {
						try {
							game.castAbility(buttonsAL.get(1), Direction.LEFT);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					} else if (choices == 2) {
						try {
							game.castAbility(buttonsAL.get(1), Direction.UP);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					} else if (choices == 3) {
						try {
							game.castAbility(buttonsAL.get(1), Direction.DOWN);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					}

				} else if ((buttonsAL.size() > 2) && choice == 2) {

					String[] button = { "Right", "Left", "Down", "Up" };
					int choices = JOptionPane.showOptionDialog(null, "Which Direction you want to cast?",
							"Choose a Direction", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							button, null);
					if (choices == 0) {
						try {
							game.castAbility(buttonsAL.get(2), Direction.RIGHT);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					} else if (choices == 1) {
						try {
							game.castAbility(buttonsAL.get(2), Direction.LEFT);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					} else if (choices == 2) {
						try {
							game.castAbility(buttonsAL.get(2), Direction.UP);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					} else if (choices == 3) {
						try {
							game.castAbility(buttonsAL.get(2), Direction.DOWN);
							Main_Game_View.setVisible(false);
							Main_Game_Controller g = new Main_Game_Controller(game);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
						}

					}

				}

			}
		} else if (e.getActionCommand().equals("castAbilitySingleTarget")) {
			ArrayList<Ability> buttonsAL = new ArrayList<Ability>();
			for (int i = 0; i < game.getCurrentChampion().getAbilities().size(); i++) {
				if (game.getCurrentChampion().getAbilities().get(i).getCastArea().equals(AreaOfEffect.SINGLETARGET)) {
					buttonsAL.add(game.getCurrentChampion().getAbilities().get(i));
				}
			}
			String[] buttons = new String[buttonsAL.size()];
			for (int i = 0; i < buttonsAL.size(); i++) {
				buttons[i] = buttonsAL.get(i).getName();
			}
			if (buttons.length == 0) {
				JOptionPane.showMessageDialog(null, "You dont have these type of abilities", null,
						JOptionPane.WARNING_MESSAGE);
			} else {
				int choice = JOptionPane.showOptionDialog(null, "Which Ability you want to cast?", "Choose an Ability",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);
				int x = 0;
				int y = 0;
				String[] button = { "0", "1", "2", "3", "4" };
				int choiceX;
				int choiceY;
				if (choice == 0) {
					choiceX = JOptionPane.showOptionDialog(null, "Which x coordinates you want to cast into?", "Choose a Value",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, null);
					if (choiceX == 0) {
						x = 0;
					} else if (choiceX == 1) {
						x = 1;
					} else if (choiceX == 2) {
						x = 2;
					} else if (choiceX == 3) {
						x = 3;
					} else if (choiceX == 4) {
						x = 4;
					}
					choiceY = JOptionPane.showOptionDialog(null, "Which y coordinates you want to cast into?", "Choose a Value",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, null);
					if (choiceY == 0) {
						y = 0;
					} else if (choiceY == 1) {
						y = 1;
					} else if (choiceY == 2) {
						y = 2;
					} else if (choiceY == 3) {
						y = 3;
					} else if (choiceY == 4) {
						y = 4;
					}
					try {
						game.castAbility(buttonsAL.get(0), x, y);
						Main_Game_View.setVisible(false);
						Main_Game_Controller g = new Main_Game_Controller(game);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
					}

				} else if ((buttonsAL.size() > 1) && choice == 1) {
					choiceX = JOptionPane.showOptionDialog(null, "Which x coordinates you want to cast into?", "Choose a Value",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, null);
					if (choiceX == 0) {
						x = 0;
					} else if (choiceX == 1) {
						x = 1;
					} else if (choiceX == 2) {
						x = 2;
					} else if (choiceX == 3) {
						x = 3;
					} else if (choiceX == 4) {
						x = 4;
					}
					choiceY = JOptionPane.showOptionDialog(null, "Which y coordinates you want to cast into?", "Choose a Value",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, null);
					if (choiceY == 0) {
						y = 0;
					} else if (choiceY == 1) {
						y = 1;
					} else if (choiceY == 2) {
						y = 2;
					} else if (choiceY == 3) {
						y = 3;
					} else if (choiceY == 4) {
						y = 4;
					}
					try {
						game.castAbility(buttonsAL.get(1), x, y);
						Main_Game_View.setVisible(false);
						Main_Game_Controller g = new Main_Game_Controller(game);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
					}
				} else if ((buttonsAL.size() > 2) && choice == 2) {
					choiceX = JOptionPane.showOptionDialog(null, "Which x coordinates you want to cast into?", "Choose a Value",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, null);
					if (choiceX == 0) {
						x = 0;
					} else if (choiceX == 1) {
						x = 1;
					} else if (choiceX == 2) {
						x = 2;
					} else if (choiceX == 3) {
						x = 3;
					} else if (choiceX == 4) {
						x = 4;
					}
					choiceY = JOptionPane.showOptionDialog(null, "Which y coordinates you want to cast into?", "Choose a Value",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, button, null);
					if (choiceY == 0) {
						y = 0;
					} else if (choiceY == 1) {
						y = 1;
					} else if (choiceY == 2) {
						y = 2;
					} else if (choiceY == 3) {
						y = 3;
					} else if (choiceY == 4) {
						y = 4;
					}
					try {
						game.castAbility(buttonsAL.get(2), x, y);
						Main_Game_View.setVisible(false);
						Main_Game_Controller g = new Main_Game_Controller(game);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		} else if (e.getActionCommand().equals("useLeaderAbility")) {
			try {
				game.useLeaderAbility();
				Main_Game_View.setVisible(false);
				Main_Game_Controller g = new Main_Game_Controller(game);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);
			}
		}else if (e.getActionCommand().equals("endTurn")) {
			try {
				game.endTurn();
				Player player=null;
				player=game.checkGameOver();
				if (player!=null) {
					Main_Game_View.setVisible(false);
					Final_Game f= new Final_Game(player);
				}else {
					Main_Game_View.setVisible(false);
					Main_Game_Controller g = new Main_Game_Controller(game);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.WARNING_MESSAGE);	
			}
		}
		

	}

	public static boolean isFirstLeader(Champion champ, String firstLeaderName) {
		boolean isfirstleader = false;
		if (firstLeaderName.equals(champ.getName())) {
			isfirstleader = true;
		}
		return isfirstleader;
	}

	public static String Queue(Game game) {
		String data = "Turn Order Queue: " + '\n';
		PriorityQueue f = new PriorityQueue(6);
		PriorityQueue s = game.getTurnOrder();
		while(!s.isEmpty()) {
			Champion c = ((Champion) s.peekMin());
			data = data + c.getName() + '\n';
			f.insert(s.remove());
		}
		while(!f.isEmpty()) {
			s.insert(f.remove());
		}
		
		return data;
	}

	public static boolean isSecondLeader(Champion champ, String secondLeaderName) {
		boolean isSecondleader = false;
		if (secondLeaderName.equals(champ.getName())) {
			isSecondleader = true;
		}
		return isSecondleader;
	}

	public static void addData(Game game, Main_Game Main_Game_View, String firstleaderName, String secondleaderName) {
		
		Main_Game_View.order.setText(Queue(game));
		Main_Game_View.currentChampion.setText(game.getCurrentChampion().remain());

		Main_Game_View.ability1.setText(game.getCurrentChampion().getAbilities().get(0).toString());
		Main_Game_View.ability2.setText(game.getCurrentChampion().getAbilities().get(1).toString());
		Main_Game_View.ability3.setText(game.getCurrentChampion().getAbilities().get(2).toString());

		Main_Game_View.PlayerOneDataLabelOne.setText(game.getFirstPlayer().getName());
		Main_Game_View.PlayerOneDataLabelTwo.setText("Leader Ability Used: " + game.isFirstLeaderAbilityUsed());

		
		if(game.getFirstPlayer().getTeam().size()==1) {
			Main_Game_View.playerOneChampionsChampionOne.setText((String) game.getFirstPlayer().getTeam().get(0).remain()
					+ "Leader: " + isFirstLeader(game.getFirstPlayer().getTeam().get(0), firstleaderName));
		}
		else if(game.getFirstPlayer().getTeam().size()==2) {
			Main_Game_View.playerOneChampionsChampionOne.setText((String) game.getFirstPlayer().getTeam().get(0).remain()
					+ "Leader: " + isFirstLeader(game.getFirstPlayer().getTeam().get(0), firstleaderName));
			Main_Game_View.playerOneChampionsChampionTwo.setText((String) game.getFirstPlayer().getTeam().get(1).remain()
					+ "Leader: " + isFirstLeader(game.getFirstPlayer().getTeam().get(1), firstleaderName));
		}
		else if(game.getFirstPlayer().getTeam().size()==3) {
			Main_Game_View.playerOneChampionsChampionOne.setText((String) game.getFirstPlayer().getTeam().get(0).remain()
					+ "Leader: " + isFirstLeader(game.getFirstPlayer().getTeam().get(0), firstleaderName));
			Main_Game_View.playerOneChampionsChampionTwo.setText((String) game.getFirstPlayer().getTeam().get(1).remain()
					+ "Leader: " + isFirstLeader(game.getFirstPlayer().getTeam().get(1), firstleaderName));
			Main_Game_View.playerOneChampionsChampionThree.setText((String) game.getFirstPlayer().getTeam().get(2).remain()
					+ "Leader: " + isFirstLeader(game.getFirstPlayer().getTeam().get(2), firstleaderName));
		}
		
		if(game.getSecondPlayer().getTeam().size()==1) {
			Main_Game_View.playerTwoChampionsChampionOne.setText((String) game.getSecondPlayer().getTeam().get(0).remain()
					+ "Leader: " + isSecondLeader(game.getSecondPlayer().getTeam().get(0), secondleaderName));
		}
		else if(game.getSecondPlayer().getTeam().size()==2) {
			Main_Game_View.playerTwoChampionsChampionOne.setText((String) game.getSecondPlayer().getTeam().get(0).remain()
					+ "Leader: " + isSecondLeader(game.getSecondPlayer().getTeam().get(0), secondleaderName));
			Main_Game_View.playerTwoChampionsChampionTwo.setText((String) game.getSecondPlayer().getTeam().get(1).remain()
					+ "Leader: " + isSecondLeader(game.getSecondPlayer().getTeam().get(1), secondleaderName));
		}
		else if(game.getSecondPlayer().getTeam().size()==3) {
			Main_Game_View.playerTwoChampionsChampionOne.setText((String) game.getSecondPlayer().getTeam().get(0).remain()
					+ "Leader: " + isSecondLeader(game.getSecondPlayer().getTeam().get(0), secondleaderName));
			Main_Game_View.playerTwoChampionsChampionTwo.setText((String) game.getSecondPlayer().getTeam().get(1).remain()
					+ "Leader: " + isSecondLeader(game.getSecondPlayer().getTeam().get(1), secondleaderName));
			Main_Game_View.playerTwoChampionsChampionThree.setText((String) game.getSecondPlayer().getTeam().get(2).remain()
					+ "Leader: " + isSecondLeader(game.getSecondPlayer().getTeam().get(2), secondleaderName));
		}
		
	
		Main_Game_View.PlayerTwoDataLabelOne.setText(game.getSecondPlayer().getName());
		Main_Game_View.PlayerTwoDataLabelTwo.setText("Leader Ability Used: " + game.isSecondLeaderAbilityUsed());
		
	}

}
