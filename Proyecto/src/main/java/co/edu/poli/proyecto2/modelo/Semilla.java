package co.edu.poli.proyecto2.modelo;

import java.io.*;
import java.util.*;

/**
 * La clase Semilla representa una semilla con atributos básicos como id, nombre,
 * cantidad disponible, tiempo de cosecha y origen. Esta clase implementa {@link Serializable}
 * para permitir la serialización de sus instancias.
 * 
 * @author 
 * @version 1.0
 */
public class Semilla implements Serializable {
    private String id;
    private String nombre;
    private int cantidadDisponible;
    private int tiempoDeCosecha;
    private String origen;

    /**
     * Constructor para inicializar la semilla.
     *
     * @param id                Identificador de la semilla.
     * @param nombre            Nombre de la semilla.
     * @param cantidadDisponible Cantidad disponible.
     * @param tiempoDeCosecha   Tiempo de cosecha.
     * @param origen            Origen de la semilla.
     */
    public Semilla(String id, String nombre, int cantidadDisponible, int tiempoDeCosecha, String origen) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.tiempoDeCosecha = tiempoDeCosecha;
        this.origen = origen;
    }

    /**
     * Retorna el id de la semilla.
     *
     * @return el id.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el id de la semilla.
     *
     * @param id el nuevo id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retorna el nombre de la semilla.
     *
     * @return el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la semilla.
     *
     * @param nombre el nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la cantidad disponible.
     *
     * @return la cantidad disponible.
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Establece la cantidad disponible de la semilla.
     *
     * @param cantidadDisponible la cantidad a asignar.
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Retorna el tiempo de cosecha.
     *
     * @return el tiempo de cosecha.
     */
    public int getTiempoDeCosecha() {
        return tiempoDeCosecha;
    }

    /**
     * Establece el tiempo de cosecha.
     *
     * @param tiempoDeCosecha el tiempo a asignar.
     */
    public void setTiempoDeCosecha(int tiempoDeCosecha) {
        this.tiempoDeCosecha = tiempoDeCosecha;
    }

    /**
     * Retorna el origen de la semilla.
     *
     * @return el origen.
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Establece el origen de la semilla.
     *
     * @param origen el origen a asignar.
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * Devuelve una representación en cadena de la semilla.
     *
     * @return cadena descriptiva de la semilla.
     */
    @Override
    public String toString() {
        return "Semilla [id=" + id + ", nombre=" + nombre + ", cantidad Disponible=" + cantidadDisponible
                + ", tiempo de cosecha=" + tiempoDeCosecha + ", origen=" + origen + "]";
    }
}
