package br.com.calculadoraimc;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static String classificaoIMC(double imc) {
        if (imc < 17)
            return "Muito abaixo do peso";
        else if (imc < 18.5)
            return "Abaixo do peso";
        else if (imc < 25)
            return "Peso normal";
        else if (imc < 30)
            return "Acima do peso";
        else if (imc < 35)
            return "Obesidade I";
        else if (imc < 40)
            return "Obesidade II (severa)";

        return "Obesidade III (mórbida)";
    }

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // ── Painel esquerdo (calculadora) ──────────────────────────────────
        Label lbPeso = new Label("Peso: ");
        Label lbAltura = new Label("Altura: ");
        Label lbResultado = new Label();

        Button btCalcularIMC = new Button("Calcular IMC");

        TextField tfPeso = new TextField();
        TextField tfAltura = new TextField();

        tfPeso.setPromptText("Peso em KG");
        tfAltura.setPromptText("Altura em Metros");

        // ── Lista observável do histórico ──────────────────────────────────
        ObservableList<String> historico = FXCollections.observableArrayList();
        ListView<String> lvHistorico = new ListView<>(historico);
        lvHistorico.setPrefSize(220, 180);
        lvHistorico.setFocusTraversable(false);

        // ── Ação do botão ──────────────────────────────────────────────────
        btCalcularIMC.setOnAction(e -> {
            try {
                double peso = Double.parseDouble(tfPeso.getText());
                double altura = Double.parseDouble(tfAltura.getText());

                double imcDoPeso = peso / (altura * altura);
                String classificacao = classificaoIMC(imcDoPeso);

                lbResultado.setText(String.format("Seu IMC é: %.2f | %s", imcDoPeso, classificacao));

                // Insere no início para manter ordem decrescente (mais recente primeiro)
                String entrada = String.format("%.1f kg | %.2f m → %.2f (%s)", peso, altura, imcDoPeso, classificacao);
                historico.add(0, entrada);
            } catch (NumberFormatException ex) {
                lbResultado.setText("Erro: Insira números válidos para peso e altura");
            }
        });

        VBox vbPainel = new VBox(10, lbPeso, tfPeso, lbAltura, tfAltura, btCalcularIMC, lbResultado);
        vbPainel.setPadding(new Insets(10));
        vbPainel.setAlignment(Pos.CENTER);

        // ── Painel central (tabela IMC) ────────────────────────────────────
        Label lbTabelaTitulo = new Label("Tabela IMC");
        lbTabelaTitulo.setFont(Font.font("System", FontWeight.BOLD, 13));

        Label lbFaixa1 = new Label("< 17,0   → Muito abaixo do peso");
        Label lbFaixa2 = new Label("< 18,5   → Abaixo do peso");
        Label lbFaixa3 = new Label("< 25,0   → Peso normal");
        Label lbFaixa4 = new Label("< 30,0   → Acima do peso");
        Label lbFaixa5 = new Label("< 35,0   → Obesidade I");
        Label lbFaixa6 = new Label("< 40,0   → Obesidade II (severa)");
        Label lbFaixa7 = new Label("≥ 40,0   → Obesidade III (mórbida)");

        for (Label lb : new Label[] { lbFaixa1, lbFaixa2, lbFaixa3,
                lbFaixa4, lbFaixa5, lbFaixa6, lbFaixa7 }) {
            lb.setFont(Font.font("System", 11));
        }

        VBox vbTabela = new VBox(6,
                lbTabelaTitulo,
                lbFaixa1, lbFaixa2, lbFaixa3,
                lbFaixa4, lbFaixa5, lbFaixa6, lbFaixa7);
        vbTabela.setPadding(new Insets(10));
        vbTabela.setAlignment(Pos.TOP_LEFT);
        vbTabela.setStyle("-fx-border-color: #aaaaaa; -fx-border-radius: 5; -fx-background-color: #f5f5f5;");

        // ── Painel direito (histórico) ─────────────────────────────────────
        Label lbHistoricoTitulo = new Label("Histórico");
        lbHistoricoTitulo.setFont(Font.font("System", FontWeight.BOLD, 13));

        VBox vbHistorico = new VBox(6, lbHistoricoTitulo, lvHistorico);
        vbHistorico.setPadding(new Insets(10));
        vbHistorico.setAlignment(Pos.TOP_LEFT);
        vbHistorico.setStyle("-fx-border-color: #aaaaaa; -fx-border-radius: 5; -fx-background-color: #f5f5f5;");

        // ── Layout principal ───────────────────────────────────────────────
        HBox hbLayout = new HBox(15, vbPainel, vbTabela, vbHistorico);
        //hbLayout.setPadding(new Insets(10));
        hbLayout.setAlignment(Pos.CENTER);

        scene = new Scene(hbLayout, 990, 290);
        stage.setTitle("Calculadora IMC");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}