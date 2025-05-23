package co.edu.poli.proyecto2.modelo;

import java.io.*;
import java.util.*;

/**
 * La clase Cereal extiende de Semilla e introduce el atributo {@code tipoSuelo}.
 * Representa una semilla destinada a cereales.
 * 
 * @author 
 * @version 1.0
 */
public class Cereal extends Semilla {
    private String tipoSuelo;

    /**
     * Constructor para un objeto de tipo Cereal.
     *
     * @param id                Identificador de la semilla.
     * @param nombre            Nombre del cereal.
     * @param cantidadDisponible Cantidad disponible.
     * @param tiempoDeCosecha   Tiempo de cosecha.
     * @param origen            Origen del cereal.
     * @param tipoSuelo         Tipo de suelo adecuado.
     */
    public Cereal(String id, String nombre, int cantidadDisponible, int tiempoDeCosecha, String origen, String tipoSuelo) {
        super(id, nombre, cantidadDisponible, tiempoDeCosecha, origen);
        this.tipoSuelo = tipoSuelo;
    }

    /**
     * Retorna el tipo de suelo.
     *
     * @return el tipo de suelo.
     */
    public String getTipoSuelo() {
        return tipoSuelo;
    }

    /**
     * Asigna el tipo de suelo.
     *
     * @param tipoSuelo el tipo de suelo a asignar.
     */
    public void setTipoSuelo(String tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }

    /**
     * Devuelve la representación en cadena del cereal.
     *
     * @return cadena que incluye la información general y el tipo de suelo.
     */
    @Override
    public String toString() {
        return super.toString() + ", Tipo de Suelo: " + tipoSuelo;
    }
}
