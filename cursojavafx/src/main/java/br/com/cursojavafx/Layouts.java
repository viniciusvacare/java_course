package br.com.cursojavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Layouts extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Button btn1 = new Button("Botao 1");
        Button btn2 = new Button("Botao 2");
        VBox vBox = new VBox(btn1, btn2);
        vBox.setAlignment(Pos.CENTER);

        Button btn3 = new Button("Botão 3");
        Button btn4 = new Button("Botão 4");
        HBox hBox = new HBox(btn3, btn4);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBox);
        borderPane.setCenter(hBox);

        scene = new Scene(borderPane, 400, 300);

        stage.setTitle("Layouts");
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}