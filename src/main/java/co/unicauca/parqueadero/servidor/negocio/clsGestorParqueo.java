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
    
    public boolean registrarEntrada(clsRegistroParqueo prmRegistroParqueo){
        return atrRegistro.registrarEntrada(prmRegistroParqueo);
    }
}
