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
public class clsTarifas {

    private int atrDiaCarro=0;
    private int atrNocheCarro=0;
    private int atrMesCarro=0;
    private int atrDiaMoto=0;
    private int atrNocheMoto=0;
    private int atrMesMoto=0;
    public int getDiaCarro() {
        return atrDiaCarro;
    }

    public void setDiaCarro(int prmDiaCarro) {
        this.atrDiaCarro = prmDiaCarro;
    }

    public int getNocheCarro() {
        return atrNocheCarro;
    }

    public void setNocheCarro(int prmNocheCarro) {
        this.atrNocheCarro = prmNocheCarro;
    }

    public int getMesCarro() {
        return atrMesCarro;
    }

    public void setMesCarro(int prmMesCarro) {
        this.atrMesCarro = prmMesCarro;
    }

    public int getDiaMoto() {
        return atrDiaMoto;
    }

    public void setDiaMoto(int prmDiaMoto) {
        this.atrDiaMoto = prmDiaMoto;
    }

    public int getNocheMoto() {
        return atrNocheMoto;
    }

    public void setNocheMoto(int prmNocheMoto) {
        this.atrNocheMoto = prmNocheMoto;
    }

    public int getMesMoto() {
        return atrMesMoto;
    }

    public void setMesMoto(int prmMesMoto) {
        this.atrMesMoto = prmMesMoto;
    }
    
}
