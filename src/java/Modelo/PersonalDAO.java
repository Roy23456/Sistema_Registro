
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonalDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listarPersonal() {
        String sql = "select * from personal";
        
        List<Personal> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Personal p = new Personal();
                p.setIdPersonal(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCargo(rs.getString(3));
                lista.add(p);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }
}
