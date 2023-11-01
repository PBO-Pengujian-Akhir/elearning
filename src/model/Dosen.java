package model;

import javax.swing.*;
/**
 *
 * @author fauza
 */
public class Dosen extends User{
    
    private final String role = "Dosen";

    public Dosen(String idUser, String name, String password){
        super(idUser, name, password);
    }

    @Override
    public final String getRole(){
        return this.role;
    }

    public static final boolean loginDosen(String id, String password) {
        try {
            String query = "SELECT * FROM dosen WHERE nip = ? AND password = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, id);
            Database.preparedStatement.setString(2, password);
            Database.resultSet = Database.preparedStatement.executeQuery();

            if (Database.resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login gagal! " + e.getMessage());
        }
        return false;
    }

    public static final String getName(String id) {
        try {
            String query = "SELECT nama_dosen FROM dosen WHERE nip = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, id);
            Database.resultSet = Database.preparedStatement.executeQuery();

            if (Database.resultSet.next()) {
                return Database.resultSet.getString("nama_dosen");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login gagal! " + e.getMessage());
        }
        return null;
    }
}
