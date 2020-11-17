package br.com.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.bean.Autor;
import br.com.bean.Categoria;
import br.com.bean.Categoria.CategoriaBuilder;

public class Livro {
	
	
	private final Integer id;
	private final String titulo;
	private final String subTitulo;
	private final String secao;
	private final String resumo;
	private final String descricao;
	private final int qtdEstoque;
//	private final List<Categoria> categoriasDoLivro;
//	private final List<Autor> autoresDoLivro;
	
//	public Livro(Integer id, String titulo, String subTitulo, String secao, String resumo, String descricao/*,
//			List<Categoria> categoriasDoLivro, List<Autor> autoresDoLivro*/) {
//		super();
//		this.id = id;
//		this.titulo = titulo;
//		this.subTitulo = subTitulo;
//		this.secao = secao;
//		this.resumo = resumo;
//		this.descricao = descricao;
//		this.categoriasDoLivro = categoriasDoLivro;
//		this.autoresDoLivro = autoresDoLivro;
//	}

//	public Livro(Integer id, String titulo, String subTitulo, String secao, String resumo, String descricao) {
//		super();
//		this.id = id;
//		this.titulo = titulo;
//		this.subTitulo = subTitulo;
//		this.secao = secao;
//		this.resumo = resumo;
//		this.descricao = descricao;
//	}

//	public Livro(String titulo, String subTitulo, String secao, String resumo, String descricao) {
//		super();
//		this.titulo = titulo;
//		this.subTitulo = subTitulo;
//		this.secao = secao;
//		this.resumo = resumo;
//		this.descricao = descricao;
//	}
//	
//	public Livro() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public Livro(Integer id, String titulo, String subTitulo, String secao, String resumo, String descricao,
			int qtdEstoque) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.secao = secao;
		this.resumo = resumo;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getId() {
		return id;
	}
	
	public int getQtdEstoque() {
		return qtdEstoque;
	}

	//	public void setId(Integer id) {
//		this.id = id;
//	}
//	
	public String getTitulo() {
		return titulo;
	}
	
//	public void setTitulo(String titulo) {
//		this.titulo = titulo;
//	}
//	
	public String getSubTitulo() {
		return subTitulo;
	}
	
//	public void setSubTitulo(String subTitulo) {
//		this.subTitulo = subTitulo;
//	}
//	
	public String getSecao() {
		return secao;
	}
	
//	public void setSecao(String secao) {
//		this.secao = secao;
//	}
//	
	public String getResumo() {
		return resumo;
	}
	
//	public void setResumo(String resumo) {
//		this.resumo = resumo;
//	}
//
	public String getDescricao() {
		return descricao;
	}

//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//
//	public List<Categoria> getCategoriasDoLivro() {
//		return categoriasDoLivro;
//	}
//
//	public void setCategoriasDoLivro(List<Categoria> categoriasDoLivro) {
//		this.categoriasDoLivro = categoriasDoLivro;
//	}
//
//	public List<Autor> getAutoresDoLivro() {
//		return autoresDoLivro;
//	}
//
//	public void setAutoresDoLivro(List<Autor> autoresDoLivro) {
//		this.autoresDoLivro = autoresDoLivro;
//	}
	
    public static LivroBuilder builder() {
        return new LivroBuilder();
    }
    
    public static final class LivroBuilder {
    	
    	private Integer id;
    	private String titulo;
    	private String subTitulo;
    	private String secao;
    	private String resumo;
    	private String descricao;
    	private int qtdEstoque;
//    	private List<Categoria> categoriasDoLivro = new ArrayList<Categoria>();
//    	private List<Autor> autoresDoLivro = new ArrayList<Autor>();
    	
        public LivroBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        
        public LivroBuilder titulo(String titulo) {
        	Objects.requireNonNull(titulo, "O atributo [titulo] � obrigat�rio.");
            this.titulo = titulo;
            return this;
        }
        
        public LivroBuilder subTitulo(String subTitulo) {
        	Objects.requireNonNull(subTitulo, "O atributo [subTitulo] � obrigat�rio.");
            this.subTitulo = subTitulo;
            return this;
        }
        
        public LivroBuilder secao(String secao) {
            this.secao = secao;
            return this;
        }
        
        public LivroBuilder resumo(String resumo) {
            this.resumo = resumo;
            return this;
        }
        
        public LivroBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }
        
        public LivroBuilder qtdEstoque(int qtdEstoque) {
        	Objects.requireNonNull(subTitulo, "O atributo [subTitulo] � obrigat�rio.");
            this.qtdEstoque = qtdEstoque;
            return this;
        }
        
//        public LivroBuilder categoriasDoLivro(List<Categoria> categoriasDoLivro) {
//            this.categoriasDoLivro = categoriasDoLivro;
//            return this;
//        }
//        
//        public LivroBuilder autoresDoLivro(List<Autor> autoresDoLivro) {
//            this.autoresDoLivro = autoresDoLivro;
//            return this;
//        }
        
        public Livro build() {

            return new Livro(id, titulo, subTitulo, secao, resumo, descricao, qtdEstoque);
        }
    	
    }
	
}
