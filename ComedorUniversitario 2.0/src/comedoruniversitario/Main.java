
package comedoruniversitario;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        
        //en vez de por defecto, lee los datos por teclado, el administrador es el primero que tienes que crear para crear lo demas
        Administrador administrador = new Administrador();
        administrador.agregarUsuario(new Administrador("jairoSeonaes", "3456"));
        /* el menu algo asi:
        BIENVENIDO A LM
        1. ADMINISTRACION
        2. CONTROL DE ACCESO
        3. CONFIGURACION
        
        si le da 1, le da otras opciones
        ADMINISTRACION
        le pide el login a administracion y si si esta entonces: 
        1. Agregar estudiante
        2. agregar usuario
        3. borrar estudiante
        3. borrar usuario
        4. actualizar estudiante/usuario
        y ahi claramente cuando le unda alguna opcion debe aparecer todo, por lo menos haz agregar estudiante y agregar usuario
        
        
        CONTROL DE ACCESO
        le pide el login a empleado
        luego, le pide cedula de estudiante desea buscar, luego deberia retirar almuerxo pero por ahora solo esa opcion
        
        CONFIGURACION
        no se ha hecho
        */
        
        
        
        Empleado empleado = new Empleado("sofiaPerez", "1234",administrador);
        Estudiante e = new Estudiante("David Barcelo", 1067593242, "Sistemas", 3);
        
        
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
            empleado.buscarEstudiante(1067593242);
        }
        
    }
    
    
}
