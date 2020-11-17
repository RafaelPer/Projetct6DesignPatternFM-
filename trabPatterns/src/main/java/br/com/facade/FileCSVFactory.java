package br.com.facade;

public class FileCSVFactory implements FilesAbstractFactory{
	@Override
	public Files createExportadorDados() {
		return new FileCSV();
	}
}
