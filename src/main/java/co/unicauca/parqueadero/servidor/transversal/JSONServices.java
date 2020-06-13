/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.transversal;

import co.unicauca.parqueadero.servidor.negocio.Parqueadero;

import co.unicauca.parqueadero.servidor.negocio.clsRegistroParqueo;
import co.unicauca.parqueadero.servidor.negocio.clsUsuario;
import co.unicauca.parqueadero.servidor.negocio.clsVehiculo;
import co.unicauca.parqueadero.servidor.negocio.clsFactura;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 *
 * @author Fernando Campo
 */
public class JSONServices {
    private static JSONServices atrParseToJSON;
    public static JSONServices getInstancia(){
        if(atrParseToJSON==null){
            atrParseToJSON=new JSONServices();
        }
        return atrParseToJSON;
    }
    public String parseToJSON(clsFactura prmFactura){
        JsonObject jsonObj=new JsonObject();
        jsonObj.addProperty("ID", prmFactura.getId());
        jsonObj.addProperty("IdRegistro", prmFactura.getIdRegistroParqueo());
        jsonObj.addProperty("valorApagar", prmFactura.getValorApagar());
        return jsonObj.toString();
    }
    public String parseToJSON(List<Parqueadero> prmParqueaderos){
        JsonObject jsonObj=new JsonObject();
        int i=1;
        for (Parqueadero objParqueadero : prmParqueaderos) {
            jsonObj.addProperty(String.valueOf(i), parseToJSON(objParqueadero));
            System.out.println("Objeto: "+jsonObj.toString());
            i++;
        }
        return jsonObj.toString();
    }
    public String parseToJSON(Parqueadero prmParqueadero){
        return parseToJson(prmParqueadero).toString();
    }
    private JsonObject parseToJson(Parqueadero prmParqueadero){
        JsonObject jsonObj=new JsonObject();
            jsonObj.addProperty("NombreParqueadero", prmParqueadero.getNombre());
            jsonObj.addProperty("Direccion", prmParqueadero.getDireccion());
            jsonObj.addProperty("Telefono", prmParqueadero.getTelefono());
            jsonObj.addProperty("IDParqueadero", prmParqueadero.getId());
            return jsonObj;
    }
    
