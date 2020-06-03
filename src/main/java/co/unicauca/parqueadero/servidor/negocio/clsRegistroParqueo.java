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
public class clsRegistroParqueo {
    private clsVehiculo  atrVehiculo=null;
    private clsUsuario atrUsuario=null;
    private String atrCodigoBarras="";
    private String atrNombresApellidosProp="";
    private String atrFechaHoraEntrada="";
    private String atrFechaHoraSalida="";
    private String atrNumeroCascos="";
    private String atrNumeroCasillero="";
    private String atrDejaLlaves="";
    private String atrObservaciones="";
    private String atrIdParqueadero="";

    

    public clsRegistroParqueo(clsUsuario prmUsuario, clsVehiculo prmVehiculo, String prmCodigoBarras, String prmIdParqueadero, String prmNombresApellidosProp, String prmFechaHoraEntrada, String prmNumeroCascos, String prmNumeroCasillero, String prmDejaLlaves, String prmObservaciones) {
        this.atrUsuario = prmUsuario;
        atrVehiculo=prmVehiculo;
        atrCodigoBarras=prmCodigoBarras;
        atrIdParqueadero=prmIdParqueadero;
        this.atrNombresApellidosProp = prmNombresApellidosProp;
        this.atrFechaHoraEntrada = prmFechaHoraEntrada;
        this.atrNumeroCascos = prmNumeroCascos;
        this.atrNumeroCasillero = prmNumeroCasillero;
        this.atrDejaLlaves = prmDejaLlaves;
        atrObservaciones=prmObservaciones;
    }
    public clsRegistroParqueo(){
        
    }
    public String getIdParqueadero() {
        return atrIdParqueadero;
    }

    public void setIdParqueadero(String prmIdParqueadero) {
        this.atrIdParqueadero = prmIdParqueadero;
    }

    public String getObservaciones() {
        return atrObservaciones;
    }

    public void setObservaciones(String prmObservaciones) {
        this.atrObservaciones = prmObservaciones;
    }
    public String getDejaLlaves() {
        return atrDejaLlaves;
    }

    public void setDejaLlaves(String prmDejaLlaves) {
        this.atrDejaLlaves = prmDejaLlaves;
    }
    

    public clsVehiculo getVehiculo() {
        return atrVehiculo;
    }

    public void setVehiculo(clsVehiculo prmVehiculo) {
        this.atrVehiculo = prmVehiculo;
    }

    public clsUsuario getUsuario() {
        return atrUsuario;
    }

    public void setUsuario(clsUsuario prmUsuario) {
        this.atrUsuario = prmUsuario;
    }

    public String getCodigoBarras() {
        return atrCodigoBarras;
    }

    public void setCodigoBarras(String prmCodigoBarras) {
        this.atrCodigoBarras = prmCodigoBarras;
    }

    
    

    public String getNombresApellidosProp() {
        return atrNombresApellidosProp;
    }

    public void setNombresApellidosProp(String prmNombresApellidosProp) {
        this.atrNombresApellidosProp = prmNombresApellidosProp;
    }

    public String getFechaHoraEntrada() {
        return atrFechaHoraEntrada;
    }

    public void setFechaHoraEntrada(String prmFechaHoraEntrada) {
        this.atrFechaHoraEntrada = prmFechaHoraEntrada;
    }

    public String getFechaHoraSalida() {
        return atrFechaHoraSalida;
    }

    public void setFechaHoraSalida(String prmFechaHoraSalida) {
        this.atrFechaHoraSalida = prmFechaHoraSalida;
    }

    public String getNumeroCascos() {
        return atrNumeroCascos;
    }

    public void setNumeroCascos(String prmNumeroCascos) {
        this.atrNumeroCascos = prmNumeroCascos;
    }

    public String getNumeroCasillero() {
        return atrNumeroCasillero;
    }

    public void setNumeroCasillero(String prmNumeroCasillero) {
        this.atrNumeroCasillero = prmNumeroCasillero;
    }
    
}
