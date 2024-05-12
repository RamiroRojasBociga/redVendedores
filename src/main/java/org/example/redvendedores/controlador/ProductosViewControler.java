package org.example.redvendedores.controlador;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.redvendedores.enumm.CategoriaProducto;
import org.example.redvendedores.enumm.EstadoProducto;
import org.example.redvendedores.estructuras.ListaSimple;
import org.example.redvendedores.modelo.Producto;
import org.example.redvendedores.modelo.RedVendedores;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar las columnas del TableView
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colImagen.setCellValueFactory(cellData -> {
            ImageView imageView = new ImageView();
            Producto producto = cellData.getValue();
            if (producto != null && producto.getImagen() != null && !producto.getImagen().isEmpty()) {
                InputStream inputStream = getClass().getResourceAsStream(producto.getImagen());
                if (inputStream != null) {
                    Image image = new Image(inputStream);
                    imageView.setImage(image);
                }
            }
            return new SimpleObjectProperty<>(imageView);
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
}
