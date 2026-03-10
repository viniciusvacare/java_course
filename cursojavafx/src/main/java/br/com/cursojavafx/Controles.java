package br.com.cursojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Controles extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Alguns controles
        Label label = new Label("Teste de label: ");
        Button button = new Button("Enviar");
        TextField textField = new TextField();
        VBox box = new VBox(label, textField, button);

        scene = new Scene(box, 300, 200);

        stage.setTitle("Controles");
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}