package org.example.redvendedores.modelo;

import javafx.scene.image.Image;
import org.example.redvendedores.enumm.CategoriaProducto;
import org.example.redvendedores.enumm.EstadoProducto;
import org.example.redvendedores.estructuras.ListaSimple;

public class RedVendedores {


    private static RedVendedores instance;
    private ListaSimple<Vendedor> vendedores;
    private ListaSimple<Administrador> administradores;
    private ListaSimple<Contacto> contactos; // Nueva lista para almacenar los contactos


    public RedVendedores() {
        this.vendedores = new ListaSimple<>();
        this.administradores = new ListaSimple<>();
        this.contactos = new ListaSimple<>(); // Agrega esta línea para inicializar la lista de contactos
        // Inicializar la lista de vendedores y administradores
        inicializarVendedores();
        inicializarAdministradores();
    }

    // Método estático para obtener la instancia única de RedVendedores
    public static RedVendedores getInstance() {
        if (instance == null) {
            instance = new RedVendedores();
        }
        return instance;
    }

    private void inicializarAdministradores() {

        Administrador administrador1 = new Administrador("Jose", "Rojas", "987654321", "Avenida Central", "jose", "123");

        this.administradores.agregarFinal(administrador1);
    }

    // Método privado para inicializar la lista de vendedores
    private void inicializarVendedores() {
        // Crear vendedores de ejemplo
        ListaSimple<Producto> productosVendedor1 = new ListaSimple<>();
        ListaSimple<Contacto> contactosVendedor1 = new ListaSimple<>();
        ListaSimple<Publicacion> muroVendedor1 = new ListaSimple<>();
        ListaSimple<Conversacion> chatVendedor1 = new ListaSimple<>();
        Vendedor vendedor1 = new Vendedor("Ramiro", "Rojas", "987654321", "Avenida Central", "ramiro", "12345", productosVendedor1, contactosVendedor1, muroVendedor1, chatVendedor1);

        ListaSimple<Producto> productosVendedor2 = new ListaSimple<>();
        ListaSimple<Contacto> contactosVendedor2 = new ListaSimple<>();
        ListaSimple<Publicacion> muroVendedor2 = new ListaSimple<>();
        ListaSimple<Conversacion> chatVendedor2 = new ListaSimple<>();
        Vendedor vendedor2 = new Vendedor("Pablo", "Castaño", "234567890", "Calle Secundaria", "pablo", "password", productosVendedor2, contactosVendedor2, muroVendedor2, chatVendedor2);

        // Crear productos de ejemplo
        Producto producto1 = new Producto("Producto 1", "imagen1.jpg", CategoriaProducto.DEPORTES, 100.0, EstadoProducto.PUBLICADO);
        //Producto producto2 = new Producto("Producto 2", "imagen2.jpg", CategoriaProducto.DEPORTES, 150.0, EstadoProducto.PUBLICADO);
        //Producto producto3 = new Producto("Producto 3", "imagen3.jpg", CategoriaProducto.HOGAR, 200.0, EstadoProducto.PUBLICADO);

        String rutaImagenMotocicleta = "/org/example/redvendedores/imagenes/MotocicletaAzul.jpg";
        Image imagenMotocicleta = new Image(getClass().getResourceAsStream(rutaImagenMotocicleta));
        Producto motocicletaAzul = new Producto("Motocicleta Azul", rutaImagenMotocicleta, CategoriaProducto.TECNOLOGIA, 1500.0, EstadoProducto.PUBLICADO);

        // Agregar productos al vendedor
        productosVendedor1.agregarFinal(producto1);
        //productosVendedor1.agregarFinal(producto2);
        //productosVendedor1.agregarFinal(producto3);
        productosVendedor1.agregarFinal(motocicletaAzul);

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
    public void agregarContacto(Contacto contacto) {
        this.contactos.agregarFinal(contacto);
    }


    public ListaSimple<Administrador> getAdministradores() {

        return administradores;
    }

    public ListaSimple<Contacto> getContactos() {
        return contactos;
    }

    public ListaSimple<Producto> getProductos() {
        ListaSimple<Producto> productos = new ListaSimple<>();

        // Recorrer la lista de vendedores y obtener sus productos
        for (Vendedor vendedor : vendedores) {
            ListaSimple<Producto> productosVendedor = vendedor.getProductos();
            // Verificar si la lista de productos del vendedor no está vacía antes de agregar elementos
            if (productosVendedor != null) {
                // Agregar cada producto del vendedor a la lista de productos de la red
                for (Producto producto : productosVendedor) {
                    productos.agregarFinal(producto);
                }
            }
        }

        return productos;
    }
}
