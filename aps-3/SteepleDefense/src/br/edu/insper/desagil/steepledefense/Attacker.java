package br.edu.insper.desagil.steepledefense;

public class Attacker extends Unit {
	public Attacker(int x, int y, int power, int health) {
		super(x, y, power, health);
	}

	public void move(int dx, int dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}
}
