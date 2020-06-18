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
        atrId = "";
    }

    public Parqueadero(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Recupera el nombre dle parqueadero
     *
     * @return Nombre del parqueadero
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del parqueadero
     *
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * recupera la direccción del parqueadero.
     *
     * @return Dirección del parqueadero
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Actiualiza la dirección del parqueadero.
     *
     * @param direccion Nueva dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Recupera el telefono del parqueadero.
     *
     * @return Telefono del parqueadero
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Actualiza el id del parqueadero.
     *
     * @param prmId Nuevo Id
     */
    public void setId(String prmId) {
        atrId = prmId;
    }

    /**
     * Recupera el id del parqueadero
     *
     * @return Id del parqueadero
     */
    public String getId() {
        return atrId;
    }

    /**
     * Actualiza el telefono del parqueadero
     *
     * @param telefono Nuevo telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
