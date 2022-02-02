package br.edu.insper.desagil.aps1;

import java.util.List;
public class Modulo {
	
	public int maior(List<Integer> numeros) {
		int max=0;
		int min=0;
		for(int n=0;n<numeros.size();n++ ) {
			if(numeros.get(n)<min) {
				min = numeros.get(n);
			} else if(numeros.get(n)>max) {
				max = numeros.get(n);
			}else {
				
			}
		if(Math.abs(min)>max) {
			max = min;
		}
		
}
		return max;}
}

