package dao;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dto.DTORol;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAORol {
    Conexion Conexion = new Conexion();
    ResultSet rs;
    
    public boolean registrarRol(DTORol dtoRol) throws SQLException, InstantiationException, IllegalAccessException {
      try {  
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("insert into tblrol values('" + dtoRol.getRol()+ "','" + dtoRol.getNombres() + "')");
        
        System.out.println("Inserto el rol con el numero : " + dtoRol.getRol() + " con Nombres: " + dtoRol.getNombres());
        return true;
    } catch (Exception e){
        return false;
    }    
}
    
    public boolean modificarRol(DTORol dtoRol) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("update tblrol set Rol  = '"+dtoRol.getRol()+
        "',Nombres = '"+dtoRol.getNombres()+"' where Rol = '"+dtoRol.getRol()+"'" );
        System.out.println("Modifico a: " +  dtoRol.getRol() + " con nombre: " + dtoRol.getNombres());
        return true;
    }
    
    public boolean eliminarUsuario(String Rol) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("delete from tblrol where Rol = '"+Rol+"'" );
        System.out.println("Borro El Rol con el numero: " + Rol);
        return true;
    }
    public DTORol buscarRol(String Rol) throws SQLException, InstantiationException, IllegalAccessException {
    Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblrol where Rol = '"+ Rol+"'");
        rs.last();
        return new DTORol(rs.getString("Rol"),rs.getString("Nombres"));
    }
    public List<DTORol> mostrarRoles() throws SQLException, InstantiationException, IllegalAccessException {
        List<DTORol> listaRoles = new ArrayList<DTORol>();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblrol");
        rs.beforeFirst();
        while(rs.next()){
            listaRoles.add(new DTORol(rs.getString("Rol"),rs.getString("Nombres")));
        }
        return listaRoles;
    }
    
    
}
