package br.com.projeto.gestaoalunos;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class GestaoAlunos {

    static int indice;
    static Aluno[] alunos = new Aluno[50];

    public static void main(String[] args) throws ParseException {
        menu();
    }

     static void criar() throws ParseException {
        String nascimento = JOptionPane.showInputDialog("Digite a data de nascimento: ");
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        String ra = JOptionPane.showInputDialog("Digite o RA do aluno: ");
        String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");

         alunos[indice] = new Aluno(indice, df.parse(nascimento),ra, nome);
        indice++;
    }

    static void excluir(){
        String ra = JOptionPane.showInputDialog("Digite o RA: ");
        int i = 0;
        boolean e = false;
        for(Aluno a:alunos){
                if(a != null && a.ra.equals(ra)){
                    alunos[i] = null;
                    JOptionPane.showMessageDialog(null,"Aluno excluido.");
                    e = true;
                }
                i++;
        }
        if(!e){
            JOptionPane.showMessageDialog(null,"Aluno não encontrado!");
        }
    }

    static void exibir(){
        String ra = JOptionPane.showInputDialog("Digite o RA: ");
        boolean encontrou = false;

        for(Aluno a: alunos){
            if(a != null && a.ra.equals(ra)){
                JOptionPane.showMessageDialog(null,a.toString());
                encontrou = true;
            }
        }
        if(!encontrou){
            JOptionPane.showMessageDialog(null,"Aluno não encontrado!");
        }
    }

    static void atualizar() throws ParseException {
        String ra = JOptionPane.showInputDialog("Digite o RA: ");
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        boolean encontrou = false;

        for(int i = 0; (alunos[i] != null); i++){
            if(alunos[i].ra.equals(ra)){
                alunos[i].nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
                alunos[i].nascimento = df.parse(JOptionPane.showInputDialog("Digite a data de nascimento"));
                encontrou = true;
            }
        }
        if(!encontrou){
            JOptionPane.showMessageDialog(null,"Aluno não encontrado!");
        }
    }

    static void menu() throws ParseException {
        String textoMaiusculo;
        char letra = ' ';
        Scanner scan;
        while(Character.compare(letra,'S') != 0){
            textoMaiusculo = JOptionPane.showInputDialog("MENU: \n     (C)riar           (E)xibir             (R)emover\n" +
                    "               (A)tualizar    (S)air");
            scan = new Scanner(textoMaiusculo);
            textoMaiusculo = scan.nextLine().toUpperCase();
            letra = textoMaiusculo.charAt(0);

            switch (letra){
                case 'C':
                    criar();
                    break;
                case 'E':
                    exibir();
                    break;
                case 'R':
                    excluir();
                    break;
                case 'A':
                    atualizar();
                    break;
                default:
                    break;
            }
        }
    }

}
