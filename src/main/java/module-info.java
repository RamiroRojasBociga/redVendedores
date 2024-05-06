module org.example.redvendedores {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.redvendedores to javafx.fxml;
    opens org.example.redvendedores.controlador to javafx.fxml;

    exports org.example.redvendedores;
    exports org.example.redvendedores.controlador;
    exports org.example.redvendedores.modelo;
}