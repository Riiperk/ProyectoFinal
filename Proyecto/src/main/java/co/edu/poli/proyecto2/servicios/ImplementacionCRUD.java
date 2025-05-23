package co.edu.poli.proyecto2.servicios;

import co.edu.poli.proyecto2.modelo.Semilla;
import java.io.*;
import java.util.*;
import java.util.Arrays;

/**
 * La clase ImplementacionCRUD implementa las interfaces {@link CRUD} y {@link OperacionArchivo}.
 * Proporciona operaciones para crear, leer, actualizar y eliminar semillas, además de métodos
 * para serializar y deserializar el arreglo de semillas.
 *
 * @version 1.0
 */
public class ImplementacionCRUD implements CRUD, OperacionArchivo {
    private Semilla[] semillas;
    private int count;
    
    /**
     * Constructor que inicializa el arreglo de semillas con un tamaño inicial de 10.
     */
    public ImplementacionCRUD() {
        semillas = new Semilla[10];
        count = 0;
    }
    
    /**
     * Expande el arreglo de semillas duplicando su tamaño.
     */
    private void expandArray() {
        semillas = Arrays.copyOf(semillas, semillas.length * 2);
    }
    
    /**
     * Crea una nueva semilla y la agrega al arreglo.
     *
     * @param semilla la semilla a crear.
     * @return mensaje confirmando la creación.
     */
    @Override
    public String create(Semilla semilla) {
        if (count == semillas.length) {
            expandArray();
        }
        semillas[count++] = semilla;
        return "Semilla creada exitosamente.";
    }
    
    /**
     * Busca y retorna una semilla por su id.
     *
     * @param id el identificador de la semilla.
     * @return la semilla encontrada o {@code null} si no se encuentra.
     */
    @Override
    public Semilla read(String id) {
        for (int i = 0; i < count; i++) {
            if (semillas[i].getId().equals(id)) {
                return semillas[i];
            }
        }
        return null;
    }
    
    /**
     * Retorna un arreglo de todas las semillas almacenadas.
     *
     * @return un arreglo con las semillas actuales.
     */
    @Override
    public Semilla[] readAll() {
        return Arrays.copyOf(semillas, count);
    }
    
    /**
     * Actualiza una semilla existente en función de su id.
     *
     * @param semilla la semilla con datos actualizados.
     * @return mensaje indicando si la actualización fue exitosa.
     */
    @Override
    public String update(Semilla semilla) {
        for (int i = 0; i < count; i++) {
            if (semillas[i].getId().equals(semilla.getId())) {
                semillas[i] = semilla;
                return "Semilla actualizada exitosamente.";
            }
        }
        return "No se encontró la semilla a actualizar.";
    }
    
    /**
     * Elimina una semilla del arreglo a partir de su id.
     *
     * @param id el identificador de la semilla a eliminar.
     * @return mensaje indicando si la eliminación fue exitosa.
     */
    @Override
    public String delete(String id) {
        for (int i = 0; i < count; i++) {
            if (semillas[i].getId().equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    semillas[j] = semillas[j + 1];
                }
                semillas[--count] = null;
                return "Semilla eliminada exitosamente.";
            }
        }
        return "No se encontró la semilla a eliminar.";
    }
    
    /**
     * Serializa el arreglo actual de semillas en la ruta de archivo especificada.
     *
     * @param path la ruta donde se guardará la serialización.
     * @return mensaje indicando el resultado de la operación.
     */
    @Override
    public String serializar(String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(readAll());
            return "Serialización exitosa. Archivo guardado en " + path;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error durante la serialización: " + e.getMessage();
        }
    }
    
    /**
     * Deserializa un arreglo de semillas desde la ruta de archivo especificada y
     * actualiza el arreglo interno.
     *
     * @param path la ruta del archivo a leer.
     * @return mensaje indicando el resultado de la operación.
     */
    @Override
    public String deserializar(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Semilla[] loaded = (Semilla[]) ois.readObject();
            semillas = loaded;
            count = loaded.length;
            return "Deserialización exitosa. Datos cargados desde " + path;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return "Error durante la deserialización: " + e.getMessage();
        }
    }
}
