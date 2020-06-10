/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fernando Campo
 */
public class RegistroParqueoImplMySql implements IRegistroParqueo {

    private clsConsultasBD atrConsultas = clsConsultasBD.getInstancia();
    private IVehiculo atrVehiculo = new clsVehiculoImplMySql();

    /**
     * Realiza el registro de una entrada de un vehiculo
     *
     * @param prmRegistroParqueo Entrada que será registrada
     * @return Verdadero si el rpoceso fue esitoso, Falso de lo cotrario.
     */
    @Override
    public boolean registrarEntrada(clsRegistroParqueo prmRegistroParqueo) {
        String sql = "INSERT INTO REGISTROPARQUEO (CEDULA,PLACA,NOMBREAPELLIDOPRO,IDPARQUEADERO,CODIGOBARRAS,FECHAHORAENTRADA,NUMEROCASCOS,"
                + "CASILLERO,DEJALLAVES,OBSERVIONES) VALUES (" + prmRegistroParqueo.getUsuario().getAtrCedula() + ",'"
                + prmRegistroParqueo.getVehiculo().getPlaca() + "','" + prmRegistroParqueo.getNombresApellidosProp() + "',"
                + prmRegistroParqueo.getIdParqueadero() + "," + prmRegistroParqueo.getCodigoBarras() + ",'"
                + prmRegistroParqueo.getFechaHoraEntrada() + "'," + prmRegistroParqueo.getNumeroCascos() + ","
                + prmRegistroParqueo.getNumeroCasillero() + "," + prmRegistroParqueo.getDejaLlaves() + ",'"
                + prmRegistroParqueo.getObservaciones() + "')";
        if (atrVehiculo.find(prmRegistroParqueo.getVehiculo().getPlaca()) == null) {
            atrVehiculo.create(prmRegistroParqueo.getVehiculo());
        }
        if (atrConsultas.consultasDDL(sql) > 0) {
            atrConsultas.close();
            return true;
        }
        return false;
    }

    /**
     * Realiza el registro de una salida de un vehiculo
     *
     * @param prmRegistroParqueo Salida que será registrada
     * @return Verdadero si el rpoceso fue esitoso, Falso de lo cotrario.
     */
    @Override
    public boolean registrarSalida(clsRegistroParqueo prmRegistroParqueo) {
        return false;
    }

    @Override
    public clsRegistroParqueo buscarXplaca(String prmPlca) {
        String sql="select* vehiculo where placa='"+prmPlca+"'";
        clsVehiculo objVehiculo=new clsVehiculo();
        clsRegistroParqueo objRegistro=null;
        try {
            ResultSet rs=atrConsultas.consultasDML(sql);
            if(rs==null)
                return null;
            if(rs.next()){
              objVehiculo.setPlaca(prmPlca);
                objVehiculo.setTipoVehiculo(rs.getString(2));
            }else{
                return null;
            }
            sql="select * from registroparqueo where placa='"+prmPlca+"' and fechahorasalida is null";
            rs=null;
            rs=atrConsultas.consultasDML(sql);
            if(rs.next()){
                objRegistro=new clsRegistroParqueo(new clsUsuario(),objVehiculo,rs.getString(6),rs.getString(5),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(12));
            }
        } catch (Exception e) {
        }
        return objRegistro;
    }

    @Override
    public clsRegistroParqueo buscarXcodigo(String prmCodigo) {
        String sql="SELECT* FROM VEHICULO WHERE CODIGOBARRAS="+prmCodigo+" and fechahorasalida is null";
        clsVehiculo objVehiculo=new clsVehiculo();
        clsRegistroParqueo objRegistro;
        try {
            ResultSet rs=atrConsultas.consultasDML(sql);
            if(rs.next()){
                objRegistro=new clsRegistroParqueo(new clsUsuario(),objVehiculo,rs.getString(6),rs.getString(5),rs.getString(4),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(12));
            }else{
                return null;
            }
            sql="select* vehiculo where placa='"+rs.getString(3)+"'";
            rs=atrConsultas.consultasDML(sql);
            if(rs.next()){
              objVehiculo.setPlaca(rs.getString(1));
                objVehiculo.setTipoVehiculo(rs.getString(2));
            }else{
                return null;
            }
            objRegistro.setVehiculo(objVehiculo);
        } catch (SQLException e) {
            return null;
        }
        return objRegistro;
    }

}
