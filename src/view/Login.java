/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.LoginController;

import java.awt.*;

/**
 *
 * @author fauza
 */
public class Login extends javax.swing.JFrame {


    public Login() {
        initComponents();
    }

    int xx, xy;

    public static Login getInstance() {
        return new Login();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonClose = new javax.swing.JLabel();
        idBox = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/closeButton.png"))); // NOI18N
        buttonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCloseMouseClicked(evt);
            }
        });
        getContentPane().add(buttonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, -1));

        idBox.setForeground(new java.awt.Color(153, 153, 153));
        idBox.setText("Type your NIM / NIP");
        idBox.setBorder(null);
        idBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                idBoxFocusLost(evt);
            }
        });
        getContentPane().add(idBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 200, 30));

        passwordField.setBorder(null);
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 200, 30));

        loginButton.setBackground(new java.awt.Color(255, 255, 255));
        loginButton.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        loginButton.setText("Login");
        loginButton.setBorder(null);
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 130, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginForm.png"))); // NOI18N
        background.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                backgroundMouseDragged(evt);
            }
        });
        background.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backgroundMousePressed(evt);
            }
        });
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backgroundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_backgroundMousePressed

    private void backgroundMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_backgroundMouseDragged

    private void buttonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_buttonCloseMouseClicked

    private void idBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idBoxFocusGained
        if (idBox.getText().equals("Type your NIM / NIP")) {
            idBox.setText("");
        }
    }//GEN-LAST:event_idBoxFocusGained

    private void idBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idBoxFocusLost
        if (idBox.getText().isEmpty()){
            idBox.setText("Type your NIM / NIP");
        }
    }//GEN-LAST:event_idBoxFocusLost

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {
        String id = idBox.getText();
        String password = passwordField.getText();

        LoginController.getInstance().loginButton(id, password);
        this.dispose();
    }
                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.setVisible(true);
                login.pack();
                login.setLocationRelativeTo(null);
                login.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel buttonClose;
    private javax.swing.JTextField idBox;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
