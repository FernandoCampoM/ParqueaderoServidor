
package co.unicauca.parqueadero.servidor.negocio;

/**
 *
 * @author Usuario
 */
public class Parqueadero {
    private String nombre;
    private String direccion;
    private String telefono;
    private String atrId;

    public Parqueadero() {
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        atrId="";
    }
    
    public Parqueadero(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setId(String prmId){
        atrId=prmId;
    }
    public String getId(){
        return atrId;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
