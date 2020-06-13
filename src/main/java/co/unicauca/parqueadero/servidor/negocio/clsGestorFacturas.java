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
        if(prmMinutos>15){
            valorApagar=Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "HORA").getCosto());
        }
        valorApagar=valorApagar+valorApagarH(prmTipoVehiculo, prmHoras);
        valorApagar=valorApagar+valorApagarD(prmTipoVehiculo, prmDias);
        return valorApagar;
    }
    private int valorApagarD(String prmTipoVehiculo,int prmDias){
         int valorApagar=0;
        int costo=0;
        int quincena=15;
        int factorDiferencial=0;
        
        if(prmDias>=0 && prmDias<=3){
            costo=Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "DIA").getCosto());
            valorApagar=prmDias*costo;
            costo=Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "NOCHE").getCosto());
            valorApagar=valorApagar+(prmDias*costo);
        }else if(prmDias>=4 && prmDias<=18){
            costo=Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "QUINCENA").getCosto());
            factorDiferencial=prmDias-quincena;
            factorDiferencial=factorDiferencial*(costo/quincena);
            valorApagar=costo+factorDiferencial;
        }else if (prmDias>18 && prmDias<30){
            costo=Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "MES").getCosto());
            factorDiferencial=prmDias-30;
            factorDiferencial=factorDiferencial*(costo/30);
            valorApagar=costo+factorDiferencial;
        }
        return valorApagar;
    }
    private int valorApagarH(String prmTipoVehiculo,int prmHoras){
         int valorApagar=0;
        int costo=0;
        int mediodia=6;
        int factorDiferencial=0;
        
        if(prmHoras>=0 && prmHoras<=3){
            costo=Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "HORA").getCosto());
            valorApagar=prmHoras*costo;
        }else if(prmHoras>=4 && prmHoras<12){
            costo=Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "MEDIODIA").getCosto());
            factorDiferencial=prmHoras-mediodia;
            factorDiferencial=factorDiferencial*(costo/mediodia);
            valorApagar=costo+factorDiferencial;
        }else if (prmHoras>=12 && prmHoras<24){
            costo=Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "DIA").getCosto());
            costo=costo+Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "NOCHE").getCosto());
            factorDiferencial=prmHoras-24;
            factorDiferencial=factorDiferencial*(costo/24);
            valorApagar=costo+factorDiferencial;
        }
        return valorApagar;
    }
}
