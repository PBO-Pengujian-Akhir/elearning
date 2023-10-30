/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.UUID;

import controller.PenugasanController;
import controller.LoginController;
import controller.UserSession;
import model.*;

/**
 *
 * @author fauza
 */
public final class PenugasanForm extends javax.swing.JFrame {
    int xx, xy;

    /**
         * Creates new form CreateAssignment
         */
    public PenugasanForm() {
        initComponents();
        table();
        Database.connect();
        clear();
    }

    void clear(){
        assignment.setText("");
        dateChooser.setText("");
        deskripsiField.setText("");
    }

    public void table(){
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("ID Penugasan");
        table.addColumn("Deadline");
        table.addColumn("Title");
        table.addColumn("Deskripsi");
        table.addColumn("Kode Mata Kuliah");
        
        try {
            Statement statement = (Statement) Database.connect().createStatement();
            ResultSet resulset = statement.executeQuery("SELECT * FROM penugasan");
            
            while(resulset.next()){
                table.addRow(new Object[] {
                    resulset.getString("id_tugas"),
                    resulset.getString("deadline"),
                    resulset.getString("title"),
                    resulset.getString("deskripsi"),
                    resulset.getString("matakuliah_kode_matakuliah")
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

        dateChooser1 = new com.raven.datechooser.DateChooser();
        deskripsiName = new javax.swing.JLabel();
        matakuliahName = new javax.swing.JLabel();
        namaTugasName = new javax.swing.JLabel();
        deadlineName = new javax.swing.JLabel();
        assignment = new javax.swing.JTextField();
        dateChooser = new javax.swing.JTextField();
        deskripsiField = new javax.swing.JTextField();
        matakuliah = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        createTugasButton = new javax.swing.JButton();
        deleteTugasButton = new javax.swing.JButton();
        updateTugasButton = new javax.swing.JButton();
        showTugasButton = new javax.swing.JButton();
        closeButton = new javax.swing.JLabel();
        titleDashboard = new javax.swing.JLabel();
        dateButton = new javax.swing.JButton();
        backMenuButton = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        dateChooser1.setForeground(new java.awt.Color(0, 155, 76));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(dateChooser);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deskripsiName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        deskripsiName.setText("Deskripsi Tugas");
        getContentPane().add(deskripsiName, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, 30));

        matakuliahName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        matakuliahName.setText("Mata Kuliah");
        getContentPane().add(matakuliahName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, 30));

        namaTugasName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        namaTugasName.setText("Nama Tugas");
        getContentPane().add(namaTugasName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, 30));

        deadlineName.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        deadlineName.setText("Deadline");
        getContentPane().add(deadlineName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, 30));
        getContentPane().add(assignment, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 280, 30));

