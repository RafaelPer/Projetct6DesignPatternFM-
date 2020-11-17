package br.com.decorator;

public abstract class LivroAcessorios {
	
	protected LivroAcessorios outrosAcessorios;

	public LivroAcessorios(LivroAcessorios OutrosAcessorios) {
		this.outrosAcessorios = OutrosAcessorios;
	}
	
	public LivroAcessorios() {
		
	}
}
