package dao;


import Conexion.Conexion;
import dto.DTOPrestamo;
import dto.DTOUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPrestamo {
    
    Conexion Conexion = new Conexion();
    ResultSet rs;
    
    public boolean registrarPrestamo(DTOPrestamo dtoPrestamo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("insert into tblprestamo values(null,'"+dtoPrestamo.getDocCliente()+"','"+dtoPrestamo.getDocEmpleado()+"','"+dtoPrestamo.getFechapedido()+"','"+dtoPrestamo.getFechaentrega()+"','"
                         + dtoPrestamo.getNombredestinatario()+ "', '" + dtoPrestamo.getDocumentodestinatario()+ "', '" + dtoPrestamo.getPrecio_Domi()+ "')");
        System.out.println("Se inserto el prestamo con codigo: " +dtoPrestamo.getDocCliente());
        return true;
    }
    public boolean registrarPrestamo2(DTOPrestamo dtoPrestamo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("insert into tblprestamo values(null,'"+dtoPrestamo.getDocCliente()+"','"+dtoPrestamo.getDocEmpleado()+"','"+dtoPrestamo.getFechapedido()+"','"+dtoPrestamo.getFechaentrega()+"',NULL, NULL, '" + dtoPrestamo.getPrecio_Domi()+ "')");
        System.out.println("Se inserto el prestamo con codigo: " +dtoPrestamo.getDocCliente());
        return true;
    }
    public boolean actualizarPrestamo(DTOPrestamo dtoPrestamo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("update tblprestamo set DocCliente = '"+dtoPrestamo.getDocCliente()+
        "', DocEmpleado = '"+dtoPrestamo.getDocEmpleado()+"', FechaPedido = '"+dtoPrestamo.getFechapedido()+
        "',FechaEntrega = '"+dtoPrestamo.getFechaentrega()+"', NombreDestinatario = '"+dtoPrestamo.getNombredestinatario()+
        "',DocDestinatario = '"+dtoPrestamo.getDocumentodestinatario()+"', '" + dtoPrestamo.getPrecio_Domi()+ "' where Codigo = '"+dtoPrestamo.getCodigo()+"'");
        System.out.println("Se ha actualizado los datos del prestamo con codigo: "+dtoPrestamo.getCodigo());
        return true;
    }
    public boolean eliminarPrestamo(int codigo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("delete from tblprestamo where Codigo = '"+codigo+"'");
        System.out.println("Borro el prestamo con codigo: " + codigo);
        return true;
    }
    public DTOPrestamo buscarPrestamo(int codigo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        ResultSet rs = cn.executeQuery("select * from tblprestamo where Codigo = '"+codigo+"'");
        rs.last();
        return new DTOPrestamo(rs.getInt("Codigo"),rs.getString("DocCliente"),rs.getString("DocEmpleado"),rs.getString("FechaPedido"),rs.getString("FechaEntrega"),rs.getString("NombreDestinatario"),rs.getString("DocDestinatario"),rs.getInt("Precio_Domi"));
        }
    public List<DTOPrestamo> mostrarPrestamos() throws SQLException, InstantiationException, IllegalAccessException {
        List<DTOPrestamo> listaPrestamos = new ArrayList<DTOPrestamo> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblprestamo");
        rs.beforeFirst();
        while(rs.next()){
            listaPrestamos.add(new DTOPrestamo(rs.getInt("Codigo"),rs.getString("DocCliente"),rs.getString("DocEmpleado"),rs.getString("FechaPedido"),rs.getString("FechaEntrega"),rs.getString("NombreDestinatario"),rs.getString("DocDestinatario"),rs.getInt("Precio_Domi")));
        }
        return listaPrestamos;
    }

    public List<DTOPrestamo> buscarLike(String codigo) throws SQLException, InstantiationException, IllegalAccessException{
        List<DTOPrestamo> listaPrestamos = new ArrayList<DTOPrestamo> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TP.Codigo, CONCAT(TU.Nombres, TU.Apellidos) as Cliente, CONCAT(TUS.Nombres, TUS.Apellidos) as Empleado, TP.FechaPedido, TP.FechaEntrega, TP.NombreDestinatario, TP.DocDestinatario, TP.Precio_Domi from tblprestamo AS TP INNER JOIN tblusuario AS TU ON TP.DocCliente = TU.DocIdentidad INNER JOIN tblusuario AS TUS ON TP.DocEmpleado = TUS.DocIdentidad where (TP.Codigo LIKE '%"+codigo+"%' OR TU.Nombres LIKE '%"+codigo+"%' OR TU.Apellidos LIKE '%"+codigo+"%' OR TUS.Nombres LIKE '%"+codigo+"%' OR TUS.Apellidos LIKE '%"+codigo+"%') order by TP.Codigo DESC");
        rs.beforeFirst();
        while(rs.next()){
            listaPrestamos.add(new DTOPrestamo(rs.getInt("Codigo"),rs.getString("Cliente"),rs.getString("Empleado"),rs.getString("FechaPedido"),rs.getString("FechaEntrega"),rs.getString("NombreDestinatario"),rs.getString("DocDestinatario"),rs.getInt("Precio_Domi")));
        }
        return listaPrestamos;
    }
      public int ultimo_insertado() throws SQLException, InstantiationException, IllegalAccessException{
     Statement cn = Conexion.conectar().createStatement();
     ResultSet rs = cn.executeQuery("SELECT Codigo FROM tblprestamo ORDER BY Codigo desc limit 1");
     rs.last();
     return rs.getInt("Codigo");
 }
    
}