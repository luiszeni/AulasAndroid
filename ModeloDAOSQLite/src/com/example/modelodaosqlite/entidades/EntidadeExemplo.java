package com.example.modelodaosqlite.entidades;

public class EntidadeExemplo implements EntidadePersistivel {
	
	private int id;
	private String descricao;
	private boolean exemploBoolean;
	
	public EntidadeExemplo(){};
	
	public EntidadeExemplo(int id, String descricao, boolean exemploBoolean) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.exemploBoolean = exemploBoolean;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isExemploBoolean() {
		return exemploBoolean;
	}
	public void setExemploBoolean(boolean exemploBoolean) {
		this.exemploBoolean = exemploBoolean;
	}

	@Override
	public String toString() {
		return "EntidadeExemplo [id=" + id + ", descricao=" + descricao
				+ ", exemploBoolean=" + exemploBoolean + "]";
	}
	
	
	
}
