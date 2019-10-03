package br.com.gbrsistemas.estoque.entidade;

public class Prato {

	private int idPrato;
	private String nome;
	private String descricao;
	private double preco;

	public Prato() {

	}

	public Prato(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getIdPrato() {
		return idPrato;
	}

	public void setIdPrato(int idPrato) {
		this.idPrato = idPrato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Prato{" +
				"idPrato=" + idPrato +
				", nome='" + nome + '\'' +
				", descricao='" + descricao + '\'' +
				", preco=" + preco +
				'}';
	}
}
