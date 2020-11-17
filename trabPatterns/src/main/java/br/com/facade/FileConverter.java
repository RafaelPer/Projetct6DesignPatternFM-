package br.com.facade;

public class FileConverter {
	public Files converter(FilesType ft) {
		Files fileExport = FilesFactory.getExportadorDados(new FileJSONFactory());
        switch (ft) {
        case JSON:
        	fileExport = FilesFactory.getExportadorDados(new FileJSONFactory());
            break;
        case CSV:
        	fileExport = FilesFactory.getExportadorDados(new FileCSVFactory());
            break;
        }
        
        return fileExport;
	}
}
