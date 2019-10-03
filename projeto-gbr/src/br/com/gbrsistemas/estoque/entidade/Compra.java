package br.com.gbrsistemas.estoque.entidade;

import java.sql.Date;

public class Compra {
	
	private int idCompra;
	private Date dataCompra;
	private double valor;
	private String formaPgto;
	Fornecedor fornecedor;
	Produto produto;

	public Compra() {
	}

	public Compra(Date dataCompra, double valor, String formaPgto) {
		this.dataCompra = dataCompra;
		this.valor = valor;
		this.formaPgto = formaPgto;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(String formaPgto) {
		this.formaPgto = formaPgto;
	}

	@Override
	public String toString() {
		return "Compra{" +
				"idCompra=" + idCompra +
				", dataCompra=" + dataCompra +
				", valor=" + valor +
				", formaPgto='" + formaPgto + '\'' +
				'}';
	}
}
