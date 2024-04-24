
package comedoruniversitario;

import java.time.LocalDate;
import java.util.ArrayList;


public class Estudiante extends Persona {
    
    protected ArrayList <Estudiante> listaEstudiante;
    protected String carrera;
    protected int semestre;

    public Estudiante() {
    }
    
    public Estudiante(String nombre, long cedula, int cantidadAlmuerzo, LocalDate fechaRetiro) {
        super(nombre, cedula);
        this.cantidadAlmuerzo = cantidadAlmuerzo;
        this.fechaRetiro = fechaRetiro;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
    

    public int getCantidadAlmuerzo() {
        return cantidadAlmuerzo;
    }

    public void setCantidadAlmuerzo(int cantidadAlmuerzo) {
        this.cantidadAlmuerzo = cantidadAlmuerzo;
    }


    @Override
    public String toString() {
        return "Estudiante{"+ super.toString() + "cantidadAlmuerzo=" + cantidadAlmuerzo + ", fechaRetiro=" + fechaRetiro + '}';
    }
    
    
    
    public void retirarAlmuerzo(Estudiante e){
        if(listaEstudiante.contains(e)){
            e.cantidadAlmuerzo -= 1;
            fechaRetiro = LocalDate.now();
            registroAlmuerzo.add(e);
        }
    }
    
    public void actualizarRegistroAlmuerzo(Estudiante e){
        
    }
    
    
    
}
