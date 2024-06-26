package TiketPesawat.controller;

import TiketPesawat.helper.DBPesan;
import TiketPesawat.model.*;
import TiketPesawat.views.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PesanController {
    // Deklar Views

    PesanView view;

    // Deklar controller
    MasukController mc;

    //  buat tabel
    private DefaultTableModel model;

    public PesanController() {
        String[] kolom = {"kode Jadwal", "Kode Maskapai", "Kota Awal", "Kota Tujuan", "Jam Keberangkatan",
            "Jam Kedatangan", "Harga", "Kursi Tersedia", "Kursi Terambil", "Status Kuota"};
        model = new DefaultTableModel(kolom, 0);

        view = new PesanView(this);
        view.getPesananTabel().setModel(model);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }

    public void tampilPage() {
        view.setVisible(true);
    }

    public void hilangPage() {
        view.setVisible(false);
    }

    public void keMasuk() {
        mc = new MasukController();
        mc.tampilPage();
    }

    public List loadDataKota() {
        DBPesan helper = new DBPesan();
        List<PesanModel> data = helper.getDataKota();
        return data;
    }

    public void cekJadwal(String kotaAwal, String kotaAkhir) {
        String kodeKotaAwal = kotaAwal.substring(0, 4);
        String kodeKotaTujuan = kotaAkhir.substring(0, 4);

        DBPesan helper = new DBPesan();

        if (kodeKotaAwal.equals(kodeKotaTujuan)) {
            JOptionPane.showMessageDialog(null, "Tempat asal dan tujuan tidak boleh sama!");
            return;
        }

        boolean isDataExist = helper.cekDataJadwal(kodeKotaAwal, kodeKotaTujuan);
        String kodeJadwal = helper.ambilKodeJadwal(kodeKotaAwal, kodeKotaTujuan);

        if (isDataExist) {
            // Periksa status kuota
            boolean isKuotaPenuh = helper.isKuotaPenuh(kodeJadwal);
            if (isKuotaPenuh) {
                JOptionPane.showMessageDialog(null, "Maaf, kuota untuk rute ini sudah penuh. Silakan pilih jadwal lain.");
            } else {
                refreshTable(kodeKotaAwal, kodeKotaTujuan);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tidak ada jadwal yang tersedia untuk rute ini!");
        }
    }

    public void refreshTableCetak(String kotaawal, String kotatujuan) {
        String kodeKotaAwal = kotaawal.substring(0, 4);
        String kodeKotaTujuan = kotatujuan.substring(0, 4);
        refreshTable(kodeKotaAwal, kodeKotaTujuan);

    }

    //  Methode buat refresh tablenya
    private void refreshTable(String kodeKotaAwal, String kodeKotaTujuan) {
        model.setRowCount(0);
        DBPesan helper = new DBPesan();
        List<JadwalModel> data = helper.getJadwal(kodeKotaAwal, kodeKotaTujuan);
        for (JadwalModel m : data) {
            // nambah baris - dalamnya array
            model.addRow(new Object[]{
                m.getKodeJadwal(),
                m.getKodePesawat(),
                m.getKodeKotaAwal(),
                m.getKodeKotaTujuan(),
                m.getJamKeberangkatan(),
                m.getJamKedatangan(),
                m.getHarga(),
                m.getKursiTersedia(),
                m.getKursiDiambil(),
                m.getStatusKuota()
            });
        }
    }

    public String hitungHarga(String jmlKrs, String hrgTkt) {
        int jumlahKursi = Integer.parseInt(jmlKrs);
        int hargaTiket = Integer.parseInt(hrgTkt);
        int total = jumlahKursi * hargaTiket;
        System.out.println("total : " + total);

        return String.valueOf(total);
    }

    public void pembayaranDanCetak(Orang orang) {
        if (orang.nama.isEmpty() || orang.totalHarga.isEmpty() || orang.uang.isEmpty() || orang.kursi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
            return;
        }

        // Pengecekan numerik
        try {
            int totalHargaTiket = Integer.parseInt(orang.totalHarga);
            int uangCustomer = Integer.parseInt(orang.uang);
            int jumlahKursi = Integer.parseInt(orang.kursi);

            DBPesan helper = new DBPesan();
            boolean isKuotaPenuh = helper.isKuotaPenuh(orang.kodeJadwal);

            if (isKuotaPenuh) {
                JOptionPane.showMessageDialog(null, "Kuota penuh! Tidak bisa memesan tiket.");
                return;
            }

            if (totalHargaTiket <= uangCustomer) {
                // Update kursi diambil
                boolean isKursiUpdated = helper.updateKursiDiambil(orang.kodeJadwal, jumlahKursi);
                if (isKursiUpdated) {
                    printTiket(orang);

                } else {
                    JOptionPane.showMessageDialog(null, "Gagal mengupdate jumlah kursi.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Uangnya kurang pak!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Tipe Uang harus berupa angka Manis!");
        }
    }

    //    BUAT CETAK TIKETNYA
    public void printTiket(Orang orang) {
        DBPesan helper = new DBPesan();
        List<JadwalModel> data = helper.getJadwalKodeJadwal(orang.kodeJadwal);

        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tidak ada data jadwal ditemukan untuk kode jadwal: " + orang.kodeJadwal);
            return;
        }

        // Nanti dibuat bisa banyak tiketnya
        String filePath = "C:\\Users\\Akbar\\OneDrive\\Documents\\matkul\\matkul smt 4\\Prak PBO\\TAprakPBO\\ProjekAkhir-PrakPBO\\tiket\\"
                + "tiket-" + orang.nama + "--" + orang.nik + ".txt";
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println("==========   Misal ini   =============");
            writer.println("========== Tiket Pesawat =============");
            writer.println("+ Data Diri Anda : +");
            writer.println("NIK          = " + orang.nik);
            writer.println("Nama         = " + orang.nama);
            writer.println("Nomer HP     = " + orang.noHp);
            writer.println("Jumlah Kursi = " + orang.kursi);
            writer.println("------------------------------------");

            // Write the data for each flight schedule
            writer.println("+ Data Pesawat : +");
            for (JadwalModel m : data) {
                writer.println("Kode Jadwal         = " + m.getKodeJadwal());
                writer.println("Maskapai            = " + m.getPesawat());
                writer.println("Dari Kota           = " + m.getKotaAwal());
                writer.println("Menuju Kota         = " + m.getKotaTujuan());
                writer.println("Jam Keberangkatan   = " + m.getJamKeberangkatan());
                writer.println("Jam Sampai          = " + m.getJamKedatangan());
                writer.println("Harga satu tiket    = " + m.getHarga());
                writer.println("------------------------------------");
            }

            writer.println("Total Harga = " + orang.totalHarga);
            writer.println("------------------------------------");
            writer.println("        SEMOGA SAMPAI TUJUAN        ");
            writer.println("======================================");
            JOptionPane.showMessageDialog(null, "Tiket berhasil di cetak!");
        } catch (FileNotFoundException e) {
        }
    }
}
