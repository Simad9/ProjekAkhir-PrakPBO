package TiketPesawat.helper;

import TiketPesawat.model.JadwalModel;
import java.sql.*;
import java.util.*;

public class DBJadwal {

    private String dbUrl = "jdbc:mysql://localhost/projek_akhir_pbo";
    private String user = "root";
    private String pass = "";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String query;

    public DBJadwal() {
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- Jadwal Feature ---
    public List<JadwalModel> getDataPesawat() {
        String query = "SELECT * FROM pesawat";
        List<JadwalModel> list = new ArrayList<JadwalModel>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                JadwalModel data = new JadwalModel();
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

    public List<JadwalModel> getDataKota() {
        String query = "SELECT * FROM kota";
        List<JadwalModel> list = new ArrayList<JadwalModel>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                JadwalModel data = new JadwalModel();
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

    public List<JadwalModel> getAllJadwal() {
        List<JadwalModel> list = new ArrayList<JadwalModel>();
        query = "SELECT * FROM jadwal";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                JadwalModel data = new JadwalModel();
                data.setKodeJadwal(rs.getString("kodeJadwal"));
                data.setKodePesawat(rs.getString("kodePesawat"));
                data.setKodeKotaAwal(rs.getString("kodeKotaAwal"));
                data.setKodeKotaTujuan(rs.getString("kodeKotaTujuan"));
                data.setJamKeberangkatan(rs.getString("jamKeberangkatan"));
                data.setJamKedatangan(rs.getString("jamKedatangan"));
                data.setHarga(rs.getString("harga"));
                data.setKursiDiambil(rs.getString("kursiDiambil"));
                data.setKursiTersedia(rs.getString("kursiTersedia"));
                data.setStatusKuota(rs.getString("statusKuota"));
                list.add(data);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertDataJadwal(String kode, String pesawat, String kotaAwal, String kotaTujuan, String jamKeb,
            String jamKed, String harga, String kursiTersedia, String kursiDiambil) {
        boolean value = false;
        
        query = "INSERT INTO `jadwal` (`kodeJadwal`, `jamKeberangkatan`, `jamKedatangan`, `harga`, `kodePesawat`, `kodeKotaAwal`, `kodeKotaTujuan`, `kursiTersedia`, `kursiDiambil`) VALUES ('"
                + kode + "', '" + jamKeb + "', '" + jamKed + "', '" + harga + "', '" + pesawat + "', '" + kotaAwal
                + "', '" + kotaTujuan + "', '" + kursiTersedia + "', '" + kursiDiambil + "')";
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

    public boolean deleteDataJadwal(String kode) {
        boolean value = false;
        query = "DELETE FROM jadwal WHERE kodeJadwal=\"" + kode + "\"";
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

    public boolean updateDataJadwal(String kode, String pesawat, String kotaAwal, String kotaTujuan, String jamKeb,
            String jamKed, String harga, String kursiTersedia, String kursiDiambil) {
        boolean value = false;
        query = "UPDATE `jadwal` SET "
                + "kodePesawat = '" + pesawat + "', kodeKotaAwal = '" + kotaAwal + "', kodeKotaTujuan = '" + kotaTujuan + "', "
                + "`jamKeberangkatan` = '" + jamKeb + "', `jamKedatangan` = '" + jamKed + "', `harga` = '" + harga + "', "
                + "`kursiTersedia` = '" + kursiTersedia + "', `kursiDiambil` = '" + kursiDiambil + "' "
                + "WHERE kodeJadwal = '" + kode + "';";
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

    public boolean isKodeJadwalExists(String kodeJadwal) {
        boolean exists = false;
        String query = "SELECT COUNT(*) FROM jadwal WHERE kodeJadwal = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, kodeJadwal);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

}
