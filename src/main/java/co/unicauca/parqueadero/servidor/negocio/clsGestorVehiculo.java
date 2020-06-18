/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.negocio;

import co.unicauca.parqueadero.servidor.acceso.IVehiculo;
import co.unicauca.parqueadero.servidor.acceso.clsVehiculoImplMySql;

/**
 *
 * @author Fernando Campo
 */
public class clsGestorVehiculo {

    IVehiculo atrVehiculoDB;

    public clsGestorVehiculo() {
        atrVehiculoDB = new clsVehiculoImplMySql();
    }

    /**
     * Realiza un nuevo registro de vehiculo en la base de datos
     *
     * @param prmVehiculo Vehiculo que será registrado
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario.
     */
    public boolean create(clsVehiculo prmVehiculo) {
        return atrVehiculoDB.create(prmVehiculo);
    }

    /**
     * Recupera un vehiculo asociado a una placa dada
     *
     * @param prmPlaca Placa del vehiculo que se desea recuperar
     * @return Vehiculo recuperado
     */
    public clsVehiculo find(String prmPlaca) {
        return atrVehiculoDB.find(prmPlaca);
    }
}
