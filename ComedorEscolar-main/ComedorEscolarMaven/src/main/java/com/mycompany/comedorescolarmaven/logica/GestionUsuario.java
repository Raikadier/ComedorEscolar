package com.mycompany.Logica;

import com.mycompany.Datos.AUsuario;
import com.mycompany.Datos.IUsuario;
import com.mycompany.Entidades.Estudiante;
import com.mycompany.Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

public class GestionUsuario implements IUsuario {

    private IUsuario archivo;

    public GestionUsuario() {
        this.archivo = new AUsuario();
    }

    @Override
    public boolean agregarUsuario(Usuario u) {
        return this.archivo.agregarUsuario(u);
    }

    @Override
    public Usuario buscarUsuario(long cedula) {
        return this.archivo.buscarUsuario(cedula);
    }

    @Override
    public boolean borrarUsuario(long cedula) {
        return this.archivo.borrarUsuario(cedula);
    }

    @Override
    public ArrayList<Usuario> obtenerUsuario() {
        return this.archivo.obtenerUsuario();
    }

    @Override
    public boolean verificarLoginAdministrador(String username, String password) {
        return this.archivo.verificarLoginAdministrador(username, password);
    }

    @Override
    public boolean verificarLoginEmpleado(String username, String password) {
        return this.archivo.verificarLoginEmpleado(username, password);
    }
}
