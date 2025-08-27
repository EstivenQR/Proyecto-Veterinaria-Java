package DBCon;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
     
    // Para levantar la BD
    public static final String URL = "jdbc:mysql://localhost:3306/veterinaria_mello";

    public static final String USER = "root";

    public static final String PASS = "MySQLPassword#2023";
    


    public static Connection getConnection() {
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
}

