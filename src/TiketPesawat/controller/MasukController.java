package TiketPesawat.controller;

import TiketPesawat.helper.*;
import TiketPesawat.views.*;
import javax.swing.JOptionPane;

public class MasukController {
  // Deklar view
  MasukView view;

  // Deklar controller
  DaftarController dc;
  AdminController ac;

  public MasukController() {
    view = new MasukView(this);
    view.setVisible(true);
    view.setLocationRelativeTo(null);
  }

  public void tampilPage() {
    view.setVisible(true);
  }

  public void hilangPage() {
    view.setVisible(false);
  }

  // Method fitur
  public void cekLogin(String username, String pass) {
    DBAuth helper = new DBAuth();
    if (helper.cekLogin(username, pass)) {
      JOptionPane.showMessageDialog(null, "Login Berhasil euy!");
      ac = new AdminController();
      ac.tampilPage();
      String nama = helper.ambilNama(username, pass);
      ac.ambilNama(nama);
      view.setVisible(false);

    } else {
      JOptionPane.showMessageDialog(null, "Username atau Password salah euy!");
    }
  }

  // Metohod buat pindah halaman
  public void keAdmin() {
    ac = new AdminController();
    ac.tampilPage();
    view.setVisible(false);
  }

  public void keDaftar() {
    dc = new DaftarController();
    dc.tampilPage();
    view.setVisible(false);
  }

}
