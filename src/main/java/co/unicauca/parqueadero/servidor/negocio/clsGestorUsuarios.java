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
public class clsGestorUsuarios {

    IUsuario atrUsuario;

    public clsGestorUsuarios() {
        atrUsuario = new clsUsuarioImplMySql();
    }

    /**
     * Realiza el registro de un nuevo usuario en la base de datos
     *
     * @param prmUser Usuario que será registrado
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario
     */
    public boolean create(clsUsuario prmUser) {
        return atrUsuario.create(prmUser);
    }

    /**
     * Recupera un usuario asociado con un login especificado
     *
     * @param prmLogin Login para realizar la busqueda del usuario
     * @return Usuario recuperado
     */
    public clsUsuario find(String prmLogin) {
        return atrUsuario.find(prmLogin);
    }
}
