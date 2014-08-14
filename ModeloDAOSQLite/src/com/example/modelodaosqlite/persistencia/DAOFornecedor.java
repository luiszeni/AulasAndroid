package com.example.modelodaosqlite.persistencia;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;

import com.example.modelodaosqlite.entidades.Fornecedor;

public class DAOFornecedor extends DAOBase<Fornecedor> {

	public static final String NOME_TABELA = "fornecedor";

	public static final String COLUNA_ID = "id";
	public static final String COLUNA_NOME= "nome";
	public static final String COLUNA_CNPJ= "cnpj";

	public static final String CREATE_TABLE = "CREATE TABLE "+ NOME_TABELA + " ("+COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
																				  COLUNA_NOME+" TEXT, "+
																				  COLUNA_CNPJ + " INTEGER" +
																				  ")";
																													
	public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + NOME_TABELA;
	
		
	public static final String SELECT_FORNECEDOR_NOME = "SELECT * FROM " + NOME_TABELA + 
														" WHERE " + COLUNA_NOME + " = ";
	
	public DAOFornecedor(Context context) {
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
	public ContentValues entidadeParaContentValues(Fornecedor entidade) {
		ContentValues cv = new ContentValues();
		
		if(entidade.getId() > 0)
			cv.put(COLUNA_ID, entidade.getId());
		
		cv.put(COLUNA_NOME, entidade.getNome());
		cv.put(COLUNA_CNPJ, entidade.getCnpj());
		return cv;
	}

	@Override
	public Fornecedor contentValuesParaEntidade(ContentValues contentValues) {
		Fornecedor forn = new Fornecedor();
		
		forn.setId(contentValues.getAsInteger(COLUNA_ID));
		forn.setNome(contentValues.getAsString(COLUNA_NOME));
		forn.setCnpj(contentValues.getAsInteger(COLUNA_CNPJ));
		
		return forn;
	}
	
	public Fornecedor buscaFornecedorPorNome(String nome){
			
		List<Fornecedor> lista = recuperarPorQuery(SELECT_FORNECEDOR_NOME + "'" + nome + "'");
	
		if(lista.size() > 0)
			return lista.get(0);
		
		return null;
	}

}
