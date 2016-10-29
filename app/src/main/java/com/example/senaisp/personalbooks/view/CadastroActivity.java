package com.example.senaisp.personalbooks.view;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.senaisp.personalbooks.R;
import com.example.senaisp.personalbooks.dao.UsuarioDao;
import com.example.senaisp.personalbooks.model.Usuario;

/**
 * Created by SENAI SP on 29/10/2016.
 */

public class CadastroActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        helper = new FormularioHelper(this);

        Intent intent = getIntent();
        Usuario usuario = (Usuario) intent.getSerializableExtra("usuario");
        if(usuario != null) {
            helper.preencheFormulario(usuario);
        }



        Button enviar = (Button) findViewById (R.id.btnEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Usuario usuario = helper.pegaUsuario();

               /* UsuarioDao dao = new UsuarioDao();
                if(usuario.getId() != null) {
                    dao.altera(usuario);
                } else {
                    dao.insere(usuario);
                }
                dao.close();*/



                Toast.makeText(CadastroActivity.this,"Usuário"+ usuario.getEmail()+ "Salvo!" ,Toast.LENGTH_SHORT).show();
                finish();




            }
        });
    }
}
