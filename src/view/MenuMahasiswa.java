/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.UserSession;
import static model.Database.connect;

/**
 *
 * @author fauza
 */
public class MenuMahasiswa extends javax.swing.JFrame {
    
    public MenuMahasiswa() {
        initComponents();
        connect();
    }

    public static String saveMatakuliah() {
        return chooseMatakuliah.getSelectedItem().toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectedDate1 = new com.raven.datechooser.SelectedDate();
        subTitleText = new javax.swing.JLabel();
        chooseMatakuliah = new javax.swing.JComboBox<>();
        masukButton = new javax.swing.JButton();
        titleText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subTitleText.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        subTitleText.setText("Pilih Mata Kuliah");
        getContentPane().add(subTitleText, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        chooseMatakuliah.setFont(new java.awt.Font("Montserrat Light", 0, 12)); // NOI18N
        chooseMatakuliah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basis Data Lanjut", "Dasar Dasar Pengembangan Perangkat Lunak", "Desain dan Manajemen Jaringan Komputer", "Desain Basis Data", "Interaksi Manusia dan Komputer", "Manajemen Layanan IT", "Manajemen Proses Bisnis Pemrograman Berorientasi Objek", "Riset Operasi" }));
        getContentPane().add(chooseMatakuliah, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 240, 40));

        masukButton.setText("Masuk");
        masukButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masukButtonMouseClicked(evt);
            }
        });
        getContentPane().add(masukButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 120, 30));

        titleText.setFont(new java.awt.Font("Montserrat Medium", 0, 36)); // NOI18N
        titleText.setForeground(new java.awt.Color(0, 155, 76));
        titleText.setText("Menu Mahasiswa");
        getContentPane().add(titleText, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backtButton.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboardForm.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void masukButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masukButtonMouseClicked

        TugasForm matakuliahForm = new TugasForm();
        matakuliahForm.setVisible(true);
        matakuliahForm.pack();
        matakuliahForm.setLocationRelativeTo(null);
        matakuliahForm.setDefaultCloseOperation(MenuMahasiswa.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_masukButtonMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(MenuMahasiswa.EXIT_ON_CLOSE);
        UserSession.getInstance().clearSession();
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private static javax.swing.JComboBox<String> chooseMatakuliah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton masukButton;
    private com.raven.datechooser.SelectedDate selectedDate1;
    private javax.swing.JLabel subTitleText;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
