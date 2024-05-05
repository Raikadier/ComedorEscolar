
package comedoruniversitario;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        
        Administrador administrador = new Administrador();
        
        administrador.agregarUsuario(new Administrador("jairoSeonaes", "3456"));
        Empleado empleado = new Empleado("sofiaPerez", "1234");
        Estudiante e = new Estudiante("David Barcelo", 1067593242, "Sistemas", 3);
                
        boolean confirmar = administrador.verificarLogin("jairoSeonaes", "3456");
        if(confirmar == true){
            administrador.agregarEstudiante(e);

            administrador.agregarUsuario(empleado);

        } else{
            System.out.println("Acceso denegado");
        }
        
        boolean permitirAcceso = administrador.verificarLogin("sofiaPerez", "1234");
        if(permitirAcceso == true){
            empleado.buscarEstudiante(e);
        }
        
    }
    
    public static void imprimirEstudiante(){
        
    }
    
}
