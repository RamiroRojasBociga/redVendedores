package org.example.redvendedores.modelo;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String identificacion;
    protected String direccion;
    protected String nombreUsuario;
    protected String password;
    public Persona() {

    }

    public Persona(String nombre, String apellido, String identificacion, String direccion, String nombreUsuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "nombre:" + nombre +
                "\napellido:" + apellido +
                "\nidentificacion:" + identificacion +
                "\ndireccion:" + direccion +
                "\nnombreUsuario:" + nombreUsuario +
                "\npassword;" + password;
    }
}
