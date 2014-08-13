package com.example.modelodaosqlite.persistencia;

import android.content.ContentValues;
import android.content.Context;

import com.example.modelodaosqlite.entidades.Cidade;

public class DAOCidade extends DAOBase<Cidade>{

	public static final String NOME_TABELA = "cidade";

	public static final String COLUNA_ID = "id";
	public static final String COLUNA_NOME= "nome";
	public static final String COLUNA_ID_ESTADO = "id_estado";

	public static final String CREATE_TABLE = "CREATE TABLE "+ NOME_TABELA + " ("+COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
																				  COLUNA_NOME+" TEXT, "+
																				  COLUNA_ID_ESTADO+" INT "+
																			   ")";
	
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NOME_TABELA;
	
	
		public DAOCidade(Context context) {
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
	public ContentValues entidadeParaContentValues(Cidade entidade) {
		
		ContentValues cv = new ContentValues();
		
		if(entidade.getId() > 0)
			cv.put(COLUNA_ID,entidade.getId());
		
		cv.put(COLUNA_NOME,entidade.getNome());
		cv.put(COLUNA_ID_ESTADO,entidade.getIdEstado());
		
		return cv;
	}

	
	@Override
	public Cidade contentValuesParaEntidade(ContentValues contentValues) {
		
		Cidade cidade = new Cidade();
		
		cidade.setId(contentValues.getAsInteger(COLUNA_ID));
		cidade.setNome(contentValues.getAsString(COLUNA_NOME));
		cidade.setIdEstado(contentValues.getAsInteger(COLUNA_ID_ESTADO));
		
		return cidade;
	}
}
