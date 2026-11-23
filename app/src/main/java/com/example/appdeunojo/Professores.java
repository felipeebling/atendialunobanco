package com.example.appdeunojo;

import java.io.Serializable;

public class Professores  implements Serializable {
    private int id;
    private String nome;
    private String identificacaoInstitucional;
    private String email;
    private String senha;

    public Professores(String nome, String identificacaoInstitucional, String email, String senha) {
        this.nome = nome;
        this.identificacaoInstitucional = identificacaoInstitucional;
        this.email = email;
        this.senha = senha;
    }

    public Professores(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Professores() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificacaoInstitucional() {
        return identificacaoInstitucional;
    }

    public void setIdentificacaoInstitucional(String identificacaoInstitucional) {
        this.identificacaoInstitucional = identificacaoInstitucional;
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
}
