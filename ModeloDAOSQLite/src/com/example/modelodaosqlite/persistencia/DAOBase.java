package com.example.modelodaosqlite.persistencia;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.modelodaosqlite.entidades.EntidadePersistivel;

public abstract class DAOBase <T extends EntidadePersistivel>{

	protected SQLiteDatabase db;
		
	public DAOBase(Context context) {
		DbHelper bdHelper = DbHelper.getInstancia(context);
		db = bdHelper.getWritableDatabase();
	}
	
	public abstract String getNomeColunaPrimaryKey();
	public abstract String getNomeTabela();
	public abstract ContentValues entidadeParaContentValues(T entidade);
	public abstract T contentValuesParaEntidade(ContentValues contentValues);
	
	public void inserir(T entidade){
		ContentValues cv = entidadeParaContentValues(entidade);
		db.insert(getNomeTabela(), null, cv);
	}
	
	public void deletar(T entidade){
		String [] valores = {String.valueOf(entidade.getId())};
		db.delete(getNomeTabela(),  getNomeColunaPrimaryKey() + " =  ?", valores);
	}
	
	public void editar(T entidade){
		String [] valores = {String.valueOf(entidade.getId())}; 
		ContentValues cv = entidadeParaContentValues(entidade);
		db.update(getNomeTabela(), cv, getNomeColunaPrimaryKey() + " = ?" , valores);
	}
	
	public List<T> buscarTodos(){
		String query = "SELECT * from " + getNomeTabela();
		return recuperarPorQuery(query);
	}
	
	public T buscarPorId(int id){
		String query = "SELECT * from " + getNomeTabela() + " WHERE "+ getNomeColunaPrimaryKey() + " = " + id;
	
		List<T> resultado = recuperarPorQuery(query);
		if(resultado.size() > 0)
			return resultado.get(0);
		return null;
	}

	public List<T> recuperarPorQuery(String query){
		Cursor c = db.rawQuery(query, null);
		List<T> listaRetorno = new ArrayList<T>();
		if(c.moveToFirst()){
			do {
				ContentValues cv = new ContentValues();
				DatabaseUtils.cursorRowToContentValues(c, cv);
				listaRetorno.add(contentValuesParaEntidade(cv));
			} while (c.moveToNext());
		}
		return listaRetorno;
	}
}
