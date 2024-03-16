package comedorescolar;

import java.util.List;

public class SistemaDeAutenticacion {

    private List<Estudiante> estudiantesRegistrados;

    public SistemaDeAutenticacion() {
    }

    public SistemaDeAutenticacion(List<Estudiante> estudiantesRegistrados) {
        this.estudiantesRegistrados = estudiantesRegistrados;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantesRegistrados.add(estudiante);
    }

    public boolean autenticarEstudiante(String nombre, long cedula) {
        // identifica si el estudiante hace parte del programa
        return true;
    }

}
