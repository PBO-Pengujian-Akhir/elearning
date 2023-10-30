package model;

import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.*;

public class Mahasiswa extends User{

        public Mahasiswa(String idUser, String name, String password, String role){
            super(idUser, name, password, role);
        }
        @Override
        public String getRole(){
            return "Mahasiswa";
        }

        public static boolean loginMahasiswa(String id, String password) {
            try {
                String query = "SELECT * FROM mahasiswa WHERE nim = ? AND password = ?";
                Database.preparedStatement = Database.connection.prepareStatement(query);
                Database.preparedStatement.setString(1, id);
                Database.preparedStatement.setString(2, password);
                Database.resultSet = Database.preparedStatement.executeQuery();

                if (Database.resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Login berhasil!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Login gagal!");
                    return false;
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Login gagal! " + e.getMessage());
                return false;
            }
        }
}
