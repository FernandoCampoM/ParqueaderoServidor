/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.*;
import java.util.List;

/**
 *
 * @author Fernando Campo
 */
public interface IRegistroParqueo {

    /**
     * Realiza el registro de una entrada de un vehiculo
     *
     * @param prmRegistroParqueo Entrada que será registrada
     * @return Verdadero si el rpoceso fue esitoso, Falso de lo cotrario.
     */
    public boolean registrarEntrada(clsRegistroParqueo prmRegistroParqueo);

    /**
     * Realiza el registro de una salida de un vehiculo
     *
     * @param prmRegistroParqueo Salida que será registrada
     * @return Verdadero si el rpoceso fue esitoso, Falso de lo cotrario.
     */
    public boolean registrarSalida(clsRegistroParqueo prmRegistroParqueo);

    /**
     * Recupera un registro del parqueo de un vehiculo que esté parqueado
     * realizando la busqueda por la placa.
     *
     * @param prmPlca Placa por la cual se desea buscar
     * @param prmIdParqueadero Id del parqueadero en el cual se desea buscar.
     * @return Objeto de clsRegistroParqueo
     */
    public clsRegistroParqueo buscarXplaca(String prmPlca, String prmIdParqueadero);

    /**
     * Recupera un registro del parqueo de un vehiculo que esté parqueado
     * realizando la busqueda por codigo de barras.
     *
     * @param prmCodigo Código de barras asociado con el registro a buscar
     * @param prmIdParqueadero Id del parqueadero en el cual se desea buscar.
     * @return Objeto de clsRegistroParqueo
     */
    public clsRegistroParqueo buscarXcodigo(String prmCodigo, String prmIdParqueadero);
    /**
     * Recupera una lista de estadisticas dada una fecha y el id de un parqueadero
     * @param prmFecha Fecha dodne sequieren las estadisticas
     * @param prmIdParqueadero Id del parqueadero que requiere las estadisticas.
     * @return 
     */
    public List<clsEstadisticas> afluencia(String prmFecha,String prmIdParqueadero);
}
