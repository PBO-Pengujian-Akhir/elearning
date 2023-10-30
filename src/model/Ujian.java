/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fauza
 */
public class Ujian {
    private final String kodeUjian;
    private final String keterangan;
    private final String link;
    private final String kodeMatakuliah;

    public Ujian(String kodeUjian, String keterangan, String link, String kodeMatakuliah){
        this.kodeUjian = kodeUjian;
        this.keterangan = keterangan;
        this.link = link;
        this.kodeMatakuliah = kodeMatakuliah;
    }

    public String getKodeUjian(){
        return this.kodeUjian;
    }

    public String getKeterangan(){
        return this.keterangan;
    }

    public String getLink(){
        return this.link;
    }
    
    public String getKodematakuliah(){
        return this.kodeMatakuliah;
    }
    
    public void createUjian(){
        try {
            String query = "INSERT INTO ujian (kode_ujian, keterangan, link, matakuliah_kode_matakuliah) VALUES (?, ?, ?, ?)";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getKodeUjian());
            Database.preparedStatement.setString(2, this.getKeterangan());
            Database.preparedStatement.setString(3, this.getLink());
            Database.preparedStatement.setString(4, this.getKodematakuliah());

            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Database.disconnect();
                JOptionPane.showMessageDialog(null, "Ujian berhasil dibuat!");
            } else {
                JOptionPane.showMessageDialog(null, "Ujian gagal dibuat!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ujian gagal dibuat! " + e.getMessage());
        }
    }

    public void deleteUjian() {
        try {
            String query = "DELETE FROM ujian WHERE kode_ujian = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getKodeUjian());

            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Database.disconnect();
                JOptionPane.showMessageDialog(null, "Ujian berhasil dihapus!");
            }
        } catch (SQLException e) {
            Database.disconnect();
            JOptionPane.showMessageDialog(null, "Ujian gagal dihapus! " + e.getMessage());
        }
    }

    public void updateUjian() {
        try {
            String query = "UPDATE ujian SET keterangan = ?, link = ? WHERE kode_ujian = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getKeterangan());
            Database.preparedStatement.setString(2, this.getLink());
            Database.preparedStatement.setString(3, this.getKodeUjian());

            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Database.disconnect();
                JOptionPane.showMessageDialog(null, "Ujian berhasil diupdate!");
            }
        } catch (SQLException e) {
            Database.disconnect();
            JOptionPane.showMessageDialog(null, "Ujian gagal diupdate! " + e.getMessage());
        }
    }
    
}
