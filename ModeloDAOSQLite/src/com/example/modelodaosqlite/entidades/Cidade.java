package com.example.modelodaosqlite.entidades;

public class Cidade implements EntidadePersistivel{
	
	private int id;
	private  String nome;
	private int idEstado;
	
	public Cidade(){};
	public Cidade(int id, String nome, int idEstado) {
		super();
		this.id = id;
		this.nome = nome;
		this.idEstado = idEstado;
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
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", idEstado=" + idEstado
				+ "]";
	}
	
		

}
