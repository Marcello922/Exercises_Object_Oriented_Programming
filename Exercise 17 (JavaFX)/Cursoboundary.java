package com.curso.pooexercicio17.ex17;

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
import java.util.ArrayList;
import java.util.List;

public class Cursoboundary extends Application {
    Button btnAdiciona = new Button("Adicionar");
    Button btnPesquisa = new Button("Pesquisar");
    Label lblId = new Label("Id ");
    Label lblNome = new Label("Nome ");
    Label lblCodCurso = new Label("Código do curso ");
    Label lblNomeCoord = new Label("Nome do Coordenador ");
    Label lblQntAlunos = new Label("Quantidade de Alunos ");
    TextField txfId = new TextField();
    TextField txfNome = new TextField();
    TextField txfCodCurso = new TextField();
    TextField txfNomeCoord = new TextField();
    TextField txfQntAlunos = new TextField();

    List<CursoEntity> lista = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Cursoboundary.class.getResource("hello-view.fxml"));
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 300);

        //x   y
        lblId.relocate(0, 0);
        txfId.relocate(150, 0);
        lblNome.relocate(0, 40);
        txfNome.relocate(150, 40);
        lblCodCurso.relocate(0, 80);
        txfCodCurso.relocate(150, 80);
        lblNomeCoord.relocate(0, 120);
        txfNomeCoord.relocate(150, 120);
        lblQntAlunos.relocate(0, 160);
        txfQntAlunos.relocate(150, 160);
        btnAdiciona.relocate(0, 200);
        btnPesquisa.relocate(100, 200);


        pane.getChildren().addAll(lblId, lblNome, lblNomeCoord, lblCodCurso, lblQntAlunos, txfNome, txfId, txfNomeCoord, txfCodCurso, txfQntAlunos, btnAdiciona, btnPesquisa);

        btnAdiciona.setOnAction( e -> {
            CursoEntity c = this.boundarytoEntity();
            lista.add(c);
            System.out.println(lista);
        });

        btnPesquisa.setOnAction( e -> {
            boolean encontrado = false;
            for(CursoEntity c : lista) {
                if (c.getNome().contains(txfNome.getText())) {
                    this.entitytoBoundary(c);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                Alert a = new Alert(Alert.AlertType.INFORMATION,
                        "Curso não encontrado");
                a.showAndWait();
            }
        });


        stage.setTitle("Gestão de cursos");
        stage.setScene(scene);
        stage.show();

    }
        public CursoEntity boundarytoEntity() {
            CursoEntity c = new CursoEntity();
            try {
                c.setId(Long.parseLong(txfId.getText()));
                c.setNome(txfNome.getText());
                c.setCodCurso(Long.parseLong(txfCodCurso.getText()));
                c.setNomeCoord(txfNomeCoord.getText());
                c.setQntAlunos(Integer.parseInt(txfQntAlunos.getText()));
            } catch (Exception e) {
                System.out.println("Erro : " + e.getMessage());
            }
            return c;
        }

        public void entitytoBoundary(CursoEntity c){
        if(c != null){
            txfId.setText(String.valueOf(c.getId()));
            txfNome.setText(String.valueOf(c.getNome()));
            txfCodCurso.setText(String.valueOf(c.getCodCurso()));
            txfNomeCoord.setText(String.valueOf(c.getNomeCoord()));
            txfQntAlunos.setText(String.valueOf(c.getQntAlunos()));
        }
        }

    public static void main(String[] args) {
        launch();
    }
}

