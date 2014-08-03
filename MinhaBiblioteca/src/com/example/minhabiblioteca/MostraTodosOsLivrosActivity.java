package com.example.minhabiblioteca;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MostraTodosOsLivrosActivity extends Activity {
	
	private ListView lvMostraTodosOsLivros; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_mostra_todos_livros);
		
		Button btAbreCadastro = (Button) findViewById(R.id.btAbreCadastro);
		lvMostraTodosOsLivros = (ListView) findViewById(R.id.lvMostraTodosOsLivros);
		
		btAbreCadastro.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent(MostraTodosOsLivrosActivity.this, CadastroLivroActivity.class);
				startActivity(it);
			}
		});
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		
		DbHelper dbHelper = new DbHelper(this);
		List<Livro> listaLivros = dbHelper.selectTodosOsLivros();
		
		ArrayAdapter<Livro> adp = new ArrayAdapter<Livro>(this, android.R.layout.simple_list_item_1, listaLivros);
		
		lvMostraTodosOsLivros.setAdapter(adp);
		
	}
	
}
