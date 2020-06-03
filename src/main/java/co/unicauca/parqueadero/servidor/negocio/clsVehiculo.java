/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.negocio;

/**
 *
 * @author Fernando Campo
 */
public class clsVehiculo {

    
    private String atrPlaca="";
    private String atrTipoVehiculo="";

    public clsVehiculo(String prmPlaca, String prmTipoVehiculo) {
        atrPlaca=prmPlaca;
        atrTipoVehiculo=prmTipoVehiculo;
    }
    public clsVehiculo(){
        
    }

    public String getPlaca() {
        return atrPlaca;
    }

    public void setPlaca(String prmPlaca) {
        this.atrPlaca = prmPlaca;
    }

    public String getTipoVehiculo() {
        return atrTipoVehiculo;
    }

    public void setTipoVehiculo(String prmTipoVehiculo) {
        this.atrTipoVehiculo = prmTipoVehiculo;
    }
    
}
