package br.com.gbrsistemas.estoque;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.gbrsistemas.estoque.dao.FornecedorDAO;
import br.com.gbrsistemas.estoque.entidade.Fornecedor;

public class FornecedorTest {

	@Test
	public void inserirFornecedor() throws Exception {
		Fornecedor forn = new Fornecedor();
		forn.setBairro("Areias");
		forn.setCep("8866786");
		forn.setCnpj("3242342123/34342");
		forn.setEndereco("Rua de Areias");
		forn.setMunicipio("Biguaçu");
		forn.setNome("Mercado Areias");
		forn.setStatus("ATIVO");
		forn.setTelefone("33348877");

		FornecedorDAO dao = new FornecedorDAO();
		dao.addFornecedor(forn);
		
		Assert.assertNotNull(forn);
				
	}

	@Test
	public void editarFornecedor() throws Exception {

		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setBairro("Passa Vinte");
		fornecedor.setCep("88877030");
		fornecedor.setCnpj("1784269845/58498");
		fornecedor.setEndereco("Rua do Imperatriz");
		fornecedor.setMunicipio("Palhoça");
		fornecedor.setNome("NOVO IMPERATRIZ");
		fornecedor.setStatus("INATIVO");
		fornecedor.setTelefone("35553432");

		FornecedorDAO dao = new FornecedorDAO();

		dao.editarFornecedor(fornecedor, 2);

		Fornecedor alterado = dao.buscarFornecedorPorId(2);
		Assert.assertNotNull(alterado);
	}

	@Test
	public void desativarFornecedor() throws Exception {
		FornecedorDAO dao = new FornecedorDAO();
		dao.desativaFornecedor(3);
		
		
	}

	@Test
	public void listarFonrecedor() throws Exception {

		System.out.println("LISTA DE FORNECEDORES");

		FornecedorDAO dao = new FornecedorDAO();
		List<Fornecedor> lista = dao.listarFornecedor();

		for (Fornecedor item : lista)
			System.out.println(item);
	}
	
	@Test
	public void buscarFornecedorPorStatus() throws Exception {
		System.out.println("BUSCANDO FORNECEDOR POR STATUS");
		FornecedorDAO dao = new FornecedorDAO();
		List<Fornecedor> lista = dao.buscarFornecedorPorStatus("INATIVO");
		for (Fornecedor fornecedor : lista)
			System.out.println(fornecedor);
		Assert.assertNotNull(dao);
	}

}
