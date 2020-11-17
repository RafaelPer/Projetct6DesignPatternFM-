package br.com.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;

import br.com.bean.Livro;

public class FileCSV extends Files {

	private static FileWriter file;

	@Override
	public boolean exportar() {
		System.out.println("CSV File");
		return true;
	}

	@Override
	public boolean exportar(Livro livro) {
		String filename;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date date = new Date();
		filename = "C:\\Users\\Rhyix\\Desktop\\Trabalho_Topicos_Avanc_Tecnologias_Patterns\\filesExports\\Livro " + formatter.format(date) + ".csv";
		CellProcessor[] processors = new CellProcessor[] { new ParseInt(), new NotNull(), new NotNull(), null, null,
				null, new ParseInt() };
		ICsvBeanWriter beanWriter = null;
		try {
			beanWriter = new CsvBeanWriter(new FileWriter(filename), CsvPreference.STANDARD_PREFERENCE);
			String[] header = { "id", "titulo", "subTitulo", "secao", "resumo", "descricao", "qtdEstoque" };
			beanWriter.writeHeader(header);
			beanWriter.write(livro, header, processors);
		} catch (IOException ex) {
			System.err.println("Error writing the CSV file: " + ex);
			return false;
		} finally {
			if (beanWriter != null) {
				try {
					beanWriter.close();
				} catch (IOException ex) {
					System.err.println("Error closing the writer: " + ex);
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean exportar(List<Livro> livros) {
		String filename;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date date = new Date();
		filename = "C:\\Users\\Rhyix\\Desktop\\Trabalho_Topicos_Avanc_Tecnologias_Patterns\\filesExports\\Livros " + formatter.format(date) + ".csv";
		CellProcessor[] processors = new CellProcessor[] { new ParseInt(), new NotNull(), new NotNull(), null, null,
				null, new ParseInt() };
		ICsvBeanWriter beanWriter = null;
		try {
			beanWriter = new CsvBeanWriter(new FileWriter(filename), CsvPreference.STANDARD_PREFERENCE);
			String[] header = { "id", "titulo", "subTitulo", "secao", "resumo", "descricao", "qtdEstoque" };
			beanWriter.writeHeader(header);
			for(Livro livro: livros) {
				beanWriter.write(livro, header, processors);
			}
		} catch (IOException ex) {
			System.err.println("Error writing the CSV file: " + ex);
			return false;
		} finally {
			if (beanWriter != null) {
				try {
					beanWriter.close();
				} catch (IOException ex) {
					System.err.println("Error closing the writer: " + ex);
					return false;
				}
			}
		}

		return true;
	}

	static public void Logs(String str) {
		System.out.println(str);
	}
}
