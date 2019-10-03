package br.com.gbrsistemas.estoque.entidade;

import java.sql.Date;

public class Produto {

	private int idProduto;
	private String nome;
	private double preco;
	private String marca;
	private int quantidade;
	private Date fabricacao;
	private Date validade;
	private Categoria categoria;
	private Medida medida;
	private Fornecedor fornecedor;


	public Produto() {

	}

	public Produto(int idProduto, String nome, double preco, String marca, int quantidade, Date fabricacao, Date validade,
				   Categoria categoria, Medida medida, Fornecedor fornecedor) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.quantidade = quantidade;
		this.fabricacao = fabricacao;
		this.validade = validade;
		this.categoria = categoria;
		this.medida = medida;
		this.fornecedor = fornecedor;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto{" +
				"idProduto=" + idProduto +
				", nome='" + nome + '\'' +
				", preco=" + preco +
				", marca='" + marca + '\'' +
				", quantidade=" + quantidade +
				", fabricacao=" + fabricacao +
				", validade=" + validade +
				", categoria=" + categoria +
				", medida=" + medida +
				", fornecedor=" + fornecedor +
				'}';
	}
}
