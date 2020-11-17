package br.com.controller;

import java.util.List;

import br.com.bean.Livro;
import br.com.dao.LivroDao;
import br.com.util.TipoConexao;

public class LivroCT {

	public void insert(Livro l, TipoConexao tc) {
		LivroDao daoLivro = new LivroDao();
		daoLivro.insert(l, tc);
	}

	public void update(Livro l, TipoConexao tc) {
		LivroDao daoLivro = new LivroDao();
		daoLivro.update(l, tc);
	}

	public void delete(Integer i, TipoConexao tc) {
		LivroDao daoLivro = new LivroDao();
		daoLivro.delete(i, tc);
	}

	public Livro select(Integer i, TipoConexao tc) {
		LivroDao daoLivro = new LivroDao();
		Livro l = (Livro) daoLivro.select(i, tc);
		return l;
	}

	public List select(TipoConexao tc) {
		LivroDao daoLivro = new LivroDao();
		List ls = daoLivro.select(tc);
		return ls;
	}
}
