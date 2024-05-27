package TiketPesawat.helper;

import java.sql.*;
import java.util.*;
import TiketPesawat.model.*;

public class DBHelper {
    private String dbUrl = "jdbc:mysql://localhost/projek_akhir_pbo";
    private String user = "root";
    private String pass = "";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String query;

    public DBHelper() {
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

    

   

}
