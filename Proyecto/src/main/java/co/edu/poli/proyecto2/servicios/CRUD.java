package co.edu.poli.proyecto2.servicios;

import co.edu.poli.proyecto2.modelo.Semilla;
import java.io.*;
import java.util.*;

/**
 * Interfaz que define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para objetos de tipo {@link Semilla}.
 *
 * @version 1.0
 */
public interface CRUD {
    /**
     * Crea una nueva semilla.
     *
     * @param semilla el objeto semilla a crear.
     * @return mensaje confirmando la creación.
     */
    String create(Semilla semilla);

    /**
     * Leyendo una semilla a partir de su id.
     *
     * @param id el identificador de la semilla.
     * @return la semilla encontrada o {@code null} si no existe.
     */
    Semilla read(String id);

    /**
     * Retorna todas las semillas almacenadas.
     *
     * @return un arreglo de {@code Semilla}.
     */
    Semilla[] readAll();

    /**
     * Actualiza la información de una semilla existente.
     *
     * @param semilla la semilla con datos actualizados.
     * @return mensaje indicando el resultado de la operación.
     */
    String update(Semilla semilla);

    /**
     * Elimina una semilla a partir de su id.
     *
     * @param id el identificador de la semilla a eliminar.
     * @return mensaje indicando el resultado de la eliminación.
     */
    String delete(String id);
}