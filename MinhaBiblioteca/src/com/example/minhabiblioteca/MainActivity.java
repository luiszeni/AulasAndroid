package com.example.minhabiblioteca;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(this);
        
        Livro senhorDosAneis = new Livro(0,"Senhor dos Aneis", "TOLKIEN", 300); 
   
        dbHelper.insertLivro(senhorDosAneis);
        dbHelper.insertLivro(new Livro(0,"Guerra dos Tronos","MARTIN", 1000));
        
        
       List<Livro> listaLivros = dbHelper.selectTodosOsLivros();
        
       for (Iterator iterator = listaLivros.iterator(); iterator.hasNext();) {
    	   Livro livro = (Livro) iterator.next();
    	   
    	   Log.i("AppMinhaBiblioteca", livro.toString());
		
       }
        
    }

}
