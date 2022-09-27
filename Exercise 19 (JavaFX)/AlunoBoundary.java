package com.example.exercicio19;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.LightBase;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class AlunoBoundary extends Application {

    private AlunoControl control = new AlunoControl();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Pane paneprincipal = new Pane();
    GridPane gridpane = new GridPane();
    Label lblId = new Label("Id:");
    Label lblRa = new Label("Ra:");
    Label lblNome = new Label("Nome:");
    Label lblNascimento = new Label("Nascimento:");

    TextField txfId = new TextField();
    TextField txfRa = new TextField();
    TextField txfNome = new TextField();
    TextField txfNascimento = new TextField();

    Button btnAdiciona = new Button("Adicionar");
    Button btnPesquisa = new Button("Pesquisar");

    TableView<Aluno> tabelaAluno = new TableView<>();

    private void criaTabela(){
        TableColumn<Aluno, Integer> colunaId = new TableColumn("Id");
        colunaId.setCellValueFactory( new PropertyValueFactory<>("id"));
        TableColumn<Aluno, Long> colunaRa = new TableColumn("Ra");
        colunaRa.setCellValueFactory( new PropertyValueFactory<>("ra"));
        TableColumn<Aluno, String> colunaNome = new TableColumn("Nome");
        colunaNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        TableColumn<Aluno, String> colunaNascimento = new TableColumn("Nascimento");
        colunaNascimento.setCellValueFactory( (AlunoProp) -> {
            LocalDate n = AlunoProp.getValue().getNascimento();
            String strData = n.format(this.dtf);
            return new ReadOnlyStringWrapper(strData);
        });
        tabelaAluno.getColumns().addAll(colunaId,colunaRa,colunaNome,colunaNascimento);
        tabelaAluno.setItems(control.getListaView());
    }


    @Override
    public void start(Stage stage) throws IOException {
        gridpane.setHgap(10);
        gridpane.setVgap(5);
        gridpane.addRow(0,lblId,txfId);
        gridpane.addRow(1,lblRa,txfRa);
        gridpane.addRow(2,lblNome,txfNome);
        gridpane.addRow(3,lblNascimento,txfNascimento);
        gridpane.addRow(4,btnAdiciona,btnPesquisa);
        this.criaTabela();
        gridpane.add(tabelaAluno,0,5,2,2);
        btnAdiciona.setOnAction( e -> {
            LocalDate dtf = LocalDate.parse(txfNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            control.adiciona(Integer.parseInt(txfId.getText()),Long.parseLong(txfRa.getText()),txfNome.getText(),dtf);
        });
        btnPesquisa.setOnAction( e -> {
            control.pesquisa(txfNome.getText());
        });
        paneprincipal.getChildren().add(gridpane);
        Scene scene = new Scene(paneprincipal, 400, 400);
        stage.setTitle("Gestão de Alunos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}