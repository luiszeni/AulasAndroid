package com.example.modelodaosqlite.persistencia;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;

import com.example.modelodaosqlite.entidades.Console;
import com.example.modelodaosqlite.entidades.Jogo;

public class DAOJogo extends DAOBase<Jogo>{

	public static final String NOME_TABELA = "jogo";

	public static final String COLUNA_ID = "id";
	public static final String COLUNA_NOME= "nome";
	public static final String COLUNA_LOCADO = "locado";
	public static final String COLUNA_ID_CONSOLE = "id_console";
	
	public static final String CREATE_TABLE = "CREATE TABLE "+ NOME_TABELA + " ("+COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
																				  COLUNA_NOME+" TEXT, "+
																				  COLUNA_LOCADO+" BOOLEAN, "+
																				  COLUNA_ID_CONSOLE+" INTEGER "+
																				  ")";
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NOME_TABELA;
	
	
	
	public static final String SELECT_TODOS_DE_CONSOLE = "SELECT * FROM " + NOME_TABELA 
															+" WHERE " + COLUNA_ID_CONSOLE + " = "  ;
	
	public DAOJogo(Context context) {
		super(context);
	}

	@Override
	public String getNomeColunaPrimaryKey() {
		return COLUNA_ID;
	}

	@Override
	public String getNomeTabela() {
		return NOME_TABELA;
	}

	@Override
	public ContentValues entidadeParaContentValues(Jogo entidade) {
	
		ContentValues cv = new ContentValues();
		if( entidade.getId() > 0)
			cv.put(COLUNA_ID, entidade.getId());
		
		cv.put(COLUNA_NOME, entidade.getNome());
		cv.put(COLUNA_LOCADO, entidade.isLocado());
		cv.put(COLUNA_ID_CONSOLE, entidade.getId_console());
		
		return cv;
	}

	@Override
	public Jogo contentValuesParaEntidade(ContentValues contentValues) {

		Jogo jogo = new Jogo();
		
		jogo.setId(contentValues.getAsInteger(COLUNA_ID));
		jogo.setNome(contentValues.getAsString(COLUNA_NOME));
		jogo.setLocado(contentValues.getAsBoolean(COLUNA_LOCADO));
		jogo.setId_console(contentValues.getAsInteger(COLUNA_ID_CONSOLE));
		
		return jogo;
	}

	
	
	public List<Jogo> buscaTodosDeUmConsole(Console con){
		 return recuperarPorQuery(SELECT_TODOS_DE_CONSOLE + 
				 "'" + con.getId() + "'");
	}
	
	
	
}
