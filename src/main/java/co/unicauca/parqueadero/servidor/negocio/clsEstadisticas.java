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
public class clsEstadisticas {
    private String atrHora="";
    private String atrNumeroEntradas="";
    /**
     * Recupera la hora
     * @return Hora
     */
    public String getHora() {
        return atrHora;
    }
    /**
     * Actualiza la hora
     * @param prmHora Nueva Hora
     */
    public void setHora(String prmHora) {
        atrHora = prmHora;
    }
    /**
     * Recupera el nuemro de entradas
     * @return Numero de entradas
     */
    public String getNumeroEntradas() {
        return atrNumeroEntradas;
    }
    /**
     * Actualiza el nuemro d entradas.
     * @param prmNumeroEntradas Numero de entradas.
     */
    public void setNumeroEntradas(String prmNumeroEntradas) {
        atrNumeroEntradas = prmNumeroEntradas;
    }
    
}
