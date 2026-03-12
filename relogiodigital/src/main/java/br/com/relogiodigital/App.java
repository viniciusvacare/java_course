package br.com.relogiodigital;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * JavaFX App
 */
public class App extends Application {

    final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Label lbRelogio = new Label(LocalTime.now().format(FORMATADOR));
        lbRelogio.setFont(Font.font("Consolas", FontWeight.BOLD, 200));
        lbRelogio.setStyle("-fx-text-fill: #00ff41;-fx-effect: dropshadow(gaussian, #00ff41, 10, 0.6, 0, 0)dropshadow(gaussian, #00ff41, 10, 1.0, 0, 0);");

        // Atualiza o label a cada segundo
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> lbRelogio.setText(LocalTime.now().format(FORMATADOR))));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        StackPane root = new StackPane(lbRelogio);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: black;");

        // Redimensiona a fonte conforme a largura da janela muda
        root.widthProperty().addListener((obs, oldVal, newVal) -> lbRelogio
                .setFont(Font.font("Monospace", FontWeight.BOLD, newVal.doubleValue() / 5.5)));

        scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setFullScreen(true); // inicia em tela cheia
        stage.setFullScreenExitHint(""); // remove a mensagem "pressione ESC para sair"
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}