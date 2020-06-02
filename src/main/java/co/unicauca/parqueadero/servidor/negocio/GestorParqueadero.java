
package co.unicauca.parqueadero.servidor.negocio;
import co.unicauca.parqueadero.servidor.acceso.IParqueadero;
import co.unicauca.parqueadero.servidor.acceso.ParqueaderoImplMySql;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class GestorParqueadero {
    IParqueadero parqueaderos;

    public GestorParqueadero() {
        this.parqueaderos = new ParqueaderoImplMySql();
    }
     public List<Parqueadero> getParqueaderos() {
        return parqueaderos.getParqueaderos();
    }

    public Parqueadero find(String id) {
        return parqueaderos.find(id);
    }

    public boolean create(Parqueadero parq) {
        return parqueaderos.create(parq);
    }

    public boolean actualizar(Parqueadero parq) {
        return parqueaderos.actualizar(parq);
    }

    public boolean eliminar(String nombre) {
        return parqueaderos.eliminar(nombre);
    }

}
