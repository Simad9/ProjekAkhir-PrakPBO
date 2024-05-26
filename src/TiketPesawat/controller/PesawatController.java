package TiketPesawat.controller;

import TiketPesawat.views.*;

public class PesawatController {
    PesawatView view;
    
//    Dekler Controller
    AdminController ac;

    public PesawatController() {
        view = new PesawatView(this);
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
