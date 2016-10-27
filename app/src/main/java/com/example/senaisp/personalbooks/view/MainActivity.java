package com.example.senaisp.personalbooks.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.senaisp.personalbooks.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnEntrar;
    private EditText edtLogin;
    private EditText edtSenha;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();

        if (login == null || senha == null ){
            Toast.makeText(getBaseContext(),
                    "Os campos login e senha não podem estar vazios!",
                    Toast.LENGTH_LONG).show();
            if (login == "admin" && senha == "admin" ){
                setContentView(R.layout.activity_perfil);
            }

        }

    }
}
