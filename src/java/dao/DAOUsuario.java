package dao;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dto.DTOUsuario;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOUsuario {
    Conexion Conexion = new Conexion();
    ResultSet rs;
    
    public boolean registrarUsuario(DTOUsuario dtoUsuario) throws SQLException, InstantiationException, IllegalAccessException {                
        try {
            Statement cn= Conexion.conectar().createStatement();
            cn.executeUpdate("insert into tblusuario values('" + dtoUsuario.getDocumento() + "','" + dtoUsuario.getNombres() + "','"
                    + dtoUsuario.getApellidos() + "', '" + dtoUsuario.getDireccion() + "','" + dtoUsuario.getTelefono() + "', '"
                    + dtoUsuario.getEmail() + "' , '" + dtoUsuario.getPassword() + "', '" + dtoUsuario.getRol() + "')");

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean modificarUsuario(DTOUsuario dtoUsuario) throws SQLException, InstantiationException, IllegalAccessException {
        try {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("update tblusuario set Nombres = '"+dtoUsuario.getNombres()+
        "',Apellidos = '"+dtoUsuario.getApellidos()+"',Direccion = '"+dtoUsuario.getDireccion()+
        "',Telefono = '"+dtoUsuario.getTelefono()+"',Email = '"+dtoUsuario.getEmail()+"',Password = '"+dtoUsuario.getPassword()+
        "',Rol = '"+dtoUsuario.getRol()+"' where DocIdentidad = '"+dtoUsuario.getDocumento()+"'" );
        System.out.println("se modifico el campo con cedula: " + dtoUsuario.getDocumento());
        return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    
    public boolean eliminarUsuario(String Documento) throws SQLException, InstantiationException, IllegalAccessException {
        try {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("delete from tblusuario where DocIdentidad = '"+Documento+"'" );
        System.out.println("se elimino el campo con cedula: " + Documento);
        return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public DTOUsuario buscarUsuario(String documento) throws SQLException, InstantiationException, IllegalAccessException {
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblusuario where DocIdentidad = '"+ documento+"'");
        rs.last();
        return new DTOUsuario(rs.getString("DocIdentidad"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Direccion"),rs.getString("Telefono"),rs.getString("Email"),rs.getString("Password"),rs.getString("Rol"));
    }
    
    public List<DTOUsuario> mostrarUsuarios() throws SQLException, InstantiationException, IllegalAccessException{
        List<DTOUsuario> listaUsuarios = new ArrayList<DTOUsuario> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select TU.DocIdentidad, TU.Nombres, TU.Apellidos, TU.Direccion, TU.Telefono, TU.Email, TU.Password, TR.Nombres AS 'Rol' from tblusuario AS TU inner join tblrol as TR on TU.Rol = TR.Rol;");
        rs.beforeFirst();
        while(rs.next()){
            listaUsuarios.add(new DTOUsuario(rs.getString("DocIdentidad"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Direccion"),rs.getString("Telefono"),rs.getString("Email"),rs.getString("Password"),rs.getString("Rol")));
        }
        return listaUsuarios;
    }

        public List<DTOUsuario> buscarLike(String codigo, String doc) throws SQLException, InstantiationException, IllegalAccessException{
        List<DTOUsuario> listaUsuarios = new ArrayList<DTOUsuario> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select TU.DocIdentidad, TU.Nombres, TU.Apellidos, TU.Direccion, TU.Telefono, TU.Email, TU.Password, TR.Nombres AS 'Rol' from tblusuario AS TU inner join tblrol as TR on TU.Rol = TR.Rol where (TU.DocIdentidad LIKE '%"+codigo+"%' OR TU.Nombres LIKE '%"+codigo+"%' OR TU.Apellidos LIKE '%"+codigo+"%') AND NOT (TU.DocIdentidad='"+doc+"')");
        rs.beforeFirst();
        while(rs.next()){
            listaUsuarios.add(new DTOUsuario(rs.getString("DocIdentidad"),rs.getString("Nombres"),rs.getString("Apellidos"),rs.getString("Direccion"),rs.getString("Telefono"),rs.getString("Email"),rs.getString("Password"),rs.getString("Rol")));
        }
        return listaUsuarios;
    }

}


