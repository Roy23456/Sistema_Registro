package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndicadorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List totalDespacho() {
        String sql = "SELECT e.Descripcion, DATE_FORMAT(d.fechaDespacho, '%Y-%m') AS Mes, SUM(dd.Cantidad) AS cantidadDespachos"
                + " FROM detalle_despacho dd"
                + " JOIN despacho d ON dd.idDespacho = d.idDespacho"
                + " JOIN equipos e ON dd.idEquipo = e.idEquipo"
                + " GROUP BY DATE_FORMAT(d.fechaDespacho, '%Y-%m'), e.Descripcion"
                + " ORDER BY DATE_FORMAT(d.fechaDespacho, '%Y-%m'), e.Descripcion";
        
        List<Indicador> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Indicador i = new Indicador();
                i.setDescripcion(rs.getString("Descripcion"));
                i.setCantidadTotal(rs.getInt("cantidadDespachos"));
                i.setMes(rs.getString("Mes"));
                lista.add(i);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }
    
    public List indiceRotacion() {
        
        String sql = "SELECT DATE_FORMAT(d.fechaDespacho, '%Y-%m') AS Mes, e.Descripcion,"
                + " (SUM(dd.Cantidad) / ((e.Cantidad + SUM(dd.Cantidad))/2)) * 100 AS indiceRotacion"
                + " FROM equipos e"
                + " LEFT JOIN detalle_despacho dd ON e.idEquipo = dd.idEquipo"
                + " LEFT JOIN despacho d ON dd.idDespacho = d.idDespacho"
                + " WHERE YEAR(d.fechaDespacho) = YEAR(e.Fecha)"
                + " GROUP BY DATE_FORMAT(d.fechaDespacho, '%Y-%m'), e.Descripcion";
        
        List<Indicador> indice = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Indicador i = new Indicador();
                i.setDescripcion(rs.getString("Descripcion"));
                i.setIndiceRotacion(rs.getDouble("indiceRotacion"));
                i.setMes(rs.getString("Mes"));
                indice.add(i);
            }
            
        } catch (SQLException e) {
        }
        
        return indice;
    }
    
}
