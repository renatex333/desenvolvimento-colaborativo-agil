package br.edu.insper.desagil.MyFood;

public abstract class Item {
		private String nome;

		public Item(String nome) {
			
			this.nome = nome;
		}

		public String getNome() {
			return nome;
		}
		
		public abstract double getPreco();
			
}
