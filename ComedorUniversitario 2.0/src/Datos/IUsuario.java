
package Datos;

import Entidades.Estudiante;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

public interface IUsuario {
    
    public boolean agregarUsuario(Usuario u);
    public Usuario buscarUsuario(long cedula);
    public boolean borrarUsuario(long cedula);
    public ArrayList<Usuario> obtenerUsuario();
    
}
