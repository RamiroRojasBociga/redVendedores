package org.example.redvendedores.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.redvendedores.estructuras.ListaSimple;
import org.example.redvendedores.modelo.Contacto;
import org.example.redvendedores.modelo.RedVendedores;
import org.example.redvendedores.modelo.Vendedor;

public class ContactosViewControler {

    @FXML
    private Button btnAgregarContacto;

    @FXML
    private ListView<Contacto> listViewContactos;

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
        // Obtener la lista de contactos desde RedVendedores
        ObservableList<Contacto> contactosObservable = obtenerListaObservableContactos();

        // Configurar la lista en la ListView
        listViewContactos.setItems(contactosObservable);
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

        // Actualizar la lista observable y la ListView
        ObservableList<Contacto> contactosObservable = obtenerListaObservableContactos();
        listViewContactos.setItems(contactosObservable);

        // Aquí puedes realizar acciones adicionales, como limpiar los campos de texto
        limpiarCampos();
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
