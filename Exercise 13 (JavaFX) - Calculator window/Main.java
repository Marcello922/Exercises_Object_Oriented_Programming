package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage Stage) throws Exception{
        TilePane tilePane = new TilePane();
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(100,200);
        borderPane.setCenter(tilePane);
        Pane pan = new Pane(borderPane);
        Scene sc = new Scene(pan,100,200);

        TextField entrada = new TextField();
        entrada.setPrefSize(100,10);
        Button bce = new Button("CE");

        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button bma = new Button("+");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button bme = new Button("-");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button bmult = new Button("*");
        Button bvirg = new Button(",");
        Button b0 = new Button("0");
        Button big = new Button("=");
        Button bdiv = new Button("/");
        tilePane.setPrefSize(100,400);
        tilePane.getChildren().addAll(b1,b2,b3,bma,b4,b5,b6,bme,b7,b8,b9,bmult,bvirg,b0,big,bdiv);
        TilePane tilePane1 = new TilePane();
        tilePane1.getChildren().addAll(entrada,bce);
        borderPane.setTop(tilePane1);
        Stage.setScene(sc);
       Stage.setTitle("Calculadora");
       Stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
