package com.mycompany.Logica;

import com.mycompany.Entidades.Estudiante;
import java.time.LocalDate;
import java.time.Period;

public class Entrega {

    private Estudiante estudiante;
    private LocalDate fechaEntrega;
    private int noAlmuerzosDisponibles;
    private PeriodoEntrega periodo;
    private ARegistroEntrega entregas;

    public Entrega() {
    }

    public Entrega(Estudiante estudiante, ARegistroEntrega entregas, PeriodoEntrega periodo, LocalDate fechaEntrega, int noAlmuerzosDisponibles) {
        this.estudiante = estudiante;
        this.entregas = entregas;
        this.fechaEntrega = fechaEntrega;
        this.noAlmuerzosDisponibles = noAlmuerzosDisponibles;
        this.periodo = periodo;
    }

    public PeriodoEntrega getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoEntrega periodo) {
        this.periodo = periodo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getNoAlmuerzosDisponibles() {
        return noAlmuerzosDisponibles;
    }

    public void setNoAlmuerzosDisponibles(int noAlmuerzosDisponibles) {
        this.noAlmuerzosDisponibles = noAlmuerzosDisponibles;
    }

    public ARegistroEntrega getEntregas() {
        return entregas;
    }

    public void setEntregas(ARegistroEntrega entregas) {
        this.entregas = entregas;
    }

    @Override
    public String toString() {
        return "Entrega{" + "estudiante= " + (estudiante != null ? estudiante.getNombre() + estudiante.getCedula() : "null") + ", fechaEntrega=" + fechaEntrega
                + ", noAlmuerzosDisponibles=" + noAlmuerzosDisponibles + ", periodo=" + (periodo != null ? "PeriodoEntrega" : "null");
    }

    public String dataFile() {
        return this.estudiante.dataFile() + ";" + this.fechaEntrega + ";" + this.noAlmuerzosDisponibles + ";" + this.periodo;
    }

    public void retirarAlmuerzo(Estudiante e) {
        this.fechaEntrega = LocalDate.now();
        boolean confirmarRetiro = periodo.confirmarRetiro(e);
        if (confirmarRetiro) {
            this.noAlmuerzosDisponibles -= 1;
            entregas.registrarEntrega(this);

        } else {
            System.out.println("No tiene mas almuerzos disponibles");
        }

    }

    public void actualizarRegistroAlmuerzo(Estudiante e) {
        Period semana = Period.between(periodo.getFechaFin(), periodo.getFechaInicio());
        if (semana.getDays() == 6) {
            noAlmuerzosDisponibles = 3;
        }

    }

}
