package co.edu.poli.proyecto2.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Clase principal que extiende de Application e inicia la aplicación de gestión de semillas.
 * <p>
 * Esta clase carga la interfaz definida en un archivo FXML (por ejemplo, "SemillaAplicacion.fxml"),
 * establece la escena principal con dimensiones 1000x600 y muestra la ventana con el título "Gestion de Semillas".
 * Además, provee métodos para cambiar la raíz de la escena y para cargar archivos FXML.
 * </p>
 *
 * @version 1.0
 */
public class App extends Application {

    private static Scene scene;

    /**
     * Método de inicio de la aplicación.
     * <p>
     * Crea una escena utilizando el archivo FXML "SemillaAplicacion.fxml", la asigna al escenario,
     * define el título de la ventana y la muestra.
     * </p>
     *
     * @param stage El escenario principal.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("SemillaAplicacion"), 1000, 600);
        stage.setScene(scene);
        stage.setTitle("Gestion de Semillas");
        stage.show();
    }

    /**
     * Cambia la raíz de la escena actual por la definida en el archivo FXML especificado.
     *
     * @param fxml El nombre del archivo FXML (sin extensión) que se usará como nueva raíz.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Carga un archivo FXML y retorna su nodo raíz.
     *
     * @param fxml El nombre del archivo FXML (sin extensión) a cargar.
     * @return El nodo raíz contenido en el archivo FXML.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return loader.load();
    }

    /**
     * Método principal que lanza la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}