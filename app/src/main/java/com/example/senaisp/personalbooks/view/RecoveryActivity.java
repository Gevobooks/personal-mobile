package com.example.senaisp.personalbooks.view;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.senaisp.personalbooks.R;

/**
 * Created by Kleber on 24/10/2016.
 */

public class RecoveryActivity extends AppCompatActivity{

    public void btnVoltar (View view){

        setContentView(R.layout.activity_main);
    }

    public void onBackPressed() {
        setContentView(R.layout.activity_main);
    }
    public void btnRecovery (View view){

        EditText recoveryMail = (EditText) findViewById(R.id.edtRecovery);
        String texto = recoveryMail.getText().toString();

            if ( texto == null || texto.equals("")) {
                Toast.makeText(getApplication(),
                        "O campo e-mail não foi digitado corretamente!",
                        Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(getApplication(),
                        "e-mail enviado com sucesso!, verifique seu e-mail",
                        Toast.LENGTH_LONG).show();
                        setContentView(R.layout.activity_main);
            }
    }
}

