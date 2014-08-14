package com.example.modelodaosqlite.persistencia;

import android.content.ContentValues;
import android.content.Context;

import com.example.modelodaosqlite.entidades.Produto;

public class DAOProduto extends DAOBase<Produto>{

	public static final String NOME_TABELA = "produto";

	public static final String COLUNA_ID = "id";
	public static final String COLUNA_NOME= "nome";
	public static final String COLUNA_VALOR= "valor";
	public static final String COLUNA_ID_FORNECEDOR = "id_fornecedor";

	public static final String CREATE_TABLE = "CREATE TABLE "+ NOME_TABELA + " ("+COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
																				  COLUNA_NOME+" TEXT, "+
																				  COLUNA_VALOR+ " DOUBLE," +
																				  COLUNA_ID_FORNECEDOR+ " INTEGER" +
																				  ")";
																													
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NOME_TABELA;
	

	public DAOProduto(Context context) {
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
	public ContentValues entidadeParaContentValues(Produto entidade) {
		ContentValues cv = new ContentValues();
		
		if(entidade.getId() > 0)
			cv.put(COLUNA_ID, entidade.getId());
		
		cv.put(COLUNA_NOME, entidade.getNome());
		cv.put(COLUNA_VALOR, entidade.getValor());
		cv.put(COLUNA_ID_FORNECEDOR, entidade.getId_fornecedor());
		return cv;
	}

	@Override
	public Produto contentValuesParaEntidade(ContentValues contentValues) {
		
		Produto pro = new Produto();
		
		pro.setId(contentValues.getAsInteger(COLUNA_ID));
		pro.setNome(contentValues.getAsString(COLUNA_NOME));
		pro.setValor(contentValues.getAsDouble(COLUNA_VALOR));
		pro.setId_fornecedor(contentValues.getAsInteger(COLUNA_ID_FORNECEDOR));

		return pro;
	}
	
	

}
