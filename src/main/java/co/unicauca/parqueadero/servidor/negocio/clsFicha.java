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
public class clsFicha {
     private String atrCodigoBarras="";
     public clsFicha(String prmCodigoBarras){
         atrCodigoBarras=prmCodigoBarras;
     }
    public String getCodigoBarras() {
        return atrCodigoBarras;
    }

    public void setCodigoBarras(String prmCodigoBarras) {
        this.atrCodigoBarras = prmCodigoBarras;
    }
    
}
