package br.edu.insper.desagil.aquecimento;

import java.util.ArrayList;
import java.util.List;

public class Cumulativo {

	public List<Integer> calcula(List<Integer> v) {
		List<Integer> c = new ArrayList<>();
		
		c.add(v.get(0));
		
		for (int i = 1; i < v.size(); i++) {
			c.add(c.get(i - 1) + v.get(i));
		}
		
		return c;
	}

}
