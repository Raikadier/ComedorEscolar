
package comedoruniversitario;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Usuario{
    
    private Administrador administrador;

    public Empleado() {
    }

    public Empleado(String nombreUsuario, String contraseña,Administrador administrador ) {
        super(nombreUsuario, contraseña);
        this.administrador = administrador;
        
    }

    
    @Override
    public String toString() {
        return "(Empleado)"+"\n" + super.toString();
    }
    
    
    @Override
    public boolean verificarLogin(String nom, String contra) {
        for(Usuario u: administrador.getListaUsuarios()){
            if(u.nombreUsuario == nom && u.contraseña == contra && u instanceof Empleado){
                return true;
            }
        }
        return false;

    }
    
    
    public boolean buscarEstudiante(Estudiante e){
        if(administrador.getListaEstudiantes().contains(e)){
            System.out.println("Acceso permitido");
            return true;
        }
        else{
            System.out.println("Acceso denegado");
            return false;
        }
    }
            
}
