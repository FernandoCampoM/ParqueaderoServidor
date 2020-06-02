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
public class clsUserAdmin extends clsUsuario implements IUserAdmin{

    public clsUserAdmin(String prmCedula, String prmNombres, String prmApellidos, String prmRol, String prmLogin, String prmPassword) {
        super(prmCedula, prmNombres, prmApellidos, prmRol, prmLogin, prmPassword);
    }

    @Override
    public boolean crearParqueadero() {
        return false;
    }
    
}
