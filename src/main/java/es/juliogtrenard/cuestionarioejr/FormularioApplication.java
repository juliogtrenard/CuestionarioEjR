package es.juliogtrenard.cuestionarioejr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase de la aplicacion de un formulario con temporizador
 */
public class FormularioApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FormularioApplication.class.getResource("/es/juliogtrenard/cuestionarioejr/formulario.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TEST");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Lanza la aplicación
     *
     * @param args parámetros por consola
     */
    public static void main(String[] args) {
        launch();
    }
}