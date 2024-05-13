package org.example.redvendedores.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.redvendedores.estructuras.ListaSimple;
import org.example.redvendedores.modelo.RedVendedores;
import org.example.redvendedores.modelo.Vendedor;

import java.io.IOException;

public class AdministrarRedViewControler {

    @FXML
    private TableView<Vendedor> tableViewVendedores;

    @FXML
    private TableColumn<Vendedor, String> colNombre;

    @FXML
    private TableColumn<Vendedor, String> colApellido;

    @FXML
    private TableColumn<Vendedor, String> colIdentificacion;

    @FXML
    private TableColumn<Vendedor, String> colDireccion;

    @FXML
    private TableColumn<Vendedor, String> colUsuario;

    @FXML
    private TableColumn<Vendedor, String> colContraseña;

    @FXML
    private Button btnAbrirCrearVendedor;

    @FXML
    private Button btnEliminarVendedor;

    @FXML
    private Button btnVerEstadisticas;

    @FXML
    void initialize() {
        // Configurar las columnas del TableView
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));

        // Aquí se debería obtener y establecer los datos en el TableView
        tableViewVendedores.setItems(obtenerListaObservableVendedores());
    }


    private ObservableList<Vendedor> obtenerListaObservableVendedores() {
        ObservableList<Vendedor> vendedoresObservable = FXCollections.observableArrayList();

        // Obtener la lista simple de vendedores desde RedVendedores
        ListaSimple<Vendedor> listaVendedores = RedVendedores.getInstance().getVendedores();

        // Verificar si la lista de vendedores no está vacía antes de agregar elementos
        if (listaVendedores != null) {
            // Agregar cada vendedor de la lista simple a la lista observable
            for (Vendedor vendedor : listaVendedores) {
                vendedoresObservable.add(vendedor);
            }
        }

        return vendedoresObservable;
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

    @FXML
    void eliminarVendedor() {
        // Aquí elimina el vendedor seleccionado en el TableView
    }

    @FXML
    void verEstadisticas() {
        // Aquí muestra las estadísticas relacionadas con la red de vendedores
    }
}
