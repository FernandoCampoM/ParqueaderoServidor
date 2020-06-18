/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.servidor.negocio;

/**
 *
 * @author Fernando Campo
 */
public class clsRegistroParqueo {

    private clsVehiculo atrVehiculo = null;
    private clsUsuario atrUsuario = null;
    private String atrCodigoBarras = "";
    private String atrNombresApellidosProp = "";
    private String atrFechaHoraEntrada = "";
    private String atrFechaHoraSalida = "";
    private String atrNumeroCascos = "";
    private String atrNumeroCasillero = "";
    private String atrDejaLlaves = "";
    private String atrObservaciones = "";
    private String atrIdParqueadero = "";
    private String atrEntregaFicha = "";
    private String atrIdRegistro = "";

    public clsRegistroParqueo(clsUsuario prmUsuario, clsVehiculo prmVehiculo, String prmCodigoBarras, String prmIdParqueadero, String prmNombresApellidosProp, String prmFechaHoraEntrada, String prmNumeroCascos, String prmNumeroCasillero, String prmDejaLlaves, String prmObservaciones) {
        this.atrUsuario = prmUsuario;
        atrVehiculo = prmVehiculo;
        atrCodigoBarras = prmCodigoBarras;
        atrIdParqueadero = prmIdParqueadero;
        this.atrNombresApellidosProp = prmNombresApellidosProp;
        this.atrFechaHoraEntrada = prmFechaHoraEntrada;
        this.atrNumeroCascos = prmNumeroCascos;
        this.atrNumeroCasillero = prmNumeroCasillero;
        this.atrDejaLlaves = prmDejaLlaves;
        atrObservaciones = prmObservaciones;
    }

    /**
     * Recupera el id
     *
     * @return id
     */
    public String getIdRegistro() {
        return atrIdRegistro;
    }

    /**
     * Actualiza el id
     *
     * @param prmIdRegistro nuevo Id
     */
    public void setIdRegistro(String prmIdRegistro) {
        this.atrIdRegistro = prmIdRegistro;
    }

    /**
     * Recupera si entra ficha al momento de sacar el vehiculo
     *
     * @return "True" en caso de entregarla. "False" de lo contrario.
     */
    public String getEntregaFicha() {
        return atrEntregaFicha;
    }

    /**
     * Actualia el estado del atributo entragaFicha
     *
     * @param prmEntregaFicha Nuevo valor
     */
    public void setEntregaFicha(String prmEntregaFicha) {
        this.atrEntregaFicha = prmEntregaFicha;
    }

    public clsRegistroParqueo() {

    }

    /**
     * recupera el id del parqueadero
     *
     * @return Id parqueadero
     */
    public String getIdParqueadero() {
        return atrIdParqueadero;
    }

    /**
     * Actualiza el id del parqueadero.
     *
     * @param prmIdParqueadero Nuevo Id
     */
    public void setIdParqueadero(String prmIdParqueadero) {
        this.atrIdParqueadero = prmIdParqueadero;
    }

    /**
     * Recupera las observaciones.
     *
     * @return Observaciones.
     */
    public String getObservaciones() {
        return atrObservaciones;
    }

    /**
     * Actualiza las observaciones.
     *
     * @param prmObservaciones Nuevas observaciones.
     */
    public void setObservaciones(String prmObservaciones) {
        this.atrObservaciones = prmObservaciones;
    }

    /**
     * Recupera el valor del atributo dejaLLaves
     *
     * @return "TRUE" si deja llaves. "FALSE" de lo contrario.
     */
    public String getDejaLlaves() {
        return atrDejaLlaves;
    }

    /**
     * Atualiza el estado dle atributo dejaLlaves
     *
     * @param prmDejaLlaves
     */
    public void setDejaLlaves(String prmDejaLlaves) {
        this.atrDejaLlaves = prmDejaLlaves;
    }

    /**
     * Recupera el vehiculo implicado en el ingreso.
     *
     * @return Objeto de clsVehiculo
     */
    public clsVehiculo getVehiculo() {
        return atrVehiculo;
    }

    /**
     * Atualiza el vehiculo implicado en el ingreso.
     *
     * @param prmVehiculo Nuevo vehiculo
     */
    public void setVehiculo(clsVehiculo prmVehiculo) {
        this.atrVehiculo = prmVehiculo;
    }

    /**
     * recupera el usuario que realiza el ingreso.
     *
     * @return Objeto de clsUsuario
     */
    public clsUsuario getUsuario() {
        return atrUsuario;
    }

    /**
     * Actualiza el usuario que realiza el ingreso.
     *
     * @param prmUsuario Nuevo usuario
     */
    public void setUsuario(clsUsuario prmUsuario) {
        this.atrUsuario = prmUsuario;
    }

    /**
     * Recupera el codigo de barras asociado al ingreso.
     *
     * @return Codigo de barras
     */
    public String getCodigoBarras() {
        return atrCodigoBarras;
    }

    /**
     * Actualiza el codigo de barras.
     *
     * @param prmCodigoBarras Nuevo codigo de barras
     */
    public void setCodigoBarras(String prmCodigoBarras) {
        this.atrCodigoBarras = prmCodigoBarras;
    }

    /**
     * Recupera los nombresy apellidos del conductor.
     *
     * @return Nombres y apellidos del conductor.
     */
    public String getNombresApellidosProp() {
        return atrNombresApellidosProp;
    }

    /**
     * Actualiza los nombrs y apellidos del conductor.
     *
     * @param prmNombresApellidosProp Nuevos nombres y apellidos.
     */
    public void setNombresApellidosProp(String prmNombresApellidosProp) {
        this.atrNombresApellidosProp = prmNombresApellidosProp;
    }

    /**
     * Recupera la fecha y hora de entrada.
     *
     * @return Fecha y hora de entrada.
     */
    public String getFechaHoraEntrada() {
        return atrFechaHoraEntrada;
    }

    /**
     * Atualiza la fecha hora de entrada
     *
     * @param prmFechaHoraEntrada Nueva fecha hora de entrada
     */
    public void setFechaHoraEntrada(String prmFechaHoraEntrada) {
        this.atrFechaHoraEntrada = prmFechaHoraEntrada;
    }

    /**
     * Recuepera la fecha hora de salida
     *
     * @return Fecha hora salida
     */
    public String getFechaHoraSalida() {
        return atrFechaHoraSalida;
    }

    /**
     * Aactualiza la fecha hora de salida.
     *
     * @param prmFechaHoraSalida Nueva fecha hora de salida.
     */
    public void setFechaHoraSalida(String prmFechaHoraSalida) {
        this.atrFechaHoraSalida = prmFechaHoraSalida;
    }

    /**
     * Recuepera el numero de cascos.
     *
     * @return Numero de cascos.
     */
    public String getNumeroCascos() {
        return atrNumeroCascos;
    }

    /**
     * Actualiza el numero de cascos.
     *
     * @param prmNumeroCascos Nuevo numero de cascos.
     */
    public void setNumeroCascos(String prmNumeroCascos) {
        this.atrNumeroCascos = prmNumeroCascos;
    }

    /**
     * Recupera el numeor de casilleros.
     *
     * @return Numero de casilleros
     */
    public String getNumeroCasillero() {
        return atrNumeroCasillero;
    }

    /**
     * Actualiza el numero de casillero.
     *
     * @param prmNumeroCasillero Nuevo numero de casillero
     */
    public void setNumeroCasillero(String prmNumeroCasillero) {
        this.atrNumeroCasillero = prmNumeroCasillero;
    }

}
