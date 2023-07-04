
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DespachoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listarDespacho() {
        String sql = "select D.idDespacho, D.idUsuario, D.idPersonal, D.fechaDespacho, P.Nombre"
                + " from despacho D"
                + " inner join personal P on P.idPersonal = D.idPersonal";
        
        List<Despacho> listar = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Despacho d = new Despacho();
                d.setIdDespacho(rs.getInt(1));
                d.setIdUsuario(rs.getInt(2));
                d.setIdPersonal(rs.getInt(3));
                d.setFechaDespacho(rs.getString(4));
                d.setNombre(rs.getString(5));
                listar.add(d);
            }
            
        } catch (SQLException e) {
            
        }
        return listar;
    }
    
    public String idDespacho() {
        String idDespacho = "";
        String sql = "select max(idDespacho) from despacho";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                idDespacho = rs.getString(1);
            }
            
        } catch (SQLException e) {
            
        }
        return idDespacho;
    }
    
    public int agregarDespacho(Despacho d) {
        String sql = "insert into despacho(idPersonal, idUsuario, fechaDespacho) values (?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, d.getIdPersonal());
            ps.setInt(2, d.getIdUsuario());
            ps.setString(3, d.getFechaDespacho());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }    
        return r;
    }
    
    public int editarDespacho(Despacho d) {
        String sql = "update despacho set fechaDespacho=? where idDespacho=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, d.getFechaDespacho());
            ps.setInt(2, d.getIdDespacho());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }    
        return r;
    }
    
    public void eliminarDespacho(int idDespacho) {
        String sql = "delete from despacho where idDespacho=?";
        
        try {
             con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDespacho);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
}

