module br.edu.ifsp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires java.base;

    opens br.edu.ifsp.app to javafx.fxml;
    opens br.edu.ifsp.controller to javafx.fxml;

    exports br.edu.ifsp.app;

    exports br.edu.ifsp.classes;
}
