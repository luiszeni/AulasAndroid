package com.example.minhabiblioteca;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CadastroLivroActivity extends Activity implements OnClickListener{

	EditText etTitulo;
	EditText etAutor; 
	EditText etPaginas; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_cadastro_livros);
		
		
		etTitulo = (EditText) findViewById(R.id.etTitulo);
		etAutor  = (EditText) findViewById(R.id.etAutor);
		etPaginas  = (EditText) findViewById(R.id.etPaginas);
		
		Button btGeraCadastro = (Button) findViewById(R.id.btGeraCadastro);
		
		btGeraCadastro.setOnClickListener(this);

	}

	
	@Override
	public void onClick(View v) {
		Livro livro = new Livro();
		
		livro.setTitulo(etTitulo.getText().toString());
		livro.setAutor(etAutor.getText().toString());
		livro.setPaginas( Integer.parseInt(etPaginas.getText().toString()));
		
		DbHelper dbHelper = new DbHelper(this);
		dbHelper.insertLivro(livro);
		finish();

	}
	
}
