
package Logica;

import Datos.AEstudiante;
import Datos.IEstudiante;
import Entidades.Estudiante;
import java.util.List;

public class GestionEstudiante implements IEstudiante{
    
    private IEstudiante archivo;
    
    public GestionEstudiante(){
        this.archivo = new AEstudiante();
    }

    @Override
    public boolean agregarEstudiante(Estudiante e) {
        return this.archivo.agregarEstudiante(e);
    }

    @Override
    public Estudiante buscarEstudiante(long cedula) {
        return this.archivo.buscarEstudiante(cedula);
    }

    @Override
    public boolean borrarEstudiante(long cedula) {
        return this.archivo.borrarEstudiante(cedula);
    }

    @Override
    public List<Estudiante> obtenerEstudiantes() {
        return this.archivo.obtenerEstudiantes();
    }
    
   
}
