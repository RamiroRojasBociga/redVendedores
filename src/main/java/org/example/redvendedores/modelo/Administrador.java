package org.example.redvendedores.modelo;

public class Administrador extends Persona {
    public Administrador(String nombre, String apellido, String identificacion, String direccion, String nombreUsuario, String password) {
        super(nombre, apellido, identificacion, direccion, nombreUsuario, password);
    }

    // Métodos específicos para administración
    public void gestionarRed() {
        // Lógica para gestionar la red social
    }

    public void verEstadisticas() {
        // Lógica para visualizar estadísticas de la red social
    }


}
