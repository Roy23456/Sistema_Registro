
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    
    public Connection Conexion(){      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://byizrxottl1kxyjagehx-mysql.services.clever-cloud.com:3306/byizrxottl1kxyjagehx?useSSL=false&serverTimezone=America/Lima", "ufmuqw1jsqj0gknk", "1IuAKJeDLMyUnEUsc585");
            System.out.println("Conexion exitosa");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR " +e);
        }
        return con;
    }
}
