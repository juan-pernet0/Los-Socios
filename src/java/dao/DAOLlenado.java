package dao;

import Conexion.Conexion;
import dto.DTOLlenado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOLlenado {
    Conexion Conexion = new Conexion();
    ResultSet rs;
    
    public boolean registrarLlenado(DTOLlenado dtoLlenado) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("insert into tblllenado values(NULL,now(),'"+dtoLlenado.getNitEmpresa()+"')");
        System.out.println("Se inserto el proceso de llenado con empresa : "+dtoLlenado.getNitEmpresa()+" y con fecha de llenado: "+dtoLlenado.getFechallenado());
        return true;
    }

    public boolean modificarLlenado(DTOLlenado dtoLlenado) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("update tblllenado set Codigo  = '"+dtoLlenado.getCodigo()+
        "',FechaLlenado = '"+dtoLlenado.getFechallenado()+"',NitEmpresa  = '"+dtoLlenado.getNitEmpresa()+
        "' where Codigo = '"+dtoLlenado.getCodigo()+"'" );
        System.out.println("se modifico el llenado con codigo: " + dtoLlenado.getCodigo());
        return true;
    }
    
    
    
    public boolean eliminarLlenado(int Codigo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn= Conexion.conectar().createStatement();
        cn.executeUpdate("delete from tblllenado where Codigo = '"+Codigo+"'" );
        System.out.println("se elimino el llenado con codigo: " + Codigo);
        return true;
    }
    
    public DTOLlenado buscarLlenado(int Codigo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblllenado where Codigo = '"+Codigo+"'");
        rs.last();
        return new DTOLlenado(rs.getInt("Codigo"),rs.getString("FechaLlenado"),rs.getString("NitEmpresa"));
    }
    
    public List<DTOLlenado> mostrarLlenados() throws SQLException, InstantiationException, IllegalAccessException{
        List<DTOLlenado> listaLlenados = new ArrayList<DTOLlenado> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblllenado");
        rs = st.executeQuery("select TL.Codigo, TL.FechaLlenado, TE.Nombres AS NitEmpresa from tblllenado AS TL inner join tblempresa as TE on TL.CodEmpresa = TE.NIT");
        rs.beforeFirst();
        while(rs.next()){
            listaLlenados.add(new DTOLlenado(rs.getInt("Codigo"),rs.getString("FechaLlenado"),rs.getString("NitEmpresa")));
        }
        return listaLlenados;
    }
        public List<DTOLlenado> buscarLike(String codigo) throws SQLException, InstantiationException, IllegalAccessException{
        List<DTOLlenado> listaLlenados = new ArrayList<DTOLlenado> ();
        Statement st= Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select TL.Codigo, TL.FechaLlenado, TE.Nombres AS NitEmpresa from tblllenado AS TL inner join tblempresa as TE on TL.CodEmpresa = TE.NIT where TL.Codigo LIKE '%"+codigo+"%' OR TE.Nombres LIKE '%"+codigo+"%'");
        rs.beforeFirst();
        while(rs.next()){
            listaLlenados.add(new DTOLlenado(rs.getInt("Codigo"),rs.getString("FechaLlenado"),rs.getString("NitEmpresa")));
        }
        return listaLlenados;
    }
        public int ultimo_insertado() throws SQLException, InstantiationException, IllegalAccessException{
     Statement cn = Conexion.conectar().createStatement();
     ResultSet rs = cn.executeQuery("SELECT Codigo FROM tblllenado ORDER BY Codigo desc limit 1");
     rs.last();
     return rs.getInt("Codigo");
 }
}