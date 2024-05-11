package org.example.redvendedores.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministrarRedControler {

    @FXML
    private Button btnAbrirCrearVendedor;

    @FXML
    private Button btnEliminarVendedor;

    @FXML
    private Button btnVerEstadisticas;

    @FXML
    private ListView<?> listViewVendedores;

    @FXML
    void abrirVentanaCrearVendedor(ActionEvent event) {
        abrirCrearVendedor();


    }


    @FXML
    void eliminarVendedor(ActionEvent event) {

    }

    @FXML
    void verEstadisticas(ActionEvent event) {

    }
    @FXML
    void abrirCrearVendedor() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/redvendedores/crearVendedor-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            // Cerrar la ventana de login
            Stage loginStage = (Stage) btnAbrirCrearVendedor.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
