package com.example.modelodaosqlite.testes;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.modelodaosqlite.entidades.EntidadeExemplo;
import com.example.modelodaosqlite.persistencia.DAOExemplo;

public class TesteEntidadeExemplo extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Cria duas entidadesExemplo
		EntidadeExemplo ent1 = new EntidadeExemplo(0,"Exemplo de entidade 1", true);
		EntidadeExemplo ent2 = new EntidadeExemplo(0,"Exemplo de entidade 2", false);
		
		//pega o dao pelo singleton passando o contexto
		DAOExemplo dao = DAOExemplo.getInstancia(this);
		
		
		//Recupera a quantidade de registros na tabela entidade_exemplo pegando o size da lista que é retornada.
		//Será usado depois dos inserts este valor para verificar se a inserção funcionou;
		int nRegistrosAntes = dao.buscarTodos().size();		
		
		//insere as duas entidadesExemplo
		dao.inserir(ent1);
		dao.inserir(ent2);
		
		int nRegistrosDepois = dao.buscarTodos().size();	
		
		if(nRegistrosDepois == nRegistrosAntes)
			Log.i("teste dao", "problema ao inserir, o banco continua com a mesma quantidade de registros");
		else
			Log.i("teste dao", "inserirido com sucesso");
		
		//Mostra todos os itens do banco no logcat
		List<EntidadeExemplo> entidadesNoBanco = dao.buscarTodos();	
		
		int aux = 0;
		//Para cada entidade da lista mostra o que esta no banco e faz um update da descrição e do boolean
		for (Iterator iterator = entidadesNoBanco.iterator(); iterator.hasNext();) {
			EntidadeExemplo entidadeExemplo = (EntidadeExemplo) iterator.next();
			Log.i("teste dao", entidadeExemplo.toString());
			//muda a descricao
			entidadeExemplo.setDescricao("Nova descrição " + aux++);
			//inverte o valor do boolean
			entidadeExemplo.setExemploBoolean(!entidadeExemplo.isExemploBoolean());
			//edita a entidade
			dao.editar(entidadeExemplo);
		}
		
		
		Log.i("teste dao", "Depois do Update");
		//busca todas as entidades depois de editar e verifica se estão diferentes das originais		
		List<EntidadeExemplo> entidadesNoBancoDepoisEditar = dao.buscarTodos();	
		
		for (int i = 0; i < entidadesNoBancoDepoisEditar.size() ; i++) {
			EntidadeExemplo entidade = entidadesNoBanco.get(i);

			Log.i("teste dao", entidade.toString());
			
			//testa o recuperar pela ID
			EntidadeExemplo recuperadoPelaID = dao.buscarPorId(entidade.getId());
			Log.i("teste dao", recuperadoPelaID.toString());
			
			//Exclui a entidade
			dao.deletar(entidade);
			
		} 
		
		//verifica se deletou corretamente
		int nRegistrosDepoisDeDeletar = dao.buscarTodos().size();
		
		if(nRegistrosDepoisDeDeletar > 0)
			Log.i("teste dao", "problema ao deletar");
		else
			Log.i("teste dao", "deletou com sucesso");
		
		
		
	}

}
