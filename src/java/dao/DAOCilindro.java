package dao;

import Conexion.Conexion;
import dto.DTOCilindro;
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

public class DAOCilindro {

    Conexion Conexion = new Conexion();
//    Connection connection = Conexion.conectar();
    ResultSet rs;

    public boolean registrarCilindro(DTOCilindro dtoCilindro) throws SQLException, InstantiationException, IllegalAccessException {
        try {
            Statement cn = Conexion.conectar().createStatement();
            cn.executeUpdate("insert into tblcilindros values(null,'" + dtoCilindro.getEmpresa() + "'," + dtoCilindro.getCapacidad() + "," + dtoCilindro.getPrecio() + "," + dtoCilindro.getCilindros_llenos() + "," + dtoCilindro.getCilindros_Vacios() + "," + dtoCilindro.getCilindros_Prestados() + ")");
            System.out.println("Se inserto el cilindro con la capacidad: " + dtoCilindro.getCapacidad() + " con el precio: " + dtoCilindro.getPrecio() + " de la empresa: " + dtoCilindro.getEmpresa());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean modificarCilindro(DTOCilindro dtoCilindro) throws SQLException, InstantiationException, IllegalAccessException {
        try {
        Statement cn = Conexion.conectar().createStatement();
        cn.executeUpdate("update tblcilindros set CodEmpresa = '" + dtoCilindro.getEmpresa()
                + "',Capacidad = '" + dtoCilindro.getCapacidad() + "',Precio = '" + dtoCilindro.getPrecio()
                + "',CilindrosLlenos = '" + dtoCilindro.getCilindros_llenos() + "',CilindrosVacios = '" + dtoCilindro.getCilindros_Vacios()
                + "',CilindrosPrestados = '" + dtoCilindro.getCilindros_Prestados()
                + "' where Codigo = '" + dtoCilindro.getCodigo() + "'");
        return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarCilindro(int codigo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn = Conexion.conectar().createStatement();
        cn.executeUpdate("delete from tblcilindros where Codigo = '" + codigo + "'");
        System.out.println("Se elimino el registro con el codigo: " + codigo + " de tblcilindros");
        return true;
    }

    public DTOCilindro buscarCilindro(int Codigo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select * from tblcilindros where Codigo = '" + Codigo + "'");
        rs.last();
        return new DTOCilindro(rs.getInt("Codigo"), rs.getInt("Capacidad"), rs.getInt("Precio"), rs.getString("CodEmpresa"), rs.getInt("CilindrosLlenos"), rs.getInt("CilindrosVacios"), rs.getInt("CilindrosPrestados"));

    }

    public List<DTOCilindro> mostrarCilindro() throws SQLException, InstantiationException, IllegalAccessException {
        List<DTOCilindro> listaCilindros = new ArrayList<DTOCilindro>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TC.Codigo, TE.Nombres as 'CodEmpresa', TC.Capacidad, TC.Precio, TC.CilindrosLlenos, TC.CilindrosVacios, TC.CilindrosPrestados FROM tblcilindros as TC inner join tblempresa as TE on TC.CodEmpresa = TE.NIT order by Codigo desc;");
        rs.beforeFirst();
        while (rs.next()) {
            listaCilindros.add(new DTOCilindro(rs.getInt("Codigo"), rs.getInt("Capacidad"), rs.getInt("Precio"), rs.getString("CodEmpresa"), rs.getInt("CilindrosLlenos"), rs.getInt("CilindrosVacios"), rs.getInt("CilindrosPrestados")));
        }
        return listaCilindros;
    }
    
//    buscarCilindroCodigoEmpresa
    
    //METODO QUE SE VA A UTILIZAR  SOLO EN EL CONTROLDE PRESTAMO PARA HACER EL MODIFICAR REQUIRIENDO EL CODIGO DE LA EMPRESA
    public DTOCilindro buscarCilindroNombreEmpresa(int Codigo) throws SQLException, InstantiationException, IllegalAccessException {
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TC.Codigo, TE.Nombres as 'CodEmpresa', TC.Capacidad, TC.Precio, TC.CilindrosLlenos, TC.CilindrosVacios, TC.CilindrosPrestados FROM tblcilindros as TC inner join tblempresa as TE on TC.CodEmpresa = TE.NIT where Codigo = '" + Codigo + "'");
        rs.last();
        return new DTOCilindro(rs.getInt("Codigo"), rs.getInt("Capacidad"), rs.getInt("Precio"), rs.getString("CodEmpresa"), rs.getInt("CilindrosLlenos"), rs.getInt("CilindrosVacios"), rs.getInt("CilindrosPrestados"));

    }
    
    
    public List<DTOCilindro> mostrarCilindro2() throws SQLException, InstantiationException, IllegalAccessException {
        List<DTOCilindro> listaCilindros = new ArrayList<DTOCilindro>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM tblcilindros");
        rs.beforeFirst();
        while (rs.next()) {
            listaCilindros.add(new DTOCilindro(rs.getInt("Codigo"), rs.getInt("Capacidad"), rs.getInt("Precio"), rs.getString("CodEmpresa"), rs.getInt("CilindrosLlenos"), rs.getInt("CilindrosVacios"), rs.getInt("CilindrosPrestados")));
        }
        return listaCilindros;
    }
    
    public List<DTOCilindro> buscarCilindroempresa(String empresa) throws SQLException, InstantiationException, IllegalAccessException {
        List<DTOCilindro> listaCilindrosem = new ArrayList<DTOCilindro>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("SELECT TC.Codigo,TC.CodEmpresa, TE.Nombres as 'CodEmpresa', TC.Capacidad, TC.Precio, TC.CilindrosLlenos, TC.CilindrosVacios, TC.CilindrosPrestados FROM tblcilindros as TC inner join tblempresa as TE on TC.CodEmpresa = TE.NIT where TC.CodEmpresa='"+empresa+"'order by Codigo desc;");
        rs.beforeFirst();
        while (rs.next()) {
            listaCilindrosem.add(new DTOCilindro(rs.getInt("Codigo"), rs.getInt("Capacidad"), rs.getInt("Precio"), rs.getString("CodEmpresa"), rs.getInt("CilindrosLlenos"), rs.getInt("CilindrosVacios"), rs.getInt("CilindrosPrestados")));
        }
        return listaCilindrosem;
    }
}
