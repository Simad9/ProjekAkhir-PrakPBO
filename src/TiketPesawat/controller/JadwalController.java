package TiketPesawat.controller;

import TiketPesawat.views.*;

public class JadwalController {
  JadwalView view;

  // Deklar Controller
  AdminController ac;

  public JadwalController() {
    view = new JadwalView(this);
    view.setVisible(true);
    view.setLocationRelativeTo(null);
  }

  public void tampilPage() {
    view.setVisible(true);
  }

  public void hilangPage() {
    view.setVisible(false);
  }

  // methode tambahan
  public void keAdmin() {
    ac = new AdminController();
    ac.tampilPage();
    view.setVisible(false);
  }

}
