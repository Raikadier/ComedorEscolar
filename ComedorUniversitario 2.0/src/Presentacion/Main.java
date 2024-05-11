
package Presentacion;

import Entidades.Administrador;
import Entidades.Empleado;
import Entidades.Estudiante;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        char finCiclo;
        int opc;
        int op;
        int opcAdmin;
        Administrador administrador = new Administrador();
        Empleado empleado = null;
        Estudiante estudiante = null;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Por favor, antes de ingresar cree un Usuario (ADMINISTRADOR)");
        System.out.println("NOMBRE USUARIO: "); String usuario = entrada.nextLine();
        System.out.println("CONTRASEÑA: "); String clave = entrada.nextLine();
        administrador.agregarUsuario(new Administrador(usuario, clave));
        
        finCiclo =  'S';
        while(finCiclo == 'S'){
            do{
            System.out.println("BIENVENIDO AL PORTAL");
            System.out.println("   DIGITE OPCION");
            System.out.println("----------------------");
            System.out.println("1. ADMINISTRACION");
            System.out.println("2. CONTROL DE ACCESO");
            System.out.println("3. CONFIGURACION");
            System.out.println("4. SALIR");
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
                    op = 's';
                    while(op == 's'){
                        do{
                            System.out.println("1. AGREGAR USUARIO");
                            System.out.println("2. AGREGAR ESTUDIANTE");
                            System.out.println("3. BORRAR ESTUDIANTE");
                            System.out.println("4. BORRAR USUARIO");
                            System.out.println("5. ACTUALIZAR ESTUDIANTE");
                            System.out.println("6. SALIR");
                            opcAdmin = entrada.nextInt();
                        } while (opcAdmin < 1 || opcAdmin > 6);
                        switch(opcAdmin){
                            case 1:  System.out.println("REGISTRO DE USUARIOS (EMPLEADOS)");
                                     System.out.println("nombre usuario: ");
                                     entrada.nextLine();
                                     String userEmpleado = entrada.nextLine();
                                     System.out.println("contraseña: ");
                                     String claveEmpleado = entrada.nextLine();
                                     empleado = new Empleado(userEmpleado, claveEmpleado, administrador);
                                     administrador.agregarUsuario(empleado);
                                     break;
                            case 2:  System.out.println("----------------------");
                                     System.out.println("Registro de Estudiante: ");
                                     System.out.println("Nombre Estudiante: ");
                                     entrada.nextLine();
                                     String nomEstudiante = entrada.nextLine();
                                     System.out.println("cedula Estudiante: ");
                                     long cedEstudiante = entrada.nextLong();
                                     System.out.println("carrera: ");
                                     entrada.nextLine();
                                     String carreraEstudiante = entrada.nextLine();
                                     System.out.println("semestre Estudiante: ");
                                     int semEstudiante = entrada.nextInt();
                                     estudiante = new Estudiante(nomEstudiante, cedEstudiante, carreraEstudiante, semEstudiante);
                                     administrador.agregarEstudiante(estudiante);
                                     System.out.println("----------------------");
                                     break;
                            case 6:  op = 'n';
                                 
                        }
                    }
                    
                }
                else{
                    System.out.println("Usuario incorrecto / no registrado");
                }
                break;
                
            case 2:  System.out.println("2. CONTROL DE ACCESO");
                System.out.println("Verificar Login");
                System.out.println("----------------------");
                System.out.println("nombre usuario: ");
                entrada.nextLine();
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
    
    
}
