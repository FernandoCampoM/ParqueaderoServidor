/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import java.util.List;
import co.unicauca.parqueadero.servidor.negocio.Parqueadero;

/**
 *
 * @author Usuario
 */
public interface IParqueadero {

    /**
     * Recupera de la base de datos todos los parqueaderos
     *
     * @return Lista de parqueaderos
     */
    public List<Parqueadero> getParqueaderos();

    /**
     * Recupera un parqueadero asociado con el Id especidicado por prmId
     *
     * @param prmId Identificador del parqueadero a recuperar
     * @return
     */
    public Parqueadero find(String prmId);

    /**
     * Registra un nuevo parqueadero en la base de datos
     *
     * @param Parq Nuevo parqueadero que se va a registrar
     * @return Verdadero si fue exitoso. Falso de lo contrario
     */
    public boolean create(Parqueadero Parq);

    /**
     * Actualiza la información de un parqueadero en la base de datos
     *
     * @param Parq Parqueadero que se va a actualizar.
     * @return Verdadero si fue exitoso. Falso de lo contrario
     */
    public boolean actualizar(Parqueadero Parq);

    /**
     * Elimina un prqueadero asociado con un Id espedifico
     *
     * @param prmId Identificador del parqueadero a eliminar
     * @return
     */
    public boolean eliminar(String prmId);

    /**
     * Recupera los parqueadero en los cuales trabaja un usuario.
     *
     * @param prmCedula Cédula del usuario
     * @return Lista de parqueaderos recuperados
     */
    public List<Parqueadero> findXcedula(String prmCedula);

}
