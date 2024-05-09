package org.example.redvendedores.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.redvendedores.modelo.Administrador;
import org.example.redvendedores.modelo.RedVendedores;
import org.example.redvendedores.modelo.Vendedor;

import javax.swing.*;
import java.io.IOException;

public class LoginViewControler {
    private RedVendedores redVendedores;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblUsuario1;

    @FXML
    private TextField txtUsuario; // Campo de texto para el usuario

    @FXML
    private PasswordField psdPassword; // Campo de contraseña

    @FXML
    void cancelar(ActionEvent event) {
        // Obtener la ventana actual y cerrarla
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void iniciarSesion(ActionEvent event) {
        String usuario = txtUsuario.getText(); // Obtener el texto del campo de usuario
        String password = psdPassword.getText(); // Obtener el texto del campo de contraseña

        if (esAdministrador(usuario, password)) {
            // Las credenciales corresponden a un administrador, puedes abrir la ventana del administrador
            // Lógica para abrir la ventana del administrador...
            JOptionPane.showMessageDialog(null, "Inicio  correcto para Administrador", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } else if (esVendedor(usuario, password)) {
            // Las credenciales corresponden a un vendedor, puedes abrir la ventana del vendedor
            JOptionPane.showMessageDialog(null, "Inicio  correcto para Vendedor", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Lógica para abrir la ventana del vendedor..
            abrirVentanaVendedor();

        } else {
            // Las credenciales son inválidas, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean esAdministrador(String usuario, String password) {
        for (Administrador admin : redVendedores.getAdministradores()) {
            if (admin.getNombreUsuario().equals(usuario) && admin.getPassword().equals(password)) {
                return true; // Las credenciales coinciden con un administrador en la lista
            }
        }
        return false; // No se encontraron credenciales coincidentes de administrador
    }

    private boolean esVendedor(String usuario, String password) {
        for (Vendedor vendedor : redVendedores.getVendedores()) {
            if (vendedor.getNombreUsuario().equals(usuario) && vendedor.getPassword().equals(password)) {
                return true; // Las credenciales coinciden con un vendedor en la lista
            }
        }
        return false; // No se encontraron credenciales coincidentes de vendedor
    }


    private boolean credencialesValidas(String usuario, String password) {
        for (Vendedor vendedor : redVendedores.getVendedores()) {
            if (vendedor.getNombreUsuario().equals(usuario) && vendedor.getPassword().equals(password)) {
                return true; // Las credenciales coinciden con un vendedor en la lista
            }
        }
        return false; // No se encontraron credenciales coincidentes
    }
    private void abrirVentanaVendedor() {
        try {
            // Cargar el archivo FXML de la ventana del vendedor
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/redvendedores/vendedor-view.fxml"));
            Parent root = fxmlLoader.load();

            // Crear una nueva escena y configurarla en el escenario
            Stage stage = new Stage();
            stage.setTitle("Ventana Vendedor");
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar la ventana de login
            Stage loginStage = (Stage) btnLogin.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initData(RedVendedores redVendedores) {
        this.redVendedores = redVendedores;
    }
}
