/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comedoruniversitario;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTES
 */
public class PeriodoDeEntrega {
    
    private Estudiante[] estudiantes;
    private ArrayList<Estudiante> historialAlmuerzo;
    private LocalDate fechaRetiro;
    private int cantidadSemanalAlmuerzo;

    public PeriodoDeEntrega() {}

    public PeriodoDeEntrega(Estudiante[] estudiantes, ArrayList<Estudiante> historialAlmuerzo, LocalDate fechaRetiro, int cantidadSemanalAlmuerzo) {
        this.estudiantes = estudiantes;
        this.historialAlmuerzo = historialAlmuerzo;
        this.fechaRetiro = fechaRetiro;
        this.cantidadSemanalAlmuerzo = cantidadSemanalAlmuerzo;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Estudiante> getHistorialAlmuerzo() {
        return historialAlmuerzo;
    }

    public void setHistorialAlmuerzo(ArrayList<Estudiante> historialAlmuerzo) {
        this.historialAlmuerzo = historialAlmuerzo;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public int getCantidadSemanalAlmuerzo() {
        return cantidadSemanalAlmuerzo;
    }

    public void setCantidadSemanalAlmuerzo(int cantidadSemanalAlmuerzo) {
        this.cantidadSemanalAlmuerzo = cantidadSemanalAlmuerzo;
    }

    @Override
    public String toString() {
        return "PeriodoDeEntrega{" + "estudiantes=" + estudiantes + ", historialAlmuerzo=" + historialAlmuerzo + ", fechaRetiro=" + fechaRetiro + ", cantidadSemanalAlmuerzo=" + cantidadSemanalAlmuerzo + '}';
    }
}
