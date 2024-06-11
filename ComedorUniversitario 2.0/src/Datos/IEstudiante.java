
package Datos;

import Entidades.Estudiante;
import java.util.List;

public interface IEstudiante {
    
    public boolean agregarEstudiante(Estudiante e);
    public Estudiante buscarEstudiante(long cedula);
    public boolean borrarEstudiante(long cedula);
    public List<Estudiante> obtenerEstudiantes();
    
}
