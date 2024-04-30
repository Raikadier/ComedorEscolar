
package comedoruniversitario;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Administrador extends Usuario{
    
    private ArrayList <Administrador> listaAdministrador;
    private ArrayList <Estudiante> listaEstudiantes;
    

    public Administrador() {
    }

    public Administrador(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
    }
    
    public Administrador(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
    
    @Override
    public boolean verificarLogin(String nom, String contra) {
        return true;
    }

    @Override
    public void agregarUsuario() {
        
    }
    
    public void agregarEstudiante(Estudiante e){
        if (!listaEstudiantes.contains(e)){
            listaEstudiantes.add(e);
        }
        else{
            System.out.println("Estudiante ya registrado");
        }
    }
    
    public boolean buscarEstudiante(Estudiante e){
        return listaEstudiantes.contains(e);
    }
    
    public void borrarEstudiante(Estudiante e){
        if(listaEstudiantes.contains(e)){
            listaEstudiantes.remove(e);
        }
        else{
            System.out.println("Estudiante no encontrado");
        }
    }
    
    public void actualizarEstudiante(Estudiante e){
        if(listaEstudiantes.contains(e)){
            
        }
    }
}
