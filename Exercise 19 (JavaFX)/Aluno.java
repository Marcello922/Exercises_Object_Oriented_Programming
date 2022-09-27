package com.example.exercicio19;

import java.time.LocalDate;

public class Aluno {
    int id;
    long ra;
    String nome;
    LocalDate nascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRa() {
        return ra;
    }

    public void setRa(long ra) {
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

    public Aluno(int id, long ra, String nome, LocalDate nascimento) {
        this.id = id;
        this.ra = ra;
        this.nome = nome;
        this.nascimento = nascimento;
    }
}
