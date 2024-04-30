
package comedoruniversitario;

import java.time.LocalDate;

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
        noAlmuerzosDisponibles -= 1;
        fechaEntrega = LocalDate.now();
    }
    
    
    
}
