package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import br.com.bean.AluguelLivro;
import br.com.util.Dao;
import br.com.util.TipoConexao;
import br.com.util.Conexao;
import br.com.util.ConexaoFactory;
import br.com.util.ConexaoMySQL;
import br.com.util.ConexaoSQLite;

public class AluguelLivroDao implements Dao {

	@Override
	public void insert(Object o, TipoConexao tc) {
		// TODO Auto-generated method stub
		AluguelLivro al = (AluguelLivro) o;
		Conexao consql = null;
		String sql = "insert into AluguelLivro (dataAluguel, dataDevolucao, livroAlugado, isDevolvido, isAlugado, isActive) values (?,?,?,?,?,?)";
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataAluguel = s.format(al.getDataAluguel().getTime());
		String dataDevolucao = s.format(al.getDataDevolucao().getTime());
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
			ps.setString(1, dataAluguel);
			ps.setString(2, dataDevolucao);
			ps.setInt(3, al.getLivroAlugado());
			ps.setBoolean(4, al.getIsDevolvido());
			ps.setBoolean(5, al.getIsAlugado());
			ps.setBoolean(6, al.getIsActive());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object o, TipoConexao tc) {
		AluguelLivro al = (AluguelLivro) o;
		Conexao consql = null;
		String sql = "update AluguelLivro set dataAluguel=?, dataDevolucao=?, livroAlugado=?, isDevolvido=?, isAlugado=?, isActive=? where id=?";
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataAluguel = s.format(al.getDataAluguel().getTime());
		String dataDevolucao = s.format(al.getDataDevolucao().getTime());
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
			ps.setString(1, dataAluguel);
			ps.setString(2, dataDevolucao);
			ps.setInt(3, al.getLivroAlugado());
			ps.setBoolean(4, al.getIsDevolvido());
			ps.setBoolean(5, al.getIsAlugado());
			ps.setBoolean(6, al.getIsActive());
			ps.setInt(7, al.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer i, TipoConexao tc) {
//		Autor a = (Autor) o;
		Conexao consql = null;
		String sql = "delete from AluguelLivro where id=?";
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
		AluguelLivro al = new AluguelLivro();
		Conexao consql = null;
		String sql = "select * from AluguelLivro where id=?";
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar cdataAluguel = Calendar.getInstance();
		Date dtdataAluguel = new Date();

		Calendar cdataDevolucao = Calendar.getInstance();
		Date dtdataDevolucao = new Date();
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
				dtdataAluguel = s.parse(rs.getString("dataAluguel"));
				cdataAluguel.setTime(dtdataAluguel);
				dtdataDevolucao = s.parse(rs.getString("dataDevolucao"));
				cdataDevolucao.setTime(dtdataDevolucao);
//				System.out.println(rs.getString("dataAluguel"));
//				System.out.println(cdataAluguel);
//				System.out.println(cdataAluguel);
				al.setId(rs.getInt("id"));
				al.setDataAluguel(cdataAluguel);
				al.setDataDevolucao(cdataDevolucao);
				al.setLivroAlugado(rs.getInt("livroAlugado"));
				al.setIsAlugado(rs.getBoolean("isAlugado"));
				al.setIsDevolvido(rs.getBoolean("isDevolvido"));
				al.setIsActive(rs.getBoolean("isActive"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public List select(TipoConexao tc) {
		List list = new ArrayList();
		Conexao consql = null;
		String sql = "select * from AluguelLivro";
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
				AluguelLivro al = new AluguelLivro();

				Calendar cdataAluguel = Calendar.getInstance();
				Date dtdataAluguel = new Date();
				dtdataAluguel = s.parse(rs.getString("dataAluguel"));
				cdataAluguel.setTime(dtdataAluguel);

				Calendar cdataDevolucao = Calendar.getInstance();
				Date dtdataDevolucao = new Date();
				dtdataDevolucao = s.parse(rs.getString("dataDevolucao"));
				cdataDevolucao.setTime(dtdataDevolucao);

//				System.out.println(rs.getString("dataAluguel"));
//				System.out.println(cdataAluguel.getTime());
//				System.out.println(cdataDevolucao.getTime());

				al.setId(rs.getInt("id"));
				al.setDataAluguel(cdataAluguel);
				al.setDataDevolucao(cdataDevolucao);
				al.setLivroAlugado(rs.getInt("livroAlugado"));
				al.setIsAlugado(rs.getBoolean("isAlugado"));
				al.setIsDevolvido(rs.getBoolean("isDevolvido"));
				al.setIsActive(rs.getBoolean("isActive"));
				list.add(al);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public AluguelLivroDao() {
		super();
	}
	
    public static AluguelLivroDao of() {
        return new AluguelLivroDao();
    }
    
    public AluguelLivroDao copy() {
    	AluguelLivroDao aluguelLivroDao = AluguelLivroDao.of();

        return aluguelLivroDao;
    }
    
    public static AluguelLivroDao safeCopy(AluguelLivroDao aluguelLivroDao) {
        if (Objects.nonNull(aluguelLivroDao)) {
            return aluguelLivroDao.copy();
        }

        return null;
    }
}
