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

    IFactura atrFacturaBD = new clsFacturaImplMySql();
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
        String sql = "UPDATE registroparqueo set fechahorasalida='" + prmRegistroParqueo.getFechaHoraSalida() + "', entregaficha=" + prmRegistroParqueo.getEntregaFicha() + " where idregistro=" + prmRegistroParqueo.getIdRegistro();
        if (atrConsultas.consultasDDL(sql) > 0) {
            atrConsultas.close();
            return true;
        }
        return false;
    }

    /**
     * Recupera un registro del parqueo de un vehiculo que esté parqueado
     * realizando la busqueda por la placa.
     *
     * @param prmPlca Placa por la cual se desea buscar
     * @param prmIdParqueadero Id del parqueadero en el cual se desea buscar.
     * @return Objeto de clsRegistroParqueo
     */
    @Override
    public clsRegistroParqueo buscarXplaca(String prmPlca, String prmIdParqueadero) {
        String sql = "select* from vehiculo where placa='" + prmPlca + "'";
        clsVehiculo objVehiculo = new clsVehiculo();
        clsRegistroParqueo objRegistro = null;
        try {
            ResultSet rs = atrConsultas.consultasDML(sql);
            if (rs == null) {
                return null;
            }
            if (rs.next()) {
                objVehiculo.setPlaca(prmPlca);
                objVehiculo.setTipoVehiculo(rs.getString(2));
            } else {
                return null;
            }
            sql = "select * from registroparqueo where placa='" + prmPlca + "' and idparqueadero=" + prmIdParqueadero + " and fechahorasalida is null";
            rs = null;
            rs = atrConsultas.consultasDML(sql);
            if (rs.next()) {
                objRegistro = new clsRegistroParqueo(new clsUsuario(), objVehiculo, rs.getString(6), rs.getString(5), rs.getString(4), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(12));
                if (objRegistro.getNumeroCasillero() == null) {
                    objRegistro.setNumeroCasillero("");
                }
                objRegistro.setIdRegistro(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return objRegistro;
    }

    /**
     * Recupera un registro del parqueo de un vehiculo que esté parqueado
     * realizando la busqueda por codigo de barras.
     *
     * @param prmCodigo Código de barras asociado con el registro a buscar
     * @param prmIdParqueadero Id del parqueadero en el cual se desea buscar.
     * @return Objeto de clsRegistroParqueo
     */
    @Override
    public clsRegistroParqueo buscarXcodigo(String prmCodigo, String prmIdParqueadero) {
        String sql = "SELECT* FROM registroparqueo WHERE CODIGOBARRAS=" + prmCodigo + " and idparqueadero=" + prmIdParqueadero + " and fechahorasalida is null";
        clsVehiculo objVehiculo = new clsVehiculo();
        clsRegistroParqueo objRegistro;
        try {
            ResultSet rs = atrConsultas.consultasDML(sql);
            if (rs.next()) {
                objRegistro = new clsRegistroParqueo(new clsUsuario(), objVehiculo, rs.getString(6), rs.getString(5), rs.getString(4), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(12));
                if (objRegistro.getNumeroCasillero() == null) {
                    objRegistro.setNumeroCasillero("");
                }
                objRegistro.setIdRegistro(rs.getString(1));
            } else {
                return null;
            }
            sql = "select* from vehiculo where placa='" + rs.getString(3) + "'";
            rs = atrConsultas.consultasDML(sql);
            if (rs.next()) {
                objVehiculo.setPlaca(rs.getString(1));
                objVehiculo.setTipoVehiculo(rs.getString(2));
            } else {
                return null;
            }
            objRegistro.setVehiculo(objVehiculo);
        } catch (SQLException e) {
            return null;
        }
        return objRegistro;
    }

}
