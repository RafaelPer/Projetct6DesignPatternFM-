package br.com.util;

import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoSQLite extends Conexao {

	private static String filename = "trabPatterns.db";
	private static String url = "jdbc:sqlite:C:\\Users\\Rhyix\\Desktop\\Trabalho_Topicos_Avanc_Tecnologias_Patterns\\padroesProjetosTrabalho_java_puro_mvc_mavenAPI\\trabPatterns\\sqliteDatabase\\"
			+ filename;
	private static String urldb = "C:\\Users\\Rhyix\\Desktop\\Trabalho_Topicos_Avanc_Tecnologias_Patterns\\padroesProjetosTrabalho_java_puro_mvc_mavenAPI\\trabPatterns\\sqliteDatabase\\sqliteDatabase";
	// static String usuario = "root";
	// static String senha = "";
	private static Connection con = null;
	private static File file;

	@Override
	public Connection getConexao() throws SQLException {
		try {
			// Class.forName("org.gjt.mm.mysql.Driver");
			Class.forName("org.sqlite.JDBC");
			if (con == null) {
				con = (Connection) DriverManager.getConnection(url);
				file = new File(urldb + filename);
				if (!file.exists()) {
					DatabaseMetaData meta = con.getMetaData();
					System.out.println("O nome driver � " + meta.getDriverName());
					System.out.println("Foi criado uma nova databse com o nome de " + filename + ".");
				} else {
					System.out.println(
							"Ja existe uma database criada com o nome " + filename + " no local " + urldb + ".");
				}

			}
			return con;
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
	}

	@Override
	public void createTables() throws SQLException {
		Connection connection = null;
		Statement stm = null;

		String sqlCreateLivro = "CREATE TABLE IF NOT EXISTS `Livro` (\r\n"
				+ "	`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\r\n"
				+ "	`titulo` TEXT NOT NULL,\r\n"
				+ "	`subTitulo` TEXT NOT NULL,\r\n"
				+ "	`secao` TEXT,\r\n"
				+ "	`resumo` TEXT,\r\n"
				+ "	`descricao` TEXT,"
				+ "	`qtdEstoque` INTEGER NOT NULL);";

		String sqlCreateAutor = "CREATE TABLE IF NOT EXISTS `Autor` (\r\n"
				+ "	`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\r\n"
				+ "	`nome` TEXT NOT NULL,\r\n"
				+ "	`rg` TEXT NOT NULL,\r\n"
				+ "	`cpf` TEXT NOT NULL,\r\n"
				+ "	`contatoTel` TEXT NOT NULL,\r\n"
				+ "	`contatoCel` TEXT,\r\n"
				+ "	`contatoEmail` TEXT,\r\n"
				+ "	`livroa` INTEGER NOT NULL,\r\n" 
				+ "	CONSTRAINT FK_LivroA FOREIGN KEY (livroa)\r\n" 
				+ " REFERENCES Livro(id));";

		String sqlCreateCategoria = "CREATE TABLE IF NOT EXISTS `Categoria` (\r\n"
				+ "	`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\r\n"
				+ "	`nome` TEXT NOT NULL,\r\n"
				+ "	`descricao` TEXT NOT NULL,\r\n"
				+ "	`livroc` INTEGER NOT NULL,\r\n" 
				+ "	CONSTRAINT FK_LivroC FOREIGN KEY (livroc)\r\n" 
				+ "	REFERENCES Livro(id));";
		
		String sqlCreateAluguelLivro = "CREATE TABLE IF NOT EXISTS `AluguelLivro` (\r\n"
				+ "	`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\r\n"
				+ "	`dataAluguel` TEXT NOT NULL,\r\n"
				+ "	`dataDevolucao` TEXT NOT NULL,\r\n"
				+ "	`livroAlugado` INTEGER NOT NULL,\r\n" 
				+ "	`isDevolvido` NUMERIC NOT NULL,\r\n"
				+ "	`isAlugado` NUMERIC NOT NULL,\r\n"
				+ "	`isActive` NUMERIC NOT NULL DEFAULT 1,\r\n"
				+ "	CONSTRAINT FK_LivroAlugado FOREIGN KEY (livroAlugado)\r\n" 
				+ "	REFERENCES Livro(id));";
		try {
			connection = this.getConexao();
			stm = connection.createStatement();
			stm.executeUpdate(sqlCreateLivro);
			stm.close();

			stm = connection.createStatement();
			stm.executeUpdate(sqlCreateAutor);
			stm.close();

			stm = connection.createStatement();
			stm.executeUpdate(sqlCreateCategoria);
			
			stm = connection.createStatement();
			stm.executeUpdate(sqlCreateAluguelLivro);
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static String getFilename() {
//		return filename;
//	}
//
//	public static void setFilename(String filename) {
//		ConexaoSQLite.filename = filename;
//	}

}
