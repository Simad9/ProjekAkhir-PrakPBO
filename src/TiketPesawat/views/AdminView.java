/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TiketPesawat.views;

import TiketPesawat.controller.AdminController;

/**
 *
 * @author user
 */
public class AdminView extends javax.swing.JFrame {

    AdminController ac;
    public AdminView(AdminController c) {
        initComponents();
        this.ac = c;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sapaan = new javax.swing.JLabel();
        kotaBtn = new javax.swing.JButton();
        jadwalBtn = new javax.swing.JButton();
        pesawatBtn = new javax.swing.JButton();
        keluarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Halaman Admin");

        sapaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sapaan.setText("Hallo, Siapa");

        kotaBtn.setText("Kota");
        kotaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kotaBtnMouseClicked(evt);
            }
        });

        jadwalBtn.setText("Jadwal Penerbangan");
        jadwalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jadwalBtnMouseClicked(evt);
            }
        });

        pesawatBtn.setText("Pesawat");
        pesawatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesawatBtnMouseClicked(evt);
            }
        });

        keluarBtn.setBackground(java.awt.Color.red);
        keluarBtn.setForeground(new java.awt.Color(255, 255, 255));
        keluarBtn.setText("Keluar");
        keluarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarBtnMouseClicked(evt);
            }
        });
        keluarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(kotaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pesawatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(sapaan)
                        .addComponent(jadwalBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(keluarBtn))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sapaan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kotaBtn)
                    .addComponent(pesawatBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jadwalBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keluarBtn)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   //   Tombol pindah halaman
    private void kotaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kotaBtnMouseClicked
        // TODO add your handling code here:
        ac.keKota();
    }//GEN-LAST:event_kotaBtnMouseClicked

    private void pesawatBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesawatBtnMouseClicked
        // TODO add your handling code here:
        ac.kePesawat();
    }//GEN-LAST:event_pesawatBtnMouseClicked

    private void jadwalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jadwalBtnMouseClicked
        // TODO add your handling code here:
        ac.keJadwal();
    }//GEN-LAST:event_jadwalBtnMouseClicked

    private void keluarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarBtnMouseClicked
        // TODO add your handling code here:
        ac.hilangPage();
    }//GEN-LAST:event_keluarBtnMouseClicked

    private void keluarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keluarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jadwalBtn;
    private javax.swing.JButton keluarBtn;
    private javax.swing.JButton kotaBtn;
    private javax.swing.JButton pesawatBtn;
    private javax.swing.JLabel sapaan;
    // End of variables declaration//GEN-END:variables

//    Ganti text label
    public void ubahLabel(String nama){
        sapaan.setText("Hallo, "+nama+"");
    }
}
