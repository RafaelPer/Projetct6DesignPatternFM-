package br.com.bean;

import java.util.Objects;

import br.com.bean.Livro;

public class Autor {
	
	
	private final Integer id;
	private final String nome;
	private final String rg;
	private final String cpf;
	private final String contatoTel;
	private final String contatoCel;
	private final String contatoEmail;
	private final Integer livroa;
	
	public Autor(Integer id, String nome, String rg, String cpf, String contatoTel, String contatoCel,
			String contatoEmail, Integer livroa) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.contatoTel = contatoTel;
		this.contatoCel = contatoCel;
		this.contatoEmail = contatoEmail;
		this.livroa = livroa;
	}

//	public Autor(Integer id, String nome, String rg, String cpf, String contatoTel, String contatoCel,
//			String contatoEmail) {
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.rg = rg;
//		this.cpf = cpf;
//		this.contatoTel = contatoTel;
//		this.contatoCel = contatoCel;
//		this.contatoEmail = contatoEmail;
//	}

//	public Autor(String nome, String rg, String cpf, String contatoTel, String contatoCel, String contatoEmail) {
//		super();
//		this.nome = nome;
//		this.rg = rg;
//		this.cpf = cpf;
//		this.contatoTel = contatoTel;
//		this.contatoCel = contatoCel;
//		this.contatoEmail = contatoEmail;
//	}
	
//	public Autor() {
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
	public String getRg() {
		return rg;
	}
//	
//	public void setRg(String rg) {
//		this.rg = rg;
//	}
//	
	public String getCpf() {
		return cpf;
	}
//	
//	public void setCpf(String cpf) {
//		this.cpf = cpf;
//	}
//	
	public String getContatoTel() {
		return contatoTel;
	}
//	
//	public void setContatoTel(String contatoTel) {
//		this.contatoTel = contatoTel;
//	}
//	
	public String getContatoCel() {
		return contatoCel;
	}
//	
//	public void setContatoCel(String contatoCel) {
//		this.contatoCel = contatoCel;
//	}
//	
	public String getContatoEmail() {
		return contatoEmail;
	}
//	
//	public void setContatoEmail(String contatoEmail) {
//		this.contatoEmail = contatoEmail;
//	}
//
	public Integer getLivroa() {
		return livroa;
	}
//
//	public void setLivroa(Livro livroa) {
//		this.livroa = livroa;
//	}
	
    public static AutorBuilder builder() {
        return new AutorBuilder();
    }
    
    public static final class AutorBuilder {
    	
    	private Integer id;
    	private String nome;
    	private String rg;
    	private String cpf;
    	private String contatoTel;
    	private String contatoCel;
    	private String contatoEmail;
    	private Integer livroa;
    	
        public AutorBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        
        public AutorBuilder nome(String nome) {
        	Objects.requireNonNull(nome, "O atributo [nome] � obrigat�rio.");
            this.nome = nome;
            return this;
        }
        
        public AutorBuilder rg(String rg) {
        	Objects.requireNonNull(rg, "O atributo [rg] � obrigat�rio.");
            this.rg = rg;
            return this;
        }
        
        public AutorBuilder cpf(String cpf) {
        	Objects.requireNonNull(cpf, "O atributo [cpf] � obrigat�rio.");
            this.cpf = cpf;
            return this;
        }
        
        public AutorBuilder contatoTel(String contatoTel) {
        	Objects.requireNonNull(contatoTel, "O atributo [contatoTel] � obrigat�rio.");
            this.contatoTel = contatoTel;
            return this;
        }
        
        public AutorBuilder contatoCel(String contatoCel) {
            this.contatoCel = contatoCel;
            return this;
        }
        
        public AutorBuilder contatoEmail(String contatoEmail) {
        	Objects.requireNonNull(contatoEmail, "O atributo [contatoEmail] � obrigat�rio.");
            this.contatoEmail = contatoEmail;
            return this;
        }
        
        public AutorBuilder livroa(Integer livroa) {
        	Objects.requireNonNull(contatoEmail, "O atributo [livroa] � obrigat�rio.");
            this.livroa = livroa;
            return this;
        }
        
        public Autor build() {

            return new Autor(id, nome, rg, cpf, contatoTel, contatoCel, contatoEmail, livroa);
        }
    	
    }
	
}
