package br.edu.insper.desagil.aps1;

public class Grade {

	public String constroi(int n) {
		int N=2*n+1;
		String s="";
		for(int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if(i%2==0) {
					if (j%2==0) {
							s += "+";
					}
					else {
							s += "-";
					}
					
				}
				else {
					if(j%2==0) {
							s += "|";
						}
					else {
							s += " ";
					}
				}
			}
			s += "\n";
		}
		
return s;
		
		
	}

}
