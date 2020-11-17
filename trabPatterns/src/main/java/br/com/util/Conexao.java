package br.com.util;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Conexao {
	public abstract Connection getConexao() throws SQLException;
	public abstract void createTables() throws SQLException;
}
