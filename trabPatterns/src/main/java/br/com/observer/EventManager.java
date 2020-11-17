package br.com.observer;

import java.util.ArrayList;
import java.util.List;

import br.com.bean.AluguelLivro;
import br.com.bean.Livro;

public class EventManager {
	
	private List<Observer> observers;
	private List<AluguelLivro> aluguelLivro;
	private Livro livroAlugado;
	
//    public EventManager(){
//        observers = new ArrayList<Observer>();
//    }
	
    public void setInfos( List<AluguelLivro> al, Livro l ){
    	this.aluguelLivro = al;
    	this.livroAlugado = l;
    	notifyObservers();
    }
    
    public void addObserver( Observer observer ) {
    	 observers.add( observer );
	}
    public void removeObserver( Observer observer ) {
        int index = observers.indexOf( observer );

        if( index > -1 ){

            observers.remove( observer );
        }
	}
    public void notifyObservers() {
        for( Observer o :observers ){

//            o.update(aluguelLivro, livroAlugado);
        }
	}
}
