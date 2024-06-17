package com.mycompany.comedorescolarmaven.datos;

import com.mycompany.comedorescolarmaven.entidades.Usuario;
import java.util.ArrayList;

public interface IUsuario {

    public boolean agregarUsuario(Usuario u);

    public Usuario buscarUsuario(long cedula);

    public boolean borrarUsuario(long cedula);

    public ArrayList<Usuario> obtenerUsuario();

    public boolean verificarLoginAdministrador(String username, String password);

    public boolean verificarLoginEmpleado(String username, String password);
}
