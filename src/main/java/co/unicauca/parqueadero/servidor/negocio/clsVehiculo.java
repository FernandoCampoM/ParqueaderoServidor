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

    private String atrPlaca = "";
    private String atrTipoVehiculo = "";

    public clsVehiculo(String prmPlaca, String prmTipoVehiculo) {
        atrPlaca = prmPlaca;
        atrTipoVehiculo = prmTipoVehiculo;
    }

    public clsVehiculo() {

    }

    /**
     * Recupera la placa del veiculo.
     *
     * @return Placa
     */
    public String getPlaca() {
        return atrPlaca;
    }

    /**
     * Actualiza la placa
     *
     * @param prmPlaca Nueva placa
     */
    public void setPlaca(String prmPlaca) {
        this.atrPlaca = prmPlaca;
    }

    /**
     * Recupera el tipo de vehiculo
     *
     * @return TipoVehiculo.
     */
    public String getTipoVehiculo() {
        return atrTipoVehiculo;
    }

    /**
     * Actualiza el tipo de vehiculo.
     *
     * @param prmTipoVehiculo Nuevo tipo de vehiculo.
     */
    public void setTipoVehiculo(String prmTipoVehiculo) {
        this.atrTipoVehiculo = prmTipoVehiculo;
    }

}
