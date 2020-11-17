package br.com.controller;

import br.com.dao.CreateTablesDao;
import br.com.util.TipoConexao;

public class CreateTablesCT {
	public void createNewsTables(TipoConexao tc) {
		CreateTablesDao ctdao = new CreateTablesDao();
		try {
			ctdao.createNewsTables(tc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
