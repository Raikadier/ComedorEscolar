
package Logica;

import java.util.ArrayList;
import java.util.List;

public class RegistroEntregaImpList implements RegistroEntrega {
    
    private List<Entrega> entregas;

    public RegistroEntregaImpList() {
        this.entregas = new ArrayList<>();
    }

    public RegistroEntregaImpList(List<Entrega> entregas) {
        this.entregas = new ArrayList<>();
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    @Override
    public String toString() {
        return "RegistroPeriodoEntregaImpList{" + "entregas=" + entregas + '}';
    }
    

    @Override
    public void registrarEntrega(Entrega entrega) {
        entregas.add(entrega);
    }

    @Override
    public boolean registrarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
