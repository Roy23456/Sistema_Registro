
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleDespachoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listarDetalle() {
        String sql = "select D.idDetalleDespacho, D.idDespacho, D.idEquipo, D.Cantidad,"
                + " S.fechaDespacho, E.codigo_SAP, E.Serie, E.Descripcion"
                + " from detalle_despacho D"
                + " inner join despacho S on S.idDespacho = D.idDespacho"
                + " inner join equipos E on E.idEquipo = D.idEquipo";
        
        List<DetalleDespacho> listar = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                DetalleDespacho de = new DetalleDespacho();
                de.setIdDetalleDespacho(rs.getInt(1));
                de.setIdDespacho(rs.getInt(2));
                de.setIdEquipo(rs.getInt(3));
                de.setCantidad(rs.getInt(4));
                de.setFechaDespacho(rs.getString(5));
                de.setCodigo_SAP(rs.getInt(6));
                de.setSerie(rs.getString(7));
                de.setDescripcion(rs.getString(8));
                listar.add(de);
            }
            
        } catch (SQLException e) {
            
        }
        return listar;
    }
    
    public int agregarDetalle(DetalleDespacho de) {
        String sql = "insert into detalle_despacho(idDespacho, idEquipo, Cantidad) values (?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, de.getIdDespacho());
            ps.setInt(2, de.getIdEquipo());
            ps.setInt(3, de.getCantidad());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }
    
    public List filtrarDetalle(int idDespacho) {
        String sql = "select D.idDetalleDespacho, D.idDespacho, D.idEquipo, D.Cantidad,"
                + " S.fechaDespacho, E.codigo_SAP, E.Serie, E.Descripcion"
                + " from detalle_despacho D"
                + " inner join despacho S on S.idDespacho = D.idDespacho"
                + " inner join equipos E on E.idEquipo = D.idEquipo"
                + " where D.idDespacho="+idDespacho;
        
        List<DetalleDespacho> listado = new ArrayList<>();
        
        try {
            con = cn.Conexion();    
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                DetalleDespacho de = new DetalleDespacho();
                de.setIdDetalleDespacho(rs.getInt(1));
                de.setIdDespacho(rs.getInt(2));
                de.setIdEquipo(rs.getInt(3));
                de.setCantidad(rs.getInt(4));
                de.setFechaDespacho(rs.getString(5));
                de.setCodigo_SAP(rs.getInt(6));
                de.setSerie(rs.getString(7));
                de.setDescripcion(rs.getString(8));
                listado.add(de);
            }
            
        } catch (SQLException e) {
            
        }
        return listado;
    }
    
    public int editarDetalle(DetalleDespacho de) {
        String sql = "update detalle_despacho set idEquipo=?, Cantidad=? where idDespacho=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, de.getIdEquipo());
            ps.setInt(2, de.getCantidad());
            ps.setInt(3, de.getIdDespacho());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }    
        return r;
    }
    
    public void eliminarDetalle (int idDespacho) {
        String sql = "delete from detalle_despacho where idDespacho=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDespacho);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
}
