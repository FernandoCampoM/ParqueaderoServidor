package co.unicauca.parqueadero.servidor.acceso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import co.unicauca.parqueadero.servidor.negocio.Parqueadero;
import co.unicauca.parqueadero.servidor.servidor.JSONServices;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ParqueaderoImplMySql implements IParqueadero {

    private clsConsultasBD atrConsultas;

    public ParqueaderoImplMySql() {
        atrConsultas=clsConsultasBD.getInstancia();
    }

    @Override
    public List<Parqueadero> getParqueaderos() {
        ResultSet rs=null;
	List<Parqueadero> listaParqueadero= new ArrayList();
	String sql="SELECT * FROM PARQUEADERO";
        try {			
            rs=atrConsultas.consultasDML(sql);
            while (rs.next()) {
		listaParqueadero.add(new Parqueadero(rs.getString(1),rs.getString(2),rs.getInt(3)));
            }
            atrConsultas.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
	}
        return listaParqueadero;
    }

    @Override
    public Parqueadero find(String id) {
        ResultSet rs=null;
	Parqueadero parqueadero=null;
	String sql="SELECT * FROM PARQUEADERO WHERE IDPARQUEADERO="+id;
        try {			
            rs=atrConsultas.consultasDML(sql);
            while (rs.next()) {
		parqueadero=new Parqueadero(rs.getString(1),rs.getString(2),rs.getInt(3));
            }
            atrConsultas.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
	}
        return parqueadero;
    }

    @Override
    public boolean create(Parqueadero par) {
            String sql = "INSERT INTO PARQUEADERO (NOMBRE,DIRECCION,TELEFONO) values ('" + par.getNombre() + "','" + par.getDireccion() + "'," + par.getTelefono()+")";
         try {
            if(atrConsultas.consultasDDL(sql)>0){
                atrConsultas.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
	}
        return false;
    }

    @Override
    //pendiente
    public boolean actualizar(Parqueadero parq) {
        String sql = "UPDATE PARQUEADERO SET nombreParqueadero='" + parq.getNombre()
                + "', direccion='" + parq.getDireccion() + "', telefono='" + parq.getTelefono()
                + "'" + " WHERE IDPARQUEADERO=" +  parq.getId();
        try {
            if(atrConsultas.consultasDDL(sql)>0){
                atrConsultas.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
	}
        return false;
        
    }

    @Override
    public boolean eliminar(String prmId) {
        String sql = "DELETE FROM PARQUEADERO WHERE IDPARQUEADERO=" +prmId;
        try {
            if(atrConsultas.consultasDDL(sql)>0){
                atrConsultas.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase ParqueaderoImpl, método getParqueaderos");
	}
        return false;
    }

   

}
