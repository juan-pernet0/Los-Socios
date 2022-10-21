/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author user
 */
public class DTOPedido_Cilindro {
    int CodigoLlenado;
    int CodCilindro;
    int cantidad;

    public DTOPedido_Cilindro() {
    }

    public DTOPedido_Cilindro(int CodigoLlenado, int CodCilindro, int cantidad) {
        this.CodigoLlenado = CodigoLlenado;
        this.CodCilindro = CodCilindro;
        this.cantidad = cantidad;
    }

    public int getCodigoLlenado() {
        return CodigoLlenado;
    }

    public void setCodigoLlenado(int CodigoLlenado) {
        this.CodigoLlenado = CodigoLlenado;
    }

    public int getCodCilindro() {
        return CodCilindro;
    }

    public void setCodCilindro(int CodCilindro) {
        this.CodCilindro = CodCilindro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
