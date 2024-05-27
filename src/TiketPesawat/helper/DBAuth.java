package TiketPesawat.helper;

import java.sql.*;

public class DBAuth {
    private String dbUrl = "jdbc:mysql://localhost/projek_akhir_pbo";
    private String user = "root";
    private String pass = "";
    
  private Connection conn;
  private Statement stmt;
  private ResultSet rs;
  private String query;
  
  public DBAuth() {
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  // ---- Auth Feature ----
  public boolean cekLogin(String username, String password) {
    boolean value = false;
    query = "SELECT * FROM users WHERE username = '" + username + "' && password = '" + password + "'";
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(query);
      while (rs.next()) {
        value = true;
      }
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return value;
  }

  public boolean daftarUser(String nama, String email, String username, String password) {
    boolean value = false;
    query = "INSERT INTO `users` (`nama`, `email`, `username`, `password`) VALUES ('" + nama + "', '" + email
        + "', '" + username + "', '" + password + "');";
    try {
      stmt = conn.createStatement();
      if (stmt.executeUpdate(query) > 0) {
        value = true;
      }
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return value;
  }

  public String ambilNama(String username, String password) {
    query = "SELECT * FROM users WHERE username = '" + username + "' && password = '" + password + "'";
    String nama = "";
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(query);
      while (rs.next()) {
        nama = rs.getString("nama");
      }
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return nama;
  }
}
