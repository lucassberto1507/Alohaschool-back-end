package br.com.gbrsistemas.estoque;

import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.gbrsistemas.estoque.dao.ProdutoDAO;
import br.com.gbrsistemas.estoque.entidade.Fornecedor;
import br.com.gbrsistemas.estoque.entidade.Produto;

public class ProdutoTest {
	
	//CLASSIFICANDO UM PRODUTO COMO INATIVO(Desativando)
	@Test
	public void desativarProduto() throws Exception {
		ProdutoDAO dao = new ProdutoDAO();
		dao.desativarProduto(3);

	}
	
	//EDITANDO UM PRODUTO
	@Test
	public void editarProduto() throws Exception {
		Date data = new Date(System.currentTimeMillis());
		System.out.println("EDITANDO UM PRODUTO");
		Produto produto = new Produto();
		produto.setFabricacao(data);
		produto.setItem("BATATA BAROA");
		produto.setMarca("Mini Mercado da Maria");
		produto.setPreco(0.60);
		produto.setQtde(300);
		produto.setUnidade("KG");
		produto.setValidade(data);

		ProdutoDAO dao = new ProdutoDAO();

		dao.editarProduto(produto, 3);
		
		Produto alterado = dao.buscarProdutoPorId(3);
		Assert.assertNotNull(alterado);

	}
	
	//ADICIONANDO UM NOVO PRODUTO
	@Test
	public void inserirProduto() throws Exception {
		Date data = new Date(System.currentTimeMillis());
		System.out.println("ADICIONANDO UM PRODUTO");
		Produto produto = new Produto();
		produto.setFabricacao(data);
		produto.setItem("Goiaba");
		produto.setMarca("Goiabinha");
		produto.setPreco(1.00);
		produto.setQtde(300);
		produto.setUnidade("UNIDADE");
		produto.setValidade(data);
		produto.setStatus("");

		ProdutoDAO dao = new ProdutoDAO();

		dao.addProduto(produto);

	}

	@Test
	public void listarProduto() throws Exception {

		System.out.println("LISTA DE PRODUTOS");

		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> lista = dao.listarProduto();

		for (Produto item : lista)
			System.out.println(item);

	}

	@Test
	public void subtrairProduto() throws Exception {

		System.out.println("BAIXANDO PRODUTOS");

		ProdutoDAO dao = new ProdutoDAO();

		dao.subtrairProduto(3, 100);

	}

	@Test
	public void somarProduto() throws Exception {

		System.out.println("SOMANDO PRODUTOS");

		ProdutoDAO dao = new ProdutoDAO();

		dao.somarProduto(4, 100);
	}
}
