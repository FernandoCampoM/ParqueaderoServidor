/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.acceso;

import co.unicauca.parqueadero.servidor.negocio.clsFactura;

/**
 *
 * @author Fernando Campo
 */
public class clsFacturaImplMySql implements IFactura {

    clsConsultasBD atrConsultas;

    public clsFacturaImplMySql() {
        atrConsultas = clsConsultasBD.getInstancia();
    }

    /**
     * Guarda una factura en la base de datos.
     *
     * @param prmFactura
     * @return Verdadero si el proceso fue exitoso. Falso de lo ocntrario.
     */
    @Override
    public boolean guardar(clsFactura prmFactura) {
        String sql = "INSERT INTO FACTURACION(IDREGISTRO,VALORAPAGAR) VALUES(" + prmFactura.getIdRegistroParqueo() + "," + prmFactura.getValorApagar() + ")";
        if (atrConsultas.consultasDDL(sql) > 0) {
            atrConsultas.close();
            return true;
        }
        return false;
    }

}
