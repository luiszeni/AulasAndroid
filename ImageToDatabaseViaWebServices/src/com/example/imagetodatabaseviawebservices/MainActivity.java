package com.example.imagetodatabaseviawebservices;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lvUsuario;
	private List<Usuario> usrs;
	private UsuarioDAO dao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
		
		dao = new UsuarioDAO();
		Button btCadastrar = (Button) findViewById(R.id.btCadastrar);
		lvUsuario = (ListView) findViewById(R.id.lvUsuarios);
		
		btCadastrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this, CadastroActivity.class);
				startActivity(it);
			}
		});
		
		lvUsuario.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
					boolean result = dao.exculirUsuario(usrs.get(position));
					if (result) {
						onResume();
					}
				return false;
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		usrs = dao.BuscarTodosUsuarios();
		
		UsuarioAdapter usrAdp = new UsuarioAdapter(this, usrs);
		lvUsuario.setAdapter(usrAdp);
	}
	
}
