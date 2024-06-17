package com.mycompany.Datos;

import com.mycompany.Entidades.Estudiante;
import com.mycompany.Entidades.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AUsuario implements IUsuario {

    private File manejoArchivo;
    private FileWriter escrituraArc;
    private Scanner lectura;
    private Usuario usuario;

    //coloca el nombre al arch
    public AUsuario() {
        this("archivoUsuario.dat");
    }

    //se le asigna a manejoarchivo
    public AUsuario(String archivo) {
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
    public boolean agregarUsuario(Usuario u) {
        PrintWriter pw = null;
        try {
            this.escrituraArc = new FileWriter(this.manejoArchivo, true);
            pw = new PrintWriter(this.escrituraArc);
            pw.println(u.dataFile());
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

    private Usuario convertirAUsuario(String linea) {
        String[] datos = linea.split(";");
        String rol = datos[0];
        String username = datos[1];
        String password = datos[2];
        String nombre = datos[3];
        long cedula = Long.parseLong(datos[4]);
        long tel = Long.parseLong(datos[5]);
        return new Usuario(rol, username, password, nombre, cedula, tel);
    }

    @Override
    public Usuario buscarUsuario(long cedula) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(this.manejoArchivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Usuario user = convertirAUsuario(linea);
                if (usuario.getCedula() == cedula) {
                    return usuario;
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
    public boolean borrarUsuario(long cedula) {
        File archivoTemporal = new File("temporal.dat");
        PrintWriter pw = null;
        Scanner scanner = null;

        try {
            archivoTemporal.createNewFile(); // Crea un nuevo archivo temporal
            pw = new PrintWriter(archivoTemporal);
            scanner = new Scanner(this.manejoArchivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Usuario user = convertirAUsuario(linea);
                if (user.getCedula() != cedula) {
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
    public ArrayList<Usuario> obtenerUsuario() {
        ArrayList usuarios = new ArrayList();
        if (!this.manejoArchivo.exists()) {
            return usuarios;
        }
        try {
            this.lectura = new Scanner(this.manejoArchivo);
            while (this.lectura.hasNext()) {
                String data = this.lectura.nextLine();
                Usuario e = this.convertirAUsuario(data);
                usuarios.add(e);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No fue posible abrir el archivo para lectura");
        } finally {
            if (this.lectura != null) {
                this.lectura.close();
            }
        }
        return usuarios;
    }

    @Override
    public boolean verificarLoginAdministrador(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(this.manejoArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Usuario usuario = convertirAUsuario(linea);
                if (usuario.getRol() == "Administrador" && usuario.getNombreUsuario().equals(username) && usuario.getContraseña().equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean verificarLoginEmpleado(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(this.manejoArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Usuario usuario = convertirAUsuario(linea);
                if (usuario.getRol() == "Empleado" && usuario.getNombreUsuario().equals(username) && usuario.getContraseña().equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
