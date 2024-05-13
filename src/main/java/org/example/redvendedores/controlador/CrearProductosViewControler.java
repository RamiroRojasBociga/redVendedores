package org.example.redvendedores.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.redvendedores.enumm.CategoriaProducto;
import org.example.redvendedores.enumm.EstadoProducto;
import org.example.redvendedores.modelo.Producto;
import org.example.redvendedores.modelo.RedVendedores;

import java.io.IOException;

public class CrearProductosViewControler {

    @FXML
    private Button btnCrearProducto;

    @FXML
    private Button btnVolver;

    @FXML
    private ComboBox<CategoriaProducto> cbCategoria;

    @FXML
    private ComboBox<EstadoProducto> cbEstado;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize() {
        // Configurar los ComboBox con los valores de los enums
        cbCategoria.setItems(FXCollections.observableArrayList(CategoriaProducto.values()));
        cbEstado.setItems(FXCollections.observableArrayList(EstadoProducto.values()));
    }

    @FXML
    void crearProducto(ActionEvent event) {
        // Obtener los valores de los campos de texto y comboboxes
        String nombre = txtNombre.getText();
        String imagen = txtApellido.getText(); // Asumiendo que este campo es para la imagen
        double precio = Double.parseDouble(txtCedula.getText());
        CategoriaProducto categoria = cbCategoria.getValue();
        EstadoProducto estado = cbEstado.getValue();

        // Crear un nuevo producto
        Producto nuevoProducto = new Producto(nombre, imagen, categoria, precio, estado);

        // Agregar el nuevo producto a la lista de productos en RedVendedores
        RedVendedores.getInstance().getProductos().agregarFinal(nuevoProducto);
        System.out.println("Lista de productos:");
        RedVendedores.getInstance().getProductos().imprimirLista();

        // Limpiar los campos de texto y seleccionar el combobox
        limpiarCampos();

        // Actualizar la tabla de productos en la vista anterior
        actualizarTablaProductos();

        // Imprimir el nuevo producto creado
        System.out.println("Nuevo producto creado: " + nuevoProducto);
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtCedula.clear();
        cbCategoria.getSelectionModel().clearSelection();
        cbEstado.getSelectionModel().clearSelection();
    }

    private void actualizarTablaProductos() {
        // Implementa la lógica para actualizar la tabla de productos en la vista anterior
    }

    @FXML
    void volverAVendedor(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/redvendedores/vendedor-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar la ventana actual
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
