package com.example.senaisp.personalbooks.model;

/**
 * Created by SENAI SP on 29/10/2016.
 */
import java.io.Serializable;

public class Usuario implements Serializable {

    private Long id;
    private String email;
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return getId() + " - " + getEmail();
    }
}