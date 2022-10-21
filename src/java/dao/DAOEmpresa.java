package dao;

import Conexion.Conexion;
import dto.DTOEmpresa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEmpresa {

    Conexion Conexion = new Conexion();
    ResultSet rs;


    public boolean registrarEmpresa(DTOEmpresa dtoEmpresa) throws SQLException, InstantiationException, IllegalAccessException {
       try{ 
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("insert into tblempresa values('"+ dtoEmpresa.getNit()+"','" +dtoEmpresa.getNombre()+"')");
        System.out.println("Inserto la empresa: " + dtoEmpresa.getNombre()+ " con codigo: " + dtoEmpresa.getNit());
        return true;
        
    } catch (Exception e){
        return false;
    }    
}

    public boolean modificarEmpresa(DTOEmpresa dtoEmpresa) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("update tblempresa set NIT = '"+dtoEmpresa.getNit()+"', Nombres = '"+dtoEmpresa.getNombre()+
            "'where NIT  = '"+dtoEmpresa.getNit()+"'");
        System.out.println("Modifico a la: " + dtoEmpresa.getNombre() + " con codigo: " + dtoEmpresa.getNit());
        return true;
    }

    public boolean eliminarEmpresa(String nit) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("delete from tblempresa where NIT = '"+nit+"'" );
        System.out.println("Borro la empresa con codigo: " + nit);
        return true;
    }
    
    public DTOEmpresa buscarEmpresa(String nit) throws SQLException, InstantiationException, IllegalAccessException {
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblempresa where NIT = '"+nit+"'");
        rs.last();
        return new DTOEmpresa(rs.getString("NIT"),rs.getString("Nombres"));
        }
    public List<DTOEmpresa> mostrarEmpresa() throws SQLException, InstantiationException, IllegalAccessException {
        List<DTOEmpresa> listaEmpresas = new ArrayList<DTOEmpresa> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblempresa");
        rs.beforeFirst();
        while(rs.next()){
            listaEmpresas.add(new DTOEmpresa(rs.getString("NIT"),rs.getString("Nombres")));
        }
        return listaEmpresas;
    }

    public List<DTOEmpresa> buscarLike(String nit) throws SQLException, InstantiationException, IllegalAccessException{
        List<DTOEmpresa> listaEmpresas = new ArrayList<DTOEmpresa> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TE.NIT, TE.Nombres from tblempresa AS TE where TE.Nombres LIKE '%"+nit+"%' OR TE.NIT LIKE '%"+nit+"%'");
        rs.beforeFirst();
        while(rs.next()){
            listaEmpresas.add(new DTOEmpresa(rs.getString("NIT"),rs.getString("Nombres")));
        }
        return listaEmpresas;
    }
    
}
