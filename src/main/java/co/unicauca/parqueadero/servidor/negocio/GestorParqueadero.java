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

    /**
     * Recupera de la base de datos todos los parqueaderos
     *
     * @return Lista de parqueaderos
     */
    public List<Parqueadero> getParqueaderos() {
        return parqueaderos.getParqueaderos();
    }

    /**
     * Recupera un parqueadero asociado con el Id especidicado por prmId
     *
     * @param id Identificador del parqueadero a recuperar
     * @return
     */

    public Parqueadero find(String id) {
        return parqueaderos.find(id);
    }

    /**
     * Registra un nuevo parqueadero en la base de datos
     *
     * @param parq Nuevo parqueadero que se va a registrar
     * @return Verdadero si fue exitoso. Falso de lo contrario
     */
    public boolean create(Parqueadero parq) {
        return parqueaderos.create(parq);
    }

    /**
     * Actualiza la información de un parqueadero en la base de datos
     *
     * @param parq Parqueadero que se va a actualizar.
     * @return Verdadero si fue exitoso. Falso de lo contrario
     */
    public boolean actualizar(Parqueadero parq) {
        return parqueaderos.actualizar(parq);
    }

    /**
     * Elimina un prqueadero asociado con un Id espedifico
     *
     * @param prmId Identificador del parqueadero a eliminar
     * @return
     */
    public boolean eliminar(String prmId) {
        return parqueaderos.eliminar(prmId);
    }

    /**
     * Recupera los parqueadero en los cuales trabaja un usuario.
     *
     * @param prmCedula Cédula del usuario
     * @return Lista de parqueaderos recuperados
     */
    public List<Parqueadero> findXcedula(String prmCedula) {
        return parqueaderos.findXcedula(prmCedula);
    }
}
