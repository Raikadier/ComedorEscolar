package com.mycompany.Logica;

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
        return "RegistroEntregaImpList{" + "entregas=" + (entregas != null ? "List of Entregas" : "null") + '}';
    }

    @Override
    public boolean registrarEntrega(Entrega entrega) {
        return entregas.add(entrega);
    }

    @Override
    public void mostrarLista() {
        for (Entrega entrega : this.entregas) {
            System.out.println(entrega);
        }
    }

}
