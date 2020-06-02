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
public abstract class  clsUsuario {
    private String atrCedula;
    private String atrNombres;
    private String atrApellidos;
    private String atrRol;
    private String atrLogin;
    private String atrPassword;
    public clsUsuario(String prmCedula, String prmNombres, String prmApellidos, String prmRol, String prmLogin, String prmPassword) {
        atrCedula = prmCedula;
        atrNombres = prmNombres;
        atrApellidos = prmApellidos;
        atrRol = prmRol;
        atrLogin = prmLogin;
        atrPassword = prmPassword;
    }

    public String getAtrCedula() {
        return atrCedula;
    }

    public void setAtrCedula(String prmCedula) {
        this.atrCedula = atrCedula;
    }

    public String getAtrNombres() {
        return atrNombres;
    }

    public void setAtrNombres(String prmNombres) {
        this.atrNombres = atrNombres;
    }

    public String getAtrApellidos() {
        return atrApellidos;
    }

    public void setAtrApellidos(String prmApellidos) {
        this.atrApellidos = atrApellidos;
    }

    public String getAtrRol() {
        return atrRol;
    }

    public void setAtrRol(String prmRol) {
        this.atrRol = atrRol;
    }

    public String getAtrLogin() {
        return atrLogin;
    }

    public void setAtrLogin(String prmLogin) {
        this.atrLogin = atrLogin;
    }

    public String getAtrPassword() {
        return atrPassword;
    }

    public void setAtrPassword(String prmPassword) {
        this.atrPassword = atrPassword;
    }
    public boolean registrarEntrada(){
        return false;
    }
}
