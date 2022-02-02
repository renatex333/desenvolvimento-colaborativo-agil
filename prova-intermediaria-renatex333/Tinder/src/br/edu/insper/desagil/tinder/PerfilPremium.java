package br.edu.insper.desagil.tinder;

public class PerfilPremium extends Perfil{
	private int pontos;
	
	public PerfilPremium(int id, String nome, Gerenciador gerenciador) {
		super(id, nome, gerenciador);
		this.pontos = 0;
	}

	public int getPontos() {
		return this.pontos;
	}
	
	public void adicionaPontos(int n) {
		this.pontos += n;
	}

	@Override
	public boolean autoriza() {
		if (this.pontos >= 10) {
			this.pontos -= 10;
			return true;
		}else {
			return false;
		}
	}
}
