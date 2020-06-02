/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.servidor;
import co.unicauca.parqueadero.servidor.negocio.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
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
    public String parseToJSON(List<Parqueadero> prmParqueaderos){
        JsonArray jsonArray = new JsonArray();
        for (Parqueadero objParqueadero : prmParqueaderos) {
            jsonArray.add(parseToJson(objParqueadero));
        }
        return jsonArray.toString();
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
    
}
