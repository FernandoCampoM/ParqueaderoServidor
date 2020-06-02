/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

/**
 *
 * @author Fernando Campo
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fernando Campo
 */
public class clsConsultasBD {
    private static clsConsultasBD atrConsultasBD;
    private ConexionMysql atrConexion;
    private Statement stm;
    private Connection con;
    private ResultSet rs;
    public static clsConsultasBD getInstancia(){
        if(atrConsultasBD==null){
            atrConsultasBD= new clsConsultasBD();
        }
        return atrConsultasBD;
    }
    public int consultasDDL(String prmConsultaSQL){
        stm= null;
	 con=null;
        int varFilasAfectadas=-1;
		try {		
                    atrConexion=new ConexionMysql();
                    atrConexion.conectar();
			con=atrConexion.getConnection();
			stm= con.createStatement();
			varFilasAfectadas= stm.executeUpdate(prmConsultaSQL);
			
		} catch (SQLException e) {
			System.out.println("Error: Clase ParqueaderoImpl, método create");
			e.printStackTrace();
		}
        return varFilasAfectadas;
    }
    public ResultSet consultasDML(String prmConsultaSQL){
         con =null;
         stm= null;
        rs=null;
        try {
            atrConexion=new ConexionMysql();
            atrConexion.conectar();
            con=atrConexion.getConnection();
	    stm=con.createStatement();
            rs=stm.executeQuery(prmConsultaSQL);
            
	} catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
	}
        return rs;
    }
    public void close(){
        try {
            stm.close();
            con.close();
            if(rs!=null)
                rs.close();
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
        
    }
}
