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
public interface IFactura {

    /**
     * Guarda una factura en la base de datos.
     *
     * @param prmFactura
     * @return Verdadero si el proceso fue exitoso. Falso de lo ocntrario.
     */
    public boolean guardar(clsFactura prmFactura);
}
