package br.com.facade;

public class FileJSONFactory implements FilesAbstractFactory{

	@Override
	public Files createExportadorDados() {
		return new FileJSON();
	}

}
