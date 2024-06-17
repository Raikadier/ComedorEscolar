package com.mycompany.Entidades;

import java.util.List;

public interface Registro {

    public void agregarUsuario(Usuario u);

    public void agregarEstudiante(Estudiante e);

    public boolean buscarEstudiante(long cedula);

    public void borrarEstudiante(long cedula);

    public void borrarUsuario(String nomUsuario);

    public List<Estudiante> obtenerEstudiantes();

    public void actualizarEstudiante(long cedula);
}
