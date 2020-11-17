package br.com.observer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.bean.AluguelLivro;
import br.com.bean.Livro;
import br.com.controller.LivroCT;
import br.com.util.TipoConexao;

public class DataDevolucaoListener implements Observer {

	private Subject subject;

	public DataDevolucaoListener(Subject subject) {
		this.subject = subject;
		this.subject.addObserver(this);
	}

	private String display(AluguelLivro al, Livro la) {
		return "O livro: " + la.getId() + " - " + la.getTitulo()
				+ " está com data de devolução atrasada ou no dia de entrega (Aluguel Livro: " + al.getId()
				+ " - Data Devolução: " + al.getDataDevolucao().getTime() + ")";
	}

	@Override
	public String update(Integer idAluguelLivro, Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado,
			Boolean isDevolvido, Boolean isAlugado, Boolean isActive, TipoConexao tc) {

		Calendar c = Calendar.getInstance();

		AluguelLivro al = new AluguelLivro();
		al.setId(idAluguelLivro);
		al.setDataAluguel(dataAluguel);
		al.setDataDevolucao(dataDevolucao);
		al.setLivroAlugado(livroAlugado);
		al.setIsDevolvido(isDevolvido);
		al.setIsAlugado(isAlugado);
		al.setIsActive(isActive);

		LivroCT lct = new LivroCT();
		Livro la = lct.select(livroAlugado, tc);

		String ob = "Livro: " + la.getId() + " - " + la.getTitulo()
				+ " esta com a data de devolução em dia ou esta desativado" + "(Aluguel Livro: " + al.getId()
				+ " - Data Devolução: " + al.getDataDevolucao().getTime() + ")";

		if (c.getTime().compareTo(al.getDataDevolucao().getTime()) >= 0 && al.getIsActive() == true) {
			ob = display(al, la);
		}

		return ob;

//		List<String> listObserver = new ArrayList<String>();
//		for(AluguelLivro al : aluguelLivro) {
//			
//			if(c.getTime().compareTo(al.getDataDevolucao().getTime()) >= 0) {
//				listObserver.add(display(al, livroAlugado));
//			}
//		}
//		return listObserver;

	}

	@Override
	public void update(Integer idAluguelLivro, Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado,
			Boolean isDevolvido, Boolean isAlugado, Boolean isActive) {
		// TODO Auto-generated method stub

	}

}
