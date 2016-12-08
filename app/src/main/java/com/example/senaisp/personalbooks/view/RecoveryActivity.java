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
import com.example.senaisp.personalbooks.model.viewModel.Token;
import com.example.senaisp.personalbooks.repository.ICallback;
import com.example.senaisp.personalbooks.repository.UserRepository;


public class RecoveryActivity extends AppCompatActivity implements View.OnClickListener {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_recovery);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener (onClickSend());

    }



    public View.OnClickListener onClickSend(){
        return new Button.OnClickListener(){
            public void onClick (View v){

                String email = ((EditText) findViewById(R.id.edtRecovery)).getText().toString();

                UserRepository.getForgetPassword(email, new ICallback<Token>() {
                    @Override
                    public void Callback(final Token back, final Exception error)
                    {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (error != null)
                                {
                                    Intent StartSession = new Intent(getContext(), MainActivity.class);
                                    alerta("E-mail enviado com sucesso!, verifique seu e-mail");
                                    startActivity(StartSession);
                                    setContentView(R.layout.activity_main);
                                }
                                else
                                {
                                    alerta("O campo e-mail não foi digitado corretamente!");
                                }

                            }
                        });
                    }
                });



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
}