package org.example.redvendedores.controlador;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.redvendedores.enumm.CategoriaProducto;
import org.example.redvendedores.enumm.EstadoProducto;
import org.example.redvendedores.estructuras.ListaSimple;
import org.example.redvendedores.modelo.Producto;
import org.example.redvendedores.modelo.RedVendedores;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductosViewControler implements Initializable {

    @FXML
    private TableView<Producto> tableViewProductos;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, CategoriaProducto> colCategoria;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, EstadoProducto> colEstado;

    @FXML
    private TableColumn<Producto, ImageView> colImagen;

    @FXML
    private Button btnCrearProductoNuevo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar las columnas del TableView
        colNombre.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("precio"));
        colEstado.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("estado"));

        colImagen.setCellValueFactory(cellData -> {
            ImageView imageView = new ImageView();
            imageView.setFitWidth(100); // Ancho fijo de la imagen
            imageView.setFitHeight(100); // Alto fijo de la imagen

            Producto producto = cellData.getValue();
            if (producto != null && producto.getImagen() != null && !producto.getImagen().isEmpty()) {
                InputStream inputStream = getClass().getResourceAsStream(producto.getImagen());
                if (inputStream != null) {
                    Image image = new Image(inputStream);
                    imageView.setImage(image);
                }
            }

            return new ReadOnlyObjectWrapper<>(imageView);
        });

        // Obtener la lista de productos desde RedVendedores y configurarla en el TableView
        tableViewProductos.setItems(obtenerListaObservableProductos());
    }

    private ObservableList<Producto> obtenerListaObservableProductos() {
        ObservableList<Producto> productosObservable = FXCollections.observableArrayList();

        // Obtener la lista simple de productos desde RedVendedores
        ListaSimple<Producto> listaProductos = RedVendedores.getInstance().getProductos();

        // Verificar si la lista de productos no está vacía antes de agregar elementos
        if (listaProductos != null) {
            // Agregar cada producto de la lista simple a la lista observable
            for (Producto producto : listaProductos) {
                productosObservable.add(producto);
            }
        }

        return productosObservable;
    }

    @FXML
    void irACrearProductos(ActionEvent event) {
        try {
            // Cargar el archivo FXML de la ventana de creación de productos
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/redvendedores/crearproductos-view.fxml"));
            Parent root = fxmlLoader.load();

            // Crear una nueva escena y configurarla en el escenario
            Stage stage = new Stage();
            stage.setTitle("Crear Productos");
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar la ventana actual de productos
            Stage currentStage = (Stage) btnCrearProductoNuevo.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar la tabla de productos después de agregar uno nuevo
    private void actualizarTablaProductos() {
        tableViewProductos.setItems(obtenerListaObservableProductos());
    }

}
