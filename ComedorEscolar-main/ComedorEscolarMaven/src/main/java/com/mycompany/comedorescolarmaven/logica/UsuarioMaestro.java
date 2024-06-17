/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.comedorescolarmaven.logica;

/**
 *
 * @author DAVID
 */
public class UsuarioMaestro {
    
    private final String USER = "david";
    private final String PASSWORD = "12345";

    public UsuarioMaestro() {
        
    }
    
    public boolean usuarioMaestro(String username, String password){
        // implementar logica para validacion de credenciales de ususario
        return (username.equals(USER)&&password.equals(PASSWORD));
    }

}
