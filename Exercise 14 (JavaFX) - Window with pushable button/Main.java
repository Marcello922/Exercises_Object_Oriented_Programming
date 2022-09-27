package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        Scene scene = new Scene(p,200, 200);
        Label l = new Label("");
        l.relocate(10,10);
        Button btn = new Button("Ok");
        btn.relocate(50,100);
        p.getChildren().addAll(btn,l);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ação do botão");
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) { System.out.println("Hello World");
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
