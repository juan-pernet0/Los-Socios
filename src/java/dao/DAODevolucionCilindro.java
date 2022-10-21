package dao;

import Conexion.Conexion;
import dto.DTODevolucionCilindro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAODevolucionCilindro {
    Conexion Conexion = new Conexion();
    ResultSet rs;
    
    public boolean registrarDevolucionIntermedia(DTODevolucionCilindro dtoDevolucionCilindro) throws SQLException, InstantiationException, IllegalAccessException {                
        try {
            Statement cn= Conexion.conectar().createStatement();
            cn.executeUpdate("insert into tbldevolucioncilindros values('" + dtoDevolucionCilindro.getCodDevolucion() + "','" + dtoDevolucionCilindro.getCodCilindros()+"','" + dtoDevolucionCilindro.getCantidad()+"')");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<DTODevolucionCilindro> ListaCilindrosPrestadostodavia(String CodigoPrestamo) throws SQLException, InstantiationException, IllegalAccessException{
        try{
        List<DTODevolucionCilindro> ListaCilindrosPrestadostodavia = new ArrayList<DTODevolucionCilindro> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TD.CodPrestamo as 'Codigo_Prestamo', TDC.CodCilindros as 'Codigo_Cilindros', (TPC.Cantidad-SUM(TDC.Cantidad)) AS 'Cilindros_Prestados_ Actualmente' FROM tbldevolucion as TD INNER JOIN tbldevolucioncilindros as TDC on TD.Codigo = TDC.CodDevolucion INNER JOIN tblprestamo as TP on TP.Codigo = TD.CodPrestamo INNER JOIN tblprestamocilindros as TPC on TP.Codigo = TPC.CodigoPrestamo where TPC.CodigoPrestamo = TD.CodPrestamo AND TPC.CodCilindro = TDC.CodCilindros GROUP BY TD.CodPrestamo,TDC.CodCilindros HAVING Codigo_Prestamo = '"+CodigoPrestamo+"';");
        rs.beforeFirst();
        while(rs.next()){
            ListaCilindrosPrestadostodavia.add(new DTODevolucionCilindro(rs.getString("Codigo_Prestamo"),rs.getString("Codigo_Cilindros"),rs.getInt("Cilindros_Prestados_ Actualmente")));
        }
        return ListaCilindrosPrestadostodavia;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
