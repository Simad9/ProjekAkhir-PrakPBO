package TiketPesawat.controller;

import TiketPesawat.views.*;

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

  public void hilangPage(){
    view.setVisible(false);
}
  
//    method tambahan
    public void keMasuk() {
        mc = new MasukController();
        mc.tampilPage();
        view.setVisible(false);
    }
}
