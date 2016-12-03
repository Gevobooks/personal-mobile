package com.example.senaisp.personalbooks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.widget.Toast;
import com.example.senaisp.personalbooks.converter.UsuarioConverter;
import com.example.senaisp.personalbooks.dao.UsuarioDao;
import com.example.senaisp.personalbooks.model.Usuario;

import java.util.List;

public class EnviarUsuarioTask extends AsyncTask<Void, Void, String> {
    private Context context;
    private ProgressDialog dialog;

    public EnviarUsuarioTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde", "Enviando usuario...", true, true);
    }

    @Override
    protected String doInBackground(Void... params) {




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

