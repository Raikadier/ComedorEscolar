
package com.mycompany.Datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class Estudiante extends Persona {
    
    protected ArrayList <Estudiante> listaEstudiante;
    protected String carrera;
    private String correo;
    protected int semestre;

    public Estudiante() {
    }

    public Estudiante(String carrera, String correo, int semestre, String nombre, long cedula, long tel) {
        super(nombre, cedula, tel);
        this.listaEstudiante = listaEstudiante;
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

    

    public ArrayList<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(ArrayList<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
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
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;  
        Estudiante that = (Estudiante) o;
        return semestre == that.semestre &&
               Objects.equals(carrera, that.carrera) &&
               Objects.equals(correo, that.correo) &&
               Objects.equals(listaEstudiante, that.listaEstudiante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carrera, correo, semestre, listaEstudiante);
    }


    @Override
    public String toString() {
        return "Estudiante -> "+super.toString() +  ", carrera: " + carrera + ", semestre: " + semestre + '}';
    }
    
    
    
    
}
