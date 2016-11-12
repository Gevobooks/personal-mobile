package com.example.senaisp.personalbooks.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.senaisp.personalbooks.R;

/**
 * Created by Kleber on 24/10/2016.
*/

public class RecoveryActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_recovery);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener (onClickSend());
        Button btnNadaAver = (Button)findViewById(R.id.btnNadaVer);
        btnNadaAver.setOnClickListener(onClickCadastro());
    }

    public View.OnClickListener onClickCadastro(){
        return new Button.OnClickListener(){
            public void onClick (View v){
                Intent StartRecovery = new Intent (getContext(), CadastroActivity.class );
                startActivity(StartRecovery);
                setContentView(R.layout.activity_cadastro);
            }
        };
    }

    public View.OnClickListener onClickSend(){
        return new Button.OnClickListener(){
            public void onClick (View v){

                EditText recoveryMail = (EditText) findViewById(R.id.edtRecovery);
                String texto = recoveryMail.getText().toString();

                if ( texto == null || texto.equals("")) {
                    alerta("O campo e-mail não foi digitado corretamente!");

                }else{
                    alerta("E-mail enviado com sucesso!, verifique seu e-mail");
                    setContentView(R.layout.activity_main);
                }
            }

        };

    }

    private Context getContext(){
        return this;
    }

    public void alerta (String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    public void onBackPressed() {

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        this.finish();
    }

    /*public void btnVoltar (View view){

        setContentView(R.layout.activity_main);
    }*/
}

