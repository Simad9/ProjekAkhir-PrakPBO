package TiketPesawat.controller;

import TiketPesawat.helper.DBHelper;
import TiketPesawat.model.KotaModel;
import TiketPesawat.views.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class KotaController {
  KotaView view;

  // Deklar Controller
  AdminController ac;
  
//  buat tabel
  private DefaultTableModel model;

  public KotaController() {
      String [] kolom = {"Kode", "Kota"};
      model = new DefaultTableModel(kolom, 0);
      refreshTable();
            
    view = new KotaView(this);
    view.getKotaTabel().setModel(model);
    view.setVisible(true);
    view.setLocationRelativeTo(null);
  }

  public void tampilPage() {
    view.setVisible(true);
  }

  public void hilangPage() {
    view.setVisible(false);
  }
  
//  Metohde buat yang CRUD -- inti feature
   public void addData(String kode, String kota){
        DBHelper helper = new DBHelper();
        if(helper.insertDataKota(kode, kota)){
            refreshTable();
        }else{
            System.out.println("Gagal buat data baru");
        }   
    }
    
    public void updateData(int row, String kode, String kota){
        String id = model.getValueAt(row, 1).toString();
        if(row != -1){
            DBHelper helper = new DBHelper();
            if(helper.updateDataKota(kode, kota)){
                refreshTable();
            }
        }else{
            System.out.println("Tidak ada data");
        }
    }
    
    public void hapusData(int row){
        String kode = model.getValueAt(row, 0).toString();
        if(row != -1){
            DBHelper helper = new DBHelper();
            if(helper.deleteDataKota(kode)){
                refreshTable();
            }
        }else{
            System.out.println("Tidak ada data");
        }
    }
  

//  Methode buat refresh tablenya
   private void refreshTable(){
        model.setRowCount(0);
        DBHelper helper = new DBHelper();
        List<KotaModel> data = helper.getAllKota();
        for(KotaModel m : data){
            // nambah baris - dalamnya array
            model.addRow(new Object[]{m.getKodeKota(), m.getKota()});
        }
    }
  
  
//  methode buat pindah halaman
  public void keAdmin() {
    ac = new AdminController();
    ac.tampilPage();
    view.setVisible(false);
  }
}
