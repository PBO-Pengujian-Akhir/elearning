package model;

import javax.swing.*;
import java.sql.SQLException;

public class PengumpulanTugas {
    private String idPengumpulan;
    private String idMahasiswa;
    private String lampiran;
    private String tanggalPengumpulan;
    private String status;
    private String idTugas;

    public PengumpulanTugas(String idPengumpulan, String lampiran, String tanggalPengumpulan, String status, String idMahasiswa, String idTugas){
        this.idPengumpulan = idPengumpulan;
        this.lampiran = lampiran;
        this.tanggalPengumpulan = tanggalPengumpulan;
        this.status = status;
        this.idMahasiswa = idMahasiswa;
        this.idTugas = idTugas;
    }

    public String getIdPengumpulan(){
        return this.idPengumpulan;
    }

    public String getLampiran(){
        return this.lampiran;
    }

    public String getTanggalPengumpulan(){
        return this.tanggalPengumpulan;
    }

    public String getStatus(){
        return this.status;
    }

    public String getIdTugas(){
        return this.idTugas;
    }

    public String getIdMahasiswa(){
        return this.idMahasiswa;
    }

    public void createPengumpulanTugas(){
        try {
            String query = "INSERT INTO pengumpulan_tugas (id_pengumpulan, lampiran, tanggal_pengumpulan, status, mahasiswa_nim, penugasan_id_tugas) VALUES (?, ?, ?, ?, ?, ?)";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getIdPengumpulan());
            Database.preparedStatement.setString(2, this.getLampiran());
            Database.preparedStatement.setString(3, this.getTanggalPengumpulan());
            Database.preparedStatement.setString(4, this.getStatus());
            Database.preparedStatement.setString(5, this.getIdMahasiswa());
            Database.preparedStatement.setString(6, this.getIdTugas());

            int rowsAffected = Database.preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Database.disconnect();
                JOptionPane.showMessageDialog(null, "Pengumpulan tugas berhasil dibuat!");
            }
        } catch (SQLException e) {
            Database.disconnect();
            JOptionPane.showMessageDialog(null, "Pengumpulan tugas gagal dibuat! " + e.getMessage());
        }
    }

}
