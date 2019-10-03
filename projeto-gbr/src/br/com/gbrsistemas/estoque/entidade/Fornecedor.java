package br.com.gbrsistemas.estoque.entidade;

public class Fornecedor {
	
	private int idFornecedor;
	private String nome;
	private String cnpj;
	private String telefone;
	private String cep;
	private String uf;
	private String cidade;
	private String bairro;
	private String logradouro;
	private String numero;
	private String status = "ATIVO";

	public Fornecedor() {
		
	}

	public Fornecedor(String nome, String cnpj, String telefone, String cep, String uf,
					  String cidade, String bairro, String logradouro, String numero, String status) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.status = status;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Fornecedor{" +
				"idFornecedor=" + idFornecedor +
				", nome='" + nome + '\'' +
				", cnpj='" + cnpj + '\'' +
				", telefone='" + telefone + '\'' +
				", cep='" + cep + '\'' +
				", uf='" + uf + '\'' +
				", cidade='" + cidade + '\'' +
				", bairro='" + bairro + '\'' +
				", logradouro='" + logradouro + '\'' +
				", numero='" + numero + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
