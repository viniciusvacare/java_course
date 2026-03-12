package br.com.cursojavafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneAula extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Label lbNome = new Label("Nome: ");
        Label lbEmail = new Label("E-mail: ");

        TextField tfNome = new TextField();
        TextField tfEmail = new TextField();

        Button btEnviar = new Button("Enviar");

        GridPane gpPainel = new GridPane();
        gpPainel.setHgap(8);
        gpPainel.setVgap(8);
        gpPainel.setPadding(new Insets(5));

        gpPainel.addRow(0, lbNome, tfNome);
        gpPainel.addRow(1, lbEmail, tfEmail);
        gpPainel.addRow(2, btEnviar);

        scene = new Scene(gpPainel, 400, 300);

        stage.setTitle("GridPane");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
