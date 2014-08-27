package com.example.intentfilter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        Button btTela1 = (Button) findViewById(R.id.btTela1);
        Button btTela2 = (Button) findViewById(R.id.btTela2); 
        
        btTela1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this, Tela1.class);
				it.putExtra("msg", " botao 1");
				startActivity(it);
			}
		});
        
        btTela2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this, Tela2.class);
				it.putExtra("msg", " botao 2");
				startActivity(it);
			}
		});
    }
}
