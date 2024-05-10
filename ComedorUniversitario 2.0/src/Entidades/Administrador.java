
package Entidades;

import Entidades.Usuario;
import Entidades.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Administrador extends Usuario implements Registro{
    
    private List <Usuario> listaUsuarios;
    private List <Estudiante> listaEstudiantes;
    

    public Administrador() {
        this.listaEstudiantes = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        
    }

    public Administrador(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
    }
    

    public Administrador(List<Usuario> listaUsuarios) {
        this.listaUsuarios = new ArrayList<>();
    }


    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "(Administrador)" +"\n"+ super.toString();
    }
    
    
    
    @Override
    public boolean verificarLogin(String nom, String contra) {
        for(Usuario u: listaUsuarios){
            if(u.nombreUsuario == nom && u.contraseña == contra){
                return true;
            }
        }
        return false;
    }

    @Override
    public void agregarUsuario(Usuario u) {
        if(!this.listaUsuarios.contains(u)){
            this.listaUsuarios.add(u);
            System.out.println("Usuario agregado exitosamente: "+u);
        }
        else{
            System.out.println("Usuario ya registrado");
        }
    }
    
    @Override
    public void agregarEstudiante(Estudiante e){
        if (!listaEstudiantes.contains(e)){
            listaEstudiantes.add(e);
            System.out.println("Estudiante agregado exitosamente: "+e);
        }
        else{
            System.out.println("Estudiante ya registrado");
        }
    }
    
    @Override
    public boolean buscarEstudiante(long cedula){
        for(Estudiante e: listaEstudiantes){
            if(cedula == e.cedula){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    @Override
    public void borrarEstudiante(long cedula){
        for(Estudiante e: listaEstudiantes){
            if(e.cedula == cedula){
                listaEstudiantes.remove(e);
            }
            else{
                System.out.println("Estudiante no encontrado");
            }
        }
    }
    
    @Override
    public void borrarUsuario(String nomUsuario){
        for(Usuario e: listaUsuarios){
            if(e.nombreUsuario == nomUsuario){
                listaUsuarios.remove(e);
            }
            else{
                System.out.println("Estudiante no encontrado");
            }
        }
    }
    
    @Override
    public void actualizarEstudiante(Estudiante e){
        if(listaEstudiantes.contains(e)){
            
        }
    }
}
