
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

    public Empleado(Administrador administrador, String nombreUsuario, String contraseña, String nombre, long cedula, long tel) {
        super(nombreUsuario, contraseña, nombre, cedula, tel);
        this.administrador = administrador;
    }

    
  
    @Override
    public String toString() {
        return "(Empleado)"+"\n" + super.toString();
    }
   
    @Override
    public boolean verificarLogin(String nom, String contra) {
        
        if(administrador == null){
            return false;
        }
        for(Usuario u: administrador.getListaUsuarios()){
            if(u.getNombreUsuario().equalsIgnoreCase(nom) && u.getContraseña().equalsIgnoreCase(contra) && u instanceof Empleado){
                return true;
            }
        }
        return false;

    }
    
    
    public Estudiante buscarEstudiante(long cedula){
        for(Estudiante e: administrador.getListaEstudiantes()){
            if(e.cedula == cedula){
                System.out.println("Acesso permitido");
                return e;
            }
            else{
                System.out.println("Acceso denegado - NO EXISTE EN EL SISTEMA");
            }
        }
        return null;  
    }
            
}
