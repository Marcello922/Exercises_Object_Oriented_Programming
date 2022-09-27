package br.com.projeto.gestaoalunos;

import java.util.Date;

public class Aluno {
   long id;
   Date nascimento;
    String ra, nome;
    public Aluno(long id, Date nascimento, String ra, String nome) {
        this.id = id;
        this.nascimento = nascimento;
        this.ra = ra;
        this.nome = nome;
    }

    @Override
    public String toString(){
       String saida = " Aluno nº " + Long.toString(id)+ "\n Nome: " + nome + "\n RA: " + ra + "\n Data de Nascimento: " + nascimento.toString();
       return saida;
   }

}
