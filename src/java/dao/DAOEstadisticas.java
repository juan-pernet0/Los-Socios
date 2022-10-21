/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.Conexion;
import dto.DTOEstadisticas;
import dto.DTORol;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DAOEstadisticas {

    Conexion Conexion = new Conexion();
    ResultSet rs;

    public List<DTOEstadisticas> meses() throws SQLException, InstantiationException, IllegalAccessException {
        List<DTOEstadisticas> listaMeses = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT concat(monthname(FechaPedido),' - ',year(FechaPedido)) as 'Fecha', COUNT(Codigo) as 'Numero_de_pedidos' FROM tblpedido GROUP BY monthname(FechaPedido),year(FechaPedido) order by year(FechaPedido) ,month(FechaPedido)  LIMIT 12;");
        rs.beforeFirst();
        while (rs.next()) {
            listaMeses.add(new DTOEstadisticas(rs.getString("Fecha"), rs.getInt("Numero_de_pedidos")));

        }
        return listaMeses;
    }

    public List<DTOEstadisticas> Primera_Consulta(int Numero_Registros) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTOEstadisticas> Lista_Primera_Consulta = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_PrimeraConsulta('" + Numero_Registros + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Primera_Consulta.add(new DTOEstadisticas(rs.getString("Cliente"), rs.getInt("Cantidad_Cilindros_Pedidos")));

        }
        return Lista_Primera_Consulta;

    }
    
    public List<DTOEstadisticas> Segunda_Consulta(String FechaInicial, String FechaFinal) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTOEstadisticas> Lista_Segunda_Consulta = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_SegundaConsulta('" + FechaInicial + "','" + FechaFinal + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Segunda_Consulta.add(new DTOEstadisticas(rs.getString("Mes"), rs.getInt("Numero de Pedidos")));

        }
        return Lista_Segunda_Consulta;

    }
    
    public List<DTOEstadisticas> Tercera_Consulta(int Numero_Registros) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTOEstadisticas> Lista_Tercera_Consulta = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_TerceraConsulta('" + Numero_Registros + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Tercera_Consulta.add(new DTOEstadisticas(rs.getString("Usuario"), rs.getInt("Numero de Pedidos")));

        }
        return Lista_Tercera_Consulta;

    }
    public List<DTOEstadisticas> Cuarta_Consulta(int Numero_Registros) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTOEstadisticas> Lista_Cuarta_Consulta = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_CuartaConsulta('" + Numero_Registros + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Cuarta_Consulta.add(new DTOEstadisticas(rs.getString("Empresa"), rs.getInt("Cantidad de Pedidos")));

        }
        return Lista_Cuarta_Consulta;

    }
    public List<DTOEstadisticas> Quinta_Consulta(String FechaInicial, String FechaFinal) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTOEstadisticas> Lista_Quinta_Consulta = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_QuintaConsulta('" + FechaInicial + "','" + FechaFinal + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Quinta_Consulta.add(new DTOEstadisticas(rs.getString("Fecha"), rs.getInt("numero de pedidos")));

        }
        return Lista_Quinta_Consulta;

    }
    public List<DTOEstadisticas> Sexta_Consulta(String FechaInicial, String FechaFinal) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTOEstadisticas> Lista_Sexta_Consulta = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_SextaConsulta('" + FechaInicial + "','" + FechaFinal + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Sexta_Consulta.add(new DTOEstadisticas(rs.getString("Fecha"), rs.getInt("numero de pedidos")));

        }
        return Lista_Sexta_Consulta;

    }
    
    public List<DTORol> Septima_Consulta(int Numero_Registros) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTORol> Lista_Septima_Consulta = new ArrayList<DTORol>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_SeptimaConsulta('" + Numero_Registros + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Septima_Consulta.add(new DTORol(rs.getString("Cliente"), rs.getString("Promedio_Cilindros_Pedidos")));

        }
        return Lista_Septima_Consulta;

    }
    
    public int Octava_Consulta() throws InstantiationException, SQLException, IllegalAccessException {
        Statement cn = Conexion.conectar().createStatement();
        ResultSet rs = cn.executeQuery("CAll SP_OctavaConsulta()");
        rs.last();
        return rs.getInt("Cantidad de usuario");

    }
    
    public List<DTOEstadisticas> Novena_Consulta(int Numero_Registros) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTOEstadisticas> Lista_Novena_Consulta = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_NovenaConsulta('" + Numero_Registros + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Novena_Consulta.add(new DTOEstadisticas(rs.getString("Empleado"), rs.getInt("Pedidos Asignados")));

        }
        return Lista_Novena_Consulta;

    }
    
    public List<DTOEstadisticas> Decima_Consulta(int Numero_Registros) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTOEstadisticas> Lista_Decima_Consulta = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_DecimaConsulta('" + Numero_Registros + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Decima_Consulta.add(new DTOEstadisticas(rs.getString("Hora"), rs.getInt("Numero de Pedidos")));

        }
        return Lista_Decima_Consulta;

    }
    
    public List<DTOEstadisticas> Undecima_Consulta(int Numero_Registros) throws InstantiationException, SQLException, IllegalAccessException {
        List<DTOEstadisticas> Lista_Decima_Consulta = new ArrayList<DTOEstadisticas>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("CAll SP_UndecimaConsulta('" + Numero_Registros + "')");
        rs.beforeFirst();
        while (rs.next()) {
            Lista_Decima_Consulta.add(new DTOEstadisticas(rs.getString("Dia"), rs.getInt("Pedidos")));

        }
        return Lista_Decima_Consulta;

    }
}
