
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Usuario validarUsuario(String Usuario, String Password) {
        Usuario us = new Usuario();
        String sql = "select U.IdUsuario, U.Nombre, U.Apellido, U.DNI, U.Correo, U.Usuario, U.Password, "
                + "U.IdRol, R.NombreRol from usuario U "
                + "inner join rol R on R.IdRol = U.IdRol "
                + "where Usuario=? and Password=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Usuario);
            ps.setString(2, Password);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                us.setIdUsuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setApellido(rs.getString(3));
                us.setDNI(rs.getInt(4));
                us.setCorreo(rs.getString(5));
                us.setUsuario(rs.getString(6));
                us.setPassword(rs.getString(7));
                us.setIdRol(rs.getInt(8));
                us.setNombreRol(rs.getString(9));
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return us;
    }
    
    public int agregarUsuario(Usuario u) {
        String sql = "insert into usuario (Nombre,Apellido,DNI,Correo,Usuario,Password,IdRol) values(?,?,?,?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setInt(3, u.getDNI());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getUsuario());
            ps.setString(6, u.getPassword());
            ps.setInt(7, u.getIdRol());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }
}
