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
public class clsTarifas {
    private String atrTipoTarifa="";
    private String atrCosto="";
    private String atrTipoVehiculo="";
    
    public String getTipoTarifa() {
        return atrTipoTarifa;
    }

    public void setTipoTarifa(String prmTipoTarifa) {
        this.atrTipoTarifa = prmTipoTarifa;
    }

    public String getCosto() {
        return atrCosto;
    }

    public void setCosto(String prmCosto) {
        this.atrCosto = prmCosto;
    }

    public String getTipoVehiculo() {
        return atrTipoVehiculo;
    }

    public void setTipoVehiculo(String prmTipoVehiculo) {
        this.atrTipoVehiculo = prmTipoVehiculo;
    }
}
