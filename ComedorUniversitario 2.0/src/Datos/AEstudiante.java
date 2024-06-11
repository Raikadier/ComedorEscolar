package Datos;

import Entidades.Estudiante;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class AEstudiante implements IEstudiante {

    private File manejoArchivo;
    private FileWriter escrituraArc;
    private Scanner lectura;

    //coloca el nombre al arch
    public AEstudiante() {
        this("archivoEstudiante.dat");
    }

    //se le asigna a manejoarchivo
    public AEstudiante(String archivo) {
        this.manejoArchivo = new File(archivo);
    }

    public File getManejoArchivo() {
        return manejoArchivo;
    }

    public void setManejoArchivo(File manejoArchivo) {
        this.manejoArchivo = manejoArchivo;
    }

    public FileWriter getEscrituraArc() {
        return escrituraArc;
    }

    public void setEscrituraArc(FileWriter escrituraArc) {
        this.escrituraArc = escrituraArc;
    }

    public Scanner getLectura() {
        return lectura;
    }

    public void setLectura(Scanner lectura) {
        this.lectura = lectura;
    }

    @Override
    public boolean agregarEstudiante(Estudiante e) {
        PrintWriter pw = null;
        try {
            this.escrituraArc = new FileWriter(this.manejoArchivo, true);
            pw = new PrintWriter(this.escrituraArc);
            pw.println(e.dataFile());
            return true;
        } catch (IOException ioe) {
            System.out.println("No se pudo guardar");
            return false;
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
    
    private Estudiante convertirAEstudiante(String linea){
        String[] datos = linea.split(";");
        String nombre = datos[0];
        long cedula = Long.parseLong(datos[1]);
        String correo = datos[2];
        String carrera = datos[3];
        int semestre = Integer.parseInt(datos[4]);
        long tel = Long.parseLong(datos[5]);
        return new Estudiante(carrera, correo, semestre, nombre, cedula, tel);
    }

    @Override
    public Estudiante buscarEstudiante(long cedula) {
         Scanner scanner = null;
         try{
             scanner = new Scanner(this.manejoArchivo);
             while(scanner.hasNextLine()){
                 String linea = scanner.nextLine();
                 Estudiante estudiante = convertirAEstudiante(linea);
                 if(estudiante.getCedula() == cedula){
                     return estudiante;
                 }
             }
         } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado");
    } finally {
        if (scanner != null) {
            scanner.close();
        }
    }
         return null;
    }

    @Override
    public boolean borrarEstudiante(long cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Estudiante> obtenerEstudiantes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
