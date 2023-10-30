/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.UjianController;
import controller.UserSession;
import java.sql.*;
import java.sql.ResultSet;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Database;
import model.Penugasan;
import model.Ujian;

/**
 *
 * @author fauza
 */
public class UjianForm extends javax.swing.JFrame {

    /**
     * Creates new form UjianForm
     */
    public UjianForm() {
        initComponents();
    }

    public void table(){
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("Kode Ujian");
        table.addColumn("Keterangan");
        table.addColumn("Link Ujian");
        table.addColumn("Kode Mata Kuliah");

        try {
            Statement statement = (Statement) Database.connect().createStatement();
            ResultSet resulset = statement.executeQuery("SELECT * FROM ujian");

            while(resulset.next()){
                table.addRow(new Object[] {
                        resulset.getString("kode_ujian"),
                        resulset.getString("keterangan"),
                        resulset.getString("link"),
                        resulset.getString("matakuliah_kode_matakuliah"),
                });
                dataTable.setModel(table);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi gagal! " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        keteranganName = new javax.swing.JLabel();
        keteranganField = new javax.swing.JTextField();
        matakuliah = new javax.swing.JComboBox<>();
        matakuliahName = new javax.swing.JLabel();
        linkName = new javax.swing.JLabel();
        linkField = new javax.swing.JTextField();
        createUjianButton = new javax.swing.JButton();
        deleteUjianButton = new javax.swing.JButton();
        updateUjianButton = new javax.swing.JButton();
        showUjianButton = new javax.swing.JButton();
        backMenuButton = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dataTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 880, 190));

        keteranganName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        keteranganName.setText("Keterangan");
        getContentPane().add(keteranganName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, 30));
        getContentPane().add(keteranganField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 310, 30));

        matakuliah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Matakuliah", "Basis Data Lanjut", "Dasar Dasar Pengembangan Perangkat Lunak", "Desain dan Manajemen Jaringan Komputer", "Desain Basis Data", "Interaksi Manusia dan Komputer", "Manajemen Layanan IT", "Manajemen Proses Bisnis Pemrograman Berorientasi Objek", "Riset Operasi" }));
        getContentPane().add(matakuliah, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 310, 30));

        matakuliahName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        matakuliahName.setText("Mata Kuliah");
        getContentPane().add(matakuliahName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, 30));

        linkName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        linkName.setText("Link");
        getContentPane().add(linkName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, 30));

        linkField.setToolTipText("");
        linkField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkFieldActionPerformed(evt);
            }
        });
        getContentPane().add(linkField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 310, 30));

        createUjianButton.setText("Buat Ujian");
        createUjianButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createUjianButtonMouseClicked(evt);
            }
        });
        createUjianButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUjianButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createUjianButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 110, -1));

        deleteUjianButton.setText("Hapus Ujian");
        deleteUjianButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteUjianButtonMouseClicked(evt);
            }
        });
        getContentPane().add(deleteUjianButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 110, -1));

        updateUjianButton.setText("Edit Ujian");
        updateUjianButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateUjianButtonMouseClicked(evt);
            }
        });
        getContentPane().add(updateUjianButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 110, -1));

        showUjianButton.setText("Tampilin Ujian");
        showUjianButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showUjianButtonMouseClicked(evt);
            }
        });
        getContentPane().add(showUjianButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, -1, -1));

        backMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backtButton.png"))); // NOI18N
        backMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMenuButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboardForm.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void linkFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linkFieldActionPerformed

    private void createUjianButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createUjianButtonMouseClicked
        String kodeMatakuliah = UjianController.getIdMatakuliah(matakuliah.getSelectedItem().toString());
        String kodeUjian = UUID.randomUUID().toString().substring(0, 5);
        String keterangan = keteranganField.getText();
        String link = linkField.getText();

        UjianController.createUjian(kodeUjian, keterangan, link, kodeMatakuliah);
    }//GEN-LAST:event_createUjianButtonMouseClicked

    private void createUjianButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUjianButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createUjianButtonActionPerformed

    private void deleteUjianButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUjianButtonMouseClicked
        int row = dataTable.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel()  ;
            String kodeUjian = model.getValueAt(row, 0).toString();
            String keterangan = model.getValueAt(row, 1).toString();
            String link = model.getValueAt(row, 2).toString();
            String kodeMatkul = model.getValueAt(row, 3).toString();

            UjianController.deleteUjian(kodeUjian, keterangan, link, kodeMatkul);
            model.removeRow(row);
        }
    }//GEN-LAST:event_deleteUjianButtonMouseClicked

    private void updateUjianButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateUjianButtonMouseClicked
        int row = dataTable.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel()  ;
            String kodeUjian = model.getValueAt(row, 0).toString();
            String keterangan = keteranganField.getText();
            String link = linkField.getText();
            String kodeMatakuliah = model.getValueAt(row, 3).toString();

            UjianController.updateUjian(kodeUjian, keterangan, link, kodeMatakuliah);
            model.removeRow(row);
        }
    }//GEN-LAST:event_updateUjianButtonMouseClicked

    private void showUjianButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showUjianButtonMouseClicked
        table();
    }//GEN-LAST:event_showUjianButtonMouseClicked

    private void backMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMenuButtonMouseClicked
        MenuDosen menuDosen = new MenuDosen();
        menuDosen.setVisible(true);
        menuDosen.pack();
        menuDosen.setLocationRelativeTo(null);
        menuDosen.setDefaultCloseOperation(MenuDosen.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backMenuButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UjianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UjianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UjianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UjianForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UjianForm ujian = new UjianForm();
                ujian.setVisible(true);
                ujian.pack();
                ujian.setLocationRelativeTo(null);
                ujian.setDefaultCloseOperation(UjianForm.EXIT_ON_CLOSE);;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backMenuButton;
    private javax.swing.JLabel background;
    private javax.swing.JButton createUjianButton;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton deleteUjianButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keteranganField;
    private javax.swing.JLabel keteranganName;
    private javax.swing.JTextField linkField;
    private javax.swing.JLabel linkName;
    private javax.swing.JComboBox<String> matakuliah;
    private javax.swing.JLabel matakuliahName;
    private javax.swing.JButton showUjianButton;
    private javax.swing.JButton updateUjianButton;
    // End of variables declaration//GEN-END:variables
}
