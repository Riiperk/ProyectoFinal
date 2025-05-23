package co.edu.poli.proyecto2.modelo;

import java.io.*;
import java.util.*;

/**
 * La clase Hortaliza extiende de Semilla y añade el atributo {@code tipoHortaliza}.
 * Representa una semilla destinada a hortalizas.
 * 
 * @author 
 * @version 1.0
 */
public class Hortaliza extends Semilla {
    private String tipoHortaliza;

    /**
     * Constructor para crear un objeto Hortaliza.
     *
     * @param id                Identificador de la semilla.
     * @param nombre            Nombre de la hortaliza.
     * @param cantidadDisponible Cantidad disponible.
     * @param tiempoDeCosecha   Tiempo de cosecha.
     * @param origen            Origen de la hortaliza.
     * @param tipoHortaliza     Tipo específico de hortaliza.
     */
    public Hortaliza(String id, String nombre, int cantidadDisponible, int tiempoDeCosecha, String origen, String tipoHortaliza) {
        super(id, nombre, cantidadDisponible, tiempoDeCosecha, origen);
        this.tipoHortaliza = tipoHortaliza;
    }

    /**
     * Retorna el tipo de hortaliza.
     *
     * @return el tipo de hortaliza.
     */
    public String getTipoHortaliza() {
        return tipoHortaliza;
    }

    /**
     * Asigna el tipo de hortaliza.
     *
     * @param tipoHortaliza el tipo a asignar.
     */
    public void setTipoHortaliza(String tipoHortaliza) {
        this.tipoHortaliza = tipoHortaliza;
    }

    /**
     * Devuelve una representación en cadena de la hortaliza, incluyendo la información de la semilla.
     *
     * @return cadena descriptiva de la hortaliza.
     */
    @Override
    public String toString() {
        return super.toString() + ", Tipo de Hortaliza: " + tipoHortaliza;
    }
}