    public String parseToJson(clsRegistroParqueo prmRegistro){
        JsonObject jsonObj=new JsonObject();
        jsonObj.addProperty("Vehiculo",parseToJSON(prmRegistro.getVehiculo()));
        jsonObj.addProperty("Usuario",parseToJSON(prmRegistro.getUsuario()));
        jsonObj.addProperty("CodigoBarras",prmRegistro.getCodigoBarras());
        jsonObj.addProperty("NombresApellidosProp",prmRegistro.getNombresApellidosProp());
        jsonObj.addProperty("FechaHoraEntrada",prmRegistro.getFechaHoraEntrada());
        jsonObj.addProperty("FechaHoraSalida",prmRegistro.getFechaHoraSalida());
        jsonObj.addProperty("NumeroCascos",prmRegistro.getNumeroCascos());
        jsonObj.addProperty("NumeroCasillero",prmRegistro.getNumeroCasillero());
        jsonObj.addProperty("DejaLlaves",prmRegistro.getDejaLlaves());
        jsonObj.addProperty("Observaciones",prmRegistro.getObservaciones());
        jsonObj.addProperty("IdParqueadero",prmRegistro.getIdParqueadero());
        jsonObj.addProperty("EntregaFicha",prmRegistro.getEntregaFicha());
        jsonObj.addProperty("IdRegistro", prmRegistro.getIdRegistro());
        return jsonObj.toString();
    }
    public String parseToJSON(clsVehiculo prmVehiculo){
        JsonObject jsonObj=new JsonObject();
        jsonObj.addProperty("Placa", prmVehiculo.getPlaca());
        jsonObj.addProperty("TipoVehiculo", prmVehiculo.getTipoVehiculo());
        return jsonObj.toString();
    }
    public String parseToJSON(clsUsuario prmUser){
        JsonObject jsonObj=new JsonObject();
        jsonObj.addProperty("Cedula",prmUser.getAtrCedula());
        jsonObj.addProperty("Nombres",prmUser.getAtrNombres());
        jsonObj.addProperty("Apellidos",prmUser.getAtrApellidos());
        jsonObj.addProperty("Rol",prmUser.getAtrRol());
        jsonObj.addProperty("Login", prmUser.getAtrLogin());
        jsonObj.addProperty("Password",prmUser.getAtrPassword());
        return jsonObj.toString();
    }
    public List<Parqueadero> parseToParqueaderos(String prmJSONParqueadero){
        List<Parqueadero> objParqueaderos=new ArrayList();
        int i=1;
        try {
            Gson gson = new Gson();
        Properties properties = gson.fromJson(prmJSONParqueadero, Properties.class);
        while(true){
            objParqueaderos.add(parseToParqueadero(properties.getProperty(String.valueOf(i))));
            i++;
        }
        } catch (Exception e) {
            System.out.println("Eror: "+e.getMessage());
        }
         return objParqueaderos;
    }
    public Parqueadero parseToParqueadero(String prmJSONParqueadero){
        Parqueadero objParqueadero=new Parqueadero();
        Gson gson = new Gson();
        Properties properties = gson.fromJson(prmJSONParqueadero, Properties.class);
        objParqueadero.setNombre(properties.getProperty("NombreParqueadero"));
        objParqueadero.setDireccion(properties.getProperty("Direccion"));
        objParqueadero.setTelefono(properties.getProperty("Telefono"));
        objParqueadero.setId(properties.getProperty("IDParqueadero"));
        return objParqueadero;
    }
    public clsFactura parseToFactura(String prmJSONFactura){
        clsFactura objFactura=new clsFactura();
        Gson gson = new Gson();
        Properties properties = gson.fromJson(prmJSONFactura, Properties.class);
        objFactura.setId(properties.getProperty("ID"));
        objFactura.setRegistroParqueo(properties.getProperty("IdRegistro"));
        objFactura.setValorApagar(properties.getProperty("valorApagar"));
        return objFactura;
    }
    public clsUsuario parseToUsuario(String prmJSONUser){
        clsUsuario objUser=new clsUsuario();
        Gson gson = new Gson();
        Properties properties = gson.fromJson(prmJSONUser, Properties.class);
        objUser.setAtrCedula(properties.getProperty("Cedula"));
        objUser.setAtrNombres(properties.getProperty("Nombres"));
        objUser.setAtrApellidos(properties.getProperty("Apellidos"));
        objUser.setAtrRol(properties.getProperty("Rol"));
        objUser.setAtrLogin(properties.getProperty("Login"));
        objUser.setAtrPassword(properties.getProperty("Password"));
        return objUser;
    }
    public clsVehiculo parseToVehiculo(String prmJSONVehiculo){
        clsVehiculo objVehiculo=new clsVehiculo();
         Gson gson = new Gson();
        Properties properties = gson.fromJson(prmJSONVehiculo, Properties.class);
        objVehiculo.setPlaca(properties.getProperty("Placa"));
        objVehiculo.setTipoVehiculo(properties.getProperty("TipoVehiculo"));
        return objVehiculo;
    }
    public clsRegistroParqueo parseToRegistroParqueo(String prmJSONRegistro){
        clsRegistroParqueo objRegistro=new clsRegistroParqueo();
        Gson gson = new Gson();
        Properties properties = gson.fromJson(prmJSONRegistro, Properties.class);
        objRegistro.setUsuario(parseToUsuario(properties.getProperty("Usuario")));
        objRegistro.setVehiculo(parseToVehiculo(properties.getProperty("Vehiculo")));
        objRegistro.setCodigoBarras(properties.getProperty("CodigoBarras"));
        objRegistro.setNombresApellidosProp(properties.getProperty("NombresApellidosProp"));
        objRegistro.setFechaHoraEntrada(properties.getProperty("FechaHoraEntrada"));
        objRegistro.setFechaHoraSalida(properties.getProperty("FechaHoraSalida"));
        objRegistro.setNumeroCascos(properties.getProperty("NumeroCascos"));
        objRegistro.setNumeroCasillero(properties.getProperty("NumeroCasillero"));
        objRegistro.setDejaLlaves(properties.getProperty("DejaLlaves"));
        objRegistro.setObservaciones(properties.getProperty("Observaciones"));
        objRegistro.setIdParqueadero(properties.getProperty("IdParqueadero"));
        objRegistro.setEntregaFicha(properties.getProperty("EntregaFicha"));
        objRegistro.setIdRegistro(properties.getProperty("IdRegistro"));
        return objRegistro;
    }
}
