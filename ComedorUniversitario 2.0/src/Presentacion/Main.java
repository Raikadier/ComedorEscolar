
package Presentacion;

import Entidades.Administrador;
import Entidades.Empleado;
import Entidades.Estudiante;
import Logica.Entrega;
import Logica.PeriodoEntrega;
import Logica.RegistroEntregaImpList;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String finCiclo;
        int opc=0;
        char op;
        int opcAdmin;
        Administrador administrador = new Administrador();
        Empleado empleado = new Empleado();
        Estudiante estudiante = null;
        Scanner entrada = new Scanner(System.in);
        administrador.agregarUsuario(new Administrador("lau", "123", "LAURA ALTAHONA", 1074839237, 1));
        RegistroEntregaImpList RegistroEntregas = new RegistroEntregaImpList();
        PeriodoEntrega periodo = new PeriodoEntrega(RegistroEntregas);
        
        DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();
        if(diaSemana == DayOfWeek.MONDAY){
            periodo.actualizarPeriodo();
        }

        finCiclo =  "S";
        while(finCiclo == "S"){
            System.out.println("NOMBRE USUARIO: ");
            String user = entrada.nextLine();
            System.out.println("CONTRASEÑA: ");
            String pass = entrada.nextLine();
            System.out.println("--------------------------");
            boolean entradaAdmi = administrador.verificarLogin(user, pass);
            boolean entradaEmpleado = empleado.verificarLogin(user, pass);
        
            if(entradaAdmi == true){
                op = 'S';
                while(op == 'S'){
                    do{
                        System.out.println("1. AGREGAR USUARIO");
                        System.out.println("2. AGREGAR ESTUDIANTE");
                        System.out.println("3. BORRAR ESTUDIANTE");
                        System.out.println("4. BUSCAR ESTUDIANTE");
                        System.out.println("5. BORRAR USUARIO");
                        System.out.println("6. ACTUALIZAR ESTUDIANTE");
                        System.out.println("7. SALIR");
                        opcAdmin = entrada.nextInt();
                    } while (opcAdmin < 1 || opcAdmin > 7);
                    switch(opcAdmin){
                        case 1:  System.out.println("REGISTRO DE USUARIOS (EMPLEADOS)");
                                 System.out.println("nombre usuario: ");
                                 entrada.nextLine();
                                 String userEmpleado = entrada.nextLine();
                                 System.out.println("contraseña: ");
                                 String claveEmpleado = entrada.nextLine();
                                 System.out.println("NOMBRE PERSONA: "); String nombreEmpleado = entrada.nextLine();
                                 System.out.println("CEDULA: "); long cedEmpleado = entrada.nextLong();
                                 System.out.println("TELEFONO: "); long telEmpleado = entrada.nextLong();
                                 empleado = new Empleado(administrador, userEmpleado, claveEmpleado, nombreEmpleado, cedEmpleado, telEmpleado);
                                 administrador.agregarUsuario(empleado);
                                 System.out.println("----------------------");
                                 System.out.println("\n");
                                 break;  
                                     
                        case 2:      System.out.println("Registro de Estudiante: ");
                                     System.out.println("Nombre Estudiante: ");
                                     entrada.nextLine();
                                     String nomEstudiante = entrada.nextLine();
                                     System.out.println("carrera: ");
                                     String carreraEstudiante = entrada.nextLine();
                                     System.out.println("correo estudiante: "); 
                                     String correoEstudiante = entrada.nextLine();
                                     System.out.println("cedula Estudiante: ");
                                     long cedEstudiante = entrada.nextLong();
                                     System.out.println("telefono Estudiante: ");
                                     long telEstudiante = entrada.nextLong();
                                     System.out.println("semestre Estudiante: ");
                                     int semEstudiante = entrada.nextInt();
                                     estudiante = new Estudiante(carreraEstudiante, correoEstudiante, semEstudiante, nomEstudiante, cedEstudiante, telEstudiante);
                                     administrador.agregarEstudiante(estudiante);
                                     System.out.println("----------------------");
                                     System.out.println("\n");
                                     break;
                                     
                            case 3:  System.out.println("BORRAR ESTUDIANTE");
                                     System.out.println("Cedula de estudiante: ");
                                     long cedula = entrada.nextLong();
                                     administrador.borrarEstudiante(cedula);
                                     System.out.println("----------------------");
                                     System.out.println("\n");
                                     break;
                                     
                            case 4:  System.out.println("BUSCAR ESTUDIANTE");
                                     System.out.println("Cedula de estudiante: ");
                                     long cedula2 = entrada.nextLong();
                                     administrador.buscarEstudiante(cedula2);
                                     System.out.println("----------------------");
                                     System.out.println("\n");
                                     break;
                                     
                            case 5:  System.out.println("BORRAR USUARIO");
                                     System.out.println("Nombre Usuario a borrar: ");
                                     entrada.nextLine();
                                     String nombreUsuario = entrada.nextLine();
                                     administrador.borrarUsuario(nombreUsuario);
                                     System.out.println("----------------------");
                                     System.out.println("\n");
                                     break;
                                     
                            case 7:  op = 'n';
                                 
                        }
                    }
                    
        }
                     
        else if (entradaEmpleado == true){
                    System.out.println("1. CONTROL DE ACCESO");
                    System.out.println("2. SALIR");
                    int opcionEmpleado = entrada.nextInt();
                    
                    switch(opcionEmpleado){
                        case 1:  System.out.println("Ingrese cedula del estudiante");
                                 long cedula = entrada.nextLong();
                                 Estudiante acceso = empleado.buscarEstudiante(cedula);
                                 if(acceso != null){
                                    System.out.println("Para retirar almuerzo presione 1");
                                    int num = entrada.nextInt();
                                    if(num == 1){
                                        Entrega entrega = new Entrega(acceso, RegistroEntregas, periodo);
                                        entrega.retirarAlmuerzo(acceso);
                                        System.out.println("LISTA DE ENTREGAS: ");
                                        RegistroEntregas.mostrarLista();
                                    }
                                }
                                break;
                        case 2: op = 'N';
                    }
            }
            else{
                System.out.println("USUARIO INCORRECTO / NO REGISTRADO");
                System.out.println("-----------------------------------");
            }   

        }
    }
    
    
    
}
