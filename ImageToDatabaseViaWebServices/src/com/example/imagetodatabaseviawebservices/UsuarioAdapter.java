package com.example.imagetodatabaseviawebservices;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UsuarioAdapter extends BaseAdapter{

	private List<Usuario> usrs;
	private Context context;
	
	public UsuarioAdapter(Context context, List<Usuario> usrs) {
		this.usrs = usrs;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return usrs.size();
	}

	@Override
	public Object getItem(int arg0) {
		return usrs.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return usrs.get(arg0).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View rootView = LayoutInflater.from(context).inflate(R.layout.lista_de_usuarios, parent, false);

		ImageView ivFoto = (ImageView) rootView.findViewById(R.id.ivLvFoto);
		TextView tvNome = (TextView) rootView.findViewById(R.id.tvLvNome);
		TextView tvIdade = (TextView) rootView.findViewById(R.id.tvLvIdade);

		Usuario usuarioDaVez = usrs.get(position);

		tvNome.setText(usuarioDaVez.getNome());
		tvIdade.setText(usuarioDaVez.getIdade() + " Anos");

		Bitmap bitmap = BitmapFactory.decodeByteArray(usuarioDaVez.getFoto(), 0, usuarioDaVez.getFoto().length);
		ivFoto.setImageBitmap(bitmap);

		return rootView;
	}

}
