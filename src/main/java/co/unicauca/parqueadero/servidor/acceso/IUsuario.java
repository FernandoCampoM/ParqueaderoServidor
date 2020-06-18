/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.*;

/**
 *
 * @author Fernando Campo
 */
public interface IUsuario {

    /**
     * Realiza el registro de un nuevo usuario en la base de datos
     *
     * @param prmUser Usuario que será registrado
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario.
     */
    public boolean create(clsUsuario prmUser);

    /**
     * Recupera un usuario asociado con un login especificado
     *
     * @param prmLogin Login para realizar la busqueda del usuario
     * @return Usuario recuperado
     */
    public clsUsuario find(String prmLogin);

    /**
     * Actualiza la información de un usuario dado
     *
     * @param prmUser Usuario al cual se le actualizará la información
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario
     */
    public boolean update(clsUsuario prmUser);

    /**
     * Elimina un usuario asociado con la cedula especificada.
     *
     * @param prmCedula
     * @return
     */
    public boolean delete(String prmCedula);
}
