package com.mycompany.Entidades;

public class Persona {

    protected String nombre;
    protected long telefono;
    protected long cedula;

    public Persona() {
    }

    public Persona(String nombre, long cedula, long tel) {
        this.telefono = tel;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + ", cedula: " + cedula + '}';
    }

}
