package com.mycompany.comedorescolarmaven;

import com.mycompany.comedorescolarmaven.logica.GestionUsuario;
import com.mycompany.comedorescolarmaven.logica.UsuarioMaestro;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnIngresar;

    private GestionUsuario tempUser = new GestionUsuario();
    private UsuarioMaestro um = new UsuarioMaestro();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void clickBtnLogin() throws IOException {
        
        String username = this.txtUsername.getText();
        String password = this.txtPassword.getText();

        if (this.tempUser.verificarLoginAdministrador(username, password)) {
            App.setNewScene("AdministradorHomeEs");
            
        } else if (this.tempUser.verificarLoginEmpleado(username, password)){
            App.setNewScene("AdministradorHomeEm");
            
            
        } else if (this.um.usuarioMaestro(username, password)) {
            //App.setNewScene("AdministradorHomeEs");
            //App.setNewScene("AdministradorHomeEm");
            App.setNewScene("EmpleadoHome");
            
        } else {
            // Genera mensaje de notificacion
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensaje de Login");
            alert.setHeaderText("Informacion de credenciales registradas");
            alert.setContentText("Las credenciales registradas no son correctas, "
                    + "intente nuevamente");
            alert.show();

        }
    }
}
