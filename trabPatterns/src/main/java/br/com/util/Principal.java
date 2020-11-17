package br.com.util;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.bean.*;
import br.com.util.ConexaoSQLite;
import br.com.dao.*;
import br.com.facade.FileConverter;
import br.com.facade.Files;
import br.com.facade.FilesType;
import br.com.controller.*;

public class Principal {

	public static void main(String[] args) {
		try {
//	        Conexao conmysql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_MYSQL);
//	        conmysql.getConexao();
//	        conmysql.createTables();
//	        Calendar c = Calendar.getInstance();
//	        System.out.println(c.getTime());
//	        Calendar c2 = Calendar.getInstance();
//	        System.out.println(c2.getTime());
//	        System.out.println(c2.getTime().compareTo(c.getTime()));
//	        AluguelLivro al = new AluguelLivro(c, c, 1, false, true, true);
//	        AluguelLivroCT alct = new AluguelLivroCT();
//	        alct.insert(al, TipoConexao.CONNECTION_SQLITE);
//	        List<AluguelLivro> allal = alct.select(TipoConexao.CONNECTION_SQLITE);
//	        System.out.println(allal);
//	        AluguelLivroDao daoAluguelLivroDao = new AluguelLivroDao();
//	        AluguelLivro all = (AluguelLivro) daoAluguelLivroDao.select(1, TipoConexao.CONNECTION_MYSQL);
//	        List<AluguelLivro> all = daoAluguelLivroDao.select(TipoConexao.CONNECTION_SQLITE);
//	        for(AluguelLivro alo : all ) {
//	        	System.out.println(alo.getDataAluguel().getTime());
//	        }
//	        System.out.println(all.getDataAluguel().getTime());
//	        daoAluguelLivroDao.insert(al, TipoConexao.CONNECTION_SQLITE);
	        LivroDao daoLivro = new LivroDao();
//			Livro l = Livro.builder().id(2).titulo("1")
//					.subTitulo("2").build();
//	        daoLivro.insert(l, TipoConexao.CONNECTION_SQLITE);
//			daoLivro.update(l);
//			daoLivro.delete(l);
//			Livro t = (Livro) daoLivro.select(3);
//			System.out.println(t.getSecao());
//	        System.out.println(daoLivro.select().size());
	        Conexao consqlite = ConexaoFactory.getConexao(TipoConexao.CONNECTION_SQLITE);
	        Livro t = (Livro) daoLivro.select(5, TipoConexao.CONNECTION_SQLITE);
	        List<Livro> listLivros = daoLivro.select(TipoConexao.CONNECTION_SQLITE);
//	        consqlite.getConexao();
//			consqlite.createTables();
//	        daoAluguelLivroDao.insert(al, TipoConexao.CONNECTION_SQLITE);
//			Calendar c = Calendar.getInstance();
//			System.out.println("Data e Hora atual: "+c.getTime());
//			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
//			String a = s.format(c.getTime());
//			System.out.println(a);
			FileConverter fc = new FileConverter();
			Files file = fc.converter(FilesType.CSV);
			System.out.println(file);
			file.exportar(listLivros);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
