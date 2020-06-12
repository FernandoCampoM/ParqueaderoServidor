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
    String atrId="";
    String atrValorApagar="0";
    String atrIdRegistroParqueo="";
    
    public String getId() {
        return atrId;
    }

    public void setId(String prmId) {
        this.atrId = prmId;
    }

    public String getValorApagar() {
        return atrValorApagar;
    }

    public void setValorApagar(String prmValorApagar) {
        this.atrValorApagar = prmValorApagar;
    }

    public String getIdRegistroParqueo() {
        return atrIdRegistroParqueo;
    }

    public void setRegistroParqueo(String prmIdRegistroParqueo) {
        this.atrIdRegistroParqueo = prmIdRegistroParqueo;
    }
    
}
