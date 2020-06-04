/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.clsRegistroParqueo;

/**
 *
 * @author Fernando Campo
 */
public class RegistroParqueoImplMySql implements IRegistroParqueo {
    private clsConsultasBD atrConsultas=clsConsultasBD.getInstancia();
    private IVehiculo atrVehiculo=new clsVehiculoImplMySql();
    @Override
    public boolean registrarEntrada(clsRegistroParqueo prmRegistroParqueo) {
        String sql="INSERT INTO REGISTROPARQUEO (CEDULA,PLACA,NOMBREAPELLIDOPRO,IDPARQUEADERO,CODIGOBARRAS,FECHAHORAENTRADA,NUMEROCASCOS,"
                + "CASILLERO,DEJALLAVES,OBSERVIONES) VALUES ("+prmRegistroParqueo.getUsuario().getAtrCedula()+",'"
                +prmRegistroParqueo.getVehiculo().getPlaca()+"','"+prmRegistroParqueo.getNombresApellidosProp()+"',"
                +prmRegistroParqueo.getIdParqueadero()+","+prmRegistroParqueo.getCodigoBarras()+",'"
                +prmRegistroParqueo.getFechaHoraEntrada()+"',"+prmRegistroParqueo.getNumeroCascos()+","
                +prmRegistroParqueo.getNumeroCasillero()+","+prmRegistroParqueo.getDejaLlaves()+",'"
                +prmRegistroParqueo.getObservaciones()+"')";
        if(atrVehiculo.find(prmRegistroParqueo.getVehiculo().getPlaca())==null){
            atrVehiculo.create(prmRegistroParqueo.getVehiculo());
        }
        if(atrConsultas.consultasDDL(sql)>0){
            atrConsultas.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean registrarSalida(clsRegistroParqueo prmRegistroParqueo) {
       return false;
    }
    
}
