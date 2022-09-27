package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane p = new Pane();
        Scene scene = new Scene(p,400, 200);
        Label id = new Label("Id: ");
        TextField txfId = new TextField();
        TextField txfNome = new TextField();
        TextField txfTelefone = new TextField();
        Label nome = new Label("Nome: ");
        Label telefone = new Label("Telefone: ");
        Button btnSalva = new Button("Salvar");
        Button btnPesquisa = new Button("Pesquisar");
        txfId.setPrefSize(300,10);
        txfNome.setPrefSize(300,10);
        txfTelefone.setPrefSize(300,10);
        id.relocate(0,0);
        txfId.relocate(50,0);
        nome.relocate(0,50);
        txfNome.relocate(50,50);
        telefone.relocate(0,100);
        txfTelefone.relocate(50,100);
        btnSalva.relocate(0,150);
        btnPesquisa.relocate(50,150);
        p.getChildren().addAll(id,txfId,txfNome,txfTelefone,nome,telefone,btnSalva,btnPesquisa);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lista de Contatos");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
