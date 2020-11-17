package br.com.facade;

import java.util.List;

import br.com.bean.Livro;

public abstract class Files {
	public abstract boolean exportar();
	public abstract boolean exportar(Livro livro);
	public abstract boolean exportar(List<Livro> livros);
}
