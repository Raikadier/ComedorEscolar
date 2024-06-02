
package Logica;

import Entidades.Estudiante;
import java.time.LocalDate;
import java.time.Period;

public class Entrega {
    
    private Estudiante estudiante;
    private LocalDate fechaEntrega;
    private int noAlmuerzosDisponibles = 3;
    private PeriodoEntrega periodo;
    private RegistroPeriodoEntregaImpList entregas;

    public Entrega() {
    }

    public Entrega(Estudiante estudiante, RegistroPeriodoEntregaImpList entregas ) {
        this.estudiante = estudiante;
        this.entregas = entregas;
        this.fechaEntrega = fechaEntrega;
        this.noAlmuerzosDisponibles = 3;
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
    
    
    public void retirarAlmuerzo(Estudiante e){
        boolean confirmarRetiro = periodo.confirmarRetiro(e);
        if (confirmarRetiro){
            this.noAlmuerzosDisponibles -= 1;
            this.fechaEntrega = LocalDate.now();
            entregas.registrarEntrega(this);
            
        }
        else{
            System.out.println("No tiene mas almuerzos disponibles");
        }

    }
    
    public void actualizarRegistroAlmuerzo(Estudiante e){
        Period semana = Period.between(periodo.getFechaFin(), periodo.getFechaInicio());
        if(semana.getDays() == 7){
            noAlmuerzosDisponibles = 3;
        }
        
    }
    
}
