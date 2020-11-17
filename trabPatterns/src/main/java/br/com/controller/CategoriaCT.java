package br.com.controller;

import java.util.List;

import br.com.bean.Categoria;
import br.com.dao.CategoriaDao;
import br.com.util.TipoConexao;

public class CategoriaCT {

	public void insert(Categoria c, TipoConexao tc) {
		CategoriaDao daoCategoria = new CategoriaDao();
		daoCategoria.insert(c, tc);
	}

	public void update(Categoria c, TipoConexao tc) {
		CategoriaDao daoCategoria = new CategoriaDao();
		daoCategoria.update(c, tc);
	}

	public void delete(Integer i, TipoConexao tc) {
		CategoriaDao daoCategoria = new CategoriaDao();
		daoCategoria.delete(i, tc);
	}

	public Categoria select(Integer i, TipoConexao tc) {
		CategoriaDao daoCategoria = new CategoriaDao();
		Categoria c = (Categoria) daoCategoria.select(i, tc);
		return c;
	}

	public List select(TipoConexao tc) {
		CategoriaDao daoCategoria = new CategoriaDao();
		List ls = daoCategoria.select(tc);
		return ls;
	}
}
