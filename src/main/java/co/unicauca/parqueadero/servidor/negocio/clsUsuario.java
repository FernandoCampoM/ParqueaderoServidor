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
public class clsUsuario {

    private String atrCedula = "";
    private String atrNombres = "";
    private String atrApellidos = "";
    private String atrRol = "";
    private String atrLogin = "";
    private String atrPassword = "";

    public clsUsuario(String prmCedula, String prmNombres, String prmApellidos, String prmRol, String prmLogin, String prmPassword) {
        atrCedula = prmCedula;
        atrNombres = prmNombres;
        atrApellidos = prmApellidos;
        atrRol = prmRol;
        atrLogin = prmLogin;
        atrPassword = prmPassword;
    }

    public clsUsuario() {

    }

    /**
     * Recupera la cedula del usuario.
     *
     * @return Cedula
     */
    public String getAtrCedula() {
        return atrCedula;
    }

    /**
     * Actualiza la cedula
     *
     * @param prmCedula Nueva cedula
     */
    public void setAtrCedula(String prmCedula) {
        this.atrCedula = prmCedula;
    }

    /**
     * Recupera los nombres
     *
     * @return Nombres
     */
    public String getAtrNombres() {
        return atrNombres;
    }

    /**
     * Actualiza los nombres
     *
     * @param prmNombres Nuevos nombres
     */
    public void setAtrNombres(String prmNombres) {
        this.atrNombres = prmNombres;
    }

    /**
     * recupera los apellidos.
     *
     * @return Apellidos
     */
    public String getAtrApellidos() {
        return atrApellidos;
    }

    /**
     * Atualiza los apellidos
     *
     * @param prmApellidos Nuevos apellidos
     */
    public void setAtrApellidos(String prmApellidos) {
        this.atrApellidos = prmApellidos;
    }

    /**
     * Recupera el rol del usuario
     *
     * @return Rol
     */
    public String getAtrRol() {
        return atrRol;
    }

    /**
     * Actualiza el rol
     *
     * @param prmRol nuevo rol
     */
    public void setAtrRol(String prmRol) {
        this.atrRol = prmRol;
    }

    /**
     * Recupera el login de usuario.
     *
     * @return Login
     */
    public String getAtrLogin() {
        return atrLogin;
    }

    /**
     * Actualiza el login de usuario
     *
     * @param prmLogin Nuevo login
     */
    public void setAtrLogin(String prmLogin) {
        this.atrLogin = prmLogin;
    }

    /**
     * Recuepera la contraseña.
     *
     * @return Nueva contraseña.
     */
    public String getAtrPassword() {
        return atrPassword;
    }

    /**
     * Atualiza la contraseña.
     *
     * @param prmPassword Nueva contraseña.
     */
    public void setAtrPassword(String prmPassword) {
        this.atrPassword = prmPassword;
    }

    /**
     * Valida si una contraseña es valida.
     *
     * @param prmPassword
     * @return
     */
    public boolean validarPasswod(String prmPassword) {
        if (atrPassword.endsWith(prmPassword)) {
            return true;
        }
        return false;
    }
}
