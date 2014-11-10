package com.example.imagetodatabaseviawebservices;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = -2229832341556924673L;
	
	private int id;
	private String nome;
	private int idade;
	private byte[] foto;	

	public Usuario(){};
	
	public Usuario(int id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public Usuario(int id, String nome, int idade, byte[] foto) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.foto = foto;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
