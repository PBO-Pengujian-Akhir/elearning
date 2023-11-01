package model;

import javax.swing.*;
import java.sql.SQLException;
/**
 *
 * @author fauza
 */
public class PengumpulanTugas {
    private final String idPengumpulan;
    private final String idMahasiswa;
    private final String lampiran;
    private final String tanggalPengumpulan;
    private final String status;
    private final String idTugas;

    public PengumpulanTugas(String idPengumpulan, String lampiran, String tanggalPengumpulan, String status, String idMahasiswa, String idTugas){
        this.idPengumpulan = idPengumpulan;
        this.lampiran = lampiran;
        this.tanggalPengumpulan = tanggalPengumpulan;
        this.status = status;
        this.idMahasiswa = idMahasiswa;
        this.idTugas = idTugas;
    }

    public final String getIdPengumpulan(){
        return this.idPengumpulan;
    }

    public final String getLampiran(){
        return this.lampiran;
    }

    public final String getTanggalPengumpulan(){
        return this.tanggalPengumpulan;
    }

    public final String getStatus(){
        return this.status;
    }

    public final String getIdTugas(){
        return this.idTugas;
    }

    public final String getIdMahasiswa(){
        return this.idMahasiswa;
    }

    public final void createPengumpulanTugas(){
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
                JOptionPane.showMessageDialog(null, "Pengumpulan tugas berhasil dibuat!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Pengumpulan tugas gagal dibuat! " + e.getMessage());
        }
    }

}
