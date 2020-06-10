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
public interface IVehiculo {
    /**
     * Realiza un nuevo registro de vehiculo en la base de datos
     * @param prmVehiculo Vehiculo que será registrado
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario.
     */
    public boolean create(clsVehiculo prmVehiculo);
    /**
     * Recupera un vehiculo asociado a una placa dada
     * @param prmPlaca Placa del vehiculo que se desea recuperar
     * @return Vehiculo recuperado
     */
    public clsVehiculo find(String prmPlaca);
    /**
     * Actualiza la información de un vehiculo dado
     * @param prmVehiculo Vehiculo ha actualizar
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario.
     */
    public boolean update(clsVehiculo prmVehiculo);
    /**
     * Elimina un vehiculo asociado a una placa dad.
     * @param prmPLaca Placa del vehiculo a eliminar.
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario.
     */
    public boolean delete(String prmPLaca);
    
}
