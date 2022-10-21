package dao;

import Conexion.Conexion;
import dto.DTOPedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPedido {

    Conexion Conexion = new Conexion();
    ResultSet rs;

    public boolean registrarPedido(DTOPedido dtoPedido) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn = Conexion.conectar().createStatement();
        cn.executeUpdate("insert into tblpedido values(null,'" + dtoPedido.getDocCliente() + "','" + dtoPedido.getDocEmpleado() + "','" + dtoPedido.getFechapedido() + "','" + dtoPedido.getFechaentrega() + "','"
                + dtoPedido.getNombredestinatario() + "', " + dtoPedido.getDocumentodestinatario() + ",'" + dtoPedido.getPrecio_Domicilio() + "')");
        System.out.println("Se ha registrado el pedido con el documento de identidad : " + dtoPedido.getDocCliente());
        return true;
    }

    public boolean modificarPedido(DTOPedido dtoPedido) throws SQLException, InstantiationException, IllegalAccessException {
        try {
            Statement cn = Conexion.conectar().createStatement();
            cn.executeUpdate("update tblpedido set Codigo  = '" + dtoPedido.getCodigo()
                    + "',DocCliente  = '" + dtoPedido.getDocCliente() + "',DocEmpleado  = '" + dtoPedido.getDocEmpleado()
                    + "',FechaPedido = '" + dtoPedido.getFechapedido() + "',FechaEntrega = '" + dtoPedido.getFechaentrega() + "',NombreDestinatario = '" + dtoPedido.getNombredestinatario()
                    + "',DocDestinatario = '" + dtoPedido.getDocumentodestinatario() + "',Precio_Domi = '" + dtoPedido.getPrecio_Domicilio() + "' where Codigo = '" + dtoPedido.getCodigo() + "'");
            System.out.println("se modifico el pedido con codigo: " + dtoPedido.getCodigo());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<DTOPedido> mostrarPedidos() throws SQLException, InstantiationException, IllegalAccessException {
        List<DTOPedido> listaPedidos = new ArrayList<DTOPedido>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TP.Codigo, CONCAT(TU.Nombres, TU.Apellidos) as Cliente, CONCAT(TUS.Nombres, TUS.Apellidos) as Empleado, TP.FechaPedido, TP.FechaEntrega, TP.NombreDestinatario, TP.DocDestinatario, TP.Precio_Domi from tblpedido AS TP INNER JOIN tblusuario AS TU ON TP.DocCliente = TU.DocIdentidad INNER JOIN tblusuario AS TUS ON TP.DocEmpleado = TUS.DocIdentidad");
        rs.beforeFirst();
        while (rs.next()) {
            listaPedidos.add(new DTOPedido(rs.getInt("Codigo"), rs.getString("Cliente"), rs.getString("Empleado"), rs.getString("FechaPedido"), rs.getString("FechaEntrega"), rs.getString("NombreDestinatario"), rs.getString("DocDestinatario"), rs.getInt("Precio_Domi")));
        }
        return listaPedidos;
    }

    public List<DTOPedido> buscarLike(String codigo) throws SQLException, InstantiationException, IllegalAccessException {
        List<DTOPedido> listaPedidos = new ArrayList<DTOPedido>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TP.Codigo, CONCAT(TU.Nombres,\" \", TU.Apellidos) as Cliente, CONCAT(TUS.Nombres,\" \", TUS.Apellidos) as Empleado, TP.FechaPedido, TP.FechaEntrega, TP.NombreDestinatario, TP.DocDestinatario, TP.Precio_Domi from tblpedido AS TP INNER JOIN tblusuario AS TU ON TP.DocCliente = TU.DocIdentidad INNER JOIN tblusuario AS TUS ON TP.DocEmpleado = TUS.DocIdentidad where TP.Codigo LIKE '%" + codigo + "%' OR TU.Nombres LIKE '%" + codigo + "%' OR TU.Apellidos LIKE '%" + codigo + "%' OR TUS.Nombres LIKE '%" + codigo + "%' OR TUS.Apellidos LIKE '%" + codigo + "%' OR TP.NombreDestinatario LIKE '%" + codigo + "%' OR TP.DocDestinatario LIKE '%" + codigo + "%'");
        rs.beforeFirst();
        while (rs.next()) {
            listaPedidos.add(new DTOPedido(rs.getInt("Codigo"), rs.getString("Cliente"), rs.getString("Empleado"), rs.getString("FechaPedido"), rs.getString("FechaEntrega"), rs.getString("NombreDestinatario"), rs.getString("DocDestinatario"), rs.getInt("Precio_Domi")));
        }
        return listaPedidos;
    }

    public int ultimo_insertado() throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn = Conexion.conectar().createStatement();
        ResultSet rs = cn.executeQuery("SELECT Codigo FROM tblpedido ORDER BY Codigo desc limit 1");
        rs.last();
        return rs.getInt("Codigo");
    }

// public boolean eliminarPedido(int codigo) throws SQLException, InstantiationException, IllegalAccessException {
//        Statement cn= Conexion.conectar().createStatement();
//        cn.executeUpdate("delete from tblpedido where Codigo = '"+codigo+"'" );
//        System.out.println("se elimino el pedido con codigo: " + codigo);
//        return true;
//    }
    public DTOPedido buscarPedido(int codigo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblpedido where Codigo = '" + codigo + "'");
        rs.last();
        return new DTOPedido(rs.getInt("Codigo"), rs.getString("DocCliente"), rs.getString("DocEmpleado"), rs.getString("FechaPedido"), rs.getString("FechaEntrega"), rs.getString("NombreDestinatario"), rs.getString("DocDestinatario"), rs.getInt("Precio_Domi"));
    }
}
