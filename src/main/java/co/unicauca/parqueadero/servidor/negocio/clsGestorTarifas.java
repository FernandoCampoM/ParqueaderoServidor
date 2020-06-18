/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.negocio;

import co.unicauca.parqueadero.servidor.acceso.*;
import java.util.List;

/**
 *
 * @author Fernando Campo
 */
public class clsGestorTarifas {

    List<clsTarifas> atrTarifas;
    ITarifas tarifaBD;

    public clsGestorTarifas() {
        tarifaBD = new clsTarifasImplMySql();
        cargarTarifas();
    }

    /**
     * Recupera las tarifas de la base de datos
     */
    private void cargarTarifas() {
        atrTarifas = tarifaBD.getTarifas();
    }

    /**
     * Devuelve una tarifa de acuerdo al tipo de vehiculo y el tipo de tarifa.
     *
     * @param prmTipoVehiculo Tipo de vehiculo
     * @param prmTipoTarifa Tipo Tarifa.
     * @return
     */
    public clsTarifas selectTarifa(String prmTipoVehiculo, String prmTipoTarifa) {
        clsTarifas obj = null;
        for (clsTarifas objTarifa : atrTarifas) {
            if (objTarifa.getTipoVehiculo().equals(prmTipoVehiculo) && objTarifa.getTipoTarifa().equals(prmTipoTarifa)) {
                obj = objTarifa;
            }
        }
        return obj;
    }

}
