package com.example.minhabiblioteca;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

	private static final String NOME_BASE = "MinhaBiblioteca";
	private static final int VERSAO_BASE = 2;
	
	public DbHelper(Context context) {
		super(context, NOME_BASE, null, VERSAO_BASE);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlCreateTabelaLivro = "CREATE TABLE livro("
									+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
									+ "titulo TEXT,"
									+ "autor TEXT,"
									+ "paginas INTEGER"
									+ ")";
		db.execSQL(sqlCreateTabelaLivro);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		String sqlDropTabelaLivros = "DROP TABLE livro";
		db.execSQL(sqlDropTabelaLivros);
		
		onCreate(db);
	}
	
	
	public void insertLivro(Livro livro){
		SQLiteDatabase db = getWritableDatabase();
			
		ContentValues cv =new ContentValues();
		
		cv.put("titulo", livro.getTitulo());
		cv.put("autor", livro.getAutor());
		cv.put("paginas", livro.getPaginas());
		
		db.insert("livro", null, cv);
		
		db.close();
	}

	
	public List<Livro> selectTodosOsLivros(){
		
		List<Livro> listLivros = new ArrayList<Livro>(); 
		
		SQLiteDatabase db = getReadableDatabase();
		
		String sqlSelectTodosLivros = "SELECT * FROM livro";
		
		Cursor c = db.rawQuery(sqlSelectTodosLivros, null);
		
		if(c.moveToFirst()){
			do{
				Livro livro = new Livro();
				livro.setId(c.getInt(0));
				livro.setTitulo(c.getString(1));
				livro.setAutor(c.getString(2));
				livro.setPaginas(c.getInt(3));
				
				listLivros.add(livro);
			}while(c.moveToNext());
		}
		
		db.close();
		return listLivros;
	}
	
}
