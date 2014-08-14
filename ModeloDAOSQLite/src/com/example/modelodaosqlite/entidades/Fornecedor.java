package com.example.modelodaosqlite.entidades;

public class Fornecedor implements EntidadePersistivel{

	private int id;
	private String nome;
	private int cnpj;
	
	public Fornecedor(){}
	public Fornecedor(int id, String nome, int cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj
				+ "]";
	}
}
