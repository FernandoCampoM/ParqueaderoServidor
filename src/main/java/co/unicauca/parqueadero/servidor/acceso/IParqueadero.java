/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;
import java.util.List;
import co.unicauca.parqueadero.servidor.negocio.Parqueadero;
/**
 *
 * @author Usuario
 */
public interface IParqueadero {
    
    public List<Parqueadero> getParqueaderos();
    
    public Parqueadero find(String prmId);

    public boolean create(Parqueadero Parq);

    public boolean actualizar(Parqueadero Parq);

    public boolean eliminar(String prmId);

   
    
}
