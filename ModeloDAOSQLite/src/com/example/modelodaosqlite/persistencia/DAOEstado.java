package com.example.modelodaosqlite.persistencia;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;

import com.example.modelodaosqlite.entidades.Estado;

public class DAOEstado extends DAOBase<Estado>{

	public static final String NOME_TABELA = "estado";

	public static final String COLUNA_ID = "id";
	public static final String COLUNA_NOME= "nome";
	public static final String COLUNA_SIGLA = "sigla";

	public static final String CREATE_TABLE = "CREATE TABLE "+ NOME_TABELA + " ("+COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
																				  COLUNA_NOME+" TEXT, "+
																				  COLUNA_SIGLA+" TEXT "+
																			   ")";
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NOME_TABELA;
	
	
	public static final String BUSCA_PELA_SIGLA = "SELECT * FROM " + NOME_TABELA + 
															" WHERE " + COLUNA_SIGLA + " = ";
	
	public DAOEstado(Context context) {
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
	public ContentValues entidadeParaContentValues(Estado entidade) {
		
		ContentValues cv = new ContentValues();
		
		if(entidade.getId() > 0)
			cv.put(COLUNA_ID, entidade.getId());
		
		cv.put(COLUNA_NOME, entidade.getNome());		
		cv.put(COLUNA_SIGLA, entidade.getSigla());
		return cv;
	}

	@Override
	public Estado contentValuesParaEntidade(ContentValues contentValues) {
		Estado estado = new Estado();
		
		estado.setId(contentValues.getAsInteger(COLUNA_ID));
		estado.setNome(contentValues.getAsString(COLUNA_NOME));
		estado.setSigla(contentValues.getAsString(COLUNA_SIGLA));
		
		return estado;
	}

	
	public Estado bucarEstadoBySigla(String sigla){
		
		List<Estado> resultado = (ArrayList<Estado>) 
				recuperarPorQuery(BUSCA_PELA_SIGLA +"'" + sigla + "'");
		
		if(resultado.size() > 0)
			return resultado.get(0);
		
		
		return null;
	}	
}
