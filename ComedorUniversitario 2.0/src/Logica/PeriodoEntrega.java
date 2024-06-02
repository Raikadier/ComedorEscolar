
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
    private RegistroPeriodoEntregaImpList entregas;

    public PeriodoEntrega() { 
    }

    public PeriodoEntrega(RegistroPeriodoEntregaImpList entregas) {
        this.fechaInicio = LocalDate.now();
        this.fechaFin = fechaInicio.plusDays(7);
        this.estado = estado;
        this.entregas = entregas;
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



    @Override
    public String toString() {
        return "Periodo{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", entregas=" + entregas + '}';
    }
    
    public void actualizarPeriodo(){
        DayOfWeek diaSemanaActual = LocalDate.now().getDayOfWeek();
        if(diaSemanaActual == DayOfWeek.MONDAY || diaSemanaActual == DayOfWeek.THURSDAY){
            this.fechaInicio = LocalDate.now();
            this.fechaFin = fechaInicio.plusDays(7);
            System.out.println("Periodo Actualizado");
        }
        else{
            System.out.println("No se ha podido actualizar el periodo");
        }
    }
    
    public void registrarEntregas(Entrega entrega){
        entregas.registrarEntrega(entrega);
    }
    
    public boolean confirmarRetiro(Estudiante estudiante){
        int entregados = this.entregas.getEntregas().size();
        if(entregados <= 2){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    
}
