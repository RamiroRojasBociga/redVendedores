package org.example.redvendedores.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.redvendedores.modelo.RedVendedores;

public class VendedorViewControler {

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblId;

    @FXML
    private Label lblNombre;

    @FXML
    private TextField txfApellido;

    @FXML
    private TextField txfIdentificacion;

    @FXML
    private TextField txfNombre;

    @FXML
    private Label txfTitulo;


    public void initData(RedVendedores redVendedores) {
    }
}

