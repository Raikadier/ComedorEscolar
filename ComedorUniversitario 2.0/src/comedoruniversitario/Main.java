
package comedoruniversitario;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        
        Administrador administrador = new Administrador();
        Empleado empleado = new Empleado("sofiaPerez", "1234",administrador);
        Estudiante e = new Estudiante("David Barcelo", 1067593242, "Sistemas", 3);
        
        administrador.agregarUsuario(new Administrador("jairoSeonaes", "3456"));
        System.out.println("------------------------------");
                
        boolean confirmar = administrador.verificarLogin("jairoSeonaes", "3456");
        if(confirmar == true){
            administrador.agregarEstudiante(e);
            System.out.println("------------------------------");

            administrador.agregarUsuario(empleado);

        } else{
            System.out.println("Acceso denegado");
        }
        
        System.out.println("------------------------------");
        boolean permitirAcceso = empleado.verificarLogin("sofiaPerez", "1234");
        if(permitirAcceso == true){
            empleado.buscarEstudiante(e);
        }
        
    }
    
    
}
