package org.example.redvendedores.modelo;

import java.util.List;

public class Conversacion {
    private List<Mensaje> mensajes;

    public Conversacion(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public String toString() {
        return "Conversacion{" +
                "mensajes=" + mensajes +
                '}';
    }
}
