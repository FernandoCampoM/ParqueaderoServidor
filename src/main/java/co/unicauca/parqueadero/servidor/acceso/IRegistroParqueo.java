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
}
