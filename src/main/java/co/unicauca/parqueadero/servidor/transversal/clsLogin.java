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
public class clsLogin {
private String atrUser;
    private String atrPassword;
    
    
    public String getUser() {
        return atrUser;
    }

    public String getPassword() {
        return atrPassword;
    }
    
    public boolean login(String prmLogin, String prmPassword){
        clsGestorUsuarios objGestor=new clsGestorUsuarios();
        clsUsuario objUser=objGestor.find(prmLogin);
        if(objUser!=null){
            return objUser.validarPasswod(prmPassword);
        }
        return false;
    }
}
