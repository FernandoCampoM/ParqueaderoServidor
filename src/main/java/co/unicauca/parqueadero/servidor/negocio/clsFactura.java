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
public class clsFactura {

    String atrId = "";
    String atrValorApagar = "0";
    String atrIdRegistroParqueo = "";

    /**
     * Recupera el id de la factura.
     *
     * @return Id de la factura.
     */
    public String getId() {
        return atrId;
    }

    /**
     * Actualiza el id de la factura
     *
     * @param prmId Nuevo Id
     */
    public void setId(String prmId) {
        this.atrId = prmId;
    }

    /**
     * Recupera el valor a pagar.
     *
     * @return Valor a pagar
     */
    public String getValorApagar() {
        return atrValorApagar;
    }

    /**
     * Atualiza el alro a pagar.
     *
     * @param prmValorApagar Nuevo valor a pagar.
     */
    public void setValorApagar(String prmValorApagar) {
        this.atrValorApagar = prmValorApagar;
    }

    /**
     * Recupera el id del registro parqueo asociado a una factura.
     *
     * @return Id registro parqueo
     */
    public String getIdRegistroParqueo() {
        return atrIdRegistroParqueo;
    }

    /**
     * Actualiza el id del registro parqueo asociado a una factura
     *
     * @param prmIdRegistroParqueo Nuevo id registro parqueo
     */
    public void setRegistroParqueo(String prmIdRegistroParqueo) {
        this.atrIdRegistroParqueo = prmIdRegistroParqueo;
    }

}
