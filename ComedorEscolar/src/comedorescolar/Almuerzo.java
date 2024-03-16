package comedorescolar;

import java.time.LocalDate;

public class Almuerzo {

    private LocalDate fecha;
    private boolean estado;
    private Estudiante estudiante;

    public Almuerzo() {
    }

    public Almuerzo(LocalDate fecha, boolean estado, Estudiante estudiante) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean getEstado() {
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

    public void retirar(Almuerzo almuerzo) {
        // Cambia el estado del almuerzo a "retirado"

    }

}
