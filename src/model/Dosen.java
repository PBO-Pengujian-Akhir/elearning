package model;

import javax.swing.*;

public class Dosen extends User{

    public Dosen(String idUser, String name, String password, String role){
        super(idUser, name, password, role);
    }

    @Override
    public String getRole(){
        return "Dosen";
    }

    public static boolean loginDosen(String id, String password) {
        try {
            String query = "SELECT * FROM dosen WHERE nip = ? AND password = ?";
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login gagal! " + e.getMessage());
        }
        return false;
    }

    public static boolean getIdDosen(String id) {
        try {
            String query = "SELECT * FROM dosen WHERE nip = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, id);
            Database.resultSet = Database.preparedStatement.executeQuery();

            return Database.resultSet.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login gagal! " + e.getMessage());
        }
        return false;
    }

}
