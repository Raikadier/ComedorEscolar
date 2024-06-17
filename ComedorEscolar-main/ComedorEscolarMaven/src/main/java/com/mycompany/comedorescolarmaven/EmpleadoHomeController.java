package com.mycompany.comedorescolarmaven;

import com.mycompany.comedorescolarmaven.datos.AUsuario;
import com.mycompany.comedorescolarmaven.datos.IUsuario;
import com.mycompany.comedorescolarmaven.entidades.Estudiante;
import com.mycompany.comedorescolarmaven.logica.Entrega;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmpleadoHomeController {

    @FXML
    private Button btnRetirarAlmuerzo;
    
    @FXML
    private TableView<Estudiante> tableView;
    @FXML
    private TableColumn<Estudiante, Long> colID;
    @FXML
    private TableColumn<Estudiante, String> colNombre;
    @FXML
    private TableColumn<Estudiante, String> colCorreo;
    @FXML
    private TableColumn<Estudiante, Integer> colSemestre;
    @FXML
    private TableColumn<Estudiante, Long> colCedula;
    @FXML
    private TableColumn<Estudiante, Integer> colAlmuerzos;
    @FXML
    private TableColumn<Estudiante, String> colAcciones;

    private ObservableList<Estudiante> usuarioData = FXCollections.observableArrayList();
    IUsuario aUsuario = new AUsuario(); // Instancia de la clase AUsuario

    @FXML
    private void initialize() {
        // Inicializar columnas
        colID.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colSemestre.setCellValueFactory(new PropertyValueFactory<>("semestre"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colAlmuerzos.setCellValueFactory(new PropertyValueFactory<>("almuerzos"));
        colAcciones.setCellValueFactory(new PropertyValueFactory<>("acciones"));

        // Agregar datos de prueba
        agregarDatosPrueba();

        // Agregar listener para la selección de filas
        tableView.setRowFactory(tv -> {
            TableRow<Estudiante> row = new TableRow<>();
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

        // Configurar el botón para retirar almuerzo
        btnRetirarAlmuerzo.setOnAction(event -> clickBtnRetirarAlmuerzo());
    }

    private void agregarDatosPrueba() {
        // Crear instancias de Estudiante
        Estudiante e1 = new Estudiante("JOHN", 123, "correo1@example.com", "asñlkdjfñ", 2, 302,3);
        Estudiante e2 = new Estudiante("JOHNy", 234, "correo2@example.com", "ajugjgkhggdjfñ", 3, 303,3);
        
        // Agregar datos de prueba
        usuarioData.add(e1);
        usuarioData.add(e2);

        // Configurar la tabla con los datos de prueba
        tableView.setItems(usuarioData);
    }

    @FXML
    private void clickBtnRetirarAlmuerzo() {
        Estudiante selectedUser = tableView.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            Entrega entrega = new Entrega();
            entrega.retirarAlmuerzo(selectedUser);

            // Mostrar mensaje de confirmación
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Retiro de Almuerzo");
            alert.setHeaderText(null);
            alert.setContentText("Se ha retirado un almuerzo");
            alert.showAndWait();
        } else {
            // Manejar el caso donde no hay estudiante seleccionado
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Selección de Estudiante");
            alert.setHeaderText(null);
            alert.setContentText("No hay estudiante seleccionado");
            alert.showAndWait();
        }
    }
}
