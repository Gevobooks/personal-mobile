package com.example.senaisp.personalbooks.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import com.example.senaisp.personalbooks.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends SQLiteOpenHelper {

    public UsuarioDao(Context context) {
        super(context, "Usuarios", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Usuarios(" +
                "id INTEGER PRIMARY KEY," +
                "email TEXT NOT NULL," +
                "senha TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Usuarios";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoUsuario(usuario);

        db.insert("Usuarios", null, dados);
    }

    public void altera(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoUsuario(usuario);

        String[] params = {usuario.getId().toString()};
        db.update("Usuario", dados, "id = ?", params);
    }

    public List<Usuario> buscaUsuario() {
        String sql = "SELECT * FROM Usuarios";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Usuario> usuarios = new ArrayList<>();

        while(c.moveToNext()) {
            Usuario usuario = new Usuario();
            usuario.setId(c.getLong(c.getColumnIndex("id")));
            usuario.setEmail(c.getString(c.getColumnIndex("email")));
            usuario.setSenha(c.getString(c.getColumnIndex("senha")));

            usuarios.add(usuario);
        }
        c.close();

        return usuarios;
    }

    public void deleta(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {usuario.getId().toString()};
        db.delete("Usuario", "id = ?", params);
    }

    @NonNull
    private ContentValues pegaDadosDoUsuario(Usuario usuario) {
        ContentValues dados = new ContentValues();
        dados.put("email", usuario.getEmail());
        dados.put("senha", usuario.getSenha());
        return dados;
    }

}
