package com.mycompany.comedorescolarmaven.entidades;

public class Estudiante extends Persona {

    protected String carrera;
    private String correo;
    protected int semestre;
    private int cantidadAlmuerzos;

    public Estudiante() {
    }

    public Estudiante(String nombre, long cedula, String correo, String carrera, int semestre, long tel,int cantidadAlmuerzos) {
        super(nombre, cedula, tel);
        this.carrera = carrera;
        this.correo = correo;
        this.semestre = semestre;
        this.cantidadAlmuerzos = 3;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
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

    public int getCantidadAlmuerzos() {
        return cantidadAlmuerzos;
    }

    public void setCantidadAlmuerzos(int cantidadAlmuerzos) {
        this.cantidadAlmuerzos = cantidadAlmuerzos;
    }
    
    

    @Override
    public String toString() {
        return "Estudiante -> " + super.toString() + ", carrera: " + carrera + ", semestre: " + semestre + '}';
    }

    public String dataFile() {
        return this.nombre + ";" + this.cedula + ";" + this.correo + ";" + this.carrera + ";" + this.semestre + ";" + this.telefono+";"+this.cantidadAlmuerzos;
    }

}
