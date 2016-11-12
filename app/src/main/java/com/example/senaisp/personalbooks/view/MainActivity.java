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
import com.example.senaisp.personalbooks.dao.UsuarioDao;
import com.example.senaisp.personalbooks.model.Usuario;
import java.util.List;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity{

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
                    Usuario userLogado = null;
                    boolean logado = false;

                    TextView edtLogin = (EditText) findViewById(R.id.edtLogin);
                    TextView edtSenha = (EditText) findViewById(R.id.edtSenha);
                    String login = edtLogin.getText().toString();
                    String senha = edtSenha.getText().toString();


                    List<Usuario> lUser = carregaLista();

                    for(Usuario user : lUser){
                        if(user.getEmail().equals(login) && user.getSenha().equals(senha)) {
                            userLogado = user;
                            logado = true;
                        }
                    }


                    if(logado){
                        alerta("Bem-vindo, login realizado com sucesso.");


                        Intent StartSession = new Intent(getContext(), PerfilActivity.class);
                        StartSession.putExtra("user",userLogado);
                        startActivity(StartSession);
                        setContentView(R.layout.activity_perfil);
                    } else {
                        alerta("Usuário ou senha incorreto!");
                    }

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

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();

    }

    private List<Usuario> carregaLista() {

        UsuarioDao dao = new UsuarioDao(this);
        List<Usuario> usuarios = dao.buscaUsuario();
        dao.close();

        return usuarios;
    }
}
