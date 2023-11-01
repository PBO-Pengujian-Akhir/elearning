package model;

import javax.swing.*;
import java.sql.SQLException;
/**
 *
 * @author fauza
 */
public class Matakuliah {
    private String id;
    private String name;
    private String idDosen;

    public Matakuliah(String id, String name, String idDosen){
        this.id = id;
        this.name = name;
        this.idDosen = idDosen;
    }

    public Matakuliah(String name) {
        this.name = name;
    }

    public final String getId(){
        return this.id;
    }

    public final String getName(){
        return this.name;
    }

    public final String getIdDosen(){
        return this.idDosen;
    }

    public final String getIdMatakuliah() {
        String idMatakuliah = null;

        try {
            String query = "SELECT * FROM matakuliah WHERE nama_matakuliah = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getName());
            Database.resultSet = Database.preparedStatement.executeQuery();

            if (Database.resultSet.next()) {
                idMatakuliah = Database.resultSet.getString("kode_matakuliah");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Matakuliah tidak ditemukan! " + e.getMessage());
        }
        return idMatakuliah;
    }


}

