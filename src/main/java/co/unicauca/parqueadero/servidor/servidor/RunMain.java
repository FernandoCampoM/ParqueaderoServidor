package co.unicauca.parqueadero.servidor.servidor;


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
