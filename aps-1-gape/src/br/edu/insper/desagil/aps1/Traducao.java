package br.edu.insper.desagil.aps1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Traducao {

	public Map<String, List<Double>> constroi(List<Map<String, Double>> pessoas) {
		
		Map<String, List<Double>> people = new HashMap<>();
		List<Double> agelist = new ArrayList<>();
		List<Double> heightlist = new ArrayList<>();
		List<Double> weightlist = new ArrayList<>();
		
		for (Map<String, Double> d: pessoas) {
			for (String k: d.keySet()) {
				if (k == "idade") {
					agelist.add(d.get(k));
				} else if (k == "altura") {
					heightlist.add((d.get(k)*39.3701));
				} else if (k == "peso") {
					weightlist.add((d.get(k)*2.20462));
				}
			}
		}
		
		people.put("age", agelist);
		people.put("height", heightlist);
		people.put("weight", weightlist);
		
		return people;
	}

}
