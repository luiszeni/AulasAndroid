package com.example.imagetodatabaseviawebservices;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CadastroActivity extends Activity {
	private ImageView ivSelectedImage;
	private static final int REQUEST_CODE = 5678;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.cadastro);

		final EditText edNome = (EditText) findViewById(R.id.etNome);
		final EditText edIdade = (EditText) findViewById(R.id.etIdade);
		Button btCadastro = (Button) findViewById(R.id.btCadastro);
		Button btSelect = (Button) findViewById(R.id.btSelect);
		
		ivSelectedImage = (ImageView) findViewById(R.id.ivSelectedImage);

		btSelect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_CODE);
			}
		});

		btCadastro.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Bitmap bitmap = ((BitmapDrawable)ivSelectedImage.getDrawable()).getBitmap();

				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
				byte[] byteArray = stream.toByteArray();

				UsuarioDAO dao = new UsuarioDAO();
				Usuario usr = new Usuario();
				
				usr.setNome(edNome.getText().toString());
				usr.setIdade(Integer.parseInt(edIdade.getText().toString()));
				usr.setFoto(byteArray);
						
				usr = dao.inserirUsuario(usr);
				
				if (usr != null) {
					finish();
				} else {
					Toast.makeText(CadastroActivity.this, "Erro no Cadastro", Toast.LENGTH_LONG).show();
				}
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == REQUEST_CODE && data != null && data.getData() != null) {
			
			Uri uri = data.getData();

			Cursor cursor = getContentResolver().query(uri,	new String[] { android.provider.MediaStore.Images.ImageColumns.DATA },	null, null, null);
			cursor.moveToFirst();

			final String imageFilePath = cursor.getString(0);
			cursor.close();

			Bitmap bitmap = BitmapFactory.decodeFile(imageFilePath);
			ivSelectedImage.setImageBitmap(bitmap);
		}

	}
}
