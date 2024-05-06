package org.example.redvendedores.modelo;

import java.time.LocalDateTime;

public class Comentario {
    private String contenido;
    private LocalDateTime fechaHora;
    private Vendedor autor;

    public Comentario(String contenido, LocalDateTime fechaHora, Vendedor autor) {
        this.contenido = contenido;
        this.fechaHora = fechaHora;
        this.autor = autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Vendedor getAutor() {
        return autor;
    }

    public void setAutor(Vendedor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "contenido='" + contenido + '\'' +
                ", fechaHora=" + fechaHora +
                ", autor=" + autor +
                '}';
    }
}
