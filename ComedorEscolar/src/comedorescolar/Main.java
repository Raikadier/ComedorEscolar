package comedorescolar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        // Creación de estudiantes
        Estudiante Juan = new Estudiante("Laura", 12345678, 1001, new ArrayList<>());
        Estudiante Jose = new Estudiante("David", 98765000, 1002, new ArrayList<>());
        
        // Creación de una lista de estudiantes para el sistema de autenticación
        List<Estudiante> estudiantesRegistrados = new ArrayList<>();
        estudiantesRegistrados.add(Juan);
        estudiantesRegistrados.add(Jose);
        
        // Creación de sistema de autenticación
        SistemaDeAutenticacion sistemaDeAutenticacion = new SistemaDeAutenticacion(estudiantesRegistrados);
        
        // Prueba de autenticación de un estudiante
        boolean autenticado = sistemaDeAutenticacion.autenticarEstudiante("Laura", 1234567890);
        if (autenticado) {
            System.out.println("Estudiante autenticado correctamente.");
        } else {
            System.out.println("Error en la autenticación del estudiante.");
        }
        
        // Creación de un almuerzo
        Almuerzo almuerzo = new Almuerzo(LocalDate.now(), false, Juan);
        
        // Creación de sistema de almuerzo
        SistemaDeAlmuerzo sistemaDeAlmuerzo = new SistemaDeAlmuerzo();
        
        // Gestionar retiro de almuerzo por parte de un estudiante
        sistemaDeAlmuerzo.gestionarRetiroAlmuerzo(Juan, almuerzo);
        
        // Actualizar saldo de almuerzos del estudiante
        Juan.actualizarSaldo(almuerzo);

    }
}
