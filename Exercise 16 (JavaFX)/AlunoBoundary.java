package com.exercicio16.ex16aluno;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlunoBoundary extends Application {
    private Label lblNome = new Label("Nome:");
    private Label lblId = new Label("Id:");
    private Label lblRa = new Label("Ra:");
    private Label lblNascimento = new Label("Nascimento:");

    private TextField txfId = new TextField();
    private TextField txfRa = new TextField();
    private TextField txfNasc = new TextField();
    private TextField txfNome = new TextField();

    private Button btnPesquisa = new Button("Pesquisar");
    private Button btnAdiciona = new Button("Adicionar");

    List<AlunoEntity> lista = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        Pane p = new Pane();
        Scene scene = new Scene(p, 300, 300);

        lblId.relocate(0,0);
        txfId.relocate(80,0);
        lblNome.relocate(0,30);
        txfNome.relocate(80,30);
        lblRa.relocate(0,60);
        txfRa.relocate(80,60);
        lblNascimento.relocate(0,90);
        txfNasc.relocate(80,90);

        btnAdiciona.relocate(30,120);
        btnPesquisa.relocate(120,120);
        p.getChildren().addAll(lblId,lblRa,lblNome,lblNascimento,txfNasc,txfId,txfNome,txfRa,btnAdiciona,btnPesquisa);

        btnAdiciona.setOnAction( e -> {
            AlunoEntity a = this.BoundarytoEntity();
            lista.add(a);
            System.out.println(lista);
        });

        btnPesquisa.setOnAction( e -> {
            boolean encontrou = false;
            for(AlunoEntity a: lista){
                if(a.getNome().contains(txfNome.getText())){
                    this.EntitytoBoundary(a);
                    encontrou = true;
                    break;
                }
            }if (!encontrou) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Aluno não encontrado");
                alert.showAndWait();
            }
        });
        stage.setTitle("Formulário do Aluno");
        stage.setScene(scene);
        stage.show();
    }

    public void EntitytoBoundary(AlunoEntity a){
        if(a != null){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            txfId.setText(String.valueOf(a.getId()));
            txfNome.setText(String.valueOf(a.getNome()));
            txfRa.setText(String.valueOf(a.getRa()));
            String strNasc = dtf.format(a.getNascimento());
            txfNasc.setText(strNasc);
        }
    }

    public AlunoEntity BoundarytoEntity(){
        AlunoEntity a = new AlunoEntity();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try{
                a.setId(Integer.parseInt(txfId.getText()));
                a.setRa(Integer.parseInt(txfRa.getText()));
                a.setNome(txfNome.getText());
                LocalDate dt = LocalDate.parse(txfNasc.getText(), dtf);
                a.setNascimento(dt);
            }catch(Exception e){
                System.out.println("ERRO: " + e.getMessage());
            }
            return a;
    }

    public static void main(String[] args) {
        launch();
    }
}