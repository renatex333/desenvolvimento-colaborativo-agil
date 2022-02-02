package br.edu.insper.desagil.glasseffect;

import java.util.ArrayList;
import java.util.List;

public class Station extends Body {
	private List<Ship> ships;

	public Station(String name, Vector position) {
		super(name, position);
		this.ships = new ArrayList<>();
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void addShip(Ship ship) {
		ships.add(ship);
	}

	public void removeShip(int id) {
		for (Ship ship : ships) {
			if (ship.getId() == id) {
				ships.remove(ship);
				return;
			}
		}
	}
}
