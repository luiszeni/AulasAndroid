package com.example.intentfilter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela1 extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Intent it = getIntent();
		
		if(it != null && it.getExtras().getString("msg") != null){
			TextView tx = new TextView(this);
			tx.setText("Tela 1"+ it.getExtras().getString("msg"));
			setContentView(tx);
		}else{
			TextView tx = new TextView(this);
			tx.setText("Tela 1 - sem msg");
			setContentView(tx);
		}
		
		
	
	}

}
