
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listarEquipos() {
        String sql = "select * from equipos";
        
        List<Equipo> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Equipo e = new Equipo();
                e.setIdEquipo(rs.getInt(1));
                e.setIdUsuario(rs.getInt(2));
                e.setCodigo_SAP(rs.getInt(3));
                e.setSerie(rs.getString(4));
                e.setDescripcion(rs.getString(5));
                e.setCantidad(rs.getInt(6));
                e.setPrecio(rs.getDouble(7));
                e.setFecha(rs.getString(8));
                lista.add(e);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }
    
    public int agregarEquipo(Equipo eq) {
        String sql = "insert into equipos(idUsuario, codigo_SAP, Serie, Descripcion, Cantidad, Precio, Fecha) values (?,?,?,?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, eq.getIdUsuario());
            ps.setInt(2, eq.getCodigo_SAP());
            ps.setString(3, eq.getSerie());
            ps.setString(4, eq.getDescripcion());
            ps.setInt(5, eq.getCantidad());
            ps.setDouble(6, eq.getPrecio());
            ps.setString(7, eq.getFecha());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }
    
    public List filtrarEquipo(int idEquipo) {
        String sql = "select * from equipos where idEquipo=?";
        
        List<Equipo> listado = new ArrayList<>();
        
        try {
            con = cn.Conexion();    
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Equipo e = new Equipo();
                e.setIdEquipo(rs.getInt(1));
                e.setIdUsuario(rs.getInt(2));
                e.setCodigo_SAP(rs.getInt(3));
                e.setSerie(rs.getString(4));
                e.setDescripcion(rs.getString(5));
                e.setCantidad(rs.getInt(6));
                e.setPrecio(rs.getDouble(7));
                e.setFecha(rs.getString(8));
                listado.add(e);
            }
            
        } catch (SQLException e) {
            
        }
        return listado;
    }
    
    public int editarEquipo(Equipo e) {
        String sql = "update equipos set Descripcion=?, Cantidad=?, Precio=?, Fecha=? where idEquipo=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getDescripcion());
            ps.setInt(2, e.getCantidad());
            ps.setDouble(3, e.getPrecio());
            ps.setString(4, e.getFecha());
            ps.setInt(5, e.getIdEquipo());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            
        }    
        return r;
    }
    
    public void eliminarEquipo(int idEquipo) {
        String sql = "delete from equipos where idEquipo=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
    }
}
