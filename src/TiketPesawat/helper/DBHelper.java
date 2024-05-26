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

    // -- Kota Feature ---
    public List<KotaModel> getAllKota() {
        query = "SELECT * FROM kota";
        List<KotaModel> list = new ArrayList<KotaModel>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                KotaModel data = new KotaModel();
                data.setKodeKota(rs.getString("kodeKota"));
                data.setKota(rs.getString("kota"));
                list.add(data);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean insertDataKota(String kode, String kota){
        boolean value = false;
        query = "INSERT INTO `kota` (`kodeKota`, `kota`) VALUES ('"+kode+"', '"+kota+"');";
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
    
        public boolean deleteDataKota(String kode){
        boolean value = false;
        query = "DELETE FROM kota WHERE kodeKota =\"" + kode + "\"";
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
        
        public boolean updateDataKota(String kode, String kota){
        boolean value = false;
        query = "UPDATE kota SET kodeKota = '" + kode + "', kota = '" + kota + "' WHERE kodeKota = '" + kode + "'";
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

}
