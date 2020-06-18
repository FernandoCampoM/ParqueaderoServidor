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

    private String atrTipoTarifa = "";
    private String atrCosto = "";
    private String atrTipoVehiculo = "";

    /**
     * Recupera el tipo de tarifa.
     *
     * @return Tipo tarifa
     */
    public String getTipoTarifa() {
        return atrTipoTarifa;
    }

    /**
     * Actualia el tipo de tarifa
     *
     * @param prmTipoTarifa Nuvo tipo tarifa
     */
    public void setTipoTarifa(String prmTipoTarifa) {
        this.atrTipoTarifa = prmTipoTarifa;
    }

    /**
     * Recupera el costo
     *
     * @return Costo
     */
    public String getCosto() {
        return atrCosto;
    }

    /**
     * Actualiza el costo
     *
     * @param prmCosto Nuevo costo
     */
    public void setCosto(String prmCosto) {
        this.atrCosto = prmCosto;
    }

    /**
     * Recupera el tipo de vehiculo.
     *
     * @return Nuevo tipo de vehiculo.
     */
    public String getTipoVehiculo() {
        return atrTipoVehiculo;
    }

    /**
     * Actualiza el tipo de vehiculo.
     *
     * @param prmTipoVehiculo
     */
    public void setTipoVehiculo(String prmTipoVehiculo) {
        this.atrTipoVehiculo = prmTipoVehiculo;
    }
}
