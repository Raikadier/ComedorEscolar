
package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;


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

    @Override
    public String toString() {
        return "Estudiante -> "+super.toString() +  ", carrera: " + carrera + ", semestre: " + semestre + '}';
    }
    
    
    
    
}
