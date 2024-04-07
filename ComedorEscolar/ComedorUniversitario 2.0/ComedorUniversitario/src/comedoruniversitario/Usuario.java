
package comedoruniversitario;


public class Usuario extends Persona {
    
    protected String nombreUsuario;
    protected String contraseña;

    public Usuario() {
    }
    
    
    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public boolean verificarLogin(){
        return true;
    }
    
    
    
}
