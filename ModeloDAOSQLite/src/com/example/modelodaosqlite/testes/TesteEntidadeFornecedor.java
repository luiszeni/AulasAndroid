package com.example.modelodaosqlite.testes;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.modelodaosqlite.entidades.Fornecedor;
import com.example.modelodaosqlite.entidades.Produto;
import com.example.modelodaosqlite.persistencia.DAOFornecedor;
import com.example.modelodaosqlite.persistencia.DAOProduto;

public class TesteEntidadeFornecedor  extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Fornecedor nestle = new Fornecedor(0,"Nestle",68765419);
		Fornecedor pia = new Fornecedor(0,"Pia",987463874);


		DAOFornecedor daoFornecedor = new DAOFornecedor(this);
		daoFornecedor.inserir(pia);
		daoFornecedor.inserir(nestle);
		
		
		List<Fornecedor> listaForn = daoFornecedor.buscarTodos();
		
		for(int i = 0; i < listaForn.size(); i++){
			Fornecedor forn = listaForn.get(i);
			
			Log.i("exemploDAO", forn.toString());
			
		}		
		
		
		pia = daoFornecedor.buscaFornecedorPorNome("Pia");
		nestle = daoFornecedor.buscaFornecedorPorNome("Nestle");
		
		Produto leiteAlcolico = new Produto(0,"Leite Pia Integral", 2.20, pia.getId());
		
		Produto chocolateNaoAlcolico = new Produto(0,"Chocolate ao leite", 4.10, nestle.getId());
		
		Produto nescau = new Produto(0,"Nescal", 3.21, nestle.getId());
		
		
		DAOProduto daoProduto = new DAOProduto(this);
		
		daoProduto.inserir(nescau);
		daoProduto.inserir(chocolateNaoAlcolico);
		daoProduto.inserir(leiteAlcolico);
		
		List<Produto> produtos = daoProduto.buscarTodos();

		Log.i("exemploDAO", "- - - - - ");
		
		for (Iterator iterator = produtos.iterator(); iterator.hasNext();) {
			Produto produto = (Produto) iterator.next();
			
			Log.i("exemploDAO", produto.toString());
			
		}		
		
		
	}

}
