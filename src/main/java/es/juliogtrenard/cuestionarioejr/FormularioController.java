package es.juliogtrenard.cuestionarioejr;

import es.juliogtrenard.componentetemporizador.TemporizadorController;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador de los eventos de la ventana
 */
public class FormularioController implements Initializable {
    private static final int SEGUNDOS = 269;

    /**
     * Un temporizador
     */
    @FXML
    private TemporizadorController temporizador;

    /**
     * Botón de enviar
     */
    @FXML
    private Button btnEnviar1;

    /**
     * Botón de enviar
     */
    @FXML
    private Button btnEnviar2;

    /**
     * Se ejecuta cuando se carga la ventana
     *
     * @param url la url
     * @param resourceBundle los recursos
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (temporizador.setSegundos(SEGUNDOS)) {
            temporizador.iniciar();
            temporizador.finProperty().addListener((ChangeListener<Object>) (_, _, _) -> deshabilitarBotones());
        } else {
            deshabilitarBotones();
            alerta("No se ha podido iniciar el temporizador");
        }
    }

    /**
     * Se ejecuta cuando se pulsa alguno de los botones de enviar
     *
     * @param event el evento
     */
    @FXML
    void enviar(ActionEvent event) {
        temporizador.detener();
        confirmacion("Enviado");
        deshabilitarBotones();
    }

    /**
     * Deshabilita los botones de enviar
     */
    public void deshabilitarBotones() {
        btnEnviar1.setDisable(true);
        btnEnviar2.setDisable(true);
    }

    /**
     * Muestra un mensaje de alerta al usuario
     *
     * @param texto contenido de la alerta
     */
    public void alerta(String texto) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
        alerta.setContentText(texto);
        alerta.showAndWait();
    }

    /**
     * Muestra un mensaje de confirmación al usuario
     *
     * @param texto contenido del mensaje
     */
    public void confirmacion(String texto) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Info");
        alerta.setContentText(texto);
        alerta.showAndWait();
    }

}