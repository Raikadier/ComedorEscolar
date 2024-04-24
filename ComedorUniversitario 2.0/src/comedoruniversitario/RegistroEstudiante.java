/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comedoruniversitario;

/**
 *
 * @author ESTUDIANTES
 */
public class RegistroEstudiante {
    
    private Estudiante[] estudiantes;

    public RegistroEstudiante() {}

    public RegistroEstudiante(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "RegistroEstudiante{" + "estudiantes=" + estudiantes + '}';
    }
}