        dateChooser.setToolTipText("");
        dateChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChooserActionPerformed(evt);
            }
        });
        getContentPane().add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 280, 30));
        getContentPane().add(deskripsiField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 330, 130));

        matakuliah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basis Data Lanjut", "Dasar Dasar Pengembangan Perangkat Lunak", "Desain dan Manajemen Jaringan Komputer", "Desain Basis Data", "Interaksi Manusia dan Komputer", "Manajemen Layanan IT", "Manajemen Proses Bisnis Pemrograman Berorientasi Objek", "Riset Operasi" }));
        getContentPane().add(matakuliah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 280, 30));

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

        createTugasButton.setText("Buat Tugas");
        createTugasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createTugasButtonMouseClicked(evt);
            }
        });
        createTugasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTugasButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createTugasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 110, -1));

        deleteTugasButton.setText("Hapus Tugas");
        deleteTugasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteTugasButtonMouseClicked(evt);
            }
        });
        getContentPane().add(deleteTugasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 110, -1));

        updateTugasButton.setText("Edit Tugas");
        updateTugasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateTugasButtonMouseClicked(evt);
            }
        });
        getContentPane().add(updateTugasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 110, -1));

        showTugasButton.setText("Tampilin Tugas");
        showTugasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showTugasButtonMouseClicked(evt);
            }
        });
        getContentPane().add(showTugasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/closeButton.png"))); // NOI18N
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });
        getContentPane().add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        titleDashboard.setFont(new java.awt.Font("Montserrat Medium", 0, 36)); // NOI18N
        titleDashboard.setForeground(new java.awt.Color(0, 155, 76));
        titleDashboard.setText("Dashboard Dosen");
        getContentPane().add(titleDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, 40));

        dateButton.setText("...");
        dateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateButtonMouseClicked(evt);
            }
        });
        getContentPane().add(dateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 30, 30));

        backMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backtButton.png"))); // NOI18N
        backMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMenuButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboardForm.png"))); // NOI18N
        background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                backgroundMouseDragged(evt);
            }
        });
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backgroundMousePressed(evt);
            }
        });
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createTugasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTugasButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createTugasButtonActionPerformed

    private void createTugasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createTugasButtonMouseClicked
        String kodeMatakuliah = PenugasanController.getIdMatakuliah(matakuliah.getSelectedItem().toString());
        String idPenugasan = "TGS-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        String deadline = dateChooser.getText();
        String titleTugas = assignment.getText();
        String deskripsi = deskripsiField.getText();

        PenugasanController.createTugasButton(idPenugasan, deadline, titleTugas, deskripsi, kodeMatakuliah);
        clear();

    }//GEN-LAST:event_createTugasButtonMouseClicked

    private void deleteTugasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteTugasButtonMouseClicked
        int row = dataTable.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel()  ;
            String idPenugasan = model.getValueAt(row, 0).toString();
            String kodeMatakuliah = model.getValueAt(row, 4).toString();

            PenugasanController.deleteTugasButton(idPenugasan, null, null, null, kodeMatakuliah);

            model.removeRow(row);
        }

    }//GEN-LAST:event_deleteTugasButtonMouseClicked

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void backgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_backgroundMousePressed

    private void backgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_backgroundMouseDragged

    private void dateChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateChooserActionPerformed

    private void dateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateButtonMouseClicked
        dateChooser1.showPopup();
    }//GEN-LAST:event_dateButtonMouseClicked

    private void showTugasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showTugasButtonMouseClicked
        table();
    }//GEN-LAST:event_showTugasButtonMouseClicked

    private void updateTugasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateTugasButtonMouseClicked
        int row = dataTable.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel()  ;
            String idPenugasan = model.getValueAt(row, 0).toString();
            String kodeMatakuliah = model.getValueAt(row, 4).toString();
            String deadline = dateChooser.getText();
            String titleTugas = assignment.getText();
            String description = deskripsiField.getText();

            PenugasanController.updateTugasButton( idPenugasan, deadline, titleTugas, description, kodeMatakuliah);

            model.setValueAt(deadline, row, 1);
            model.setValueAt(titleTugas, row, 2);
            model.setValueAt(description, row, 3);
        }
    }//GEN-LAST:event_updateTugasButtonMouseClicked

    private void backMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMenuButtonMouseClicked
        MenuDosen menuDosen = new MenuDosen();
        menuDosen.setVisible(true);
        menuDosen.pack();
        menuDosen.setLocationRelativeTo(null);
        menuDosen.setDefaultCloseOperation(MenuDosen.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_backMenuButtonMouseClicked

    /*
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
            java.util.logging.Logger.getLogger(PenugasanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenugasanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenugasanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenugasanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PenugasanForm penugasanForm = new PenugasanForm();
                penugasanForm.setVisible(true);
                penugasanForm.pack();
                penugasanForm.setLocationRelativeTo(null);
                penugasanForm.setDefaultCloseOperation(PenugasanForm.EXIT_ON_CLOSE);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField assignment;
    private javax.swing.JLabel backMenuButton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel closeButton;
    private javax.swing.JButton createTugasButton;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton dateButton;
    private javax.swing.JTextField dateChooser;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel deadlineName;
    private javax.swing.JButton deleteTugasButton;
    private javax.swing.JTextField deskripsiField;
    private javax.swing.JLabel deskripsiName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> matakuliah;
    private javax.swing.JLabel matakuliahName;
    private javax.swing.JLabel namaTugasName;
    private javax.swing.JButton showTugasButton;
    private javax.swing.JLabel titleDashboard;
    private javax.swing.JButton updateTugasButton;
    // End of variables declaration//GEN-END:variables
}
