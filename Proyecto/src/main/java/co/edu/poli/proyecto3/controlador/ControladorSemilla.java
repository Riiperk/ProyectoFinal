package co.edu.poli.proyecto3.controlador;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.beans.property.SimpleStringProperty;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.poli.proyecto2.modelo.Semilla;
import co.edu.poli.proyecto2.modelo.Hortaliza;
import co.edu.poli.proyecto2.modelo.Legumbre;
import co.edu.poli.proyecto2.modelo.Cereal;
import co.edu.poli.proyecto2.modelo.Frutal;
import co.edu.poli.proyecto2.servicios.ImplementacionCRUD;

/**
 * Clase ControladorSemilla.
 * 
 * Esta clase se encarga de gestionar la interaccion entre la interfaz grafica y el
 * servicio de operaciones CRUD para el registro de semillas. Provee metodos para crear,
 * leer, actualizar, eliminar, serializar y deserializar semillas, ademas de actualizar
 * la tabla de visualizacion y manejar errores y validaciones.
 *
 * @version 1.0
 */
public class ControladorSemilla implements Initializable {

    @FXML private TextField txtID;
    @FXML private TextField txtNombre;
    @FXML private TextField txtCantidad;
    @FXML private TextField txtTiempo;
    @FXML private TextField txtOrigen;
    @FXML private ComboBox<String> cbTipo;
    @FXML private TableView<Semilla> tableSemillas;
    @FXML private TableColumn<Semilla, String> colID;
    @FXML private TableColumn<Semilla, String> colNombre;
    @FXML private TableColumn<Semilla, String> colTipo;
    @FXML private TableColumn<Semilla, String> colCantidadDisponible;
    @FXML private TableColumn<Semilla, String> colTiempoCosecha;
    @FXML private TableColumn<Semilla, String> colOrigen;

    private ImplementacionCRUD servicio = new ImplementacionCRUD();

    /**
     * Inicializa el controlador.
     * 
     * Configura el ComboBox con los tipos de semilla, define la asignacion de las columnas de
     * la tabla y agrega un listener para cargar los datos de la semilla seleccionada en los campos.
     *
     * @param location URL de ubicacion de recursos.
     * @param resources Recursos de la aplicacion.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbTipo.getItems().addAll("Cereal", "Frutal", "Hortaliza", "Legumbre");
        colID.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getId()));
        colNombre.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNombre()));
        colTipo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getClass().getSimpleName()));
        colCantidadDisponible.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getCantidadDisponible())));
        colTiempoCosecha.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getTiempoDeCosecha())));
        colOrigen.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getOrigen()));
        tableSemillas.getSelectionModel().selectedItemProperty().addListener((obs, old, sel) -> {
            if (sel != null) cargarEnCampos(sel);
        });
        listarAll();
    }

    /**
     * Crea una nueva semilla a partir de los datos ingresados en los campos.
     * 
     * Dependiendo del tipo seleccionado en el ComboBox, se instancia la subclase correspondiente.
     */
    @FXML private void crear() {
        if (!validarNumeros()) return;
        String id = txtID.getText();
        String nombre = txtNombre.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        int tiempo = Integer.parseInt(txtTiempo.getText());
        String origen = txtOrigen.getText();
        String tipo = cbTipo.getSelectionModel().getSelectedItem();
        Semilla s = null;
        if (tipo.equals("Hortaliza")) {
            s = new Hortaliza(id, nombre, cantidad, tiempo, origen, "Tipo Hortaliza");
        } else if (tipo.equals("Legumbre")) {
            s = new Legumbre(id, nombre, cantidad, tiempo, origen, 20.0);
        } else if (tipo.equals("Cereal")) {
            s = new Cereal(id, nombre, cantidad, tiempo, origen, "Tipo Cereal");
        } else if (tipo.equals("Frutal")) {
            s = new Frutal(id, nombre, cantidad, tiempo, origen, "Mes Fructificacion");
        }
        if (s != null) {
            servicio.create(s);
            listarAll();
            limpiar();
        }
    }

    /**
     * Busca una semilla por su ID y la muestra en la tabla.
     * 
     * Si no se encuentra, muestra una alerta de error y limpia los campos.
     */
    @FXML private void leer() {
        String id = txtID.getText();
        Semilla s = servicio.read(id);
        if (s == null) {
            mostrarError("ID semilla no existe", "No se encontro semilla con ID " + id);
            limpiar();
        } else {
            tableSemillas.setItems(FXCollections.observableArrayList(s));
        }
    }

