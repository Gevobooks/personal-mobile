package com.example.senaisp.personalbooks.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.senaisp.personalbooks.R;
import com.example.senaisp.personalbooks.model.Usuario;
import com.example.senaisp.personalbooks.model.viewModel.Token;
import com.example.senaisp.personalbooks.repository.ICallback;
import com.example.senaisp.personalbooks.repository.UserRepository;
import com.google.gson.Gson;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity
{
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = (Button) findViewById(R.id.btnEntrar);
        btnLogin.setOnClickListener (onClickLogin());
        Button btnRecovery = (Button) findViewById(R.id.btnRecovery);
        btnRecovery.setOnClickListener(onClickRecovery());
}

    public View.OnClickListener onClickLogin () {
        return new Button.OnClickListener() {
            public void onClick(View v) {

                try {

                    String login = ((EditText) findViewById(R.id.edtLogin)).getText().toString();
                    String senha = ((EditText) findViewById(R.id.edtSenha)).getText().toString();

                    Usuario user = new Usuario();
                    user.setEmail(login);
                    user.setSenha(senha);

                    String json = gson.toJson(user);

                    UserRepository.EnviarUsuario(json, new ICallback<Token>() {
                        @Override
                        public void Callback(final Token back, final Exception error)
                        {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (error != null)
                                    {
                                        //tratar o erro
                                    }
                                    else
                                    {
                                        Intent StartSession = new Intent(getContext(), PerfilActivity.class);
                                        StartSession.putExtra("user", back);
                                        startActivity(StartSession);
                                        setContentView(R.layout.activity_perfil);
                                    }

                                }
                            });
                        }
                    });


                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }

        };
    }


    public View.OnClickListener onClickRecovery(){
        return new Button.OnClickListener(){
            public void onClick (View v){
                Intent StartRecovery = new Intent (getContext(), RecoveryActivity.class );
                startActivity(StartRecovery);
                setContentView(R.layout.detalhe_recovery);
            }
        };
    }


    private Context getContext(){
        return this;
    }

    private void  alerta (String s){

        makeText(this, s, Toast.LENGTH_LONG).show();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();

}



