package com.example.senaisp.personalbooks.converter;


import com.example.senaisp.personalbooks.model.Usuario;
import org.json.JSONException;
import org.json.JSONStringer;
import java.util.List;

public class UsuarioConverter {

        public String converteParaJSON(List<Usuario> usuarios) {
            JSONStringer js = new JSONStringer();

            try {
                js.object().key("list").array().object().key("usuario").array();
                for (Usuario usuario : usuarios) {
                    js.object();
                    js.key("email").value(usuario.getEmail());
                    js.key("senha").value(usuario.getSenha());
                    js.endObject();
                }
                js.endArray().endObject().endArray().endObject();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return js.toString();
        }
    }



