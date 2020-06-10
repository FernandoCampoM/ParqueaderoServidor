/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.clsTarifas;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public clsTarifas getTarifas() {
        String sql="select * from tarifa";
        clsTarifas objTarifas=null;
        try {
            ResultSet rs=atrConsultas.consultasDML(sql);
            while(rs.next()){
                
            }
        } catch (SQLException e) {
        }
        return objTarifas;
    }
    private void asignarTarifa(clsTarifas prmTarifa, String prmCase){
        switch (prmCase){
            case "DIAMOTO":
        }
    }
    
}
