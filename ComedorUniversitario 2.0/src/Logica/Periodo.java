
package Logica;

import Logica.Entrega;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Periodo {
    
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
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
    
    public void registrarEntregas(Entrega entrega){
        entregas.add(entrega);  
    }
    
    public boolean registrarEstado(){
        int entregados = this.entregas.size();
        if(entregados <= 2){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    
}
