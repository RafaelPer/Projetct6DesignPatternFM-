package br.com.bean;

import java.util.Objects;

import br.com.bean.Livro;
import br.com.bean.Autor.AutorBuilder;

public class Categoria {
	
	
	private final Integer id;
	private final String nome;
	private final String descricao;
	private final Integer livroc;
	
	public Categoria(Integer id, String nome, String descricao, Integer livroc) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.livroc = livroc;
	}

//	public Categoria(Integer id, String nome, String descricao) {
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.descricao = descricao;
//	}
//	
//	public Categoria(String nome, String descricao) {
//		super();
//		this.nome = nome;
//		this.descricao = descricao;
//	}
//	
//	public Categoria() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
	public Integer getId() {
		return id;
	}
//	
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	
	public String getNome() {
		return nome;
	}
//	
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
	public String getDescricao() {
		return descricao;
	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//
	public Integer getLivroc() {
		return livroc;
	}
//
//	public void setLivroc(Livro livroc) {
//		this.livroc = livroc;
//	}
	
    public static CategoriaBuilder builder() {
        return new CategoriaBuilder();
    }
    
    public static final class CategoriaBuilder {
    	
    	private Integer id;
    	private String nome;
    	private String descricao;
    	private Integer livroc;
    	
        public CategoriaBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        
        public CategoriaBuilder nome(String nome) {
        	Objects.requireNonNull(nome, "O atributo [nome] � obrigat�rio.");
            this.nome = nome;
            return this;
        }
        
        public CategoriaBuilder descricao(String descricao) {
        	Objects.requireNonNull(descricao, "O atributo [descricao] � obrigat�rio.");
            this.descricao = descricao;
            return this;
        }
        
        public CategoriaBuilder livroc(Integer livroc) {
        	Objects.requireNonNull(descricao, "O atributo [livroc] � obrigat�rio.");
            this.livroc = livroc;
            return this;
        }
        
        public Categoria build() {

            return new Categoria(id, nome, descricao, livroc);
        }
    	
    }

}
