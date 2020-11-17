package br.com.observer;

import java.util.List;

import br.com.util.TipoConexao;

public interface Subject {
	public void addObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers();
	
	public void notifyObserversVoid(TipoConexao tc);

	public List notifyObservers(TipoConexao tc);
}
