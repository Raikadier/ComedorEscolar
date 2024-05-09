
package Logica;

import Entidades.Estudiante;
import java.time.LocalDate;
import java.time.Period;

public class Entrega {
    
    private Estudiante estudiante;
    private LocalDate fechaEntrega;
    private int noAlmuerzosDisponibles;
    private Periodo periodo;

    public Entrega() {
    }

    public Entrega(Estudiante estudiante, LocalDate fechaEntrega, int noAlmuerzosDisponibles) {
        this.estudiante = estudiante;
        this.fechaEntrega = fechaEntrega;
        this.noAlmuerzosDisponibles = noAlmuerzosDisponibles;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
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
        boolean confirmarRetiro = periodo.registrarEstado();
        if (confirmarRetiro){
            this.noAlmuerzosDisponibles -= 1;
            periodo.registrarEntregas(this);
            this.fechaEntrega = LocalDate.now();
        }
        else{
            System.out.println("No tiene mas almuerzos disponibles");
        }
        //ESTE METODO HAY QUE ANALIZARLO BIEN... NO ESTOY SEGURA 
    }
    
    public void actualizarRegistroAlmuerzo(Estudiante e){
        Period semana = Period.between(periodo.getFechaFin(), periodo.getFechaInicio());
        if(semana.getDays() == 7){
            noAlmuerzosDisponibles = 3;
        }
        //ESTE METODO HAY QUE ANALIZARLO BIEN... NO ESTOY SEGURA 
        
    }
    
}
