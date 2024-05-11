package org.example.redvendedores.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.example.redvendedores.estructuras.ListaSimple;
import org.example.redvendedores.modelo.RedVendedores;
import org.example.redvendedores.modelo.Vendedor;

import java.io.IOException;

public class AdministrarRedControler {
    @FXML
    private ListView<Vendedor> listViewVendedores;

    @FXML
    void initialize() {
        // Obtener la lista de vendedores desde RedVendedores
        ObservableList<Vendedor> vendedoresObservable = obtenerListaObservableVendedores();

        // Configurar la lista en la ListView
        listViewVendedores.setItems(vendedoresObservable);
    }

    private ObservableList<Vendedor> obtenerListaObservableVendedores() {
        ObservableList<Vendedor> vendedoresObservable = FXCollections.observableArrayList();

        // Obtener la lista simple de vendedores desde RedVendedores
        ListaSimple<Vendedor> listaVendedores = RedVendedores.getInstance().getVendedores();

        // Agregar cada vendedor de la lista simple a la lista observable
        for (Vendedor vendedor : listaVendedores) {
            vendedoresObservable.add(vendedor);
        }

        return vendedoresObservable;
    }

    @FXML
    private Button btnAbrirCrearVendedor;

    @FXML
    private Button btnEliminarVendedor;

    @FXML
    private Button btnVerEstadisticas;

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
            // Cerrar la ventana actual
            Stage loginStage = (Stage) btnAbrirCrearVendedor.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}