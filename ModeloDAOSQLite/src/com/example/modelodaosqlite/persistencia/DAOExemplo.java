package com.example.modelodaosqlite.persistencia;

import android.content.ContentValues;
import android.content.Context;

import com.example.modelodaosqlite.entidades.EntidadeExemplo;

public class DAOExemplo extends DAOBase<EntidadeExemplo>{

	private static DAOExemplo instancia;
	
	public static final String NOME_TABELA = "entidade_exemplo";

	public static final String COLUNA_ID = "id";
	public static final String COLUNA_DESCRICAO= "descricao";
	public static final String COLUNA_EXEMPLO_BOOLEAN = "exemplo_boolean";

	public static final String CREATE_TABLE = "CREATE TABLE "+ NOME_TABELA + " ("+COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
																				  COLUNA_DESCRICAO+" TEXT, "+
																				  COLUNA_EXEMPLO_BOOLEAN+" BOOLEAN "+
																			   ")";
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NOME_TABELA;
	
	//construtor setado como private para forçar o uso do singleton
	private DAOExemplo(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public static DAOExemplo getInstancia(Context context) {
		if (instancia == null)
			instancia = new DAOExemplo(context);
		return instancia;
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
	public ContentValues entidadeParaContentValues(EntidadeExemplo entidade) {
		ContentValues cv = new ContentValues();
	    
		if(entidade.getId() > 0) {
			cv.put(COLUNA_ID, entidade.getId());
        }		
		cv.put(COLUNA_DESCRICAO, entidade.getDescricao());
		cv.put(COLUNA_EXEMPLO_BOOLEAN, entidade.isExemploBoolean());
		return cv;
	}

	@Override
	public EntidadeExemplo contentValuesParaEntidade(ContentValues contentValues) {
		EntidadeExemplo entidade = new EntidadeExemplo();
		entidade.setId(contentValues.getAsInteger(COLUNA_ID));
		entidade.setDescricao(contentValues.getAsString(COLUNA_DESCRICAO));
		entidade.setExemploBoolean(contentValues.getAsBoolean(COLUNA_EXEMPLO_BOOLEAN));
		return entidade;
	}

}
