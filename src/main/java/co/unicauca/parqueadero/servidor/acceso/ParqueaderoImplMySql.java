package co.unicauca.parqueadero.servidor.acceso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import co.unicauca.parqueadero.servidor.negocio.Parqueadero;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Fernando Campo
 */
public class ParqueaderoImplMySql implements IParqueadero {

    private clsConsultasBD atrConsultas;

    public ParqueaderoImplMySql() {
        atrConsultas = clsConsultasBD.getInstancia();
    }

    /**
     * Recupera de la base de datos todos los parqueaderos
     *
     * @return Lista de parqueaderos
     */
    @Override
    public List<Parqueadero> getParqueaderos() {
        ResultSet rs = null;
        List<Parqueadero> listaParqueadero = new ArrayList();
        String sql = "SELECT * FROM PARQUEADERO";
        try {
            rs = atrConsultas.consultasDML(sql);
            while (rs.next()) {
                Parqueadero objParqueadero = new Parqueadero(rs.getString(1), rs.getString(2), rs.getString(3));
                objParqueadero.setId(rs.getString(4));
                listaParqueadero.add(objParqueadero);
            }
            atrConsultas.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
        }
        return listaParqueadero;
    }

    /**
     * Recupera un parqueadero asociado con el Id especidicado por prmId
     *
     * @param id Identificador del parqueadero a recuperar
     * @return
     */
    @Override
    public Parqueadero find(String id) {
        ResultSet rs = null;
        Parqueadero parqueadero = null;
        String sql = "SELECT * FROM PARQUEADERO WHERE IDPARQUEADERO=" + id;
        try {
            rs = atrConsultas.consultasDML(sql);
            while (rs.next()) {
                parqueadero = new Parqueadero(rs.getString(1), rs.getString(2), rs.getString(3));
                parqueadero.setId(rs.getString(4));
            }
            atrConsultas.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
        }
        return parqueadero;
    }

    /**
     * Registra un nuevo parqueadero en la base de datos
     *
     * @param par Nuevo parqueadero que se va a registrar
     * @return Verdadero si fue exitoso. Falso de lo contrario
     */
    @Override
    public boolean create(Parqueadero par) {
        String sql = "INSERT INTO PARQUEADERO (NOMBRE,DIRECCION,TELEFONO) values ('" + par.getNombre() + "','" + par.getDireccion() + "'," + par.getTelefono() + ")";
        try {
            if (atrConsultas.consultasDDL(sql) > 0) {
                atrConsultas.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
        }
        return false;
    }

    /**
     * Actualiza la información de un parqueadero en la base de datos
     *
     * @param par Parqueadero que se va a actualizar.
     * @return Verdadero si fue exitoso. Falso de lo contrario
     */
    @Override
    //pendiente
    public boolean actualizar(Parqueadero parq) {
        String sql = "UPDATE PARQUEADERO SET nombreParqueadero='" + parq.getNombre()
                + "', direccion='" + parq.getDireccion() + "', telefono='" + parq.getTelefono()
                + "'" + " WHERE IDPARQUEADERO=" + parq.getId();
        try {
            if (atrConsultas.consultasDDL(sql) > 0) {
                atrConsultas.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
        }
        return false;

    }

    /**
     * Elimina un prqueadero asociado con un Id espedifico
     *
     * @param prmId Identificador del parqueadero a eliminar
     * @return
     */
    @Override
    public boolean eliminar(String prmId) {
        String sql = "DELETE FROM PARQUEADERO WHERE IDPARQUEADERO=" + prmId;
        try {
            if (atrConsultas.consultasDDL(sql) > 0) {
                atrConsultas.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
        }
        return false;
    }

    /**
     * Recupera los parqueadero en los cuales trabaja un usuario.
     *
     * @param prmCedula Cédula del usuario
     * @return Lista de parqueaderos recuperados
     */
    @Override
    public List<Parqueadero> findXcedula(String prmCedula) {
        String sql = "select* from usuarioparqueadero where cedula=" + prmCedula;
        ResultSet rs;
        String idParqueadero = "";
        List<Parqueadero> listaParqueadero = new ArrayList();
        try {
            rs = atrConsultas.consultasDML(sql);
            if (rs.next()) {
                idParqueadero = rs.getString(2);
                sql = "SELECT * FROM PARQUEADERO WHERE IDPARQUEADERO=" + idParqueadero;
                rs = atrConsultas.consultasDML(sql);
                while (rs.next()) {
                    Parqueadero objParqueadero = new Parqueadero(rs.getString(1), rs.getString(2), rs.getString(3));
                    objParqueadero.setId(rs.getString(4));
                    listaParqueadero.add(objParqueadero);
                }
                atrConsultas.close();
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
        }
        return listaParqueadero;
    }

}
