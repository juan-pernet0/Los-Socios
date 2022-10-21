/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.Conexion;
import dto.DTOLlenado_Cilindros;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUVAN
 */
public class DAOLlenadoCilindro {

    Conexion Conexion = new Conexion();
    ResultSet rs;

    public boolean registrarLlenado_Cilindros(DTOLlenado_Cilindros dtoLlenado_Cilindros) throws SQLException, InstantiationException, IllegalAccessException {
        Statement cn = Conexion.conectar().createStatement();
        cn.executeUpdate("insert into tblllenadocilindros values('" + dtoLlenado_Cilindros.getCodigoLlenado() + "','" + dtoLlenado_Cilindros.getCodCilindro() + "','" + dtoLlenado_Cilindros.getCantidad() + "','" + dtoLlenado_Cilindros.getPrecio() + "')");
        return true;
    }

    public List<DTOLlenado_Cilindros> buscarLlenadoCilindro(String codigo) throws SQLException, InstantiationException, IllegalAccessException {
        List<DTOLlenado_Cilindros> listaLlenadoCilindros = new ArrayList<DTOLlenado_Cilindros>();
        Statement st = Conexion.conectar().createStatement();
        ResultSet rs = st.executeQuery("select TLL.CodigoLlenado, C.Capacidad As 'Capacidad', TLL.Cantidad, TLL.Precio from tblllenadocilindros as TLL inner join tblcilindros as C on TLL.CodCilindro=C.Codigo INNER JOIN tblllenado AS TL on TLL.CodigoLlenado=TL.Codigo inner join tblempresa as TE on TL.CodEmpresa=TE.NIT  where TL.Codigo LIKE '%" + codigo + "%' OR TE.Nombres LIKE '%" + codigo + "%' OR C.Capacidad LIKE '%" + codigo + "%'");
        rs.beforeFirst();
        while (rs.next()) {
            listaLlenadoCilindros.add(new DTOLlenado_Cilindros(rs.getInt("CodigoLlenado"), rs.getInt("Capacidad"), rs.getInt("Cantidad"), rs.getInt("Precio")));
        }
        return listaLlenadoCilindros;
    }
}
