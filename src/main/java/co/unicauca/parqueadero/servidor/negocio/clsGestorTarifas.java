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
        tarifaBD=new clsTarifasImplMySql();
        cargarTarifas();
    }
    
    private void cargarTarifas(){
        atrTarifas=tarifaBD.getTarifas();
    }
    public clsTarifas selectTarifa(String prmTipoVehiculo, String prmTipoTarifa){
        clsTarifas obj=null;
        for (clsTarifas objTarifa : atrTarifas) {
            if(objTarifa.getTipoVehiculo().equals(prmTipoVehiculo) && objTarifa.getTipoTarifa().equals(prmTipoTarifa))
                obj= objTarifa;
        }
            return obj;
    }
    
}
