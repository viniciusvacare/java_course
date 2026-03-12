module br.com.relogiodigital {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.relogiodigital to javafx.fxml;
    exports br.com.relogiodigital;
}
