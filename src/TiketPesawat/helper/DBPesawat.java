package TiketPesawat.helper;

import java.sql.*;
import java.util.*;
import TiketPesawat.model.*;

public class DBPesawat {
    private String dbUrl = "jdbc:mysql://localhost/projek_akhir_pbo";
    private String user = "root";
    private String pass = "";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String query;

    public DBPesawat() {
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -- Pesawat Feature ---
    public List<PesawatModel> getAllPesawat() {
        query = "SELECT * FROM pesawat";
        List<PesawatModel> list = new ArrayList<PesawatModel>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                PesawatModel data = new PesawatModel();
                data.setKodePesawat(rs.getString("kodePesawat"));
                data.setPesawat(rs.getString("pesawat"));
                list.add(data);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertDataPesawat(String kode, String pesawat) {
        boolean value = false;
        query = "INSERT INTO `pesawat` (`kodePesawat`, `pesawat`) VALUES ('" + kode + "', '" + pesawat + "');";
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

    public boolean deleteDataPesawat(String kode) {
        boolean value = false;
        query = "DELETE FROM pesawat WHERE kodePesawat =\"" + kode + "\"";
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

    public boolean updateDataPesawat(String kode, String pesawat) {
        boolean value = false;
        query = "UPDATE pesawat SET kodePesawat = '" + kode + "', pesawat = '" + pesawat + "' WHERE kodePesawat= '"
                + kode + "'";
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
