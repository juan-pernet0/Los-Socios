package dao;

import Conexion.Conexion;
import dto.DTOPrestamoCilindro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPrestamoCilindro {
    Conexion Conexion = new Conexion();
    ResultSet rs;
    
    public boolean registrarPrestamoCilindro(DTOPrestamoCilindro dtoPrestamoCilindro) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("insert into tblprestamocilindros values('" + dtoPrestamoCilindro.getCodigoPrestamo()+ "','" + dtoPrestamoCilindro.getCodCilindro() + "','" 
                        + dtoPrestamoCilindro.getCantidad() + "')");        
        System.out.println("se inserto el prestamo: " + dtoPrestamoCilindro.getCodigoPrestamo() + " con el cilindro: " + dtoPrestamoCilindro.getCodCilindro());
        return true;
    }
    
    public boolean modificarPrestamoCilindro(DTOPrestamoCilindro dtoPrestamoCilindro) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("update tblprestamocilindros set CodigoPrestamo   = '"+dtoPrestamoCilindro.getCodigoPrestamo()+
        "',CodCilindro  = '"+dtoPrestamoCilindro.getCodCilindro()+"',Cantidad = '"+dtoPrestamoCilindro.getCantidad()+
        "' where CodigoPrestamo   = '"+dtoPrestamoCilindro.getCodigoPrestamo()+
        "' && CodCilindro = '"+dtoPrestamoCilindro.getCodCilindro()+"'" );
        System.out.println("se modifico el prestamo: " + dtoPrestamoCilindro.getCodigoPrestamo() + " con el cilindro: " + dtoPrestamoCilindro.getCodCilindro());
        return true;
    }
    
    public boolean eliminarPrestamoCilindro(int CodigoPrestamo, int CodCilindro) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("delete from tblprestamocilindros where CodigoPrestamo  = '"+CodigoPrestamo+"' && CodCilindro = '"+CodCilindro+"'" );
        System.out.println("se elimino el campo con codigo prestamo: " + CodigoPrestamo+" y codigo cilindro: "+CodCilindro);
        return true;
    }
    public DTOPrestamoCilindro buscar1PrestamoCilindro(int CodigoPrestamo, int CodCilindro) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        ResultSet rs = cn.executeQuery("select * from tblprestamocilindros where CodigoPrestamo  = '"+CodigoPrestamo+"' && CodCilindro = '"+CodCilindro+"'" );
        rs.last();
        return new DTOPrestamoCilindro(rs.getInt("CodigoPrestamo"),rs.getInt("CodCilindro"),rs.getInt("Cantidad")); 
    }
    
    //mostrar todos los registros de tblprestamocilindros que pertenescan al mismo prestmo
    public List<DTOPrestamoCilindro> mostrarPrestamoCilindroxCodigoPrestamo(int CodigoPrestamo) throws SQLException, InstantiationException, IllegalAccessException{
        List<DTOPrestamoCilindro> listaPrestamoCilindro = new ArrayList<DTOPrestamoCilindro> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblprestamocilindros where CodigoPrestamo  = '"+CodigoPrestamo+"'");
        rs.beforeFirst();
        while(rs.next()){
            listaPrestamoCilindro.add(new DTOPrestamoCilindro(rs.getInt("CodigoPrestamo"),rs.getInt("CodCilindro"),rs.getInt("Cantidad")));
        }
        return listaPrestamoCilindro;
    }
    
    public List<DTOPrestamoCilindro> listaPrestamoCilindro() throws SQLException, InstantiationException, IllegalAccessException{
        List<DTOPrestamoCilindro> listaPrestamoCilindro = new ArrayList<DTOPrestamoCilindro> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblprestamocilindros");
        rs.beforeFirst();
        while(rs.next()){
            listaPrestamoCilindro.add(new DTOPrestamoCilindro(rs.getInt("CodigoPrestamo"),rs.getInt("CodCilindro"),rs.getInt("Cantidad")));
        }
        return listaPrestamoCilindro;
    }
public List<DTOPrestamoCilindro> ListaCilindrosPrestados() throws SQLException, InstantiationException, IllegalAccessException{
        List<DTOPrestamoCilindro> ListaCilindrosPrestados = new ArrayList<DTOPrestamoCilindro> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TD.CodPrestamo as 'Codigo_Prestamo', TDC.CodCilindros as 'Codigo_Cilindros', (TPC.Cantidad-SUM(TDC.Cantidad)) AS 'Cilindros_Prestados_ Actualmente' FROM tbldevolucion as TD INNER JOIN tbldevolucioncilindros as TDC on TD.Codigo = TDC.CodDevolucion INNER JOIN tblprestamo as TP on TP.Codigo = TD.CodPrestamo INNER JOIN tblprestamocilindros as TPC on TP.Codigo = TPC.CodigoPrestamo where TPC.CodigoPrestamo = TD.CodPrestamo AND TPC.CodCilindro = TDC.CodCilindros GROUP BY TD.CodPrestamo;");
        rs.beforeFirst();
        while(rs.next()){
            ListaCilindrosPrestados.add(new DTOPrestamoCilindro(rs.getInt("Codigo_Prestamo"),rs.getInt("Codigo_Cilindros"),rs.getInt("Cilindros_Prestados_ Actualmente")));
        }
        return ListaCilindrosPrestados;
    }
}
