/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.negocio;
import co.unicauca.parqueadero.servidor.acceso.*;
/**
 *
 * @author Fernando Campo
 */
public class clsGestorFacturas {
    clsGestorTarifas atrGestorTarifas=new clsGestorTarifas();
    IFactura atrFacturaDB;
    public clsGestorFacturas() {
        atrFacturaDB=new clsFacturaImplMySql();
    }
    public boolean guardar(clsFactura prmFactura){
        return atrFacturaDB.guardar(prmFactura);
    }
    public int valorApagar(String prmTipoVehiculo,int prmDias, int prmHoras,int prmMinutos){
        int valorApagar=0;
        int costo=0;
        int temporal=0;
        if(prmDias==0){
            if(prmHoras>=0 && prmHoras<2){
                if(prmMinutos>0)
                    temporal=1;
            }
            costo=Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "HORA").getCosto());
        }
        return valorApagar;
    }
    
}
