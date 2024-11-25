module br.edu.ifsp {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.ifsp.app to javafx.fxml;
    opens br.edu.ifsp.controller to javafx.fxml;

    exports br.edu.ifsp.app;
}
