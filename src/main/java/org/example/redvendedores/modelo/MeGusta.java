package org.example.redvendedores.modelo;

import java.time.LocalDateTime;

public class MeGusta {
    private LocalDateTime fechaHora;
    private Vendedor autor;

    public MeGusta(LocalDateTime fechaHora, Vendedor autor) {
        this.fechaHora = fechaHora;
        this.autor = autor;
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
        return "MeGusta{" +
                "fechaHora=" + fechaHora +
                ", autor=" + autor +
                '}';
    }
}
