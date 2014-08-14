package com.example.modelodaosqlite.entidades;


public class Jogo implements EntidadePersistivel {
	
	private int id;
	private String nome;
	private boolean locado;
	private int id_console;
	
	public Jogo(){};
	public Jogo(int id, String nome, boolean locado, int id_console) {
		super();
		this.id = id;
		this.nome = nome;
		this.locado = locado;
		this.id_console = id_console;
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
	public boolean isLocado() {
		return locado;
	}
	public void setLocado(boolean locado) {
		this.locado = locado;
	}
	public int getId_console() {
		return id_console;
	}
	public void setId_console(int id_console) {
		this.id_console = id_console;
	}
	@Override
	public String toString() {
		return "Jogo [id=" + id + ", nome=" + nome + ", locado=" + locado
				+ ", id_console=" + id_console + "]";
	}
	
	

}
