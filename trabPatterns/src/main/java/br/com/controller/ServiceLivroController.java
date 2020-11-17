package br.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

import br.com.bean.AluguelLivro;
import br.com.bean.Autor;
import br.com.bean.Categoria;
import br.com.bean.Livro;
import br.com.controller.LivroCT;
import br.com.facade.FileConverter;
import br.com.facade.Files;
import br.com.facade.FilesType;
import br.com.observer.DataDevolucaoListener;
import br.com.util.TipoConexao;

@Path("/service")
public class ServiceLivroController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/convertBookToJSONSQLite/{codigo}")
	public Response convertBookToJSONSQLite(@PathParam("codigo") Integer codigo) {
		LivroCT lct = new LivroCT();
		try {
			Livro livro = lct.select(codigo, TipoConexao.CONNECTION_SQLITE);
			FileConverter fc = new FileConverter();
			Files file = fc.converter(FilesType.JSON);
			System.out.println(file);
			file.exportar(livro);
			return Response.status(Response.Status.OK).entity("Livro Convertido em arquivo JSON").build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao gerar arquivo JSON: " + e.getMessage()).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/convertBookToJSONMySQL/{codigo}")
	public Response convertBookToJSONMySQL(@PathParam("codigo") Integer codigo) {
		LivroCT lct = new LivroCT();
		try {
			Livro livro = lct.select(codigo, TipoConexao.CONNECTION_MYSQL);
			FileConverter fc = new FileConverter();
			Files file = fc.converter(FilesType.JSON);
			System.out.println(file);
			file.exportar(livro);
			return Response.status(Response.Status.OK).entity("Livro Convertido em arquivo JSON").build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao gerar arquivo JSON: " + e.getMessage()).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/convertBookToCSVSQLite/{codigo}")
	public Response convertBookToCSVSQLite(@PathParam("codigo") Integer codigo) {
		LivroCT lct = new LivroCT();
		try {
			Livro livro = lct.select(codigo, TipoConexao.CONNECTION_SQLITE);
			FileConverter fc = new FileConverter();
			Files file = fc.converter(FilesType.CSV);
			System.out.println(file);
			file.exportar(livro);
			return Response.status(Response.Status.OK).entity("Livro Convertido em arquivo JSON").build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao gerar arquivo JSON: " + e.getMessage()).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/convertBookToCSVMySQL/{codigo}")
	public Response convertBookToCSVMySQL(@PathParam("codigo") Integer codigo) {
		LivroCT lct = new LivroCT();
		try {
			Livro livro = lct.select(codigo, TipoConexao.CONNECTION_MYSQL);
			FileConverter fc = new FileConverter();
			Files file = fc.converter(FilesType.CSV);
			System.out.println(file);
			file.exportar(livro);
			return Response.status(Response.Status.OK).entity("Livro Convertido em arquivo JSON").build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao gerar arquivo JSON: " + e.getMessage()).build();
		}
	}
	
	// =========================================================================
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/observerDataDevSQLite")
	public Response observerDataDevAluguelLivroSQLite() {
//		List<AluguelLivro> aluguelLivros = new ArrayList<AluguelLivro>();
		Gson gson = new Gson();
		AluguelLivroCT alct = new AluguelLivroCT();
		List<List<String>> lo = new ArrayList<List<String>>();
		try {
			List<AluguelLivro> listaAluguelLivros = alct.select(TipoConexao.CONNECTION_SQLITE);

			for (AluguelLivro aluguelLivro : listaAluguelLivros) {
				AluguelLivro teste = new AluguelLivro("Teste");
				DataDevolucaoListener dataDevolucaoListener = new DataDevolucaoListener(teste);
//				new AluguelLivro(aluguelLivro.getId(), aluguelLivro.getDataAluguel(),
//						aluguelLivro.getDataDevolucao(), aluguelLivro.getLivroAlugado(), aluguelLivro.getIsDevolvido(),
//						aluguelLivro.getIsAlugado()));
				lo.add(teste.setInfos(aluguelLivro.getId(), aluguelLivro.getDataAluguel(), aluguelLivro.getDataDevolucao(), 
						aluguelLivro.getLivroAlugado(), aluguelLivro.getIsDevolvido(), aluguelLivro.getIsAlugado(), 
						aluguelLivro.getIsActive(), TipoConexao.CONNECTION_SQLITE));
				
			}
			String json = gson.toJson(lo);
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao gerar observador de data de devolução: " + e.getMessage()).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/observerDataDevMySQL")
	public Response observerDataDevAluguelLivroMySQL() {
//		List<AluguelLivro> aluguelLivros = new ArrayList<AluguelLivro>();
		Gson gson = new Gson();
		AluguelLivroCT alct = new AluguelLivroCT();
		List<String> lo = new ArrayList<String>();
		try {
			List<AluguelLivro> listaAluguelLivros = alct.select(TipoConexao.CONNECTION_SQLITE);

			for (AluguelLivro aluguelLivro : listaAluguelLivros) {
				AluguelLivro teste = new AluguelLivro("Teste");
				DataDevolucaoListener dataDevolucaoListener = new DataDevolucaoListener(teste);
//				new AluguelLivro(aluguelLivro.getId(), aluguelLivro.getDataAluguel(),
//						aluguelLivro.getDataDevolucao(), aluguelLivro.getLivroAlugado(), aluguelLivro.getIsDevolvido(),
//						aluguelLivro.getIsAlugado()));
				lo = teste.setInfos(aluguelLivro.getId(), aluguelLivro.getDataAluguel(), aluguelLivro.getDataDevolucao(), 
						aluguelLivro.getLivroAlugado(), aluguelLivro.getIsDevolvido(), aluguelLivro.getIsAlugado(), 
						aluguelLivro.getIsActive(), TipoConexao.CONNECTION_SQLITE);
				
			}
			String json = gson.toJson(lo);
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao gerar observador de data de devolução: " + e.getMessage()).build();
		}
	}

	// =========================================================================

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createTableSQLite")
	public Response CriarTabelaSQLite(String liv) {
		try {
			CreateTablesCT ct = new CreateTablesCT();
			ct.createNewsTables(TipoConexao.CONNECTION_SQLITE);

//			return "Livro cadastrado com sucesso!";
			return Response.status(Response.Status.OK).entity("Tabelas criadas com sucesso!").build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao criar databases " + e.getMessage())
					.build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createTableMySQL")
	public Response CriarTabelaMySQL(String liv) {
		try {
			CreateTablesCT ct = new CreateTablesCT();
			ct.createNewsTables(TipoConexao.CONNECTION_MYSQL);

//			return "Livro cadastrado com sucesso!";
			return Response.status(Response.Status.OK).entity("Tabelas criadas com sucesso!").build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao criar databases " + e.getMessage())
					.build();
		}
	}

	// =========================================================================

	@POST
//	@Consumes("application/json; charset=UTF-8")
//	@Produces("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createBookSQLite")
//	public String CadastrarLivroSQLite(Livro livro) {
	public Response CadastrarLivroSQLite(String liv) {
		Gson gson = new Gson();
		Livro livro = gson.fromJson(liv, Livro.class);
		System.out.println(liv);
		System.out.println(livro.getTitulo());
		System.out.println(livro.getSubTitulo());
		try {
			LivroCT lct = new LivroCT();
			lct.insert(livro, TipoConexao.CONNECTION_SQLITE);

//			return "Livro cadastrado com sucesso!";
			return Response.status(Response.Status.OK).entity("Livro cadastrado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao cadastrar um livro " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar um livro " + e.getMessage())
					.build();
		}

	}

	@POST
//	@Consumes("application/json; charset=UTF-8")
//	@Produces("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createBookMySQL")
//	public String CadastrarLivroMySQL(Livro livro) {
	public Response CadastrarLivroMySQL(String liv) {
		Gson gson = new Gson();
		Livro livro = gson.fromJson(liv, Livro.class);
		System.out.println(liv);
		System.out.println(livro.getTitulo());
		System.out.println(livro.getSubTitulo());
		try {
			LivroCT lct = new LivroCT();
			lct.insert(livro, TipoConexao.CONNECTION_MYSQL);

//			return "Livro cadastrado com sucesso!";
			return Response.status(Response.Status.OK).entity("Livro cadastrado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao cadastrar um livro " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar um livro " + e.getMessage())
					.build();
		}

	}

	@PUT
//	@Produces("application/json; charset=UTF-8")
//	@Consumes("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterBookSQLite")
//	public String AlterarLivroSQLite(Livro livro) {
	public Response AlterarLivroSQLite(String liv) {
		Gson gson = new Gson();
		Livro livro = gson.fromJson(liv, Livro.class);
		System.out.println(liv);
		System.out.println(livro.getTitulo());
		System.out.println(livro.getSubTitulo());
		try {

			LivroCT lct = new LivroCT();
			lct.update(livro, TipoConexao.CONNECTION_SQLITE);

//			return "Livro alterado com sucesso!";
			return Response.status(Response.Status.OK).entity("Livro alterado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao alterar o livro " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar o livro " + e.getMessage())
					.build();
		}

	}

	@PUT
//	@Produces("application/json; charset=UTF-8")
//	@Consumes("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterBookMySQL")
//	public String AlterarLivroMySQL(Livro livro) {
	public Response AlterarLivroMySQL(String liv) {
		Gson gson = new Gson();
		Livro livro = gson.fromJson(liv, Livro.class);
		System.out.println(liv);
		System.out.println(livro.getTitulo());
		System.out.println(livro.getSubTitulo());
		try {

			LivroCT lct = new LivroCT();
			lct.update(livro, TipoConexao.CONNECTION_MYSQL);

//			return "Livro alterado com sucesso!";
			return Response.status(Response.Status.OK).entity("Livro alterado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao alterar o livro " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar o livro " + e.getMessage())
					.build();

		}

	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allBooksSQLite")
//	public List<Livro> TodosLivrosSQLite() {
	public Response TodosLivrosSQLite() {

		List<Livro> livros = new ArrayList<Livro>();
		Gson gson = new Gson();
		LivroCT lct = new LivroCT();
		try {
			List<Livro> listaLivros = lct.select(TipoConexao.CONNECTION_SQLITE);

			for (Livro livro : listaLivros) {

				livros.add(new Livro(livro.getId(), livro.getTitulo(), livro.getSubTitulo(),
						livro.getSecao() == null ? "" : livro.getSecao(),
						livro.getResumo() == null ? "" : livro.getResumo(),
						livro.getDescricao() == null ? "" : livro.getDescricao(), livro.getQtdEstoque()));
			}
			String json = gson.toJson(livros);
			System.out.println(json);
//			return livros;
//			return json;
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
//			return "Erro ao buscar os livros " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar os livros " + e.getMessage())
					.build();
		}
	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allBooksMySQL")
//	public List<Livro> TodosLivrosMySQL() {
	public Response TodosLivrosMySQL() {

		List<Livro> livros = new ArrayList<Livro>();
		Gson gson = new Gson();
		LivroCT lct = new LivroCT();
		try {
			List<Livro> listaLivros = lct.select(TipoConexao.CONNECTION_MYSQL);

			for (Livro livro : listaLivros) {

//				livros.add(new Livro(livro.getId(), livro.getTitulo(), livro.getSubTitulo(), livro.getSecao(),
//						livro.getResumo(), livro.getDescricao()));
				livros.add(new Livro(livro.getId(), livro.getTitulo(), livro.getSubTitulo(),
						livro.getSecao() == null ? "" : livro.getSecao(),
						livro.getResumo() == null ? "" : livro.getResumo(),
						livro.getDescricao() == null ? "" : livro.getDescricao(), livro.getQtdEstoque()));
			}
			String json = gson.toJson(livros);
			System.out.println(json);
//			return livros;
//			return json;
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
//			return "Erro ao buscar os livros " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar os livros " + e.getMessage())
					.build();
		}
	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBookByIDSQLite/{codigo}")
//	public Livro GetLivroByIDSQLite(@PathParam("codigo") Integer codigo) {
	public Response GetLivroByIDSQLite(@PathParam("codigo") Integer codigo) {
		Gson gson = new Gson();
		LivroCT lct = new LivroCT();
		try {
			Livro livro = lct.select(codigo, TipoConexao.CONNECTION_SQLITE);
			if (livro != null) {
//				return new Livro(livro.getId(), livro.getTitulo(), livro.getSubTitulo(), livro.getSecao(),
//						livro.getResumo(), livro.getDescricao());
				String json = gson.toJson(new Livro(livro.getId(), livro.getTitulo(), livro.getSubTitulo(),
						livro.getSecao() == null ? "" : livro.getSecao(),
						livro.getResumo() == null ? "" : livro.getResumo(),
						livro.getDescricao() == null ? "" : livro.getResumo(), livro.getQtdEstoque()));
				return Response.status(Response.Status.OK).entity(json).build();
			} else {
//				return null;	
				return Response.status(Response.Status.OK).entity("Livro não encontrado").build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar o livro " + e.getMessage())
					.build();
		}
	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBookByIDMySQL/{codigo}")
//	public Livro GetLivroByIDMySQL(@PathParam("codigo") Integer codigo) {
	public Response GetLivroByIDMySQL(@PathParam("codigo") Integer codigo) {
		Gson gson = new Gson();
		LivroCT lct = new LivroCT();
		try {
			Livro livro = lct.select(codigo, TipoConexao.CONNECTION_MYSQL);
			if (livro != null) {
//				return new Livro(livro.getId(), livro.getTitulo(), livro.getSubTitulo(), livro.getSecao(),
//						livro.getResumo(), livro.getDescricao());
				String json = gson.toJson(new Livro(livro.getId(), livro.getTitulo(), livro.getSubTitulo(),
						livro.getSecao() == null ? "" : livro.getSecao(),
						livro.getResumo() == null ? "" : livro.getResumo(),
						livro.getDescricao() == null ? "" : livro.getResumo(), livro.getQtdEstoque()));
				return Response.status(Response.Status.OK).entity(json).build();
			} else {
//				return null;	
				return Response.status(Response.Status.OK).entity("Livro não encontrado").build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar o livro " + e.getMessage())
					.build();
		}
	}

	@DELETE
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeBookByIDSQLite/{codigo}")
//	public String ExcluirLivroByIDSQLite(@PathParam("codigo") Integer codigo) {
	public Response ExcluirLivroByIDSQLite(@PathParam("codigo") Integer codigo) {
		LivroCT lct = new LivroCT();
		try {
			lct.delete(codigo, TipoConexao.CONNECTION_SQLITE);

//			return "Registro excluido com sucesso!";
			return Response.status(Response.Status.OK).entity("Livro excluido com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao excluir o registro! " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao excluir o livro " + e.getMessage())
					.build();
		}

	}

	@DELETE
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeBookByIDMySQL/{codigo}")
//	public String ExcluirLivroByIDMySQL(@PathParam("codigo") Integer codigo) {
	public Response ExcluirLivroByIDMySQL(@PathParam("codigo") Integer codigo) {
		LivroCT lct = new LivroCT();
		try {
			lct.delete(codigo, TipoConexao.CONNECTION_MYSQL);

//			return "Registro excluido com sucesso!";
			return Response.status(Response.Status.OK).entity("Livro excluido com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao excluir o registro! " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao excluir o livro " + e.getMessage())
					.build();
		}

	}

	// =========================================================================

	@POST
//	@Consumes("application/json; charset=UTF-8")
//	@Produces("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createAuthorSQLite")
//	public String CadastrarAutorSQLite(Autor autor) {
	public Response CadastrarAutorSQLite(String aut) {
		Gson gson = new Gson();
		Autor autor = gson.fromJson(aut, Autor.class);
		System.out.println(aut);
		System.out.println(autor.getNome());
		System.out.println(autor.getRg());
		try {
			AutorCT act = new AutorCT();
			act.insert(autor, TipoConexao.CONNECTION_SQLITE);

//			return "Autor cadastrado com sucesso!";
			return Response.status(Response.Status.OK).entity("Autor cadastrado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao cadastrar um Autor " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar um Autor " + e.getMessage())
					.build();
		}

	}

	@POST
//	@Consumes("application/json; charset=UTF-8")
//	@Produces("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createAuthorMySQL")
//	public String CadastrarAutorMySQL(Autor autor) {
	public Response CadastrarAutorMySQL(String aut) {
		Gson gson = new Gson();
		Autor autor = gson.fromJson(aut, Autor.class);
		System.out.println(aut);
		System.out.println(autor.getNome());
		System.out.println(autor.getRg());
		try {
			AutorCT act = new AutorCT();
			act.insert(autor, TipoConexao.CONNECTION_MYSQL);

//			return "Autor cadastrado com sucesso!";
			return Response.status(Response.Status.OK).entity("Autor cadastrado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao cadastrar um Autor " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar um Autor " + e.getMessage())
					.build();
		}

	}

	@PUT
//	@Produces("application/json; charset=UTF-8")
//	@Consumes("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterAuthorSQLite")
//	public String AlterarAutorSQLite(Autor autor) {
	public Response AlterarAutorSQLite(String aut) {
		Gson gson = new Gson();
		Autor autor = gson.fromJson(aut, Autor.class);
		System.out.println(aut);
		System.out.println(autor.getNome());
		System.out.println(autor.getRg());
		try {

			AutorCT act = new AutorCT();
			act.update(autor, TipoConexao.CONNECTION_SQLITE);

//			return "Autor alterado com sucesso!";
			return Response.status(Response.Status.OK).entity("Autor alterado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao alterar o Autor " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar o Autor " + e.getMessage())
					.build();
		}

	}

	@PUT
//	@Produces("application/json; charset=UTF-8")
//	@Consumes("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterAuthorMySQL")
//	public String AlterarAutorMySQL(Autor autor) {
	public Response AlterarAutorMySQL(String aut) {
		Gson gson = new Gson();
		Autor autor = gson.fromJson(aut, Autor.class);
		System.out.println(aut);
		System.out.println(autor.getNome());
		System.out.println(autor.getRg());
		try {

			AutorCT act = new AutorCT();
			act.update(autor, TipoConexao.CONNECTION_MYSQL);

//			return "Autor alterado com sucesso!";
			return Response.status(Response.Status.OK).entity("Autor alterado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao alterar o Autor " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar o Autor " + e.getMessage())
					.build();
		}

	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allAuthorsSQLite")
//	public List<Autor> TodosAutoresSQLite() {
	public Response TodosAutoresSQLite() {

		List<Autor> autores = new ArrayList<Autor>();
		Gson gson = new Gson();
		AutorCT act = new AutorCT();
		try {
			List<Autor> listaAutores = act.select(TipoConexao.CONNECTION_SQLITE);

			for (Autor autor : listaAutores) {

				autores.add(new Autor(autor.getId(), autor.getNome(), autor.getRg(), autor.getCpf(),
						autor.getContatoTel(), autor.getContatoCel() == null ? "" : autor.getContatoCel(),
						autor.getContatoEmail(), autor.getLivroa()));
			}
			String json = gson.toJson(autores);
			System.out.println(json);
//			return autores;
//			return json;
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
//			return "Erro ao buscar os livros " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar os autores " + e.getMessage())
					.build();
		}
	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allAuthorsMySQL")
//	public List<Autor> TodosAutoresMySQL() {
	public Response TodosAutoresMySQL() {

		List<Autor> autores = new ArrayList<Autor>();
		Gson gson = new Gson();
		AutorCT act = new AutorCT();
		try {
			List<Autor> listaAutores = act.select(TipoConexao.CONNECTION_MYSQL);

			for (Autor autor : listaAutores) {

				autores.add(new Autor(autor.getId(), autor.getNome(), autor.getRg(), autor.getCpf(),
						autor.getContatoTel(), autor.getContatoCel() == null ? "" : autor.getContatoCel(),
						autor.getContatoEmail(), autor.getLivroa()));
			}
			String json = gson.toJson(autores);
			System.out.println(json);
//			return autores;
//			return json;
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
//			return "Erro ao buscar os livros " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar os autores " + e.getMessage())
					.build();
		}
	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAuthorByIDSQLite/{codigo}")
//	public Autor GetAutorByIDSQLite(@PathParam("codigo") Integer codigo) {
	public Response GetAutorByIDSQLite(@PathParam("codigo") Integer codigo) {
		Gson gson = new Gson();
		AutorCT act = new AutorCT();
		try {
			Autor autor = act.select(codigo, TipoConexao.CONNECTION_SQLITE);
			if (autor != null) {
//				return new Autor(autor.getId(), autor.getNome(), autor.getRg(), autor.getCpf(),
//				autor.getContatoTel(), autor.getContatoCel() == null ? "" : autor.getContatoCel(),
//				autor.getContatoEmail(), autor.getLivroa());
				String json = gson.toJson(new Autor(autor.getId(), autor.getNome(), autor.getRg(), autor.getCpf(),
						autor.getContatoTel(), autor.getContatoCel() == null ? "" : autor.getContatoCel(),
						autor.getContatoEmail(), autor.getLivroa()));
				return Response.status(Response.Status.OK).entity(json).build();
			} else {
//				return null;	
				return Response.status(Response.Status.OK).entity("Autor não encontrado").build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar o autor " + e.getMessage())
					.build();
		}
	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAuthorByIDMySQL/{codigo}")
//	public Autor GetAutorByIDMySQL(@PathParam("codigo") Integer codigo) {
	public Response GetAutorByIDMySQL(@PathParam("codigo") Integer codigo) {
		Gson gson = new Gson();
		AutorCT act = new AutorCT();
		try {
			Autor autor = act.select(codigo, TipoConexao.CONNECTION_MYSQL);
			if (autor != null) {
//				return new Autor(autor.getId(), autor.getNome(), autor.getRg(), autor.getCpf(),
//				autor.getContatoTel(), autor.getContatoCel() == null ? "" : autor.getContatoCel(),
//				autor.getContatoEmail(), autor.getLivroa());
				String json = gson.toJson(new Autor(autor.getId(), autor.getNome(), autor.getRg(), autor.getCpf(),
						autor.getContatoTel(), autor.getContatoCel() == null ? "" : autor.getContatoCel(),
						autor.getContatoEmail(), autor.getLivroa()));
				return Response.status(Response.Status.OK).entity(json).build();
			} else {
//				return null;	
				return Response.status(Response.Status.OK).entity("Autor não encontrado").build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar o autor " + e.getMessage())
					.build();
		}
	}

	@DELETE
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeAuthorByIDSQLite/{codigo}")
//	public String ExcluirAutorByIDSQLite(@PathParam("codigo") Integer codigo) {
	public Response ExcluirAutorByIDSQLite(@PathParam("codigo") Integer codigo) {
		AutorCT act = new AutorCT();
		try {
			act.delete(codigo, TipoConexao.CONNECTION_SQLITE);

//			return "Registro excluido com sucesso!";
			return Response.status(Response.Status.OK).entity("Autor excluido com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao excluir o registro! " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao excluir o autor " + e.getMessage())
					.build();
		}

	}

	@DELETE
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeAuthorByIDMySQL/{codigo}")
//	public String ExcluirAutorByIDMySQL(@PathParam("codigo") Integer codigo) {
	public Response ExcluirAutorByIDMySQL(@PathParam("codigo") Integer codigo) {
		AutorCT act = new AutorCT();
		try {
			act.delete(codigo, TipoConexao.CONNECTION_MYSQL);

//			return "Registro excluido com sucesso!";
			return Response.status(Response.Status.OK).entity("Autor excluido com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao excluir o registro! " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao excluir o autor " + e.getMessage())
					.build();
		}

	}

	// =========================================================================

	@POST
//	@Consumes("application/json; charset=UTF-8")
//	@Produces("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createCategorySQLite")
//	public String CadastrarCategoriaSQLite(Categoria categoria) {
	public Response CadastrarCategoriaSQLite(String cat) {
		Gson gson = new Gson();
		Categoria categoria = gson.fromJson(cat, Categoria.class);
		System.out.println(cat);
		System.out.println(categoria.getNome());
		System.out.println(categoria.getDescricao());
		try {
			CategoriaCT cct = new CategoriaCT();
			cct.insert(categoria, TipoConexao.CONNECTION_SQLITE);

//			return "Categoria cadastrada com sucesso!";
			return Response.status(Response.Status.OK).entity("Categoria cadastrado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao cadastrar uma Categoria " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao cadastrar uma Categoria " + e.getMessage()).build();
		}

	}

	@POST
//	@Consumes("application/json; charset=UTF-8")
//	@Produces("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createCategoryMySQL")
//	public String CadastrarCategoriaMySQL(Autor autor) {
	public Response CadastrarCategoriaMySQL(String cat) {
		Gson gson = new Gson();
		Categoria categoria = gson.fromJson(cat, Categoria.class);
		System.out.println(cat);
		System.out.println(categoria.getNome());
		System.out.println(categoria.getDescricao());
		try {
			CategoriaCT cct = new CategoriaCT();
			cct.insert(categoria, TipoConexao.CONNECTION_MYSQL);

//			return "Categoria cadastrada com sucesso!";
			return Response.status(Response.Status.OK).entity("Categoria cadastrado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao cadastrar uma Categoria " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao cadastrar uma Categoria " + e.getMessage()).build();
		}

	}

	@PUT
//	@Produces("application/json; charset=UTF-8")
//	@Consumes("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterCategorySQLite")
//	public String AlterarCategoriaSQLite(Categoria categoria) {
	public Response AlterarCategoriaSQLite(String cat) {
		Gson gson = new Gson();
		Categoria categoria = gson.fromJson(cat, Categoria.class);
		System.out.println(cat);
		System.out.println(categoria.getNome());
		System.out.println(categoria.getDescricao());
		try {

			CategoriaCT cct = new CategoriaCT();
			cct.update(categoria, TipoConexao.CONNECTION_SQLITE);

//			return "Categoria alterada com sucesso!";
			return Response.status(Response.Status.OK).entity("Categoria alterado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao alterar o Categoria " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar a Categoria " + e.getMessage())
					.build();
		}

	}

	@PUT
//	@Produces("application/json; charset=UTF-8")
//	@Consumes("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterCategoryMySQL")
//	public String AlterarCategoriaMySQL(Categoria categoria) {
	public Response AlterarCategoriaMySQL(String cat) {
		Gson gson = new Gson();
		Categoria categoria = gson.fromJson(cat, Categoria.class);
		System.out.println(cat);
		System.out.println(categoria.getNome());
		System.out.println(categoria.getDescricao());
		try {

			CategoriaCT cct = new CategoriaCT();
			cct.update(categoria, TipoConexao.CONNECTION_MYSQL);

//			return "Categoria alterada com sucesso!";
			return Response.status(Response.Status.OK).entity("Categoria alterado com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao alterar o Categoria " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar a Categoria " + e.getMessage())
					.build();
		}

	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allCategoriesSQLite")
//	public List<Categoria> TodasCategoriasSQLite() {
	public Response TodasCategoriasSQLite() {

		List<Categoria> categorias = new ArrayList<Categoria>();
		Gson gson = new Gson();
		CategoriaCT cct = new CategoriaCT();
		try {
			List<Categoria> listaCategorias = cct.select(TipoConexao.CONNECTION_SQLITE);

			for (Categoria categoria : listaCategorias) {

				categorias.add(new Categoria(categoria.getId(), categoria.getNome(), categoria.getDescricao(),
						categoria.getLivroc()));
			}
			String json = gson.toJson(categorias);
			System.out.println(json);
//			return categorias;
//			return json;
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
//			return "Erro ao buscar as categorias " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar as categorias " + e.getMessage())
					.build();
		}
	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allCategoriesMySQL")
//	public List<Categoria> TodosCategoriasMySQL() {
	public Response TodosCategoriasMySQL() {

		List<Categoria> categorias = new ArrayList<Categoria>();
		Gson gson = new Gson();
		CategoriaCT cct = new CategoriaCT();
		try {
			List<Categoria> listaCategorias = cct.select(TipoConexao.CONNECTION_MYSQL);

			for (Categoria categoria : listaCategorias) {

				categorias.add(new Categoria(categoria.getId(), categoria.getNome(), categoria.getDescricao(),
						categoria.getLivroc()));
			}
			String json = gson.toJson(categorias);
			System.out.println(json);
//			return categorias;
//			return json;
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
//			return "Erro ao buscar as categorias " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar as categorias " + e.getMessage())
					.build();
		}
	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCategoryByIDSQLite/{codigo}")
//	public Categoria GetCategoriaByIDSQLite(@PathParam("codigo") Integer codigo) {
	public Response GetCategoriaByIDSQLite(@PathParam("codigo") Integer codigo) {
		Gson gson = new Gson();
		CategoriaCT cct = new CategoriaCT();
		try {
			Categoria categoria = cct.select(codigo, TipoConexao.CONNECTION_SQLITE);
			if (categoria != null) {
//				return new Categoria(categoria.getId(), categoria.getNome(), categoria.getDescricao(),
//				categoria.getLivroc());
				String json = gson.toJson(new Categoria(categoria.getId(), categoria.getNome(),
						categoria.getDescricao(), categoria.getLivroc()));
				return Response.status(Response.Status.OK).entity(json).build();
			} else {
//				return null;	
				return Response.status(Response.Status.OK).entity("Categoria não encontrado").build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar o categoria " + e.getMessage())
					.build();
		}
	}

	@GET
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getCategoryByIDMySQL/{codigo}")
//	public Categoria GetCategoriaByIDMySQL(@PathParam("codigo") Integer codigo) {
	public Response GetCategoriaByIDMySQL(@PathParam("codigo") Integer codigo) {
		Gson gson = new Gson();
		CategoriaCT cct = new CategoriaCT();
		try {
			Categoria categoria = cct.select(codigo, TipoConexao.CONNECTION_MYSQL);
			if (categoria != null) {
//				return new Categoria(categoria.getId(), categoria.getNome(), categoria.getDescricao(),
//				categoria.getLivroc());
				String json = gson.toJson(new Categoria(categoria.getId(), categoria.getNome(),
						categoria.getDescricao(), categoria.getLivroc()));
				return Response.status(Response.Status.OK).entity(json).build();
			} else {
//				return null;	
				return Response.status(Response.Status.OK).entity("Categoria não encontrado").build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao buscar o categoria " + e.getMessage())
					.build();
		}
	}

	@DELETE
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeCategoryByIDSQLite/{codigo}")
//	public String ExcluirCategoriaByIDSQLite(@PathParam("codigo") Integer codigo) {
	public Response ExcluirCategoriaByIDSQLite(@PathParam("codigo") Integer codigo) {
		CategoriaCT cct = new CategoriaCT();
		try {
			cct.delete(codigo, TipoConexao.CONNECTION_SQLITE);

//			return "Registro excluido com sucesso!";
			return Response.status(Response.Status.OK).entity("Categoria excluido com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao excluir o registro! " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao excluir o Categoria " + e.getMessage())
					.build();
		}

	}

	@DELETE
//	@Produces("application/json; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeCategoryByIDMySQL/{codigo}")
//	public String ExcluirAutorByIDMySQL(@PathParam("codigo") Integer codigo) {
	public Response ExcluirCategoriaByIDMySQL(@PathParam("codigo") Integer codigo) {
		CategoriaCT cct = new CategoriaCT();
		try {
			cct.delete(codigo, TipoConexao.CONNECTION_MYSQL);

//			return "Registro excluido com sucesso!";
			return Response.status(Response.Status.OK).entity("Categoria excluido com sucesso!").build();

		} catch (Exception e) {

//			return "Erro ao excluir o registro! " + e.getMessage();
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao excluir o Categoria " + e.getMessage())
					.build();
		}

	}

	// =========================================================================

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createBookRentalSQLite")
	public Response CadastrarAluguelLivroSQLite(String alugl) {
		Gson gson = new Gson();
		AluguelLivro aluguelLivro = gson.fromJson(alugl, AluguelLivro.class);
		System.out.println(alugl);
		System.out.println(aluguelLivro.getDataAluguel());
		System.out.println(aluguelLivro.getIsDevolvido());
		try {
			AluguelLivroCT alct = new AluguelLivroCT();
			alct.insert(aluguelLivro, TipoConexao.CONNECTION_SQLITE);

			return Response.status(Response.Status.OK).entity("AluguelLivro cadastrado com sucesso!").build();

		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao cadastrar AluguelLivro " + e.getMessage()).build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createBookRentalMySQL")
	public Response CadastrarAluguelLivroMySQL(String alugl) {
		Gson gson = new Gson();
		AluguelLivro aluguelLivro = gson.fromJson(alugl, AluguelLivro.class);
		System.out.println(alugl);
		System.out.println(aluguelLivro.getDataAluguel());
		System.out.println(aluguelLivro.getIsDevolvido());
		try {
			AluguelLivroCT alct = new AluguelLivroCT();
			alct.insert(aluguelLivro, TipoConexao.CONNECTION_MYSQL);

			return Response.status(Response.Status.OK).entity("AluguelLivro cadastrado com sucesso!").build();

		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao cadastrar AluguelLivro " + e.getMessage()).build();
		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterBookRentalSQLite")
	public Response AlterarAluguelLivroSQLite(String alugl) {
		Gson gson = new Gson();
		AluguelLivro aluguelLivro = gson.fromJson(alugl, AluguelLivro.class);
		System.out.println(alugl);
		System.out.println(aluguelLivro.getDataAluguel());
		System.out.println(aluguelLivro.getIsAlugado());
		try {

			AluguelLivroCT alct = new AluguelLivroCT();
			alct.update(aluguelLivro, TipoConexao.CONNECTION_SQLITE);

			return Response.status(Response.Status.OK).entity("AluguelLivro alterado com sucesso!").build();

		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar AluguelLivro " + e.getMessage())
					.build();
		}

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/alterBookRentalMySQL")
	public Response AlterarAluguelLivroMySQL(String alugl) {
		Gson gson = new Gson();
		AluguelLivro aluguelLivro = gson.fromJson(alugl, AluguelLivro.class);
		System.out.println(alugl);
		System.out.println(aluguelLivro.getDataAluguel());
		System.out.println(aluguelLivro.getIsAlugado());
		try {

			AluguelLivroCT alct = new AluguelLivroCT();
			alct.update(aluguelLivro, TipoConexao.CONNECTION_MYSQL);

			return Response.status(Response.Status.OK).entity("AluguelLivro alterado com sucesso!").build();

		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar AluguelLivro " + e.getMessage())
					.build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allBookRentalsSQLite")
	public Response TodasAluguelLivrosSQLite() {

		List<AluguelLivro> aluguelLivros = new ArrayList<AluguelLivro>();
		Gson gson = new Gson();
		AluguelLivroCT alct = new AluguelLivroCT();
		try {
			List<AluguelLivro> listaAluguelLivros = alct.select(TipoConexao.CONNECTION_SQLITE);

			for (AluguelLivro aluguelLivro : listaAluguelLivros) {

				aluguelLivros.add(new AluguelLivro(aluguelLivro.getId(), aluguelLivro.getDataAluguel(),
						aluguelLivro.getDataDevolucao(), aluguelLivro.getLivroAlugado(), aluguelLivro.getIsDevolvido(),
						aluguelLivro.getIsAlugado()));
			}
			String json = gson.toJson(aluguelLivros);
			System.out.println(json);
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao buscar as aluguelLivros " + e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allBookRentalsMySQL")
	public Response TodosAluguelLivrosMySQL() {

		List<AluguelLivro> aluguelLivros = new ArrayList<AluguelLivro>();
		Gson gson = new Gson();
		AluguelLivroCT alct = new AluguelLivroCT();
		try {
			List<AluguelLivro> listaAluguelLivros = alct.select(TipoConexao.CONNECTION_MYSQL);

			for (AluguelLivro aluguelLivro : listaAluguelLivros) {

				aluguelLivros.add(new AluguelLivro(aluguelLivro.getId(), aluguelLivro.getDataAluguel(),
						aluguelLivro.getDataDevolucao(), aluguelLivro.getLivroAlugado(), aluguelLivro.getIsDevolvido(),
						aluguelLivro.getIsAlugado()));
			}
			String json = gson.toJson(aluguelLivros);
			System.out.println(json);
			return Response.status(Response.Status.OK).entity(json).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao buscar as aluguelLivros " + e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBookRentalByIDSQLite/{codigo}")
	public Response GetAluguelLivroByIDSQLite(@PathParam("codigo") Integer codigo) {
		Gson gson = new Gson();
		AluguelLivroCT alct = new AluguelLivroCT();
		try {
			AluguelLivro aluguelLivro = alct.select(codigo, TipoConexao.CONNECTION_SQLITE);
			if (aluguelLivro != null) {
				String json = gson.toJson(new AluguelLivro(aluguelLivro.getId(), aluguelLivro.getDataAluguel(),
						aluguelLivro.getDataDevolucao(), aluguelLivro.getLivroAlugado(), aluguelLivro.getIsDevolvido(),
						aluguelLivro.getIsAlugado()));
				return Response.status(Response.Status.OK).entity(json).build();
			} else {
				return Response.status(Response.Status.OK).entity("AluguelLivro não encontrado").build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao buscar o AluguelLivro " + e.getMessage()).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBookRentalByIDMySQL/{codigo}")
	public Response GetAluguelLivroByIDMySQL(@PathParam("codigo") Integer codigo) {
		Gson gson = new Gson();
		AluguelLivroCT alct = new AluguelLivroCT();
		try {
			AluguelLivro aluguelLivro = alct.select(codigo, TipoConexao.CONNECTION_MYSQL);
			if (aluguelLivro != null) {
				String json = gson.toJson(new AluguelLivro(aluguelLivro.getId(), aluguelLivro.getDataAluguel(),
						aluguelLivro.getDataDevolucao(), aluguelLivro.getLivroAlugado(), aluguelLivro.getIsDevolvido(),
						aluguelLivro.getIsAlugado()));
				return Response.status(Response.Status.OK).entity(json).build();
			} else {
				return Response.status(Response.Status.OK).entity("AluguelLivro não encontrado").build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao buscar o AluguelLivro " + e.getMessage()).build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeBookRentalByIDSQLite/{codigo}")
	public Response ExcluirAluguelLivroByIDSQLite(@PathParam("codigo") Integer codigo) {
		AluguelLivroCT alct = new AluguelLivroCT();
		try {
			alct.delete(codigo, TipoConexao.CONNECTION_SQLITE);

			return Response.status(Response.Status.OK).entity("AluguelLivro excluido com sucesso!").build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao excluir o AluguelLivro " + e.getMessage()).build();
		}

	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/removeBookRentalByIDMySQL/{codigo}")
	public Response ExcluirAluguelLivroByIDMySQL(@PathParam("codigo") Integer codigo) {
		AluguelLivroCT alct = new AluguelLivroCT();
		try {
			alct.delete(codigo, TipoConexao.CONNECTION_MYSQL);

			return Response.status(Response.Status.OK).entity("AluguelLivro excluido com sucesso!").build();

		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Erro ao excluir o AluguelLivro " + e.getMessage()).build();
		}

	}
}
