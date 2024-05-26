package TiketPesawat.controller;

import TiketPesawat.helper.DBHelper;
import TiketPesawat.model.JadwalModel;
import TiketPesawat.model.KotaModel;
import TiketPesawat.views.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JadwalController {
  JadwalView view;

  // Deklar Controller
  AdminController ac;
  
  //  buat tabel
  private DefaultTableModel model;

  public JadwalController() {
      String [] kolom = {"kode Jadwal", "Kode Maskapai", "Kota Awal", "Kota Tujuan", "Jam Keberangkatan", "Jam Kedatangan", "Harga"};
      model = new DefaultTableModel(kolom, 0);
      refreshTable();
      
    view = new JadwalView(this);
    view.getJadwalTabel().setModel(model);
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
    public void addData(String kode, String pesawat, String kotaAwal, String kotaTujuan, String jamKeb, String jamKed, String harga){
      
        DBHelper helper = new DBHelper();
        if(helper.insertDataJadwal(kode, pesawat, kotaAwal, kotaTujuan, jamKeb, jamKed, harga)){
           JOptionPane.showMessageDialog(null, "Data berhasil!");
            refreshTable();
        }else{
            JOptionPane.showMessageDialog(null, "Kode gak boleh sama!");
        }   
   
    }
    
    /**
     *
     * @param row
     * @param kode
     * @param pesawat
     * @param kotaAwal
     * @param kotaTujuan
     * @param jamKeb
     * @param jamKed
     * @param harga
     */
    public void updateData(int row, String kode, String pesawat, String kotaAwal, String kotaTujuan, String jamKeb, String jamKed, String harga){
        String id = model.getValueAt(row, 0).toString();
        if(row != -1){
            DBHelper helper = new DBHelper();
            if(helper.updateDataJadwal(kode, pesawat, kotaAwal, kotaTujuan, jamKeb, jamKed, harga)){
                JOptionPane.showMessageDialog(null, "Data Diubah!");
                refreshTable();
            } else {
            }
        }else{
            System.out.println("Tidak ada data");
        }
    }
    
    public void hapusData(int row){
        String kode = model.getValueAt(row, 0).toString();
        if(row != -1){
            DBHelper helper = new DBHelper();
            if(helper.deleteDataJadwal(kode)){
                JOptionPane.showMessageDialog(null, "Data Dihapus!");
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
        List<JadwalModel> data = helper.getAllJadwal();
        for(JadwalModel m : data){
            // nambah baris - dalamnya array
            
            model.addRow(new Object[]{
                m.getKodeJadwal(), 
                m.getKodePesawat(),
                m.getKotaAwal(),
                m.getKotaTujuan(),
                m.getJamKeberangkatan(),
                m.getJamKedatangan(),
                m.getHarga()
            });
        }
    }
   
  // methode tambahan
  public void keAdmin() {
    ac = new AdminController();
    ac.tampilPage();
    view.setVisible(false);
  }

}
