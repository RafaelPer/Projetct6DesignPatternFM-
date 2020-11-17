package br.com.util;
import java.sql.Connection;
import br.com.util.ConexaoSQLite;
import br.com.util.ConexaoMySQL;

public abstract class ConexaoFactory {
	public static Conexao getConexao(TipoConexao tipo) {
		Conexao connection = null;
		//Connection con = null;

         switch (tipo) {
             case CONNECTION_MYSQL:
            	 connection = new ConexaoMySQL();
                 break;
             case CONNECTION_SQLITE:
            	 connection = new ConexaoSQLite();
                 break;
         }

        return connection;
    }
}
