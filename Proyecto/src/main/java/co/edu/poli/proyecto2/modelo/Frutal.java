package co.edu.poli.proyecto2.modelo;

import java.io.*;
import java.util.*;

/**
 * La clase Frutal extiende de Semilla e introduce el atributo {@code mesFructificacion}.
 * Representa una semilla destinada a frutales.
 * 
 * @author 
 * @version 1.0
 */
public class Frutal extends Semilla {
    private String mesFructificacion;

    /**
     * Constructor para crear un objeto de tipo Frutal.
     *
     * @param id                Identificador de la semilla.
     * @param nombre            Nombre del frutal.
     * @param cantidadDisponible Cantidad disponible.
     * @param tiempoDeCosecha   Tiempo de cosecha.
     * @param origen            Origen del frutal.
     * @param mesFructificacion Mes en que fructifica.
     */
    public Frutal(String id, String nombre, int cantidadDisponible, int tiempoDeCosecha, String origen, String mesFructificacion) {
        super(id, nombre, cantidadDisponible, tiempoDeCosecha, origen);
        this.mesFructificacion = mesFructificacion;
    }

    /**
     * Retorna el mes de fructificación.
     *
     * @return el mes de fructificación.
     */
    public String getMesFructificacion() {
        return mesFructificacion;
    }

    /**
     * Establece el mes de fructificación.
     *
     * @param mesFructificacion el mes a asignar.
     */
    public void setMesFructificacion(String mesFructificacion) {
        this.mesFructificacion = mesFructificacion;
    }
}
