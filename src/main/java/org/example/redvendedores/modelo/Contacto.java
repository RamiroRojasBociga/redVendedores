package org.example.redvendedores.modelo;

public class Contacto {
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String numeroTelefono;

    public Contacto(String nombre, String apellido, String numeroDocumento, String numeroTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDocumento = numeroDocumento;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return "Contacto: " +
                "\nnombre: " + nombre +
                "\napellido: " + apellido +
                "\nnumeroDocumento: " + numeroDocumento +
                "\nnumeroTelefono: " + numeroTelefono;
    }
}
