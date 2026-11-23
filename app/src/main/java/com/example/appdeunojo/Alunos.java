package com.example.appdeunojo;

import java.io.Serializable;

public class Alunos implements Serializable {

    private  String nome;
    private  int id;
    private String senha;

    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Alunos(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    public Alunos(){}
}
