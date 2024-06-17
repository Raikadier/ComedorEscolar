package com.mycompany.comedorescolarmaven.logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ARegistroEntrega implements RegistroEntrega {

    private File archivo;
    private FileWriter escritura;
    private Scanner lectura;

    public ARegistroEntrega() {
        this("archivoEntregas.dat");
    }

    public ARegistroEntrega(String archivo) {
        this.archivo = new File(archivo);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileWriter getEscritura() {
        return escritura;
    }

    public void setEscritura(FileWriter escritura) {
        this.escritura = escritura;
    }

    public Scanner getLectura() {
        return lectura;
    }

    public void setLectura(Scanner lectura) {
        this.lectura = lectura;
    }

    @Override
    public boolean registrarEntrega(Entrega entrega) {
        PrintWriter pw = null;
        try {
            this.escritura = new FileWriter(this.archivo, true);
            pw = new PrintWriter(this.escritura);
            pw.println(entrega.dataFile());
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
    public void mostrarLista() {
        try (Scanner scanner = new Scanner(this.archivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
}
