package com.mycompany.comedorescolarmaven;

import com.mycompany.comedorescolarmaven.datos.AUsuario;
import com.mycompany.comedorescolarmaven.entidades.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmpleadoHomeController {

    @FXML
    private TableView<Usuario> tableView;
    @FXML
    private TableColumn<Usuario, Long> colID;
    @FXML
    private TableColumn<Usuario, String> colNombre;
    @FXML
    private TableColumn<Usuario, String> colCorreo;
    @FXML
    private TableColumn<Usuario, Integer> colSemestre;
    @FXML
    private TableColumn<Usuario, Long> colCedula;
    @FXML
    private TableColumn<Usuario, Integer> colAlmuerzos;
    @FXML
    private TableColumn<Usuario, String> colAcciones;

    private ObservableList<Usuario> usuarioData = FXCollections.observableArrayList();
    private AUsuario aUsuario = new AUsuario(); // Instancia de la clase AUsuario
    
        Usuario u1 = new Usuario("Empleado", "user1", "pass1", "Nombre1", 12345678L, 987654321L);
        Usuario u2 = new Usuario("Empleado", "user2", "pass2", "Nombre2", 87654321L, 123456789L);
       /* AUsuario.agregarUsuario(u1);
        AUsuario.agregarUsuario(u2);*/

    @FXML
    private void initialize() {
        // Inicializar columnas
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colSemestre.setCellValueFactory(new PropertyValueFactory<>("semestre"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colAlmuerzos.setCellValueFactory(new PropertyValueFactory<>("almuerzos"));
        colAcciones.setCellValueFactory(new PropertyValueFactory<>("acciones"));

        // Cargar datos de usuario desde el archivo
        cargarDatosUsuario();

        // Agregar listener para la selección de filas
        tableView.setRowFactory(tv -> {
            TableRow<Usuario> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    for (Node r : tv.lookupAll(".table-row-cell")) {
                        r.setStyle(""); // Resetear el estilo
                    }
                    row.setStyle("-fx-background-color: #A9A9A9;"); // Oscurecer la fila seleccionada
                }
            });
            return row;
        });
    }

    private void cargarDatosUsuario() {
        usuarioData.clear();
        usuarioData.addAll(aUsuario.obtenerUsuario());
        tableView.setItems(usuarioData);
    }
}


