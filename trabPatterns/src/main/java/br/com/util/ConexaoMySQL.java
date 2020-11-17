package br.com.util;

import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL extends Conexao {

//	private static String filename = "sample.db";
	private static String url = "jdbc:mysql://localhost:3306/trabPatterns?createDatabaseIfNotExist=true";
	static String usuario = "root";
	static String senha = "";
	private static Connection con = null;
//	private static File file;

	@Override
	public Connection getConexao() throws SQLException {
		try {
//			 Class.forName("org.gjt.mm.mysql.Driver");
			 Class.forName("com.mysql.jdbc.Driver");
			if (con == null) {
				con = (Connection) DriverManager.getConnection(url, usuario, senha);
				DatabaseMetaData meta = con.getMetaData();
				System.out.println("O nome driver � " + meta.getDriverName());
				System.out.println("Foi criado uma nova databse com o nome de trabPatterns.");

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
		
		String sqlCreateLivro = "CREATE TABLE IF NOT EXISTS `Livro` (\r\n" + 
				"	`id` INT(10) NOT NULL AUTO_INCREMENT,\r\n" + 
				"	`titulo` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\r\n" + 
				"	`subTitulo` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\r\n" + 
				"	`secao` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,\r\n" + 
				"	`resumo` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,\r\n" + 
				"	`descricao` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,\r\n" +
				"	`qtdEstoque` INT(10) NOT NULL,\r\n" + 
				"	PRIMARY KEY (`id`)\r\n" + 
				") ENGINE=InnoDB;";
		
		String sqlCreateAutor = "CREATE TABLE IF NOT EXISTS `Autor` (\r\n" + 
				"	`id` INT(10) NOT NULL AUTO_INCREMENT,\r\n" + 
				"	`nome` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\r\n" + 
				"	`rg` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\r\n" + 
				"	`cpf` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\r\n" + 
				"	`contatoTel` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\r\n" + 
				"	`contatoCel` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,\r\n" + 
				"	`contatoEmail` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\r\n" + 
				"	`livroa` INT(10) NOT NULL,\r\n" + 
				"	PRIMARY KEY (`id`),\r\n" + 
				"	CONSTRAINT FK_LivroA FOREIGN KEY (livroa)\r\n" + 
				"   REFERENCES Livro(id)\r\n" + 
				") ENGINE=InnoDB;";
		
		String sqlCreateCategoria = "CREATE TABLE IF NOT EXISTS `Categoria` (\r\n" + 
				"	`id` INT(10) NOT NULL AUTO_INCREMENT,\r\n" + 
				"	`nome` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\r\n" + 
				"	`descricao` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\r\n" + 
				"	`livroc` INT(10) NOT NULL,\r\n" + 
				"	PRIMARY KEY (`id`),\r\n" + 
				"	CONSTRAINT FK_LivroC FOREIGN KEY (livroc)\r\n" + 
				"	REFERENCES Livro(id)\r\n" + 
				") ENGINE=InnoDB;";
		
		String sqlCreateAluguelLivro = "CREATE TABLE IF NOT EXISTS `AluguelLivro` (\r\n" + 
				"	`id` INT(10) NOT NULL AUTO_INCREMENT,\r\n" + 
				"	`dataAluguel` DATETIME NOT NULL,\r\n" + 
				"	`dataDevolucao` DATETIME NOT NULL,\r\n" + 
				"	`livroAlugado` INT(10) NOT NULL,\r\n" + 
				"	`isDevolvido` BOOLEAN NOT NULL,\r\n" + 
				"	`isAlugado` BOOLEAN NOT NULL,\r\n" + 
				"	`isActive` BOOLEAN NOT NULL default 1,\r\n" + 
				"	PRIMARY KEY (`id`),\r\n" + 
				"	CONSTRAINT FK_LivroAlugado FOREIGN KEY (livroAlugado)\r\n" + 
				"	REFERENCES Livro(id)\r\n" + 
				") ENGINE=InnoDB;";
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
