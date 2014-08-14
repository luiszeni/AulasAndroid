package com.example.modelodaosqlite.entidades;

public class Produto implements EntidadePersistivel{
	
	private int id;
	private String nome;
	private double valor;
	private int id_fornecedor;
	
	public Produto(){};
	
	public Produto(int id, String nome, double valor, int id_fornecedor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.id_fornecedor = id_fornecedor;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor
				+ ", id_fornecedor=" + id_fornecedor + "]";
	}

}
