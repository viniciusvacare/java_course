module br.com.cursojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.cursojavafx to javafx.fxml;
    exports br.com.cursojavafx;
}
