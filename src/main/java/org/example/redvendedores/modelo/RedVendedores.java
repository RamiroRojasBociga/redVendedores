package org.example.redvendedores.modelo;

import org.example.redvendedores.enumm.CategoriaProducto;
import org.example.redvendedores.enumm.EstadoProducto;
import org.example.redvendedores.estructuras.ListaSimple;

public class RedVendedores {

    private ListaSimple<Vendedor> vendedores;
    private ListaSimple<Administrador> administradores;

    public RedVendedores() {
        this.vendedores = new ListaSimple<>();
        this.administradores = new ListaSimple<>();
        // Inicializar la lista de vendedores y administradores
        inicializarVendedores();
        inicializarAdministradores();
    }

    private void inicializarAdministradores() {

        Administrador administrador1 = new Administrador("Jose", "Rojas", "987654321", "Avenida Central", "jose", "123");

        this.administradores.agregarFinal(administrador1);
    }

    // Método privado para inicializar la lista de vendedores
    private void inicializarVendedores() {
        // Crear vendedores de ejemplo
        ListaSimple<Producto> productosVendedor1 = new ListaSimple<>();
        ListaSimple<Vendedor> contactosVendedor1 = new ListaSimple<>();
        ListaSimple<Publicacion> muroVendedor1 = new ListaSimple<>();
        ListaSimple<Conversacion> chatVendedor1 = new ListaSimple<>();
        Vendedor vendedor1 = new Vendedor("Ramiro", "Rojas", "987654321", "Avenida Central", "ramiro", "12345", productosVendedor1, contactosVendedor1, muroVendedor1, chatVendedor1);

        ListaSimple<Producto> productosVendedor2 = new ListaSimple<>();
        ListaSimple<Vendedor> contactosVendedor2 = new ListaSimple<>();
        ListaSimple<Publicacion> muroVendedor2 = new ListaSimple<>();
        ListaSimple<Conversacion> chatVendedor2 = new ListaSimple<>();
        Vendedor vendedor2 = new Vendedor("Pablo", "Castaño", "234567890", "Calle Secundaria", "pablo", "password", productosVendedor2, contactosVendedor2, muroVendedor2, chatVendedor2);

        // Crear productos de ejemplo
        Producto producto1 = new Producto("Producto 1", "imagen1.jpg", CategoriaProducto.DEPORTES, 100.0, EstadoProducto.PUBLICADO);
        Producto producto2 = new Producto("Producto 2", "imagen2.jpg", CategoriaProducto.DEPORTES, 150.0, EstadoProducto.PUBLICADO);
        Producto producto3 = new Producto("Producto 3", "imagen3.jpg", CategoriaProducto.HOGAR, 200.0, EstadoProducto.PUBLICADO);

        // Agregar productos al vendedor
        productosVendedor1.agregarFinal(producto1);
        productosVendedor1.agregarFinal(producto2);
        productosVendedor1.agregarFinal(producto3);

        // Agregar vendedores a la lista
        this.vendedores.agregarFinal(vendedor1);
        this.vendedores.agregarFinal(vendedor2);
    }

    public ListaSimple<Vendedor> getVendedores() {
        return vendedores;
    }

    // Método para agregar un vendedor a la lista
    public void agregarVendedor(Vendedor vendedor) {
        this.vendedores.agregarFinal(vendedor);
    }

    public ListaSimple<Administrador> getAdministradores() {
        return administradores;
    }
}
