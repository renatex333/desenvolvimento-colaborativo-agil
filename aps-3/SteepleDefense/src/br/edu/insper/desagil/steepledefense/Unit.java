package br.edu.insper.desagil.steepledefense;

public abstract class Unit extends Element {
	private int power;
	private int health;

	public Unit(int x, int y, int power, int health) {
		super(x, y, 1, 1);
		this.power = power;
		this.health = health;
	}

	public void setX(int x) {
		super.setX(x);
	}
	public void setY(int y) {
		super.setY(y);
	}
	public int getPower() {
		return power;
	}
	public int getHealth() {
		return this.health;
	}

	public void increaseHealth(int gain) {
		this.health += gain;
	}
	public void decreaseHealth(int loss) {
		this.health -= loss;
	}
}
