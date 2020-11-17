package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.Autor;
import br.com.bean.Livro;
import br.com.util.Dao;
import br.com.util.TipoConexao;
import br.com.util.Conexao;
import br.com.util.ConexaoFactory;
import br.com.util.ConexaoMySQL;
import br.com.util.ConexaoSQLite;

public class AutorDao implements Dao {

	@Override
	public void insert(Object o, TipoConexao tc) {
		// TODO Auto-generated method stub
		Autor a = (Autor) o;
		Conexao consql = null;
		String sql = "insert into Autor (nome, rg, cpf, contatoTel, contatoCel, contatoEmail, livroa) values (?,?,?,?,?,?,?)";
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
			ps.setString(1, a.getNome());
			ps.setString(2, a.getRg());
			ps.setString(3, a.getCpf());
			ps.setString(4, a.getContatoTel());
			ps.setString(5, a.getContatoCel());
			ps.setString(6, a.getContatoEmail());
			ps.setInt(7, a.getLivroa());

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object o, TipoConexao tc) {
		Autor a = (Autor) o;
		Conexao consql = null;
		String sql = "update Autor set nome=?, rg=?, cpf=?, contatoTel=?, contatoCel=?, contatoEmail=?, livroa=? where id=?";
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
			ps.setString(1, a.getNome());
			ps.setString(2, a.getRg());
			ps.setString(3, a.getCpf());
			ps.setString(4, a.getContatoTel());
			ps.setString(5, a.getContatoCel());
			ps.setString(6, a.getContatoEmail());
			ps.setInt(7, a.getLivroa());
			ps.setInt(8, a.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer i, TipoConexao tc) {
//		Autor a = (Autor) o;
		Conexao consql = null;
		String sql = "delete from Autor where id=?";
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
		Autor a = Autor.builder().id(null).nome("").rg("").cpf("").contatoTel("").contatoCel("").contatoEmail("")
				.livroa(null).build();
		Conexao consql = null;
		String sql = "select * from Autor where id=?";
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
				a = Autor.builder().id(rs.getInt("id")).nome(rs.getString("nome")).rg(rs.getString("rg"))
						.cpf(rs.getString("cpf")).contatoTel(rs.getString("contatoTel"))
						.contatoCel(rs.getString("contatoCel")).contatoEmail(rs.getString("contatoEmail"))
						.livroa(rs.getInt("livroa")).build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List select(TipoConexao tc) {
		List list = new ArrayList();
		Conexao consql = null;
		String sql = "select * from Autor";
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
				Autor a = Autor.builder().id(rs.getInt("id")).nome(rs.getString("nome")).rg(rs.getString("rg"))
						.cpf(rs.getString("cpf")).contatoTel(rs.getString("contatoTel"))
						.contatoCel(rs.getString("contatoCel")).contatoEmail(rs.getString("contatoEmail"))
						.livroa(rs.getInt("livroa")).build();
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
