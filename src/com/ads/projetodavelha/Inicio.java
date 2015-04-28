package com.ads.projetodavelha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Inicio extends Activity {

	public final static String ABRE_JOGO = "com.ads.projetodavelha.JOGO";
	public final static String ABRE_JOGADA = "com.ads.projetodavelha.JOGADA";
	
	public void chamJogo (View ver){
		
		Intent mandar = new Intent (this, Velha.class );
		
		
		EditText nome1 = (EditText) findViewById(R.id.edt1);
		String digi1 = nome1.getText().toString();
		EditText nome2 = (EditText) findViewById(R.id.edt2);
		String digi2 = nome2.getText().toString();
						
		mandar.putExtra(ABRE_JOGO, digi1);
		mandar.putExtra(ABRE_JOGADA,digi2);
		startActivity(mandar) ;
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio_layout);
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
		return true;*/
	}

