package com.curso.pooexercicio17.ex17;

public class CursoEntity {
    long id,codCurso;
    int qntAlunos;

    public CursoEntity() {
        this.id = 0;
        this.codCurso = 0;
        this.qntAlunos = 0;
        this.nome = "";
        this.nomeCoord = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(long codCurso) {
        this.codCurso = codCurso;
    }

    public int getQntAlunos() {
        return qntAlunos;
    }

    public void setQntAlunos(int qntAlunos) {
        this.qntAlunos = qntAlunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCoord() {
        return nomeCoord;
    }

    public void setNomeCoord(String nomeCoord) {
        this.nomeCoord = nomeCoord;
    }

    @Override
    public String toString(){
        return this.nome;
    }

    String nome, nomeCoord;

}
