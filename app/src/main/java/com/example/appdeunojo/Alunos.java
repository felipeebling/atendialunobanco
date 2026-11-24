package com.example.appdeunojo;

import java.io.Serializable;

public class Alunos implements Serializable {

    private String nome;
    private int id;
    private String turma;
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Alunos(String email, String nome, String turma) {
        this.email = email;
        this.nome = nome;
        this.turma = turma;
    }

    public Alunos() {}
}
