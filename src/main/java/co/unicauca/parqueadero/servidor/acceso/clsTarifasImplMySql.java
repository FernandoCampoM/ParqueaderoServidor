/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.clsTarifas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Campo
 */
public class clsTarifasImplMySql implements ITarifas{
    clsConsultasBD atrConsultas=clsConsultasBD.getInstancia();
    @Override
    public boolean crear(clsTarifas prmTarifas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(clsTarifas prmTarifas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<clsTarifas> getTarifas() {
        String sql="select * from tarifa";
        List<clsTarifas> objTarifas=new ArrayList();
        try {
            ResultSet rs=atrConsultas.consultasDML(sql);
            while(rs.next()){
                clsTarifas objTarifa=new clsTarifas();
                objTarifa.setTipoTarifa(rs.getString(2));
                objTarifa.setCosto(rs.getString(3));
                objTarifa.setTipoVehiculo(rs.getString(4));
            }
        } catch (SQLException e) {
        }
        return objTarifas;
    }
    
}