
package Entidades;

import Entidades.Administrador;
import Entidades.Usuario;
import Entidades.Estudiante;
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
            if(u.getNombreUsuario().equalsIgnoreCase(nom) && u.getContraseña().equalsIgnoreCase(contra) && u instanceof Empleado){
                return true;
            }
        }
        return false;

    }
    
    
    public boolean buscarEstudiante(long cedula){
        for(Estudiante e: administrador.getListaEstudiantes()){
            if(e.cedula == cedula){
                System.out.println("Acesso permitido");
                return true;
            }
            else{
                System.out.println("Acceso denegado");
            }
        }
        return false;  
    }
            
}
