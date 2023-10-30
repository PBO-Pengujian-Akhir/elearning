/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getIdDosen(){
        return this.idDosen;
    }

    public String getIdMatakuliah() {
        String idMatakuliah = null;

        try {
            String query = "SELECT * FROM matakuliah WHERE nama_matakuliah = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getName());
            Database.resultSet = Database.preparedStatement.executeQuery();

            if (Database.resultSet.next()) {
                idMatakuliah = Database.resultSet.getString("kode_matakuliah");
                Database.disconnect();
            }
        } catch (SQLException e) {
            Database.disconnect();
            JOptionPane.showMessageDialog(null, "Matakuliah tidak ditemukan! " + e.getMessage());
        }
        return idMatakuliah;
    }


}

