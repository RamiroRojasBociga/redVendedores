package org.example.redvendedores.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.redvendedores.estructuras.ListaSimple;
import org.example.redvendedores.modelo.Contacto;
import org.example.redvendedores.modelo.RedVendedores;
import org.example.redvendedores.modelo.Vendedor;

import javax.swing.*;

public class ContactosViewControler {

    @FXML
    private Button btnAgregarContacto;

    @FXML
    private TableView<Contacto> tableViewContactos;

    @FXML
    private TableColumn<Contacto, String> colNombre;

    @FXML
    private TableColumn<Contacto, String> colApellido;

    @FXML
    private TableColumn<Contacto, String> colIdentificacion;

    @FXML
    private TableColumn<Contacto, String> colTelefono;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtTelefono;


    @FXML
    void initialize() {
        // Configurar las columnas del TableView
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento")); // Cambiado de "identificacion"
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("numeroTelefono")); // Cambiado de "telefono"

        // Obtener la lista de contactos desde RedVendedores y configurarla en el TableView
        tableViewContactos.setItems(obtenerListaObservableContactos());
    }

    private ObservableList<Contacto> obtenerListaObservableContactos() {
        ObservableList<Contacto> contactosObservable = FXCollections.observableArrayList();

        // Obtener la lista simple de contactos desde RedVendedores
        ListaSimple<Contacto> listaContactos = RedVendedores.getInstance().getContactos();

        // Verificar si la lista de contactos no está vacía antes de agregar elementos
        if (listaContactos != null) {
            // Agregar cada contacto de la lista simple a la lista observable
            for (Contacto contacto : listaContactos) {
                contactosObservable.add(contacto);
            }
        }

        return contactosObservable;
    }

    @FXML
    void agregarContacto(ActionEvent event) {
        // Verificar si la cantidad de contactos es menor que 10
        if (RedVendedores.getInstance().getContactos().getTamanio() < 10) {
            // Obtener los datos del nuevo contacto de los campos de texto
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String identificacion = txtIdentificacion.getText();
            String telefono = txtTelefono.getText();

            // Crear una instancia de Contacto con los datos obtenidos
            Contacto nuevoContacto = new Contacto(nombre, apellido, identificacion, telefono);

            // Obtener la instancia única de RedVendedores y agregar el nuevo contacto
            RedVendedores.getInstance().agregarContacto(nuevoContacto);
            System.out.println("Lista de contactos:");
            RedVendedores.getInstance().getContactos().imprimirLista();

            // Actualizar la lista observable con los nuevos datos
            tableViewContactos.setItems(obtenerListaObservableContactos());

            // Limpiar los campos de texto
            limpiarCampos();
        } else {
            // Mostrar un cuadro de diálogo con el mensaje indicando que se ha alcanzado el límite de contactos
            JOptionPane.showMessageDialog(null, "No se pueden agregar más de 10 contactos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    void limpiarCampos() {
        // Limpiar los campos de entrada
        txtNombre.setText("");
        txtApellido.setText("");
        txtIdentificacion.setText("");
        txtTelefono.setText("");
    }
}