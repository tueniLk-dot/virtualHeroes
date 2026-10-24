module com.example.virtualheroes {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.virtualheroes to javafx.fxml;
    opens com.example.virtualheroes.control to javafx.fxml;
    opens com.example.virtualheroes.dto to com.google.gson, javafx.base;

    exports com.example.virtualheroes;
}