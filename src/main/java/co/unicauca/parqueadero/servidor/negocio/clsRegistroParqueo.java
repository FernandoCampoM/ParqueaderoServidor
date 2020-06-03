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
    private clsVehiculo atrVehiculo;
    private clsUsuario atrUsuario;
    private clsFicha atrFicha;
    private String atrNombresApellidosProp;
    private String atrFechaHoraEntrada;
    private String atrFechaHoraSalida;
    private String atrNumeroCascos;
    private String atrNumeroCasillero;

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

    public clsFicha getFicha() {
        return atrFicha;
    }

    public void setFicha(clsFicha prmFicha) {
        this.atrFicha = prmFicha;
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
