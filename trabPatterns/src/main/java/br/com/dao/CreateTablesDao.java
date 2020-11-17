package br.com.dao;

import br.com.bean.*;
import br.com.util.Conexao;
import br.com.util.ConexaoFactory;
import br.com.util.TipoConexao;

import java.sql.SQLException;
import java.sql.Statement;


public class CreateTablesDao {
	
	public static void createNewsTables(TipoConexao tc) throws Exception{
		Conexao consql = null;
		try {
	         switch (tc) {
             case CONNECTION_MYSQL:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_MYSQL);
                 break;
             case CONNECTION_SQLITE:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_SQLITE);
                 break;
	         }
	         consql.createTables();
        } catch (Exception e) {  
        	throw new Exception(e.getMessage());  
        } 
	}

}
