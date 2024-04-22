
package comedoruniversitario;

import java.util.ArrayList;

public class Empleado extends Usuario{
    
    private ArrayList <Usuario> listaEmpleados;
    private ArrayList <Estudiante> listaEstudiantes;

    public Empleado() {
    }

    public Empleado(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
    }

    @Override
    public boolean verificarLogin(String nom, String contra) {
        return true;
    }
    
    @Override
    public void agregarUsuario() {
    }
    
    public boolean buscarEstudiante(Estudiante e){
        if(listaEstudiantes.contains(e)){
            System.out.println("Acceso permitido");
            return true;
        }
        else{
            System.out.println("Acceso denegado");
            return false;
        }
    }
            
}
