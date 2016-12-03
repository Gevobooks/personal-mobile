package com.example.senaisp.personalbooks.converter;


import com.example.senaisp.personalbooks.model.Usuario;
import org.json.JSONException;
import org.json.JSONStringer;
import java.util.List;

public class UsuarioConverter {

        public String converteParaJSON(String user, String password) {
            JSONStringer js = new JSONStringer();

            try {
                js.object();
                    js.key("Username").value(user);
                    js.key("Password").value(password);
                    js.endObject();

                js.endArray().endObject().endArray().endObject();
                }
             catch (JSONException e) {
                e.printStackTrace();
            }
            return js.toString();
        }
    }



