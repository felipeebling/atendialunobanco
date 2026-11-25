package com.example.appdeunojo;


import java.io.Serializable;

public class Atendimentos implements Serializable  {

    private int id;
    private int professorId;
    private int alunoId;
    private String nomeAluno;

    private String dataPrevista;
    private String horaPrevista;
    private int duracao;
    private String disciplina;

    private String tipo;
    private String modalidade;
    private String localLink;
    private String descricao;
    private String observacoes;

    private String situacao;
    private String conteudoTratado;
    private Boolean compareceu;
    private String motivoCancelamento;

    private String encaminhamento;
    private String prazoEncaminhamento;
    private boolean encaminhamentoConcluido;


    public Atendimentos() {
    }


    public Atendimentos(int professorId, int alunoId,
                       String dataPrevista, String horaPrevista,
                       int duracao, String disciplina,
                       String tipo, String modalidade,
                       String localLink, String descricao) {

        this.professorId = professorId;
        this.alunoId = alunoId;
        this.dataPrevista = dataPrevista;
        this.horaPrevista = horaPrevista;
        this.duracao = duracao;
        this.disciplina = disciplina;
        this.tipo = tipo;
        this.modalidade = modalidade;
        this.localLink = localLink;
        this.descricao = descricao;
        this.situacao = "AGENDADO";
        this.encaminhamentoConcluido = false;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProfessorId() { return professorId; }
    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getAlunoId() { return alunoId; }
    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public String getNomeAluno() { return nomeAluno; }
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getDataPrevista() { return dataPrevista; }
    public void setDataPrevista(String dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public String getHoraPrevista() { return horaPrevista; }
    public void setHoraPrevista(String horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModalidade() { return modalidade; }
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getLocalLink() { return localLink; }
    public void setLocalLink(String localLink) {
        this.localLink = localLink;
    }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getSituacao() { return situacao; }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getConteudoTratado() {
        return conteudoTratado;
    }
    public void setConteudoTratado(String conteudoTratado) {
        this.conteudoTratado = conteudoTratado;
    }

    public Boolean getCompareceu() { return compareceu; }
    public void setCompareceu(Boolean compareceu) {
        this.compareceu = compareceu;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }
    public void setMotivoCancelamento(String motivo) {
        this.motivoCancelamento = motivo;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }
    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public String getPrazoEncaminhamento() {
        return prazoEncaminhamento;
    }
    public void setPrazoEncaminhamento(String prazo) {
        this.prazoEncaminhamento = prazo;
    }

    public boolean isEncaminhamentoConcluido() {
        return encaminhamentoConcluido;
    }
    public void setEncaminhamentoConcluido(boolean concluido) {
        this.encaminhamentoConcluido = concluido;
    }
}
