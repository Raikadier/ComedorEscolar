package com.mycompany.Presentacion;

import com.mycompany.Logica.GestionUsuario;
import com.mycompany.Utilidades.Mensaje;
import java.awt.Button;
import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

public class LoginController implements Initializable {
    
    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnIngresar;
    
    GestionUsuario login = new GestionUsuario();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }

    @FXML
    private void btnIngresar_click(){
        
        if(login.verificarLoginAdministrador(txtUserName.getText(), txtPassword.getText())) {
            Mensaje.notificarMensaje("error", "Admin no encontrado", Alert.AlertType.ERROR);
        }
        
        if(login.verificarLoginEmpleado(txtUserName.getText(), txtPassword.getText())) {
            Mensaje.notificarMensaje("error", "Usuario no encontrado", Alert.AlertType.ERROR);
        }
        
        Mensaje.notificarMensaje("error", "Usuario no encontrado", Alert.AlertType.ERROR);
    }
}
