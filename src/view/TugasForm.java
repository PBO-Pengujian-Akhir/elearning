/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.MatakuliahController;
import controller.UserSession;
import model.Database;

import java.io.File;
import java.sql.*;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author fauza
 */
public class TugasForm extends javax.swing.JFrame {

    public TugasForm() {
        initComponents();
        table();
        Database.connect();

    }

    public void table() {
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("ID Penugasan");
        table.addColumn("Deadline");
        table.addColumn("Title");
        table.addColumn("Deskripsi");
        table.addColumn("Kode Mata Kuliah");

        try {
            String selectedMatakuliah = MenuMahasiswa.saveMatakuliah();
            String kodeMatakuliah = MatakuliahController.getKodeMatakuliah(selectedMatakuliah);

            if (!kodeMatakuliah.isEmpty()) {
                PreparedStatement preparedStatement = Database.connect().prepareStatement("SELECT * FROM penugasan WHERE matakuliah_kode_matakuliah = ?");
                preparedStatement.setString(1, kodeMatakuliah);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    table.addRow(new Object[]{
                            resultSet.getString("id_tugas"),
                            resultSet.getString("deadline"),
                            resultSet.getString("title"),
                            resultSet.getString("deskripsi"),
                            resultSet.getString("matakuliah_kode_matakuliah"),
                    });
                }

                jTable1.setModel(table);
            } else {
                JOptionPane.showMessageDialog(null, "Kode matakuliah tidak ditemukan.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal! " + e.getMessage());
        }
    }

    public void selectTugas(){
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        idTugasField.setText(model.getValueAt(i, 0).toString());
        keteranganField.setText(model.getValueAt(i, 3).toString());
        statusField.setText(model.getValueAt(i, 4).toString());
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileUpload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fileTugasField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        keteranganField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        idTugasField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kumpulButton = new javax.swing.JButton();
        statusText = new javax.swing.JLabel();
        statusField = new javax.swing.JTextField();
        tampilkanTugasButton = new javax.swing.JButton();
        backMenuButton = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fileUpload.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        fileUpload.setText("Uploud Tugas");
        fileUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileUploadMouseClicked(evt);
            }
        });
        fileUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileUploadActionPerformed(evt);
            }
        });
        getContentPane().add(fileUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 880, 190));
        getContentPane().add(fileTugasField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 180, 30));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel1.setText("ID Tugas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        keteranganField.setColumns(20);
        keteranganField.setRows(5);
        jScrollPane2.setViewportView(keteranganField);
        keteranganField.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 350, 110));

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 155, 76));
        jLabel3.setText("Keterangan Tugas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, 40));
        getContentPane().add(idTugasField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 180, 30));

        jLabel4.setText("Keterangan Tugas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, -1, -1));

        kumpulButton.setText("Kumpul");
        kumpulButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kumpulButtonMouseClicked(evt);
            }
        });
        getContentPane().add(kumpulButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 100, 30));

        statusText.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        statusText.setText("Status");
        getContentPane().add(statusText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, 30));
        getContentPane().add(statusField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 332, 180, 30));

        tampilkanTugasButton.setText("Tampilkan Tugas");
        tampilkanTugasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tampilkanTugasButtonMouseClicked(evt);
            }
        });
        getContentPane().add(tampilkanTugasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, -1, 30));

        backMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backtButton.png"))); // NOI18N
        backMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMenuButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboardForm.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileUploadMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();

        if (f != null) {
            String fileName = f.getName();
            String fileExtension = "";

            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex > 0) {
                fileExtension = fileName.substring(dotIndex + 1);
                fileName = fileName.substring(0, dotIndex);
            }

            fileTugasField.setText(fileName + "." + fileExtension);
        } else {
            fileTugasField.setText("Tidak ada file yang dipilih");
        }
    }//GEN-LAST:event_fileUploadMouseClicked

    private void fileUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileUploadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileUploadActionPerformed

    private void tampilkanTugasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilkanTugasButtonMouseClicked
        selectTugas();
    }//GEN-LAST:event_tampilkanTugasButtonMouseClicked

    private void kumpulButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kumpulButtonMouseClicked
        String idPengumpulan = UUID.randomUUID().toString().substring(0, 5);
        String lampiran = fileTugasField.getText();
        String idMahasiswa = UserSession.getInstance().getUserId();
        LocalDate hariIni = LocalDate.now();

        LocalDate deadline = LocalDate.parse("2020-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String status = "";

        if (hariIni.isAfter(deadline)) {
            status = "Terlambat mengumpul";
        } else if (hariIni.isEqual(deadline)) {
            status = "Terkumpul";
        } else {
            status = "Belum diperiksa";
        }

        String idTugas = idTugasField.getText();

        MatakuliahController.createPengumpulanTugas(idPengumpulan, lampiran, deadline.toString(), status, idTugas, idMahasiswa);
    }//GEN-LAST:event_kumpulButtonMouseClicked

    private void backMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMenuButtonMouseClicked
        MenuMahasiswa menuMahasiswa = new MenuMahasiswa();
        menuMahasiswa.setVisible(true);
        menuMahasiswa.pack();
        menuMahasiswa.setLocationRelativeTo(null);
        menuMahasiswa.setDefaultCloseOperation(MenuMahasiswa.EXIT_ON_CLOSE);
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
            java.util.logging.Logger.getLogger(TugasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TugasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TugasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TugasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TugasForm tugasForm = new TugasForm();
                tugasForm.setVisible(true);
                tugasForm.pack();
                tugasForm.setLocationRelativeTo(null);
                tugasForm.setDefaultCloseOperation(TugasForm.EXIT_ON_CLOSE);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backMenuButton;
    private javax.swing.JLabel background;
    private javax.swing.JTextField fileTugasField;
    private javax.swing.JButton fileUpload;
    private javax.swing.JTextField idTugasField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea keteranganField;
    private javax.swing.JButton kumpulButton;
    private javax.swing.JTextField statusField;
    private javax.swing.JLabel statusText;
    private javax.swing.JButton tampilkanTugasButton;
    // End of variables declaration//GEN-END:variables
}
