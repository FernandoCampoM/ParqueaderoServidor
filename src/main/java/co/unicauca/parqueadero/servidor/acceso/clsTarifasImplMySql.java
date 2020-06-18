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
public class clsTarifasImplMySql implements ITarifas {

    clsConsultasBD atrConsultas = clsConsultasBD.getInstancia();

    /**
     * Guarda una nueva tarifa en la base de datos.
     *
     * @param prmTarifas Tarifa que se desea guardar
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario.
     */
    @Override
    public boolean crear(clsTarifas prmTarifas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Actualiza una tarifa en la base de datos.
     *
     * @param prmTarifas Tarifa que se desea actualizar.
     * @return Verdadero si el proceso fue exitoso. Falso de lo contrario.
     */
    @Override
    public boolean update(clsTarifas prmTarifas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Recupera todas las tarifas de la base de datos.
     *
     * @return Lista de tarifas recuperadas.
     */
    @Override
    public List<clsTarifas> getTarifas() {
        String sql = "select * from tarifa";
        List<clsTarifas> objTarifas = new ArrayList();
        try {
            ResultSet rs = atrConsultas.consultasDML(sql);
            while (rs.next()) {
                clsTarifas objTarifa = new clsTarifas();
                objTarifa.setTipoTarifa(rs.getString(2));
                objTarifa.setCosto(rs.getString(3));
                objTarifa.setTipoVehiculo(rs.getString(4));
                objTarifas.add(objTarifa);
            }
        } catch (SQLException e) {
        }
        return objTarifas;
    }

}
