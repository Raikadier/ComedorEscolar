
package comedoruniversitario;

import java.time.LocalDate;
import java.util.List;

public class Periodo {
    
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean estado;
    private List<Entrega> entregas;

    public Periodo() {
    }

    public Periodo(LocalDate fechaInicio, LocalDate fechaFin, boolean estado, List<Entrega> entregas) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    @Override
    public String toString() {
        return "Periodo{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", entregas=" + entregas + '}';
    }
    
    
    
}
