package com.exercicio16.ex16aluno;

import java.time.LocalDate;
import java.util.Date;

public class AlunoEntity {
    int id,ra;
    String nome;
    LocalDate nascimento;

    public AlunoEntity() {
        id = 0;
        ra = 0;
        nome = "";
        nascimento = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
