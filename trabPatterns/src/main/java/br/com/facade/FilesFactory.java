package br.com.facade;

public abstract class FilesFactory {
    public static Files getExportadorDados(FilesAbstractFactory factory) {
        Files exportadorDados = factory.createExportadorDados();

        return exportadorDados;
    }
}
