package com.ads.projetodavelha;



import android.R.string;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Velha extends Inicio {



	private final String Botn = "btn";
	private final String Bola = "O";
	private final String Xis = "X";

	private String Ultjog = "O";
	private View view;

	int[][] deuVelha = new int [][]{

			{1,2,3}, 
			{4,5,6},
			{7,8,9},

			{1,4,7}, 
			{2,5,8},
			{3,6,9},

			{1,5,9}, 
			{3,5,7},

	};
	int h = 0;
	String jog1, jog2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setView(getLayoutInflater().inflate(R.layout.layout_velha, null));
		setContentView(getView());
		
		Intent mandar = getIntent();
		//Intent mandarn = getIntent();
		String digi1=  mandar.getStringExtra(Inicio.ABRE_JOGO);
		String digi2 =  mandar.getStringExtra(Inicio.ABRE_JOGADA);
		
		jog1=digi1;
		jog2=digi2;
		
		TextView nomeX = (TextView)findViewById(R.id.nomeX);
		TextView nomeO = (TextView)findViewById(R.id.nomeO);
		
		nomeX.setText(digi1+", joga com X");
		nomeO.setText(digi2+", joga com O");
		
		Toast.makeText(getView().getContext(), "variaveis", Toast.LENGTH_LONG).show();
		Toast.makeText(getView().getContext(), digi1, Toast.LENGTH_LONG).show();
		Toast.makeText(getView().getContext(), digi2, Toast.LENGTH_LONG).show();
		
		
		
	
		
	}



	

	public void clickBtn(View ver){
		if(!fimJog()){
			if (((Button)ver).getText().equals("")){

				if (Ultjog.equals(Xis)) {
					((Button)ver).setText(Bola);
					setUltjog(Bola);
				}
				else {
					((Button)ver).setText(Xis);
					setUltjog(Xis);
				}
			}else 
			{
				Toast.makeText(getView().getContext(), "Já marcado, escolha outro", Toast.LENGTH_SHORT).show();
			}


		}else{//h++;
			
		

		}
		fimJog();
		
	}

	//Toast.makeText(getView().getContext(), ver.getTag().toString(), Toast.LENGTH_SHORT).show();


	public Button getBtn (int tagNum){
		return (Button)getView().findViewWithTag(Botn+tagNum);
	}

	public void novoJogo (View ver){
		setEnableBtn(true);
		h=0;

		for(int i=1; i<=9; i++){
			if(getBtn(i)!=null);
			getBtn(i).setText("");
			setCorBatn(i,R.color.preto);

		}
	}
	public void setEnableBtn(boolean b){
		for(int i=1; i<=9; i++){
			if(getBtn(i)!=null){
				getBtn(i).setEnabled(b);
			}
		}
	}



	public void setCorBatn (int btan, int corX){
		getBtn(btan).setTextColor(getResources().getColor(corX));
	}



	public boolean fimJog(){

		for(int x=0; x<=7; x++){

			String ve1 = getBtn(deuVelha [x][0]).getText().toString();


			String ve2 = getBtn(deuVelha [x][1]).getText().toString();


			String ve3 = getBtn(deuVelha [x][2]).getText().toString();
			
			if ((!ve1.equals("")) &&
					(!ve2.equals("")) &&
					(!ve3.equals(""))){



				if (ve1.equals ( ve2 )&&( ve2.equals(ve3))){
					setCorBatn(deuVelha[x][0],R.color.vermelho);
					setCorBatn(deuVelha[x][1],R.color.vermelho);
					setCorBatn(deuVelha[x][2],R.color.vermelho);
					
					if(h==0){if(ve1==Xis){

						new AlertDialog.Builder(this).setTitle("Parabens "+jog1+"!").setMessage("Você Venceu").setNeutralButton("Fechar", null).show();
						//Toast.makeText(getView().getContext(),"O JOGO ACABOU!!", Toast.LENGTH_SHORT).show();
					}else{
						new AlertDialog.Builder(this).setTitle("Parabens "+jog2+"!").setMessage("Você Venceu").setNeutralButton("Fechar", null).show();
					}
						h++;
					}else{if(h>=1){

						Toast.makeText(getView().getContext(), "Aperte Play Para Jogar Novamente", Toast.LENGTH_SHORT).show();
					}

					}
					return true;
				}}}

		return false;
	}



	public View getView() {
		return view;
	}


	public void setView(View view) {
		this.view = view;
	}



	public String getUltjog() {
		return Ultjog;
	}
	public void setUltjog(String ultjog){
		this.Ultjog = ultjog;
	}

}
