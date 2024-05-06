package org.example.redvendedores.modelo;

import java.time.LocalDateTime;

public class Mensaje {
    private String contenido;
    private LocalDateTime fechaHora;
    private Vendedor remitente;

    public Mensaje(String contenido, LocalDateTime fechaHora, Vendedor remitente) {
        this.contenido = contenido;
        this.fechaHora = fechaHora;
        this.remitente = remitente;
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

    public Vendedor getRemitente() {
        return remitente;
    }

    public void setRemitente(Vendedor remitente) {
        this.remitente = remitente;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "contenido='" + contenido + '\'' +
                ", fechaHora=" + fechaHora +
                ", remitente=" + remitente +
                '}';
    }
}
