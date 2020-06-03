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
        atrVehiculoDB=new clsVehiculoImplMySql();
    }
     
    public boolean create(clsVehiculo prmVehiculo){
        return atrVehiculoDB.create(prmVehiculo);
    }
    public clsVehiculo find(String prmPlaca){
        return atrVehiculoDB.find(prmPlaca);
    }
}
