/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.*;
import java.sql.ResultSet;

/**
 *
 * @author Fernando Campo
 */
public class clsVehiculoImplMySql implements IVehiculo {
    clsConsultasBD atrConsultas;
    public clsVehiculoImplMySql(){
        atrConsultas=clsConsultasBD.getInstancia();
    }
    @Override
    public boolean create(clsVehiculo prmVehiculo) {
        String sql="INSERT INTO VEHICULO (PLACA, TIPOVEHICULO) VALUES ('"+prmVehiculo.getPlaca()+"','"+
                prmVehiculo.getTipoVehiculo()+"')";
        if(atrConsultas.consultasDDL(sql)>0){
            atrConsultas.close();
            return true;
        }
        return false;
    }

    @Override
    public clsVehiculo find(String prmPlaca) {
        String sql="select * from vehiulo where placa='"+prmPlaca+"'";
        ResultSet rs=null;
        clsVehiculo objVehiculo=null;
        try {
            rs=atrConsultas.consultasDML(sql);
            if(rs.next()){
                objVehiculo =new clsVehiculo(prmPlaca, rs.getString(2));
            }
        } catch (Exception e) {
        }
        return objVehiculo;
    }

    @Override
    public boolean update(clsVehiculo prmVehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String prmPLaca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
