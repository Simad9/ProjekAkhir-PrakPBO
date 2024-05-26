package TiketPesawat.controller;

import TiketPesawat.views.*;

public class KotaController {
  KotaView view;

  // Deklar Controller
  AdminController ac;

  public KotaController() {
    view = new KotaView(this);
    view.setVisible(true);
    view.setLocationRelativeTo(null);
  }

  public void tampilPage() {
    view.setVisible(true);
  }

  public void hilangPage() {
    view.setVisible(false);
  }

  public void keAdmin() {
    ac = new AdminController();
    ac.tampilPage();
    view.setVisible(false);
  }
}
