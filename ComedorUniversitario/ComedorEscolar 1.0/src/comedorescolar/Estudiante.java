package comedorescolar;

import java.util.List;

public class Estudiante {

    private String nombreEstudiante;
    private long cedula;
    private int codigo;
    private List<Almuerzo> saldoAlmuerzo;

    public Estudiante() {
    }

    public Estudiante(String nombreEstudiante, long cedula, int codigo, List<Almuerzo> saldoAlmuerzo) {
        this.nombreEstudiante = nombreEstudiante;
        this.cedula = cedula;
        this.codigo = codigo;
        this.saldoAlmuerzo = saldoAlmuerzo;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Almuerzo> getSaldoAlmuerzo() {
        return saldoAlmuerzo;
    }

    public void setSaldoAlmuerzo(List<Almuerzo> saldoAlmuerzo) {
        this.saldoAlmuerzo = saldoAlmuerzo;
    }

    public void retirarAlmuerzo(Almuerzo almuerzo) {
        // el estudiante ha retirado un almuerzo del sistema y llama a retirar() de almuerzo
    }

    public void actualizarSaldo(Almuerzo almuerzo) {
        // se descuenta el almuerzo al saldo
    }

}
