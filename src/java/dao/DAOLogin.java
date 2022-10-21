/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.Conexion;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
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
public class DAOLogin {

    Conexion Conexion = new Conexion();
    ResultSet rs;

    public String[] validar(int documento) throws SQLException, InstantiationException, IllegalAccessException {
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT DocIdentidad, Password, Rol, CONCAT(Nombres, Apellidos) as Usuario FROM tblusuario where DocIdentidad = '" + documento + "'");
        rs.last();

        try {
            String[] array = {rs.getString("Rol"), rs.getString("Password"), rs.getString("Usuario")};
            return array;
        } catch (Exception ex) {
            return null;
        }

    }
}
