package br.edu.insper.desagil.glasseffect;

public class Ship extends Body {
	private int id;
	private Vector speed;
	private Pilot pilot;
	private Pilot coPilot;

	public Ship(int id, String name, Vector position) {
		super(name, position);
		this.id = id;
		this.speed = null;
		this.pilot = null;
		this.coPilot = null;
	}

	public int getId() {
		return id;
	}

	public Vector getSpeed() {
		return speed;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Pilot getCoPilot() {
		return coPilot;
	}

	public void setCoPilot(Pilot coPilot) {
		this.coPilot = coPilot;
	}

	public void changeSpeed(int x, int y, int z) {
		this.speed = new Vector(x, y, z);
	}

	public void update() {
		Vector position = getPosition();
		int x = position.getX() + speed.getX();
		int y = position.getY() + speed.getY();
		int z = position.getZ() + speed.getZ();
		setPosition(new Vector(x, y, z));
	}
}
