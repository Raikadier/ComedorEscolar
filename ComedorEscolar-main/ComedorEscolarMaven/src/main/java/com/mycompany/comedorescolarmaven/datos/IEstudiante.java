package com.mycompany.comedorescolarmaven.datos;

import com.mycompany.comedorescolarmaven.entidades.Estudiante;
import java.util.ArrayList;

public interface IEstudiante {

    public boolean agregarEstudiante(Estudiante e);

    public Estudiante buscarEstudiante(long cedula);

    public boolean borrarEstudiante(long cedula);

    public ArrayList<Estudiante> obtenerEstudiantes();

}
