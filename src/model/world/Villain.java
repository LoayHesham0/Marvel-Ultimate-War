package model.world;

import java.util.ArrayList;

public class Villain extends Champion {

	public Villain(String name, int maxHP, int maxMana, int actions, int speed, int attackRange, int attackDamage) {
		super(name, maxHP, maxMana, actions, speed, attackRange, attackDamage);

	}

	public String toString() {
		return super.toString()+"Type: "+"Villain"+'\n';
	}
	
	public String remain() {
		return super.remain()+"Type: "+"Villain"+'\n'+effect();
	}
	
	@Override
	public void useLeaderAbility(ArrayList<Champion> targets) {
		for (Champion c : targets) {

			c.setCurrentHP(0);

		}

	}

}
