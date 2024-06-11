
package com.mycompany.Datos;

import com.mycompany.Entidades.Estudiante;
import com.mycompany.Entidades.Usuario;
import java.util.List;

public interface IUsuario {
    
    public boolean agregarUsuario(Usuario u);
    public Usuario buscarUsuario(long cedula);
    public boolean borrarUsuario(long cedula);
    public List<Usuario> obtenerUsuario();
    
}
