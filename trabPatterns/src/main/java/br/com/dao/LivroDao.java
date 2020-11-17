package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Livro;
import br.com.util.Dao;
import br.com.util.TipoConexao;
import br.com.util.Conexao;
import br.com.util.ConexaoFactory;
import br.com.util.ConexaoMySQL;
import br.com.util.ConexaoSQLite;

public class LivroDao implements Dao {

	@Override
	public void insert(Object o, TipoConexao tc) {
		// TODO Auto-generated method stub
		Livro l = (Livro) o;
		Conexao consql = null;
		String sql = "insert into Livro (titulo,subTitulo,secao,resumo,descricao, qtdEstoque) values (?,?,?,?,?,?)";
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
			ps.setString(1, l.getTitulo());
			ps.setString(2, l.getSubTitulo());
			ps.setString(3, l.getSecao());
			ps.setString(4, l.getResumo());
			ps.setString(5, l.getDescricao());
			ps.setInt(6, l.getQtdEstoque());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object o, TipoConexao tc) {
		Livro l = (Livro) o;
		Conexao consql = null;
		String sql = "update Livro set titulo=?,subTitulo=?,secao=?,resumo=?,descricao=?,qtdEstoque=? where id=?";
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
			ps.setString(1, l.getTitulo());
			ps.setString(2, l.getSubTitulo());
			ps.setString(3, l.getSecao());
			ps.setString(4, l.getResumo());
			ps.setString(5, l.getDescricao());
			ps.setInt(6, l.getQtdEstoque());
			ps.setInt(7, l.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer i, TipoConexao tc) {
//		Livro l = (Livro) o;
		Conexao consql = null;
		String sql = "delete from Livro where id=?";
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
		Livro l = Livro.builder().id(null).titulo("").subTitulo("").secao("").resumo("").descricao("").qtdEstoque(0)
				.build();
		Conexao consql = null;
		String sql = "select * from Livro where id=?";
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
				l = Livro.builder().id(rs.getInt("id")).titulo(rs.getString("titulo"))
						.subTitulo(rs.getString("subTitulo")).secao(rs.getString("secao"))
						.resumo(rs.getString("resumo")).descricao(rs.getString("descricao"))
						.qtdEstoque(rs.getInt("qtdEstoque")).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List select(TipoConexao tc) {
		List list = new ArrayList();
		Conexao consql = null;
		String sql = "select * from Livro";
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
				Livro l = Livro.builder().id(rs.getInt("id")).titulo(rs.getString("titulo"))
						.subTitulo(rs.getString("subTitulo")).secao(rs.getString("secao"))
						.resumo(rs.getString("resumo")).descricao(rs.getString("descricao"))
						.qtdEstoque(rs.getInt("qtdEstoque")).build();
				list.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
