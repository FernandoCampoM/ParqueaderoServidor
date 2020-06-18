/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.*;
import java.util.List;

/**
 *
 * @author Fernando Campo
 */
public interface ITarifas {

    /**
     * Guarda una nueva tarifa en la base de datos.
     *
     * @param prmTarifas Tarifa que se desea guardar
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario.
     */
    public boolean crear(clsTarifas prmTarifas);

    /**
     * Actualiza una tarifa en la base de datos.
     *
     * @param prmTarifas Tarifa que se desea actualizar.
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario.
     */
    public boolean update(clsTarifas prmTarifas);

    /**
     * Recupera todas las tarifas de la base de datos.
     *
     * @return Lista de tarifas recuperadas.
     */
    public List<clsTarifas> getTarifas();
}
