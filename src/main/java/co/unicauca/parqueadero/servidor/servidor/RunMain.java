package co.unicauca.parqueadero.servidor.servidor;

import java.sql.ResultSet;
import co.unicauca.parqueadero.servidor.negocio.*;
import co.unicauca.parqueadero.servidor.acceso.*;
import co.unicauca.parqueadero.servidor.transversal.JSONServices;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
/**
 * Aplicación principal que lanza el servidor
 * @author libardo
 */
public class RunMain {
    public static void main(String args[]){
        ParqueaderoServer regSer = new ParqueaderoServer();
        regSer.iniciar();
    /* clsGestorUsuarios gestor=new clsGestorUsuarios();
        JSONServices parse=new JSONServices();
        System.out.println(parse.parseToJSON(gestor.find("fernando")));*/
    }
}
