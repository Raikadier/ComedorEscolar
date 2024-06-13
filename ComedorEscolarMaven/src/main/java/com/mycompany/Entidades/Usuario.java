
package com.mycompany.Entidades;


public class Usuario extends Persona{
    
    protected String nombreUsuario;
    protected String contraseña;
    private String rol;

    public Usuario() {
        this.nombreUsuario = "Juan";
    }

    public Usuario(String nombreUsuario, String contraseña, String rol, String nombre, long cedula, long tel) {
        super(nombre, cedula, tel);
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario -> " + "nombreUsuario: " + nombreUsuario + ", contrase\u00f1a: " + contraseña + "rol: "+rol ;
    }
    
    public String dataFile(){
        return this.rol+";"+this.nombreUsuario+";"+ this.contraseña+";"+this.nombre+";"+this.cedula+";"+this.telefono;
    }
    
    

    
    
    
}
