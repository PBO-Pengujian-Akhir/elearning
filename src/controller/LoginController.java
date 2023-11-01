/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Database;
import model.Dosen;
import model.Mahasiswa;
import model.User;
import view.*;

import javax.swing.*;

/**
 *
 * @author fauza
 */
public class LoginController {
    public static LoginController getInstance() {
        return new LoginController();
    }

    public static boolean loginButton(String id, String password){
        try {
            Database.connect();

            if (id.equals("Type your NIM / NIP") || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields!");
            } else {
                switch (id.charAt(0)) {
                    case '2' -> {
                        if (Mahasiswa.loginMahasiswa(id, password)) {
                            UserSession.getInstance().setUserId(id);
                            UserSession.getInstance().setUserName(Mahasiswa.getName(id));
                            MenuMahasiswa dashboardMahasiswa = new MenuMahasiswa();
                            dashboardMahasiswa.setVisible(true);
                            dashboardMahasiswa.pack();
                            dashboardMahasiswa.setLocationRelativeTo(null);
                            dashboardMahasiswa.setDefaultCloseOperation(MenuMahasiswa.EXIT_ON_CLOSE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Login gagal!");
                        }
                    }
                    case '1' -> {
                        if (Dosen.loginDosen(id, password)) {
                            UserSession.getInstance().setUserId(id);
                            UserSession.getInstance().setUserName(Dosen.getName(id));
                            MenuDosen dashboardDosen = new MenuDosen();
                            dashboardDosen.setVisible(true);
                            dashboardDosen.pack();
                            dashboardDosen.setLocationRelativeTo(null);
                            dashboardDosen.setDefaultCloseOperation(MenuDosen.EXIT_ON_CLOSE);;
                        } else {
                            JOptionPane.showMessageDialog(null, "Login gagal!");
                        }
                    }
                    default -> JOptionPane.showMessageDialog(null, "Invalid ID!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
        }
        return false;
    }
    
}
