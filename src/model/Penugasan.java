package model;


import javax.swing.*;
import java.sql.SQLException;

public class Penugasan {
    private final String idPenugasan;
    private final String deadline;
    private final String title;
    private final String deskripsi;
    private final String kodeMatakuliah;

    public Penugasan(String idPenugasan, String deadline, String title, String deskripsi, String kodeMatakuliah){
        this.idPenugasan = idPenugasan;
        this.deadline = deadline;
        this.title = title;
        this.deskripsi = deskripsi;
        this.kodeMatakuliah = kodeMatakuliah;
    }

    public String getDeadline(){
        return this.deadline;
    }

    public String getDeskripsi(){
        return this.deskripsi;
    }

    public String getTitle(){
        return this.title;
    }

    public String getIdPenugasan(){
        return this.idPenugasan;
    }
    
    public String getKodeMataKuliah(){
        return this.kodeMatakuliah;
    }

    public void createPenugasan() {
        try {
            String query = "INSERT INTO penugasan (id_tugas, deadline, title, deskripsi, matakuliah_kode_matakuliah) VALUES (?, ?, ?, ?, ?)";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getIdPenugasan());
            Database.preparedStatement.setString(2, this.getDeadline());
            Database.preparedStatement.setString(3, this.getTitle());
            Database.preparedStatement.setString(4, this.getDeskripsi());
            Database.preparedStatement.setString(5, this.getKodeMataKuliah());


            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Database.disconnect();
                JOptionPane.showMessageDialog(null, "Penugasan berhasil dibuat!");
            }
        } catch (SQLException e) {
            Database.disconnect();
            JOptionPane.showMessageDialog(null, "Penugasan gagal dibuat! " + e.getMessage());
        }
    }

    public void deletePenugasan() {
        try {
            String query = "DELETE FROM penugasan WHERE id_tugas = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getIdPenugasan());

            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Database.disconnect();
                JOptionPane.showMessageDialog(null, "Penugasan berhasil dihapus!");
            }
        } catch (SQLException e) {
            Database.disconnect();
            JOptionPane.showMessageDialog(null, "Penugasan gagal dihapus! " + e.getMessage());
        }
    }

    public void updatePenugasan(){
        try {
            String query = "UPDATE penugasan SET deadline = ?, title = ?, deskripsi = ? WHERE id_tugas = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getDeadline());
            Database.preparedStatement.setString(2, this.getTitle());
            Database.preparedStatement.setString(3, this.getDeskripsi());
            Database.preparedStatement.setString(4, this.getIdPenugasan());

            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Database.disconnect();
                JOptionPane.showMessageDialog(null, "Penugasan berhasil diupdate!");
            }
        } catch (SQLException e) {
            Database.disconnect();
            JOptionPane.showMessageDialog(null, "Penugasan gagal diupdate! " + e.getMessage());
        }
    }
}
