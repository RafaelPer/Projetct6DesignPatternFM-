package br.com.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.observer.Observer;
import br.com.observer.Subject;
import br.com.util.TipoConexao;

public class AluguelLivro implements Subject {

	private Integer id;
	private Calendar dataAluguel;
	private Calendar dataDevolucao;
	private Integer livroAlugado;
	private Boolean isDevolvido;
	private Boolean isAlugado;
	private Boolean isActive;
	private List<Observer> observers;

	public AluguelLivro(Integer id, Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado,
			Boolean isDevolvido, Boolean isAlugado, Boolean isActive) {
		super();
		this.id = id;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.livroAlugado = livroAlugado;
		this.isDevolvido = isDevolvido;
		this.isAlugado = isAlugado;
		this.isActive = isActive;
	}

	public AluguelLivro(Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado, Boolean isDevolvido,
			Boolean isAlugado, Boolean isActive) {
		super();
		this.id = id;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.livroAlugado = livroAlugado;
		this.isDevolvido = isDevolvido;
		this.isAlugado = isAlugado;
		this.isActive = isActive;
	}

	public AluguelLivro(Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado, Boolean isDevolvido,
			Boolean isAlugado) {
		super();
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.livroAlugado = livroAlugado;
		this.isDevolvido = isDevolvido;
		this.isAlugado = isAlugado;
	}

	public AluguelLivro(Integer id, Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado,
			Boolean isDevolvido, Boolean isAlugado) {
		super();
		this.id = id;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.livroAlugado = livroAlugado;
		this.isDevolvido = isDevolvido;
		this.isAlugado = isAlugado;
	}

	public AluguelLivro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AluguelLivro(String teste) {
		observers = new ArrayList<Observer>();
	}

//	public void setInfos(Integer idAluguelLivro, Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado,
//			Boolean isDevolvido, Boolean isAlugado, Boolean isActive, TipoConexao tc) {
//		
//		List<String> ob= new ArrayList<String>();
//		
//		this.id = id;
//		this.dataAluguel = dataAluguel;
//		this.dataDevolucao = dataDevolucao;
//		this.livroAlugado = livroAlugado;
//		this.isDevolvido = isDevolvido;
//		this.isAlugado = isAlugado;
//
//		ob = notifyObservers(tc);
//		return ob;
//	}
	
	public List setInfos(Integer idAluguelLivro, Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado,
			Boolean isDevolvido, Boolean isAlugado, Boolean isActive, TipoConexao tc) {
		
		List<String> ob = new ArrayList<String>();
		
		this.id = idAluguelLivro;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.livroAlugado = livroAlugado;
		this.isDevolvido = isDevolvido;
		this.isAlugado = isAlugado;
		this.isActive = isActive;

		ob = notifyObservers(tc);
		return ob;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(Calendar dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Integer getLivroAlugado() {
		return livroAlugado;
	}

	public void setLivroAlugado(Integer livroAlugado) {
		this.livroAlugado = livroAlugado;
	}

	public Boolean getIsDevolvido() {
		return isDevolvido;
	}

	public void setIsDevolvido(Boolean isDevolvido) {
		this.isDevolvido = isDevolvido;
	}

	public Boolean getIsAlugado() {
		return isAlugado;
	}

	public void setIsAlugado(Boolean isAlugado) {
		this.isAlugado = isAlugado;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		int index = observers.indexOf(observer);

		if (index > -1) {

			observers.remove(observer);
		}

	}

	@Override
	public List notifyObservers(TipoConexao tc) {
		List<String> ob = new ArrayList<String>();
		for (Observer o : observers) {

			ob.add(o.update(id, dataAluguel, dataDevolucao, livroAlugado, isDevolvido, isAlugado, isActive, tc));
		}
		return ob;
	}
	
	@Override
	public void notifyObserversVoid(TipoConexao tc) {
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
}
