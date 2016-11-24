package com.example.senaisp.personalbooks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.example.senaisp.personalbooks.converter.UsuarioConverter;
import com.example.senaisp.personalbooks.dao.UsuarioDao;
import com.example.senaisp.personalbooks.model.Usuario;

import java.util.List;

public class EnviaUsuarioTask extends AsyncTask<Void, Void, String> {
    private Context context;
    private ProgressDialog dialog;

    public EnviaUsuarioTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Enviando usuario...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {
        UsuarioDao dao = new UsuarioDao(context);
        List<Usuario> usuarios = dao.buscaUsuario();
        dao.close();

        UsuarioConverter conversor = new UsuarioConverter();
        String json = conversor.converteParaJSON(usuarios);

        WebClient client = new WebClient();
        String resposta = client.post(json);
        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        dialog.dismiss();
        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }
}

