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
    public boolean create(clsUsuario prmUser);
    public clsUsuario find(String prmLogin);
    public boolean update(clsUsuario prmUser);
    public boolean delete(String prmCedula);
}