package dao;

import Conexion.Conexion;
import dto.DTODevolucion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAODevolucion {
    Conexion Conexion = new Conexion();
    ResultSet rs;
    
    public boolean registrarDevolucion(DTODevolucion dtoDevolucion) throws SQLException, InstantiationException, IllegalAccessException {                
        try {
            Statement cn= Conexion.conectar().createStatement();
            cn.executeUpdate("insert into tbldevolucion values(null,'" + dtoDevolucion.getCodPrestamo() + "','" + dtoDevolucion.getDocEmpleado()+"',now())");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean modificarDevolucion(DTODevolucion dtoDevolucion) throws SQLException, InstantiationException, IllegalAccessException {                
        try {
            Statement cn= Conexion.conectar().createStatement();
            cn.executeUpdate("update tbldevolucion set CodPrestamo = '"+dtoDevolucion.getCodPrestamo()
                    +"',DocEmpleado ='" + dtoDevolucion.getDocEmpleado()
                    +"',FechaDevolucion = '" + dtoDevolucion.getFechaDevolucion()+"' where Codigo = '" + dtoDevolucion.getCodigo()+"'");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<DTODevolucion> listaDevoluciones(String codigo) throws SQLException, InstantiationException, IllegalAccessException{
        List<DTODevolucion> listaDevoluciones = new ArrayList<DTODevolucion> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TD.Codigo AS 'Codigo', CONCAT(TU.DocIdentidad,' - ',TU.Nombres,' ',TU.Apellidos) as 'CodPrestamo',CONCAT(TUS.Nombres,' ',TUS.Apellidos) AS 'DocEmpleado', TD.FechaDevolucion as 'FechaDevolucion' FROM tbldevolucion as TD INNER JOIN tblprestamo as TP ON TD.CodPrestamo = TP.Codigo INNER JOIN tblusuario as TU ON TP.DocCliente = TU.DocIdentidad INNER JOIN tblusuario as TUS on TP.DocEmpleado = TUS.DocIdentidad;");        rs.beforeFirst();
        while(rs.next()){
            listaDevoluciones.add(new DTODevolucion(rs.getInt("Codigo"),rs.getString("CodPrestamo"),rs.getString("DocEmpleado"),rs.getString("FechaDevolucion")));
        }
        return listaDevoluciones;
    }
      public String ultimo_insertado() throws SQLException, InstantiationException, IllegalAccessException{
     Statement cn = Conexion.conectar().createStatement();
     ResultSet rs = cn.executeQuery("SELECT Codigo FROM tbldevolucion ORDER BY Codigo desc limit 1");
     rs.last();
     return rs.getString("Codigo");
 }
}
