package co.unicauca.parqueadero.servidor.servidor;

import java.sql.ResultSet;
import co.unicauca.parqueadero.servidor.negocio.*;
import co.unicauca.parqueadero.servidor.acceso.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
/**
 * Aplicación principal que lanza el servidor
 * @author libardo
 */
public class RunMain {
    public static void main(String args[]){
        //ParqueaderoServer regSer = new ParqueaderoServer();
       // regSer.iniciar();
        clsConsultasBD atrConsultas=clsConsultasBD.getInstancia();
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
        JSONServices p=new JSONServices();
        System.out.println(p.parseToJSON(listaParqueadero));
    }
}
