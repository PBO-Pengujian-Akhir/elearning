package model;

import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author fauza
 */
public class Mahasiswa extends User{

    private final String role = "Mahasiswa";
        public Mahasiswa(String idUser, String name, String password){
            super(idUser, name, password);
        }
        @Override
        public final String getRole(){
            return this.role;
        }

        public final static boolean loginMahasiswa(String id, String password) {
            try {
                String query = "SELECT * FROM mahasiswa WHERE nim = ? AND password = ?";
                Database.preparedStatement = Database.connection.prepareStatement(query);
                Database.preparedStatement.setString(1, id);
                Database.preparedStatement.setString(2, password);
                Database.resultSet = Database.preparedStatement.executeQuery();

                if (Database.resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Login gagal! ");
                return false;
            }
        }
        
        public static final String getName(String id) {
            try {
                String query = "SELECT nama_mahasiswa FROM mahasiswa WHERE nim = ?";
                Database.preparedStatement = Database.connection.prepareStatement(query);
                Database.preparedStatement.setString(1, id);
                Database.resultSet = Database.preparedStatement.executeQuery();

                if (Database.resultSet.next()) {
                    return Database.resultSet.getString("nama_mahasiswa");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan!");
            }
            return null;
        }
}
