package com.example.senaisp.personalbooks.model;

/**
 * Created by SENAI SP on 29/10/2016.
 */
import java.io.Serializable;

public class Usuario implements Serializable {


    private String Username;
    private String Password;

    public String getEmail() {
        return Username;
    }

    public void setEmail(String email) {
        this.Username = email;
    }

    public String getSenha() {
        return Password;
    }

    public void setSenha(String senha) {
        this.Password = senha;
    }


}