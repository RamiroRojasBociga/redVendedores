package org.example.redvendedores.modelo;

import org.example.redvendedores.enumm.CategoriaProducto;
import org.example.redvendedores.enumm.EstadoProducto;

public class Producto {
    private String nombre;
    private String imagen; // Ruta o nombre del archivo de la imagen
    private CategoriaProducto categoria;
    private double precio;
    private EstadoProducto estado;
    public Producto() {

    }

    public Producto(String nombre, String imagen, CategoriaProducto categoria, double precio, EstadoProducto estado) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return
                "\nnombre:" + nombre +
                "\nimagen:" + imagen +
                "\ncategoria:" + categoria +
                "\nprecio=" + precio +
                "\nestado=" + estado;
    }
}