package br.com.controller;

import java.util.List;

import br.com.bean.Autor;
import br.com.dao.AutorDao;
import br.com.util.TipoConexao;

public class AutorCT {

	public void insert(Autor a, TipoConexao tc) {
		AutorDao daoAutor = new AutorDao();
		daoAutor.insert(a, tc);
	}

	public void update(Autor a, TipoConexao tc) {
		AutorDao daoAutor = new AutorDao();
		daoAutor.update(a, tc);
	}

	public void delete(Integer i, TipoConexao tc) {
		AutorDao daoAutor = new AutorDao();
		daoAutor.delete(i, tc);
	}

	public Autor select(Integer i, TipoConexao tc) {
		AutorDao daoAutor = new AutorDao();
		Autor a = (Autor) daoAutor.select(i, tc);
		return a;
	}

	public List select(TipoConexao tc) {
		AutorDao daoAutor = new AutorDao();
		List ls = daoAutor.select(tc);
		return ls;
	}
}
