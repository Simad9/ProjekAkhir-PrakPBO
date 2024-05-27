package TiketPesawat.model;

public class Orang {
//    Nampung nama orang
    public String nik, nama, noHp, kursi, totalHarga, kodeJadwal;
    public String uang;

    public Orang(String nik, String nama, String noHp, 
            String kursi, String totalHarga, String uang, String kodeJadwal) {
        this.nik = nik;
        this.nama = nama;
        this.noHp = noHp;
        this.kursi = kursi;
        this.totalHarga = totalHarga;
        this.kodeJadwal = kodeJadwal;
        this.uang = uang;
    }
    
    
}
