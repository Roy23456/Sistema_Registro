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
        String sql = "SELECT e.Descripcion, MONTH(d.fechaDespacho) AS mes, SUM(dd.Cantidad) AS cantidadDespachos"
                + " FROM detalle_despacho dd"
                + " JOIN despacho d ON dd.idDespacho = d.idDespacho"
                + " JOIN equipos e ON dd.idEquipo = e.idEquipo"
                + " GROUP BY MONTH(d.fechaDespacho), e.Descripcion"
                + " ORDER BY MONTH(d.fechaDespacho), e.Descripcion";
        
        List<Indicador> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Indicador i = new Indicador();
                i.setDescripcion(rs.getString("Descripcion"));
                i.setCantidadTotal(rs.getInt("cantidadDespachos"));
                i.setMes(rs.getInt("mes"));
                lista.add(i);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }
    
    public List totalRegistros() {
        String sql = "SELECT Descripcion, MONTH(Fecha) AS mes, SUM(Cantidad) AS cantidadEquipos"
                + " FROM equipos"
                + " GROUP BY MONTH(Fecha), Descripcion"
                + " ORDER BY MONTH(Fecha), Descripcion";
        
        List<Indicador> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Indicador i = new Indicador();
                i.setDescripcion(rs.getString("Descripcion"));
                i.setCantidadTotal(rs.getInt("cantidadEquipos"));
                i.setMes(rs.getInt("mes"));
                lista.add(i);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }
}
