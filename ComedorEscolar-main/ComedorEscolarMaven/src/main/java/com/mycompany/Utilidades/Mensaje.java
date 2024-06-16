
package com.mycompany.Utilidades;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mensaje {
    
    public static void notificarMensaje(String titulo, String msg, AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.initOwner(null);
        alert.showAndWait();
    }
    
}
