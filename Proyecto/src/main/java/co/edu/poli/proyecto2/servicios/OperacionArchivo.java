package co.edu.poli.proyecto2.servicios;

import java.io.*;
import java.util.*;

/**
 * Interfaz que define métodos para serializar y deserializar
 * objetos en una ruta de archivo.
 *
 * @version 1.0
 */
public interface OperacionArchivo {
    /**
     * Serializa objetos y los guarda en una ruta especificada.
     *
     * @param path la ruta de archivo donde se escribirá la serialización.
     * @return mensaje indicando el resultado de la operación.
     */
    String serializar(String path);

    /**
     * Deserializa objetos desde una ruta de archivo especificada.
     *
     * @param path la ruta del archivo a leer.
     * @return mensaje indicando el resultado de la operación.
     */
    String deserializar(String path);
}
