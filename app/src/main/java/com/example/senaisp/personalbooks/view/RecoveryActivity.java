package com.example.senaisp.personalbooks.view;

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

    Button btnNadaAver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_recovery);

        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener (onClickSend());

        btnNadaAver = (Button)findViewById(R.id.btnNadaVer);
        btnNadaAver.setOnClickListener(this);
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

