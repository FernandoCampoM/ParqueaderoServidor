/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.transversal;
import co.unicauca.parqueadero.servidor.negocio.*;
/**
 *
 * @author Fernando Campo
 */
public class clsSeguridad {
    /**
     * Verifica la identidad de un usuario que intenta iniciar sesión.
     * @param prmLogin login
     * @param prmPassword contraseña.
     * @return Verdadero si las credenciales son correctas. Falso de lo contrario.
     */
    public boolean login(String prmLogin, String prmPassword){
        clsGestorUsuarios objGestor=new clsGestorUsuarios();
        clsUsuario objUser=objGestor.find(prmLogin);
        if(objUser!=null){
            return objUser.validarPasswod(prmPassword);
        }
        return false;
    }
}
