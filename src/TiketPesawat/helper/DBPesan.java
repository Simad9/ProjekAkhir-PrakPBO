package TiketPesawat.helper;

import TiketPesawat.model.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;

public class DBPesan {

    private String dbUrl = "jdbc:mysql://localhost/projek_akhir_pbo";
    private String user = "root";
    private String pass = "";

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String query;

    public DBPesan() {
        try {
            conn = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    --- Pesan Fitur ---
    public List<JadwalModel> getJadwal(String kodeKotaAwal, String kodeKotaTujuan) {
        List<JadwalModel> list = new ArrayList<JadwalModel>();
        query = "SELECT * FROM jadwal WHERE kodeKotaAwal = '" + kodeKotaAwal + "' AND kodeKotaTujuan = '" + kodeKotaTujuan + "'";
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
                data.setKursiTersedia(rs.getString("kursiTersedia"));
                data.setKursiDiambil(rs.getString("kursiDiambil"));
                data.setStatusKuota(rs.getString("statusKuota"));
                list.add(data);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<JadwalModel> getJadwalKodeJadwal(String kodeJadwal) {
        List<JadwalModel> list = new ArrayList<JadwalModel>();
        query = "SELECT jadwal.*, pesawat.pesawat, k1.kota AS kotaAwal, k2.kota AS kotaTujuan "
                + "FROM jadwal "
                + "INNER JOIN pesawat ON pesawat.kodePesawat = jadwal.kodePesawat "
                + "INNER JOIN kota AS k1 ON k1.kodeKota = jadwal.kodeKotaAwal "
                + "INNER JOIN kota AS k2 ON k2.kodeKota = jadwal.kodeKotaTujuan "
                + "WHERE kodeJadwal = '" + kodeJadwal + "'";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                JadwalModel data = new JadwalModel();
                data.setKodeJadwal(rs.getString("kodeJadwal"));
                data.setPesawat(rs.getString("pesawat"));
                data.setKotaAwal(rs.getString("kotaAwal"));
                data.setKotaTujuan(rs.getString("kotaTujuan"));
                data.setJamKeberangkatan(rs.getString("jamKeberangkatan"));
                data.setJamKedatangan(rs.getString("jamKedatangan"));
                data.setHarga(rs.getString("harga"));
                data.setKursiTersedia(rs.getString("kursiTersedia"));
                data.setKursiDiambil(rs.getString("kursiDiambil"));
                data.setStatusKuota(rs.getString("statusKuota"));
                list.add(data);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<PesanModel> getDataKota() {
        String query = "SELECT * FROM kota";
        List<PesanModel> list = new ArrayList<PesanModel>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                PesanModel data = new PesanModel();
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

    public boolean cekDataJadwal(String kodeKotaAwal, String kodeKotaTujuan) {
        boolean value = false;
        query = "SELECT * FROM jadwal WHERE kodeKotaAwal = '" + kodeKotaAwal + "' AND kodeKotaTujuan = '" + kodeKotaTujuan + "' ";
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
    
        public String ambilKodeJadwal(String kodeKotaAwal, String kodeKotaTujuan) {
        String value = "";
        query = "SELECT * FROM jadwal WHERE kodeKotaAwal = '" + kodeKotaAwal + "' AND kodeKotaTujuan = '" + kodeKotaTujuan + "' ";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                value = rs.getString("kodeJadwal");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
    

    public boolean isKuotaPenuh(String kodeJadwal) {
        boolean isFull = false;
        query = "SELECT kursiTersedia, kursiDiambil FROM jadwal WHERE kodeJadwal = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, kodeJadwal);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int kursiTersedia = rs.getInt("kursiTersedia");
                int kursiDiambil = rs.getInt("kursiDiambil");
                if (kursiDiambil >= kursiTersedia && (kursiDiambil + kursiTersedia)>= kursiTersedia) {
                    isFull = true;
                }
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isFull;
    }

    public boolean updateKursiDiambil(String kodeJadwal, int jumlahKursi) {
        boolean isUpdated = false;
        query = "UPDATE jadwal SET kursiDiambil = kursiDiambil + ? WHERE kodeJadwal = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, jumlahKursi);
            pstmt.setString(2, kodeJadwal);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

}
