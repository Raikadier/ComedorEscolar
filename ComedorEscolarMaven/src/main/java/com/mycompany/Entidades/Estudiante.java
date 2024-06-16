
package com.mycompany.Entidades;

import java.time.LocalDate;
import java.util.ArrayList;


public class Estudiante extends Persona {
    
    protected String carrera;
    private String correo;
    protected int semestre;

    public Estudiante() {
    }

    public Estudiante(String nombre, long cedula, String correo, String carrera, int semestre,  long tel) {
        super(nombre, cedula, tel);
        this.carrera = carrera;
        this.correo = correo;
        this.semestre = semestre;
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

    @Override
    public String toString() {
        return "Estudiante -> "+super.toString() +  ", carrera: " + carrera + ", semestre: " + semestre + '}';
    }
    
    
    public String dataFile(){
        return this.nombre +";"+ this.cedula+";"+this.correo+";"+this.carrera+";"+this.semestre+";"+this.telefono;
    }
    
}
