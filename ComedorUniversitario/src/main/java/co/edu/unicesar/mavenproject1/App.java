package co.edu.unicesar.mavenproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import Entidades.Administrador;
import Entidades.Empleado;
import Entidades.Estudiante;
import Logica.PeriodoEntrega;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();

        char finCiclo;
        int opc;
        int op;
        int opcAdmin;
        Administrador administrador = new Administrador();
        Empleado empleado = null;
        Estudiante estudiante = null;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Por favor, antes de ingresar cree un Usuario (ADMINISTRADOR)");
        System.out.println("NOMBRE USUARIO: ");
        String usuario = entrada.nextLine();
        System.out.println("CONTRASEÑA: ");
        String clave = entrada.nextLine();
        System.out.println("NOMBRE PERSONA: ");
        String nombreAdministrador = entrada.nextLine();
        System.out.println("CEDULA: ");
        long cedAdministrador = entrada.nextLong();
        System.out.println("TELEFONO: ");
        long telAdministrador = entrada.nextLong();
        administrador.agregarUsuario(new Administrador(usuario, clave, nombreAdministrador, cedAdministrador, telAdministrador));
        System.out.println("---------------------");
        System.out.println("\n");

        finCiclo = 'S';
        while (finCiclo == 'S') {
            do {
                System.out.println("BIENVENIDO AL PORTAL");
                System.out.println("   DIGITE OPCION");
                System.out.println("----------------------");
                System.out.println("1. ADMINISTRACION");
                System.out.println("2. CONTROL DE ACCESO");
                System.out.println("3. CONFIGURACION");
                System.out.println("4. SALIR");
                opc = entrada.nextInt();
            } while ((opc < 1) || (opc > 3));

            switch (opc) {

                case 1:
                    System.out.println("\n");
                    System.out.println("1. ADMINISTRACION");
                    System.out.println("Verificar Login (ADMINISTRADOR)");
                    System.out.println("nombre usuario: ");
                    entrada.nextLine();
                    String nomUsuario = entrada.nextLine();
                    System.out.println("contraseña: ");
                    String contraseña = entrada.nextLine();
                    System.out.println("----------------------");
                    boolean confirmar = administrador.verificarLogin(nomUsuario, contraseña);
                    if (confirmar) {
                        op = 's';
                        while (op == 's') {
                            do {
                                System.out.println("1. AGREGAR USUARIO");
                                System.out.println("2. AGREGAR ESTUDIANTE");
                                System.out.println("3. BORRAR ESTUDIANTE");
                                System.out.println("4. BUSCAR ESTUDIANTE");
                                System.out.println("5. BORRAR USUARIO");
                                System.out.println("6. ACTUALIZAR ESTUDIANTE");
                                System.out.println("7. SALIR");
                                opcAdmin = entrada.nextInt();
                            } while (opcAdmin < 1 || opcAdmin > 7);
                            switch (opcAdmin) {
                                case 1:
                                    System.out.println("REGISTRO DE USUARIOS (EMPLEADOS)");
                                    System.out.println("nombre usuario: ");
                                    entrada.nextLine();
                                    String userEmpleado = entrada.nextLine();
                                    System.out.println("contraseña: ");
                                    String claveEmpleado = entrada.nextLine();
                                    System.out.println("NOMBRE PERSONA: ");
                                    String nombreEmpleado = entrada.nextLine();
                                    System.out.println("CEDULA: ");
                                    long cedEmpleado = entrada.nextLong();
                                    System.out.println("TELEFONO: ");
                                    long telEmpleado = entrada.nextLong();
                                    empleado = new Empleado(administrador, userEmpleado, claveEmpleado, nombreEmpleado, cedEmpleado, telEmpleado);
                                    administrador.agregarUsuario(empleado);
                                    System.out.println("----------------------");
                                    System.out.println("\n");
                                    break;
                                case 2:
                                    System.out.println("Registro de Estudiante: ");
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

                                case 3:
                                    System.out.println("BORRAR ESTUDIANTE");
                                    System.out.println("Cedula de estudiante: ");
                                    long cedula = entrada.nextLong();
                                    administrador.borrarEstudiante(cedula);
                                    System.out.println("----------------------");
                                    System.out.println("\n");
                                    break;

                                case 4:
                                    System.out.println("BUSCAR ESTUDIANTE");
                                    System.out.println("Cedula de estudiante: ");
                                    long cedula2 = entrada.nextLong();
                                    administrador.buscarEstudiante(cedula2);
                                    System.out.println("----------------------");
                                    System.out.println("\n");
                                    break;

                                case 5:
                                    System.out.println("BORRAR USUARIO");
                                    System.out.println("Nombre Usuario a borrar: ");
                                    entrada.nextLine();
                                    String nombreUsuario = entrada.nextLine();
                                    administrador.borrarUsuario(nombreUsuario);
                                    System.out.println("----------------------");
                                    System.out.println("\n");
                                    break;

                                case 7:
                                    op = 'n';

                            }
                        }

                    } else {
                        System.out.println("Usuario incorrecto / no registrado");
                    }
                    break;

                case 2:
                    System.out.println("2. CONTROL DE ACCESO");
                    System.out.println("Verificar Login (EMPLEADO)");
                    System.out.println("----------------------");
                    System.out.println("nombre usuario: ");
                    entrada.nextLine();
                    String userEmpleado = entrada.nextLine();
                    System.out.println("contraseña: ");
                    String contraEmpleado = entrada.nextLine();
                    boolean verificar = empleado.verificarLogin(userEmpleado, contraEmpleado);
                    System.out.println("----------------------");
                    System.out.println("\n");
                    if (verificar) {
                        System.out.println("Ingrese cedula del estudiante");
                        long cedula = entrada.nextLong();
                        boolean acceso = empleado.buscarEstudiante(cedula);
                        if (acceso) {
                            System.out.println("Para retirar almuerzo presione 1");
                            int num = entrada.nextInt();
                            if (num == 1) {
                                LocalDate fechaInicio = LocalDate.now();
                                PeriodoEntrega periodo = new PeriodoEntrega();
                            }
                        }

                    } else {
                        System.out.println("Usuario incorrecto / no registrado");
                    }
                    System.out.println("----------------------");
                    System.out.println("\n");
                    break;

            }
        }
    }

}
