
package comedoruniversitario;


public abstract class Usuario{
    
    protected String nombreUsuario;
    protected String contraseña;

    public Usuario() {
        this.nombreUsuario = "Juan";
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

    @Override
    public String toString() {
        return "Usuario -> " + "nombreUsuario: " + nombreUsuario + ", contrase\u00f1a: " + contraseña ;
    }
    
    
    public abstract boolean verificarLogin(String nom, String contra);

    
    
    
}
