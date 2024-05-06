package org.example.redvendedores.modelo;

import org.example.redvendedores.enumm.CategoriaProducto;
import org.example.redvendedores.enumm.EstadoProducto;

import java.time.LocalDateTime;
import java.util.List;

public class Publicacion {
    private Producto producto;
    private String nombre;
    private String imagen;
    private CategoriaProducto categoria;
    private double precio;
    private EstadoProducto estado;
    private String contenido;
    private LocalDateTime fechaHoraPublicacion;
    private List<Comentario> comentarios;
    private List<MeGusta> meGusta;

    public Publicacion(Producto producto, String nombre, String imagen, CategoriaProducto categoria, double precio, EstadoProducto estado, String contenido, LocalDateTime fechaHoraPublicacion) {
        this.producto = producto;
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.contenido = contenido;
        this.fechaHoraPublicacion = fechaHoraPublicacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaHoraPublicacion() {
        return fechaHoraPublicacion;
    }

    public void setFechaHoraPublicacion(LocalDateTime fechaHoraPublicacion) {
        this.fechaHoraPublicacion = fechaHoraPublicacion;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<MeGusta> getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(List<MeGusta> meGusta) {
        this.meGusta = meGusta;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "producto=" + producto +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                ", contenido='" + contenido + '\'' +
                ", fechaHoraPublicacion=" + fechaHoraPublicacion +
                ", comentarios=" + comentarios +
                ", meGusta=" + meGusta +
                '}';
    }
}
