package TiketPesawat.views;

import TiketPesawat.controller.MasukController;

public class MasukView extends javax.swing.JFrame {

    MasukController mc;
    public MasukView(MasukController c) {
        initComponents();
        this.mc = c;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password = new javax.swing.JPasswordField();
        daftarBtn = new javax.swing.JButton();
        masukBtn = new javax.swing.JButton();
        keluarBtn = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 180, -1));

        daftarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TiketPesawat/img/btn-daftar.png"))); // NOI18N
        daftarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daftarBtnMouseClicked(evt);
            }
        });
        getContentPane().add(daftarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 200, 40));

        masukBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TiketPesawat/img/btn-masuk.png"))); // NOI18N
        masukBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masukBtnMouseClicked(evt);
            }
        });
        getContentPane().add(masukBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 200, 40));

        keluarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TiketPesawat/img/btn-keluar.png"))); // NOI18N
        keluarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarBtnMouseClicked(evt);
            }
        });
        getContentPane().add(keluarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 50, 30));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 180, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TiketPesawat/img/bg-masuk.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keluarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarBtnMouseClicked
        // TODO add your handling code here:
        mc.hilangPage();
    }//GEN-LAST:event_keluarBtnMouseClicked

    private void masukBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masukBtnMouseClicked
        // TODO add your handling code here:
        // nanti ada logika 
        mc.cekLogin(username.getText(), password.getText());
    }//GEN-LAST:event_masukBtnMouseClicked

    private void daftarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarBtnMouseClicked
        // TODO add your handling code here:
        mc.keDaftar();
    }//GEN-LAST:event_daftarBtnMouseClicked

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton daftarBtn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton keluarBtn;
    private javax.swing.JButton masukBtn;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
