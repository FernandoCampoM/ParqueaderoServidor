/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;
import co.unicauca.parqueadero.servidor.negocio.*;
import java.util.List;
/**
 *
 * @author Fernando Campo
 */
public interface ITarifas {
    public boolean crear(clsTarifas prmTarifas);
    public boolean update(clsTarifas prmTarifas);

    /**
     *
     * @return
     */
    public List<clsTarifas> getTarifas();
}