    /**
     * Actualiza la semilla con el ID especificado a partir de los datos ingresados.
     * 
     * Si la semilla no existe o los datos son invalidos, muestra una alerta.
     */
    @FXML private void actualizar() {
        String id = txtID.getText();
        if (servicio.read(id) == null) {
            mostrarError("ID semilla no existe", "No se encontro semilla con ID " + id);
            limpiar();
            return;
        }
        if (!validarNumeros()) return;
        String nombre = txtNombre.getText();
        int cantidad = Integer.parseInt(txtCantidad.getText());
        int tiempo = Integer.parseInt(txtTiempo.getText());
        String origen = txtOrigen.getText();
        String tipo = cbTipo.getSelectionModel().getSelectedItem();
        Semilla s = null;
        if (tipo.equals("Hortaliza")) {
            s = new Hortaliza(id, nombre, cantidad, tiempo, origen, "Tipo Hortaliza");
        } else if (tipo.equals("Legumbre")) {
            s = new Legumbre(id, nombre, cantidad, tiempo, origen, 20.0);
        } else if (tipo.equals("Cereal")) {
            s = new Cereal(id, nombre, cantidad, tiempo, origen, "Tipo Cereal");
        } else if (tipo.equals("Frutal")) {
            s = new Frutal(id, nombre, cantidad, tiempo, origen, "Mes Fructificacion");
        }
        if (s != null) {
            servicio.update(s);
            listarAll();
            limpiar();
        }
    }

    /**
     * Elimina la semilla con el ID ingresado.
     * 
     * En caso de que la semilla no exista, muestra una alerta de error.
     */
    @FXML private void eliminar() {
        String id = txtID.getText();
        if (servicio.read(id) == null) {
            mostrarError("ID semilla no existe", "No se encontro semilla con ID " + id);
            limpiar();
        } else {
            servicio.delete(id);
            listarAll();
            limpiar();
        }
    }

    /**
     * Muestra en la tabla todas las semillas existentes y limpia los campos de entrada.
     */
    @FXML private void leerTodo() {
        listarAll();
        limpiar();
    }

    /**
     * Serializa el arreglo de semillas a un archivo.
     * 
     * Luego, muestra informacion sobre el resultado de la operacion.
     */
    @FXML private void serializar() {
        String path = "semillas.dat";
        String msg = servicio.serializar(path);
        mostrarInfo("Serializar", msg);
    }

    /**
     * Deserializa las semillas desde un archivo, actualiza la tabla y muestra
     * informacion sobre el resultado de la operacion.
     */
    @FXML private void deserializar() {
        String path = "semillas.dat";
        String msg = servicio.deserializar(path);
        listarAll();
        mostrarInfo("Deserializar", msg);
    }

    /**
     * Lista todas las semillas obtenidas del servicio y actualiza la tabla.
     */
    private void listarAll() {
        Semilla[] arr = servicio.readAll();
        tableSemillas.setItems(FXCollections.observableArrayList(arr));
    }

    /**
     * Limpia todos los campos de entrada y la seleccion del ComboBox.
     */
    private void limpiar() {
        txtID.clear();
        txtNombre.clear();
        txtCantidad.clear();
        txtTiempo.clear();
        txtOrigen.clear();
        cbTipo.getSelectionModel().clearSelection();
    }

    /**
     * Valida que los valores de cantidad y tiempo sean enteros positivos.
     * 
     * @return true si ambos valores son validos; false de lo contrario.
     */
    private boolean validarNumeros() {
        try {
            int cantidad = Integer.parseInt(txtCantidad.getText());
            int tiempo = Integer.parseInt(txtTiempo.getText());
            if (cantidad < 0 || tiempo < 0) throw new NumberFormatException();
            return true;
        } catch (Exception e) {
            mostrarError("Valor invalido", "Cantidad y tiempo deben ser enteros positivos");
            return false;
        }
    }

    /**
     * Carga los datos de la semilla seleccionada en los campos de entrada.
     * 
     * @param sel La semilla seleccionada.
     */
    private void cargarEnCampos(Semilla sel) {
        txtID.setText(sel.getId());
        txtNombre.setText(sel.getNombre());
        txtCantidad.setText(String.valueOf(sel.getCantidadDisponible()));
        txtTiempo.setText(String.valueOf(sel.getTiempoDeCosecha()));
        txtOrigen.setText(sel.getOrigen());
        cbTipo.setValue(sel.getClass().getSimpleName());
    }

    /**
     * Muestra una alerta de error con el titulo y mensaje especificados.
     * 
     * @param titulo El titulo de la alerta.
     * @param mensaje El contenido de la alerta.
     */
    private void mostrarError(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(titulo);
        a.setContentText(mensaje);
        a.showAndWait();
    }

    /**
     * Muestra una alerta de informacion con el titulo y mensaje especificados.
     * 
     * @param titulo El titulo de la alerta.
     * @param mensaje El contenido de la alerta.
     */
    private void mostrarInfo(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setContentText(mensaje);
        a.showAndWait();
    }
}
