/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.Conexion;
import dto.DTOPedido_Cilindro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DAOPedido_Cilindro {

    Conexion Conexion = new Conexion();
    ResultSet rs;

    public boolean registrarPedido_Cilindro(DTOPedido_Cilindro dtoPedido_Cilindro) throws SQLException, InstantiationException, IllegalAccessException {
        try {
            Statement cn = Conexion.conectar().createStatement();
            cn.executeUpdate("insert into tblpedidoscilindros values('" + dtoPedido_Cilindro.getCodigoLlenado() + "','" + dtoPedido_Cilindro.getCodCilindro() + "','" + dtoPedido_Cilindro.getCantidad() + "')");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
