package org.example.redvendedores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.redvendedores.controlador.LoginViewControler;
import org.example.redvendedores.modelo.RedVendedores;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Inicializar la lista de vendedores
        RedVendedores redVendedores = new RedVendedores();

        // Cargar la vista del login
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);

        // Pasar la instancia de RedVendedores al controlador de la vista de login
        LoginViewControler controller = fxmlLoader.getController();
        controller.initData(redVendedores);

        // Configurar la escena y mostrar la ventana
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
