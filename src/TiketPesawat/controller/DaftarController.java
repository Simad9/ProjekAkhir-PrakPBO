package TiketPesawat.controller;

import TiketPesawat.helper.DBHelper;
import TiketPesawat.views.*;
import javax.swing.JOptionPane;

public class DaftarController {
  DaftarView view;

  // Deklar Controller
  MasukController mc;

  public DaftarController() {
    view = new DaftarView(this);
    view.setVisible(true);
    view.setLocationRelativeTo(null);
  }

  public void tampilPage() {
    view.setVisible(true);
  }

  public void hilangPage() {
    view.setVisible(false);
  }

  // Methode buat feature
  public void daftarUser(String nama, String email, String username, String password) {
    DBHelper helper = new DBHelper();
    if (helper.daftarUser(nama, email, username, password)) {
      JOptionPane.showMessageDialog(null, "Akun Terdaftar!");
      mc = new MasukController();
      mc.tampilPage();
      view.setVisible(false);
    } else {
      JOptionPane.showMessageDialog(null, "Username sudah dipake!");
    }
  }

  // method buat pindah halaman
  public void keMasuk() {
    mc = new MasukController();
    mc.tampilPage();
    view.setVisible(false);
  }
}
