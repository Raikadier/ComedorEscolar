/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comedoruniversitario;

/**
 *
 * @author ESTUDIANTES
 */
public class RegistroUsuario {
    
    private Usuario[] usuarios;

    public RegistroUsuario() {}

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "RegistroUsuario{" + "usuarios=" + usuarios + '}';
    }
}
