package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Livro;
import br.com.bean.Categoria;
import br.com.util.Dao;
import br.com.util.TipoConexao;
import br.com.util.Conexao;
import br.com.util.ConexaoFactory;
import br.com.util.ConexaoMySQL;
import br.com.util.ConexaoSQLite;

public class CategoriaDao implements Dao {

	@Override
	public void insert(Object o, TipoConexao tc) {
		// TODO Auto-generated method stub
		Categoria c = (Categoria) o;
		Conexao consql = null;
		String sql = "insert into Categoria (nome, descricao, livroc) values (?,?,?)";
		try {
	         switch (tc) {
             case CONNECTION_MYSQL:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_MYSQL);
                 break;
             case CONNECTION_SQLITE:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_SQLITE);
                 break;
	         }
			PreparedStatement ps = consql.getConexao().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getDescricao());
			ps.setInt(3, c.getLivroc());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object o, TipoConexao tc) {
		Categoria c = (Categoria) o;
		Conexao consql = null;
		String sql = "update Categoria set nome=?, descricao=?, livroc=? where id=?";
		try {
	         switch (tc) {
             case CONNECTION_MYSQL:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_MYSQL);
                 break;
             case CONNECTION_SQLITE:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_SQLITE);
                 break;
	         }
			PreparedStatement ps = consql.getConexao().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getDescricao());
			ps.setInt(3, c.getLivroc());
			ps.setInt(4, c.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer i, TipoConexao tc) {
//		Categoria c = (Categoria) o;
		Conexao consql = null;
		String sql = "delete from Categoria where id=?";
		try {
	         switch (tc) {
             case CONNECTION_MYSQL:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_MYSQL);
                 break;
             case CONNECTION_SQLITE:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_SQLITE);
                 break;
	         }
			PreparedStatement ps = consql.getConexao().prepareStatement(sql);
			ps.setInt(1, i);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Object select(Integer i, TipoConexao tc) {
		Categoria c = Categoria.builder().id(null).nome("")
				.descricao("").livroc(null).build();
		Conexao consql = null;
		String sql = "select * from Categoria where id=?";
		try {
	         switch (tc) {
             case CONNECTION_MYSQL:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_MYSQL);
                 break;
             case CONNECTION_SQLITE:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_SQLITE);
                 break;
	         }
			PreparedStatement ps = consql.getConexao().prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = Categoria.builder().id(rs.getInt("id")).nome(rs.getString("nome"))
						.descricao(rs.getString("descricao")).livroc(rs.getInt("livroc")).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List select(TipoConexao tc) {
		List list = new ArrayList();
		Conexao consql = null;
		String sql = "select * from Categoria";
		try {
	         switch (tc) {
             case CONNECTION_MYSQL:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_MYSQL);
                 break;
             case CONNECTION_SQLITE:
            	 consql = ConexaoFactory.getConexao(TipoConexao.CONNECTION_SQLITE);
                 break;
	         }
			PreparedStatement ps = consql.getConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Categoria c = Categoria.builder().id(rs.getInt("id")).nome(rs.getString("nome"))
						.descricao(rs.getString("descricao")).livroc(rs.getInt("livroc")).build();
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
