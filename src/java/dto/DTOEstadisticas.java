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
public class DTOEstadisticas {
    private String Fecha;
    private int Numero_de_pedidos;

    public DTOEstadisticas(String Fecha, int Numero_de_pedidos) {
        this.Fecha = Fecha;
        this.Numero_de_pedidos = Numero_de_pedidos;
    }

    public DTOEstadisticas(String string, String string0, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getNumero_de_pedidos() {
        return Numero_de_pedidos;
    }

    public void setNumero_de_pedidos(int Numero_de_pedidos) {
        this.Numero_de_pedidos = Numero_de_pedidos;
    }
}
