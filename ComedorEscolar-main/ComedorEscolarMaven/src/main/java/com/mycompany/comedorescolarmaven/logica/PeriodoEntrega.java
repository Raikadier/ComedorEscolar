package com.mycompany.comedorescolarmaven.logica;

import com.mycompany.comedorescolarmaven.entidades.Estudiante;
import com.mycompany.comedorescolarmaven.logica.Entrega;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeriodoEntrega {

    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    private Estudiante estudiante;
    private ARegistroEntrega entregas;
    private PeriodoEntrega ultimoPeriodoValido;

    public PeriodoEntrega() {
    }

    public PeriodoEntrega(LocalDate fechaInicio, LocalDate fechaFin, ARegistroEntrega entregas) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.entregas = entregas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ARegistroEntrega getEntregas() {
        return entregas;
    }

    public void setEntregas(ARegistroEntrega entregas) {
        this.entregas = entregas;
    }

    public PeriodoEntrega getUltimoPeriodoValido() {
        return ultimoPeriodoValido;
    }

    public void setUltimoPeriodoValido(PeriodoEntrega periodo) {
        this.ultimoPeriodoValido = periodo;
    }

    @Override
    public String toString() {
        return "Periodo{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin;
    }

    public PeriodoEntrega actualizarPeriodo() {

        this.fechaInicio = LocalDate.now();
        this.fechaFin = fechaInicio.plusDays(6);
        System.out.println("Periodo Actualizado");
        System.out.println("PERIODO -> Fecha inicio: " + fechaInicio + ", Fecha fin: " + fechaFin);
        PeriodoEntrega periodoSemanal = new PeriodoEntrega(fechaInicio, fechaFin, entregas);
        ultimoPeriodoValido.setUltimoPeriodoValido(periodoSemanal);
        return periodoSemanal;

    }

    public boolean confirmarRetiro(Estudiante e) {
        int entregados = 0;

        File archivo = entregas.getArchivo();
        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Entrega entrega = parseEntrega(linea);

                if (entrega.getEstudiante().equals(e)) {
                    if (entrega.getFechaEntrega().isAfter(fechaInicio) && entrega.getFechaEntrega().isBefore(fechaFin)
                            || entrega.getFechaEntrega().isEqual(fechaInicio) || entrega.getFechaEntrega().isEqual(fechaFin)) {
                        entregados += 1;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return entregados < 3;
    }

    private Entrega parseEntrega(String linea) {
        String[] datos = linea.split(";");
        Estudiante estudiante = new Estudiante(
                datos[0], // nombre
                Long.parseLong(datos[1]), // cedula
                datos[2], // correo
                datos[3], // carrera
                Integer.parseInt(datos[4]), // semestre
                Long.parseLong(datos[5]), // telefono
                Integer.parseInt(datos[6])
        );
        LocalDate fechaEntrega = LocalDate.parse(datos[6]);
        int noAlmuerzosDisponibles = Integer.parseInt(datos[7]);
        PeriodoEntrega periodo = this.ultimoPeriodoValido;

        return new Entrega(estudiante, entregas, periodo, fechaEntrega, noAlmuerzosDisponibles);
    }

}
