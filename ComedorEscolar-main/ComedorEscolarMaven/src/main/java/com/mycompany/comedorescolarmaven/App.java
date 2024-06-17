package com.mycompany.comedorescolarmaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Node;
import javafx.stage.Window;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();
    }
    
    // Reemplaza una stage por otra
    public static void setStage(String fxml)throws IOException{
        Window ventana = scene.getWindow();
        Stage stage = (Stage)ventana;
        
        Stage nuevaStage = new Stage();
        scene = new Scene(loadFXML(fxml));
        nuevaStage.setScene(scene);
        nuevaStage.setMaximized(true);
        stage.hide();
        nuevaStage.show();
    }
    
    // Crea una nueva scenea y la establece como escene de la Stage principal
    public static void setNewScene(String fxml) throws IOException{
        Window ventana = scene.getWindow();
        Stage stage = (Stage)ventana;
        setRoot(fxml);
        stage.setMaximized(true);
    }
    
    // Lee un componente a partir de un archivo FXML y lo retorna como nodo
    public static Node loadComponent(String fxml) throws IOException {
        return (Node) loadFXML(fxml);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}