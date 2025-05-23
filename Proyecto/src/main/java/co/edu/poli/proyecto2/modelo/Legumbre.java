package co.edu.poli.proyecto2.modelo;

import java.io.*;
import java.util.*;

/**
 * La clase Legumbre extiende de Semilla y añade el atributo {@code temperaturaIdeal}.
 * Representa una semilla destinada a legumbres.
 * 
 * @author 
 * @version 1.0
 */
public class Legumbre extends Semilla {
    private double temperaturaIdeal;

    /**
     * Constructor para crear un objeto Legumbre.
     *
     * @param id                Identificador de la semilla.
     * @param nombre            Nombre de la legumbre.
     * @param cantidadDisponible Cantidad disponible.
     * @param tiempoDeCosecha   Tiempo de cosecha.
     * @param origen            Origen de la legumbre.
     * @param temperaturaIdeal  Temperatura ideal para su crecimiento.
     */
    public Legumbre(String id, String nombre, int cantidadDisponible, int tiempoDeCosecha, String origen, double temperaturaIdeal) {
        super(id, nombre, cantidadDisponible, tiempoDeCosecha, origen);
        this.temperaturaIdeal = temperaturaIdeal;
    }

    /**
     * Retorna la temperatura ideal.
     *
     * @return la temperatura ideal.
     */
    public double getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    /**
     * Establece la temperatura ideal.
     *
     * @param temperaturaIdeal la temperatura a asignar.
     */
    public void setTemperaturaIdeal(double temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    /**
     * Devuelve una representación en cadena de la legumbre.
     *
     * @return cadena descriptiva que incluye la información de la semilla y la temperatura ideal.
     */
    @Override
    public String toString() {
        return super.toString() + ", Temperatura Ideal: " + temperaturaIdeal;
    }
}
