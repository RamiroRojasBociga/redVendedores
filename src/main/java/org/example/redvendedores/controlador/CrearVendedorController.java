package org.example.redvendedores.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.redvendedores.modelo.RedVendedores;
import org.example.redvendedores.modelo.Vendedor;

public class CrearVendedorController {

    @FXML
    private Button btnCrearVendedor;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUsuario;

    @FXML
    void crearVendedor(ActionEvent event) {
        // Obtener los datos del nuevo vendedor de los campos de texto
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String nombreUsuario = txtUsuario.getText();
        String password = txtContraseña.getText();

        // Crear una instancia de Vendedor con los datos obtenidos
        Vendedor nuevoVendedor = new Vendedor(nombre, apellido, identificacion, direccion, nombreUsuario, password, null, null, null, null);

        // Obtener la instancia única de RedVendedores y agregar el nuevo vendedor
        RedVendedores.getInstance().agregarVendedor(nuevoVendedor);
        // Imprimir la lista de vendedores por consola
        System.out.println("Lista de vendedores:");
        RedVendedores.getInstance().getVendedores().imprimirLista();

        // Aquí puedes realizar acciones adicionales, como limpiar los campos de texto
        limpiarCampos();
    }

    // Método para limpiar los campos de texto después de crear un nuevo vendedor
    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtCedula.clear();
        txtDireccion.clear();
        txtUsuario.clear();
        txtContraseña.clear();
    }
}
