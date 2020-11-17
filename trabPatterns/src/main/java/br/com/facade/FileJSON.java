package br.com.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import br.com.bean.Livro;

public class FileJSON extends Files{
	
	private static FileWriter file;

	@Override
	public boolean exportar() {
		System.out.println("JSON File");
		Gson gson = new Gson();
		return true;
	}

	@Override
	public boolean exportar(Livro livro) {
		Gson gson = new Gson();
		String json = gson.toJson(livro);
		String filename;
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");  
	    Date date = new Date();
	    filename = "Livro " + formatter.format(date) + ".txt";
        try {
        	 
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("C:\\Users\\Rhyix\\Desktop\\Trabalho_Topicos_Avanc_Tecnologias_Patterns\\filesExports\\" + filename);
            file.write(json);
            Logs("Successfully Copied JSON Object to File...");
            Logs("\nJSON Object: " + json);
 
        } catch (IOException e) {
            e.printStackTrace();
            return false;
 
        } finally {
 
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
		return true;
	}

	@Override
	public boolean exportar(List<Livro> livros) {
		Gson gson = new Gson();
		String json = gson.toJson(livros);
		String filename;
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");  
	    Date date = new Date();
	    filename = "Livros " + formatter.format(date) + ".txt";
        try {
        	 
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("C:\\Users\\Rhyix\\Desktop\\Trabalho_Topicos_Avanc_Tecnologias_Patterns\\filesExports\\" + filename);
            file.write(json);
            Logs("Successfully Copied JSON Object to File...");
            Logs("\nJSON Object: " + json);
 
        } catch (IOException e) {
            e.printStackTrace();
            return false;
 
        } finally {
 
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
		return true;
	}
	
    static public void Logs(String str) {
        System.out.println(str);
    }

}
