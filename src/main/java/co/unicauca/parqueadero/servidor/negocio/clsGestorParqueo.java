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
public class clsGestorParqueo {
    IRegistroParqueo atrRegistro;

    public clsGestorParqueo() {
        atrRegistro=new RegistroParqueoImplMySql();
    }
    /**
     * Realiza el registro de una entrada de un vehiculo
     *
     * @param prmRegistroParqueo Entrada que será registrada
     * @return Verdadero si el rpoceso fue esitoso, Falso de lo cotrario.
     */
    public boolean registrarEntrada(clsRegistroParqueo prmRegistroParqueo){
        return atrRegistro.registrarEntrada(prmRegistroParqueo);
    }
    public clsRegistroParqueo buscarXplaca(String prmPlca) {
       return atrRegistro.buscarXplaca(prmPlca);
    }
    public clsRegistroParqueo buscarXcodigo(String prmCodigo) {
        return atrRegistro.buscarXcodigo(prmCodigo);
    }
}
