package com.example.senaisp.personalbooks.view;

import android.widget.EditText;
import android.widget.TextView;

import com.example.senaisp.personalbooks.R;
import com.example.senaisp.personalbooks.model.Usuario;

/**
 * Created by SENAI SP on 29/10/2016.
 */


public class PerfilHelper {

    private final TextView campoUsuario;
    private final TextView campoSenha;


    private Usuario usuario;

    public PerfilHelper(PerfilActivity activity){


        campoUsuario = (TextView) activity.findViewById(R.id.textViewUsuariologado);
        campoSenha = (TextView) activity.findViewById(R.id.textViewEmailLogado);

        usuario = new Usuario();
    }



    public Usuario pegaUsuario() {
        usuario.setEmail(campoUsuario.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());
        return usuario;
    }

    public void preencheFormulario(Usuario usuario) {
        campoUsuario.setText(usuario.getEmail());
        campoUsuario.setText(usuario.getSenha());

        this.usuario = usuario;
    }

}

