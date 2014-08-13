package com.example.modelodaosqlite.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

	//Configure o nome da Base e a versão aqui:
	private static final String NOME_BASE = "BancoExemplo";
	private static final int VERSAO_BASE = 1;
	
	private static DbHelper instancia;
	
	private DbHelper(Context context) {
		super(context, NOME_BASE, null, VERSAO_BASE);
	}

	public static DbHelper getInstancia(Context context){
		if(instancia == null){
			instancia = new DbHelper(context);
		}
		return instancia;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		//Crie as tabelas do banco aqui
		db.execSQL(DAOExemplo.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//Faça a logica de upgrade de uma versão do banco para outra aqui
		db.execSQL(DAOExemplo.DROP_TABLE);
		onCreate(db);
	}	
}
