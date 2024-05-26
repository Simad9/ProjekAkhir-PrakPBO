package TiketPesawat.controller;

import TiketPesawat.views.*;

public class PesanController {
  // Deklar Views
  PesanView view;
  // Deklar controller
  MasukController mc;

  public PesanController() {
    view = new PesanView(this);
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

}
