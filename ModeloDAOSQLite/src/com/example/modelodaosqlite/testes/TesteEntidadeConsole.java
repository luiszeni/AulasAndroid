package com.example.modelodaosqlite.testes;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.modelodaosqlite.entidades.Console;
import com.example.modelodaosqlite.entidades.Jogo;
import com.example.modelodaosqlite.persistencia.DAOConsole;
import com.example.modelodaosqlite.persistencia.DAOJogo;

public class TesteEntidadeConsole extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Console snes = new Console(0,"Super Nintendo", 3.0);
		Console ps4 = new Console(0,"Pray Station", 5.0);
			
		DAOConsole daoConsole = new DAOConsole(this);
		
		daoConsole.inserir(snes);
		daoConsole.inserir(ps4);
		
		
		
		List<Console> consoles = daoConsole.buscarTodos();		
		
		for (int i = 0; i < consoles.size(); i++) {
			Console con = consoles.get(i);
			
			Log.i("ExemploDAO", con.toString());
			
			//dao.deletar(con);
		}

		ps4 = daoConsole.bucarConsoleByNome("Pray Station");
		snes = daoConsole.bucarConsoleByNome("Super Nintendo");
		
		Jogo wow = new Jogo(0,"World of Warcraft", true, ps4.getId());
		Jogo lol = new Jogo(0,"Lol não sei escrever ", false, snes.getId());
		Jogo cod = new Jogo(0,"Call of Duty", true, ps4.getId());
		
		DAOJogo daoJogo = new DAOJogo(this);
		
		daoJogo.inserir(wow);
		daoJogo.inserir(lol);
		daoJogo.inserir(cod);
		
		
		List<Jogo> jogos = daoJogo.buscarTodos();
		
		for (Iterator iterator = jogos.iterator(); iterator.hasNext();) {
			Jogo jogo = (Jogo) iterator.next();
			
			Log.i("ExemploDAO", jogo.toString());
			
		}
		
		
		//
		
		Log.i("ExemploDAO", "--------------------------");
		List<Jogo> jogosPS4 = daoJogo.buscaTodosDeUmConsole(ps4);
		
		for (Iterator iterator = jogosPS4.iterator(); iterator.hasNext();) {
			Jogo jogo = (Jogo) iterator.next();
			Log.i("ExemploDAO", jogo.toString());
		}
	
			
		
//		List<Console> consoles2 = dao.buscarTodos();	
//		
//		
//		if(consoles.size() == consoles2.size()){
//			Log.i("ExemploDAO", "XIII deu caca no delete");
//		}else{
//			Log.i("ExemploDAO", "O delete deu certo chefe");
//		}
		
	}

}
