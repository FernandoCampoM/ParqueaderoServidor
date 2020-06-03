/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.clsUsuario;
import java.sql.ResultSet;

/**
 *
 * @author Fernando Campo
 */
public class clsUsuarioImplMySql implements IUsuario {
    private clsConsultasBD atrConsultas;
    public clsUsuarioImplMySql(){
        atrConsultas=clsConsultasBD.getInstancia();
    }
    @Override
    public boolean create(clsUsuario prmUser) {
        String sql="INSERT INTO USUARIO VALUES ('"+prmUser.getAtrCedula()+"','"+prmUser.getAtrRol()+"','"+
                prmUser.getAtrNombres()+"','"+prmUser.getAtrApellidos()+"','"+prmUser.getAtrLogin()+"','"+
                prmUser.getAtrLogin()+"','"+prmUser.getAtrPassword()+"')";
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
    public clsUsuario find(String prmLogin) {
        ResultSet rs;
        String sql="SELECT * FROM USUARIO WHERE LOGIN='"+prmLogin+"'";
        clsUsuario objUser=null;
        try {
             rs=atrConsultas.consultasDML(sql);
             if(rs.next()){
                 objUser=new clsUsuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                 }
             
        } catch (Exception e) {
        }
        return objUser;
    }

    @Override
    public boolean update(clsUsuario prmUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String prmCedula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
