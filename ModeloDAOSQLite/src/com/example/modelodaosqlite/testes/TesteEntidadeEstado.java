package com.example.modelodaosqlite.testes;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.modelodaosqlite.entidades.Estado;
import com.example.modelodaosqlite.persistencia.DAOEstado;

public class TesteEntidadeEstado extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		DAOEstado dao = new DAOEstado(this);
		
		Estado rs = new Estado(0,"Rio Grade do Sul", "RS");
		Estado ac = new Estado(0,"Acre", "AC");
		
		dao.inserir(rs);
		dao.inserir(ac);
		
		Estado rs2 = dao.bucarEstadoBySigla("RS");
		
		Log.i("exemploDAO","estado buscado pela sigla " + rs2.toString());
		
		List<Estado> estados = dao.buscarTodos();
		
		for (Iterator iterator = estados.iterator(); iterator.hasNext();) {
			Estado estado = (Estado) iterator.next();
			Log.i("exemploDAO", estado.toString());
			estado.setNome("Qualquer coisa");
			
			dao.editar(estado);
		}
		
		
		List<Estado> estados2 = dao.buscarTodos();
		for (Iterator iterator = estados2.iterator(); iterator.hasNext();) {
			Estado estado = (Estado) iterator.next();
			Log.i("exemploDAO", estado.toString());
		}
		
		

		
	}
	
}
