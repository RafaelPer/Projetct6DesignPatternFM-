package br.com.controller;

import java.util.List;

import br.com.bean.AluguelLivro;
import br.com.bean.Livro;
import br.com.dao.AluguelLivroDao;
import br.com.dao.LivroDao;
import br.com.util.TipoConexao;

public class AluguelLivroCT {
	
	private AluguelLivroDao daoAL = AluguelLivroDao.of();

	public void insert(AluguelLivro al, TipoConexao tc) {
//		AluguelLivroDao daoAluguelLivro = new AluguelLivroDao();
		AluguelLivroDao daoAluguelLivro = AluguelLivroDao.safeCopy(daoAL);
		daoAluguelLivro.insert(al, tc);

		LivroDao daoLivro = new LivroDao();
		Livro livro = (Livro) daoLivro.select(al.getLivroAlugado(), tc);
		System.out.println(livro.getTitulo());
		System.out.println(livro.getSubTitulo());
		System.out.println(livro.getQtdEstoque());
		int qtdEstoque = livro.getQtdEstoque() - 1;
		System.out.println(qtdEstoque);
		if(qtdEstoque >= 0) {
			Livro livroup = Livro.builder().id(livro.getId()).titulo(livro.getTitulo()).subTitulo(livro.getSubTitulo())
					.secao(livro.getSecao()).resumo(livro.getResumo()).descricao(livro.getDescricao())
					.qtdEstoque(qtdEstoque).build();
			System.out.println(livroup.getId());
			System.out.println(livroup.getTitulo());
			System.out.println(livroup.getSubTitulo());
			System.out.println(livroup.getSecao());
			System.out.println(livroup.getResumo());
			System.out.println(livroup.getDescricao());
			System.out.println(livroup.getQtdEstoque());
			daoLivro.update(livroup, tc);
		}
		else {
			System.out.println("Não tem livros disponiveis");
		}
	}

	public void update(AluguelLivro al, TipoConexao tc) {
//		AluguelLivroDao daoAluguelLivro = new AluguelLivroDao();
		AluguelLivroDao daoAluguelLivro = AluguelLivroDao.safeCopy(daoAL);
		
		if(al.getIsDevolvido() == true  && al.getIsActive() == true) {
			LivroDao daoLivro = new LivroDao();
			Livro livro = (Livro) daoLivro.select(al.getLivroAlugado(), tc);
			int qtdEstoque = livro.getQtdEstoque() + 1;
			Livro livroup = Livro.builder().id(livro.getId()).titulo(livro.getTitulo()).subTitulo(livro.getSubTitulo())
					.secao(livro.getSecao()).resumo(livro.getResumo()).descricao(livro.getDescricao())
					.qtdEstoque(qtdEstoque).build();
			System.out.println(livroup.getId());
			System.out.println(livroup.getTitulo());
			System.out.println(livroup.getSubTitulo());
			System.out.println(livroup.getSecao());
			System.out.println(livroup.getResumo());
			System.out.println(livroup.getDescricao());
			System.out.println(livroup.getQtdEstoque());
			daoLivro.update(livroup, tc);
			al.setIsActive(false);
			System.out.println(al.getId());
			System.out.println(al.getDataAluguel());
			System.out.println(al.getDataDevolucao());
			System.out.println(al.getIsActive());
			System.out.println(al.getIsAlugado());
			System.out.println(al.getIsDevolvido());
			System.out.println(al.getLivroAlugado());
			daoAluguelLivro.update(al, tc);
		}
	}

	public void delete(Integer i, TipoConexao tc) {
//		AluguelLivroDao daoAluguelLivro = new AluguelLivroDao();
		AluguelLivroDao daoAluguelLivro = AluguelLivroDao.safeCopy(daoAL);
		daoAluguelLivro.delete(i, tc);
	}

	public AluguelLivro select(Integer i, TipoConexao tc) {
//		AluguelLivroDao daoAluguelLivro = new AluguelLivroDao();
		AluguelLivroDao daoAluguelLivro = AluguelLivroDao.safeCopy(daoAL);
		AluguelLivro al = (AluguelLivro) daoAluguelLivro.select(i, tc);
		return al;
	}

	public List select(TipoConexao tc) {
//		AluguelLivroDao daoAluguelLivro = new AluguelLivroDao();
		AluguelLivroDao daoAluguelLivro = AluguelLivroDao.safeCopy(daoAL);
		List ls = daoAluguelLivro.select(tc);
		return ls;
	}
}
