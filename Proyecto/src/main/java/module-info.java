/**
 * Modulo principal del proyecto de gestion de semillas.
 * 
 * Este modulo configura los requerimientos de JavaFX y define los paquetes abiertos
 * y exportados para la aplicacion, permitiendo el uso de FXML, controles de UI y
 * serializacion de datos.
 */
module co.edu.poli.Proyecto {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.proyecto2.modelo to javafx.base, javafx.fxml;
    opens co.edu.poli.proyecto3.controlador to javafx.fxml;
    opens co.edu.poli.proyecto2.vista to javafx.fxml;
    exports co.edu.poli.proyecto2.vista;
}
