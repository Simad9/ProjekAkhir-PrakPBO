package TiketPesawat.controller;

import TiketPesawat.views.*;

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

//  Method tambahan
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
