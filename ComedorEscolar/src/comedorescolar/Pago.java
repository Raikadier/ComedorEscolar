package comedorescolar;

import java.time.LocalDate;

public class Pago {

    private Estudiante estudiante;
    final int CANTIDAD_ALMUERZOS = 12;
    private LocalDate fechaPago;
    private double cantidadDinero;

    public Pago(Estudiante estudiante, LocalDate fechaPago, double cantidadDinero) {
        this.estudiante = estudiante;
        this.fechaPago = fechaPago;
        this.cantidadDinero = cantidadDinero;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(double cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public void generarFactura() {

    }

}
