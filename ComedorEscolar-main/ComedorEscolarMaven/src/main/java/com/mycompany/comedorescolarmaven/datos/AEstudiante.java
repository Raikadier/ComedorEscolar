package com.mycompany.comedorescolarmaven.datos;

import com.mycompany.comedorescolarmaven.entidades.Estudiante;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    private Estudiante convertirAEstudiante(String linea) {
        String[] datos = linea.split(";");
        String nombre = datos[0];
        long cedula = Long.parseLong(datos[1]);
        String correo = datos[2];
        String carrera = datos[3];
        int semestre = Integer.parseInt(datos[4]);
        long tel = Long.parseLong(datos[5]);
        int almuerzos = Integer.parseInt(datos[6]);
        return new Estudiante(nombre, cedula, correo, carrera, semestre, tel, almuerzos);
    }

    @Override
    public Estudiante buscarEstudiante(long cedula) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(this.manejoArchivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Estudiante estudiante = convertirAEstudiante(linea);
                if (estudiante.getCedula() == cedula) {
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
        File archivoTemporal = new File("temp.dat");
        PrintWriter pw = null;
        Scanner scanner = null;

        try {
            archivoTemporal.createNewFile(); // Crea un nuevo archivo temporal
            pw = new PrintWriter(archivoTemporal);
            scanner = new Scanner(this.manejoArchivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Estudiante estudiante = convertirAEstudiante(linea);
                if (estudiante.getCedula() != cedula) {
                    pw.println(linea);
                }
            }

        } catch (IOException e) {
            e.printStackTrace(); // Manejo básico de errores
            return false;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (pw != null) {
                pw.close();
            }
        }

        // Renombrar el archivo temporal como el archivo original
        if (this.manejoArchivo.delete()) {
            if (archivoTemporal.renameTo(this.manejoArchivo)) {
                return true;
            } else {
                System.out.println("No se pudo renombrar");
                return false;
            }

        } else {
            System.out.println("No se pudo borrar");
            return false;
        }

    }

    @Override
    public ArrayList<Estudiante> obtenerEstudiantes() {
        ArrayList<Estudiante> estudiantes = new ArrayList();

        if (!this.manejoArchivo.exists()) {
            return estudiantes;
        }
        try {
            this.lectura = new Scanner(this.manejoArchivo);
            while (this.lectura.hasNext()) {
                String data = this.lectura.nextLine();
                Estudiante e = this.convertirAEstudiante(data);
                estudiantes.add(e);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No fue posible abrir el archivo para lectura");
        } finally {
            if (this.lectura != null) {
                this.lectura.close();
            }
        }
        return estudiantes;
    }
    
    public void mostrarTodosLosElementos() {
        try (Scanner scanner = new Scanner(this.manejoArchivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
    }

}
