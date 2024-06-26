package com.mycompany.comedorescolarmaven.logica;

import com.mycompany.comedorescolarmaven.datos.IUsuario;
import com.mycompany.comedorescolarmaven.datos.AUsuario;
import com.mycompany.comedorescolarmaven.entidades.Usuario;

import java.util.ArrayList;

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
