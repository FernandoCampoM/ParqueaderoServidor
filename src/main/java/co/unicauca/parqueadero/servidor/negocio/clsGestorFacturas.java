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

    clsGestorTarifas atrGestorTarifas = new clsGestorTarifas();
    IFactura atrFacturaDB;

    public clsGestorFacturas() {
        atrFacturaDB = new clsFacturaImplMySql();
    }

    /**
     * Guarda una factura en la base de datos.
     *
     * @param prmFactura
     * @return Verdadero si el proceso fue exitoso. Falso de lo ocntrario.
     */
    public boolean guardar(clsFactura prmFactura) {
        return atrFacturaDB.guardar(prmFactura);
    }

    /**
     * Calcula el valor a pagar de acuerdo al tipo de vehiculo y el tiempo
     * transcurrido.
     *
     * @param prmTipoVehiculo Tipo de vehiculo
     * @param prmDias Dias transcurridos
     * @param prmHoras Horas transcurridas
     * @param prmMinutos Minutos transcurridos
     * @param prmSegundos Segundos transcurridos.
     * @return valor a pagar
     */
    public int valorApagar(String prmTipoVehiculo, int prmDias, int prmHoras, int prmMinutos, int prmSegundos) {
        if (prmSegundos > 0) {
            prmMinutos = prmMinutos + 1;
            if (prmMinutos == 60) {
                prmHoras = prmHoras + 1;
                prmMinutos = 0;
                if (prmHoras == 24) {
                    prmDias = prmDias + 1;
                    prmHoras = 0;
                }
            }
        }
        int valorApagar = 0;
        if (prmMinutos > 0) {
            valorApagar = Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "HORA").getCosto());
        }
        valorApagar = valorApagar + valorApagarH(prmTipoVehiculo, prmHoras);
        valorApagar = valorApagar + valorApagarD(prmTipoVehiculo, prmDias);
        return valorApagar;
    }

    /**
     * Calcula el valor a pagar de acuerdo al tipo de vehiculo y dias
     * transcurridos.
     *
     * @param prmTipoVehiculo Tipo de vehiculo
     * @param prmDias Dias transcurridos.
     * @return Valor a pagar
     */
    private int valorApagarD(String prmTipoVehiculo, int prmDias) {
        int valorApagar = 0;
        int costo = 0;
        int quincena = 15;
        int factorDiferencial = 0;

        if (prmDias >= 0 && prmDias <= 3) {
            costo = Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "DIA").getCosto());
            valorApagar = prmDias * costo;
            costo = Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "NOCHE").getCosto());
            valorApagar = valorApagar + (prmDias * costo);
        } else if (prmDias >= 4 && prmDias <= 18) {
            costo = Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "QUINCENA").getCosto());
            factorDiferencial = prmDias - quincena;
            factorDiferencial = factorDiferencial * (costo / quincena);
            valorApagar = costo + factorDiferencial;
        } else if (prmDias > 18 && prmDias < 30) {
            costo = Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "MES").getCosto());
            factorDiferencial = prmDias - 30;
            factorDiferencial = factorDiferencial * (costo / 30);
            valorApagar = costo + factorDiferencial;
        }
        return valorApagar;
    }

    /**
     * Calcula el valor a pagar de acuerdo al tipo de vehiculo y horas
     * transcurridas.
     *
     * @param prmTipoVehiculo Tipo de vehiculo
     * @param prmHoras Horas transcurridas.
     * @return Valor a pagar
     */
    private int valorApagarH(String prmTipoVehiculo, int prmHoras) {
        int valorApagar = 0;
        int costo = 0;
        int mediodia = 6;
        int factorDiferencial = 0;
        try {
            if (prmHoras >= 0 && prmHoras <= 3) {

                costo = Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "HORA").getCosto());
                valorApagar = prmHoras * costo;
            } else if (prmHoras >= 4 && prmHoras < 12) {
                costo = Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "MEDIODIA").getCosto());
                factorDiferencial = prmHoras - mediodia;
                factorDiferencial = factorDiferencial * (costo / mediodia);
                valorApagar = costo + factorDiferencial;
            } else if (prmHoras >= 12 && prmHoras < 24) {
                costo = Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "DIA").getCosto());
                costo = costo + Integer.parseInt(atrGestorTarifas.selectTarifa(prmTipoVehiculo, "NOCHE").getCosto());
                factorDiferencial = prmHoras - 24;
                factorDiferencial = factorDiferencial * (costo / 24);
                valorApagar = costo + factorDiferencial;
            }
        } catch (Exception e) {
            System.out.println("Error valorApagarH: " + e.getMessage());
        }
        return valorApagar;
    }
}
