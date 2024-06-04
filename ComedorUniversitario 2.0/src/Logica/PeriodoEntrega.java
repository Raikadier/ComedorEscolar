
package Logica;

import Entidades.Estudiante;
import Logica.Entrega;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class PeriodoEntrega {
    
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    private boolean estado;
    private Estudiante estudiante;
    private RegistroPeriodoEntregaImpList entregas;

    public PeriodoEntrega() { 
    }

    public PeriodoEntrega(RegistroPeriodoEntregaImpList entregas) {
        this.fechaInicio = LocalDate.now();
        this.fechaFin = fechaInicio.plusDays(6);
        this.estado = estado;
        this.entregas = entregas;
        this.estudiante = estudiante;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public RegistroPeriodoEntregaImpList getEntregas() {
        return entregas;
    }

    public void setEntregas(RegistroPeriodoEntregaImpList entregas) {
        this.entregas = entregas;
    }

    @Override
    public String toString() {
        return "Periodo{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", entregas=" + entregas + '}';
    }
    
    public void actualizarPeriodo(){
        DayOfWeek diaSemanaActual = LocalDate.now().getDayOfWeek();
        if(diaSemanaActual == DayOfWeek.MONDAY || diaSemanaActual == DayOfWeek.TUESDAY){
            this.fechaInicio = LocalDate.now();
            this.fechaFin = fechaInicio.plusDays(6);
            System.out.println("Periodo Actualizado");
            System.out.println("PERIODO -> Fecha inicio: "+ fechaInicio+", Fecha fin: "+fechaFin);
        }
        else{
            System.out.println("No se ha podido actualizar el periodo");
        }
    }
    
    
    public boolean confirmarRetiro(Estudiante e){
        System.out.println(e);
        int entregados = 0;

        for(Entrega entrega: entregas.getEntregas()){
            if(entrega.getEstudiante().equals(e)){
                if(entrega.getFechaEntrega().isAfter(fechaInicio) || entrega.getFechaEntrega().isBefore(fechaFin) 
                || entrega.getFechaEntrega().isEqual(fechaInicio) || entrega.getFechaEntrega().isEqual(fechaFin)){
                    entregados += 1;
                }
            }
        }
        
        return entregados < 3;
    }
    
    
    
}
