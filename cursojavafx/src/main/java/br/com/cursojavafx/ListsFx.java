package br.com.cursojavafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListsFx extends Application {
 private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        ObservableList<String> itens = FXCollections.observableArrayList();
        
        for(int i = 0; i < 60; i++) {
            itens.add("item " + i);
        }

        ListView<String> lvItens = new ListView<>(itens);

        VBox vbPainel = new VBox(lvItens);

        scene = new Scene(vbPainel, 400, 400);
       

        stage.setTitle("GridPane");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
