package org.example.redvendedores.modelo;

import org.example.redvendedores.estructuras.ListaSimple;

import java.util.List;

public class Vendedor extends Persona {
    private ListaSimple<Producto> productos;
    private ListaSimple<Contacto> contactos;
    private ListaSimple<Publicacion> muro;
    private ListaSimple<Conversacion> chat;

    public Vendedor() {

    }


    public Vendedor(String nombre, String apellido, String identificacion, String direccion, String nombreUsuario, String password, ListaSimple<Producto> productos, ListaSimple<Contacto> contactos, ListaSimple<Publicacion> muro, ListaSimple<Conversacion> chat) {
        super(nombre, apellido, identificacion, direccion, nombreUsuario, password);
        this.productos = productos;
        this.contactos = contactos;
        this.muro = muro;
        this.chat = chat;
    }

    public ListaSimple<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ListaSimple<Producto> productos) {
        this.productos = productos;
    }

    public ListaSimple<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ListaSimple<Contacto> contactos) {
        this.contactos = contactos;
    }

    public ListaSimple<Publicacion> getMuro() {
        return muro;
    }

    public void setMuro(ListaSimple<Publicacion> muro) {
        this.muro = muro;
    }

    public ListaSimple<Conversacion> getChat() {
        return chat;
    }

    public void setChat(ListaSimple<Conversacion> chat) {
        this.chat = chat;
    }
}
