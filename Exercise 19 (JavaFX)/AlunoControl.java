package com.example.exercicio19;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoControl {
    private List<Aluno> lista = new ArrayList<>();
    private ObservableList<Aluno> listaView = FXCollections.observableArrayList();

    IntegerProperty id = new SimpleIntegerProperty(0);
    LongProperty ra = new SimpleLongProperty(0);
    StringProperty nome = new SimpleStringProperty("");
    ObjectProperty nascimento = new SimpleObjectProperty(LocalDate.now());

    public void setAluno(Aluno a){
        id.set(a.getId());
        ra.set(a.getRa());
        nome.set(a.getNome());
        nascimento.set(a.getNascimento());
    }

    public Aluno getAluno(){
        Aluno a = new Aluno(id.get(),ra.get(),nome.get(),(LocalDate) nascimento.get());
        return a;
    }

    public void adiciona(int id, long ra, String nome, LocalDate nascimento){
        boolean encontrou = false;
        Aluno aluno = new Aluno(id,ra,nome,nascimento);
        for (int i = 0; i < lista.size(); i++){
            Aluno alunoLista = lista.get(i);
            if(aluno.getId() == alunoLista.getId()){
                encontrou = true;
            }
        }
        if(!encontrou){
            lista.add(aluno);
        }
        updateListaView();
    }

    private void updateListaView() {
        listaView.clear();
        listaView.addAll(lista);
    }

    public void pesquisa(String nome) {
        listaView.clear();
        for(Aluno a : lista) {
            if (a.getNome().contains(nome)) {
                listaView.add(a);
                setAluno(a);
            }
        }
    }

    public ObservableList<Aluno> getListaView(){
        return listaView;
    }
}