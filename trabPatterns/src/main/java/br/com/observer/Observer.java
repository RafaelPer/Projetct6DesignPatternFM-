package br.com.observer;

import java.util.Calendar;
import java.util.List;

import br.com.bean.AluguelLivro;
import br.com.bean.Livro;
import br.com.util.TipoConexao;

public interface Observer {

	public void update(Integer idAluguelLivro, Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado,
			Boolean isDevolvido, Boolean isAlugado, Boolean isActive);

	public String update(Integer id, Calendar dataAluguel, Calendar dataDevolucao, Integer livroAlugado,
			Boolean isDevolvido, Boolean isAlugado, Boolean isActive, TipoConexao tc);

}
