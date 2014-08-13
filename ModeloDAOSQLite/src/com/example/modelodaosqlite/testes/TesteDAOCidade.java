package com.example.modelodaosqlite.testes;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.modelodaosqlite.entidades.Cidade;
import com.example.modelodaosqlite.entidades.Estado;
import com.example.modelodaosqlite.persistencia.DAOCidade;
import com.example.modelodaosqlite.persistencia.DAOEstado;

public class TesteDAOCidade extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		DAOEstado dao = new DAOEstado(this);
		Estado rs = new Estado(0,"Rio Grade do Sul", "RS");
		Estado ac = new Estado(0,"Acre", "AC");
		
		dao.inserir(rs);
		dao.inserir(ac);
		
		Estado rs2 = dao.bucarEstadoBySigla("RS");
		Estado ac2 = dao.bucarEstadoBySigla("AC");
		
		DAOCidade daoCidade = new DAOCidade(this);
		
		Cidade poa = new Cidade(0,"porto alegre", rs2.getId());
		Cidade branquin = new Cidade(0,"Rio Branco", ac2.getId());
		
		
		daoCidade.inserir(poa);
		daoCidade.inserir(branquin);
		
		
		List<Cidade> cidades = daoCidade.buscarTodos();
		
		for (Iterator iterator = cidades.iterator(); iterator.hasNext();) {
			Cidade cidade = (Cidade) iterator.next();
			Log.i("exemploDAO", cidade.toString());
		}

		
	}

}
