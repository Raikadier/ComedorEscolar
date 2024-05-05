
package comedoruniversitario;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Usuario{
    
    private List <Usuario> listaEmpleados;
    private List <Estudiante> listaEstudiantes;

    public Empleado() {
        this.listaEmpleados = new ArrayList<>();
    }

    public Empleado(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
    }

    public Empleado(List<Usuario> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Usuario> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Usuario> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @Override
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String getContraseña() {
        return contraseña;
    }

    @Override
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    @Override
    public String toString() {
        return "Empleado{" + super.toString();
    }
    
    
    @Override
    public boolean verificarLogin(String nom, String contra) {
        for(Usuario u: listaEmpleados){
            if(u.nombreUsuario == nom && u.contraseña == contra && u instanceof Empleado){
                return true;
            }
        }
        return false;

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
