package com.example.modelodaosqlite.persistencia;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;

import com.example.modelodaosqlite.entidades.Console;
import com.example.modelodaosqlite.entidades.Estado;

public class DAOConsole extends DAOBase<Console>{

	public static final String NOME_TABELA = "console";

	public static final String COLUNA_ID = "id";
	public static final String COLUNA_NOME= "nome";
	public static final String COLUNA_VALOR = "valor";

	public static final String CREATE_TABLE = "CREATE TABLE "+ NOME_TABELA + " ("+COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
																				  COLUNA_NOME+" TEXT, "+
																				  COLUNA_VALOR+" DOUBLE "+
																				  ")";
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NOME_TABELA;
	
	
	public static final String BUSCA_PELO_NOME= "SELECT * FROM " + NOME_TABELA + 
			" WHERE " + COLUNA_NOME + " = ";

	
	public DAOConsole(Context context) {
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
	public ContentValues entidadeParaContentValues(Console entidade) {
		
		ContentValues cv = new ContentValues();
		
		if(entidade.getId() > 0){
			cv.put(COLUNA_ID, entidade.getId());
		}
		cv.put(COLUNA_NOME, entidade.getNome());
		cv.put(COLUNA_VALOR, entidade.getValor());
		
		return cv;
	}

	@Override
	public Console contentValuesParaEntidade(ContentValues contentValues) {

		Console cons = new Console();
		
		cons.setId(contentValues.getAsInteger(COLUNA_ID));
		cons.setNome(contentValues.getAsString(COLUNA_NOME));
		cons.setValor(contentValues.getAsDouble(COLUNA_VALOR));
		
		return cons;
	}
	
	
	public Console bucarConsoleByNome(String nome){
		
		List<Console> result = 
				recuperarPorQuery(BUSCA_PELO_NOME + "'" + nome + "'");
		
		if(result.size() > 0)
			return result.get(0);
	
		return null;
	}	
	

}
