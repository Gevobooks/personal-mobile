package com.example.senaisp.personalbooks.view;

import android.widget.EditText;
import com.example.senaisp.personalbooks.R;
import com.example.senaisp.personalbooks.model.Usuario;

/**
 * Created by SENAI SP on 29/10/2016.
 */


public class FormularioHelper {

    private final EditText campoUsuario;
    private final EditText campoSenha;

    private Usuario usuario;

    public FormularioHelper(CadastroActivity activity){


        campoUsuario = (EditText) activity.findViewById(R.id.txtCadEmail);
        campoSenha = (EditText) activity.findViewById(R.id.txtCadSenha);

        usuario = new Usuario();
    }



    public Usuario pegaUsuario() {
        usuario.setEmail(campoUsuario.getText().toString());
        usuario.setSenha(campoUsuario.getText().toString());
        return usuario;
    }

    public void preencheFormulario(Usuario usuario) {
        campoUsuario.setText(usuario.getEmail());
        campoUsuario.setText(usuario.getSenha());

        this.usuario = usuario;
    }

}

