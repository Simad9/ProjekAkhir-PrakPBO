package TiketPesawat.controller;

import TiketPesawat.views.*;

public class AdminController {
  // Dekler View
  AdminView view;

  // Dekler Controller
  KotaController kc;
  PesawatController pc;
  JadwalController jc;

  public AdminController() {
    view = new AdminView(this);
    view.setVisible(true);
    view.setLocationRelativeTo(null);
  }

  public void tampilPage() {
    view.setVisible(true);
  }

  public void hilangPage() {
    view.setVisible(false);
  }
  
//  methode buat ganti label
  public void ambilNama(String nama){
      view.ubahLabel(nama);
  }
  
//  Method buat pindah halaman
  public void keKota() {
    kc = new KotaController();
    kc.tampilPage();
    view.setVisible(false);
  }

  public void kePesawat() {
    pc = new PesawatController();
    pc.tampilPage();
    view.setVisible(false);
  }

  public void keJadwal() {
    jc = new JadwalController();
    jc.tampilPage();
    view.setVisible(false);
  }
}
