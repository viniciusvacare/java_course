module br.com.calculadoraimc {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.calculadoraimc to javafx.fxml;
    exports br.com.calculadoraimc;
}
