package br.edu.insper.desagil.aps1;

import java.util.List;
import java.util.ArrayList;

public class Digitos {
	public List<Integer> constroi(String s) {
		List<Integer> digitos = new ArrayList<>();
		List<Character> numeros = new ArrayList<Character>(){{
				add('0');
				add('1');
				add('2');
				add('3');
				
				add('4');
				add('5');
				add('6');
				add('7');
				add('8');
				add('9');
			
		}};
		
		for (int i = 0; i < s.length(); i++) {
		    char c=s.charAt(i);
			if(numeros.contains(c) ) {
		    	digitos.add(i);
		    }
			
		   
		}
		
		return digitos;		
	}
	
}