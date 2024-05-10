
package Entidades;

public interface Registro {
    
    
    public void agregarUsuario(Usuario u);
    public void agregarEstudiante(Estudiante e);
    public boolean buscarEstudiante(long cedula);
    public void borrarEstudiante(long cedula);
    public void borrarUsuario(String nomUsuario);
    public void actualizarEstudiante(Estudiante e);
}
