
package Presentacion;

import Entidades.Administrador;
import Entidades.Empleado;
import Entidades.Estudiante;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        int opc;
        Administrador administrador = new Administrador();
        Empleado empleado = null;
        Estudiante estudiante = null;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Por favor, antes de ingresar cree un Usuario (ADMINISTRADOR)");
        System.out.println("NOMBRE USUARIO: "); String usuario = entrada.nextLine();
        System.out.println("CONTRASEÑA: "); String clave = entrada.nextLine();
        administrador.agregarUsuario(new Administrador(usuario, clave));
        
        do{
            System.out.println("BIENVENIDO AL PORTAL");
            System.out.println("   DIGITE OPCION");
            System.out.println("----------------------");
            System.out.println("1. ADMINISTRACION");
            System.out.println("2. CONTROL DE ACCESO");
            System.out.println("3. CONFIGURACION");
            opc = entrada.nextInt();
        } while ((opc < 1) || (opc > 3));
        
        switch(opc){
            
            case 1:  System.out.println("1. ADMINISTRACION");
                System.out.println("Verificar Login");
                 /*Por ahora solo se hizo el registro, pero esta opcion tendra todas las acciones 
                   del administrador*/
                System.out.println("nombre usuario: ");
                entrada.nextLine();
                String nomUsuario = entrada.nextLine();
                System.out.println("contraseña: "); String contraseña = entrada.nextLine();
                System.out.println("----------------------");
                boolean confirmar = administrador.verificarLogin(nomUsuario, contraseña);
                if(confirmar){
                    System.out.println("REGISTRO DE USUARIOS (EMPLEADOS)");
                    System.out.println("nombre usuario: ");
                    String userEmpleado = entrada.nextLine();
                    System.out.println("contraseña: ");
                    String claveEmpleado = entrada.nextLine();
                    empleado = new Empleado(userEmpleado, claveEmpleado, administrador);
                    administrador.agregarUsuario(empleado);
                    
                    System.out.println("----------------------");
                    System.out.println("Registro de Estudiante: ");
                    System.out.println("Nombre Estudiante: ");
                    String nomEstudiante = entrada.nextLine();
                    System.out.println("cedula Estudiante: ");
                    long cedEstudiante = entrada.nextLong();
                    System.out.println("carrera: ");
                    String carreraEstudiante = entrada.nextLine();
                    System.out.println("semestre Estudiante: ");
                    int semEstudiante = entrada.nextInt();
                    estudiante = new Estudiante(nomEstudiante, cedEstudiante, carreraEstudiante, semEstudiante);
                    administrador.agregarEstudiante(estudiante);
                    System.out.println("----------------------");
                }
                else{
                    System.out.println("Usuario incorrecto / no registrado");
                }
                break;
                
            case 2:  System.out.println("2. CONTROL DE ACCESO");
                System.out.println("Verificar Login");
                System.out.println("----------------------");
                System.out.println("nombre usuario: ");
                String userEmpleado = entrada.nextLine();
                System.out.println("contraseña: ");
                String contraEmpleado = entrada.nextLine();
                boolean verificar = empleado.verificarLogin(userEmpleado, contraEmpleado);
                if(verificar){
                    System.out.println("Ingrese cedula del estudiante");
                    long cedula = entrada.nextLong();
                    empleado.buscarEstudiante(cedula);
                }
                else{
                    System.out.println("Usuario incorrecto / no registrado");
                }
                System.out.println("----------------------");
                break;
           
        }
       
        
        
    }
    
    
}
