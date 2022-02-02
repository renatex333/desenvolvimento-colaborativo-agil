package br.edu.insper.desagil.aps1;

import java.util.ArrayList;
import java.util.List;

public class Derivada {

	public List<Integer> constroi(List<Integer> v) {
		List<Integer> d = new ArrayList<>();
		for(int i=0;i<v.size()-1;i++) {
			d.add(v.get(i+1)-v.get(i));
		}
		return d;
	}

}
