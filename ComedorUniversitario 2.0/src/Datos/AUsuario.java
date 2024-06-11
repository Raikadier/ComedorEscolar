
package Datos;

import Entidades.Estudiante;
import Entidades.Usuario;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class AUsuario implements IUsuario{
    
    private File manejoArchivo;
    private FileWriter escrituraArc;
    private Scanner lectura;

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
    
   

    @Override
    public Usuario buscarUsuario(long cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrarUsuario(long cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> obtenerUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
