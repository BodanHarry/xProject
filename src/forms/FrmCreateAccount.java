package forms;

import data.TblUser;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import models.User;

public class FrmCreateAccount extends javax.swing.JFrame {

    TblUser dUser = new TblUser();
    User actualUser = new User();
    
    HashMap<JTextField, String> hash = new HashMap<>();
    
    public FrmCreateAccount() {
        initComponents();
        this.setLocationRelativeTo(null);
        fillHashList();
    }
    
    private void fillHashList(){
        hash.put(jTfEmail, "Enter your email");
        hash.put(jTfUsername, "Enter your username");
        hash.put(jPfPassword, "****************");
    }
    
    private void estheticTextField(JTextField element){
        hash.entrySet().stream().filter(a -> element == a.getKey())
                                .filter(a -> element.getText().equals(a.getValue()))
                                .forEach(a -> a.getKey().setText(""));
                                                      
        hash.entrySet().stream().filter(a -> element != a.getKey())
                                .filter(a -> a.getKey().getText().equals(""))
                                .forEach(a -> a.getKey().setText(a.getValue()));          
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLoginPanel = new javax.swing.JPanel();
        jLogin = new javax.swing.JPanel();
        jSpPassword = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtPassword = new javax.swing.JLabel();
        jTxtLogin = new javax.swing.JLabel();
        jTxtUsername = new javax.swing.JLabel();
        jTfUsername = new javax.swing.JTextField();
        jPfPassword = new javax.swing.JPasswordField();
        jBtnLogin = new javax.swing.JPanel();
        jLbCrateAccount = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSpEmail = new javax.swing.JPanel();
        jTxtEmail = new javax.swing.JLabel();
        jSpUsername = new javax.swing.JPanel();
        jTfEmail = new javax.swing.JTextField();
        jTxtErrorPassword = new javax.swing.JLabel();
        jTxtErrorUsername = new javax.swing.JLabel();
        jTxtErrorEmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 450));

        jLoginPanel.setBackground(new java.awt.Color(255, 255, 255));
        jLoginPanel.setForeground(new java.awt.Color(255, 255, 255));
        jLoginPanel.setMaximumSize(new java.awt.Dimension(400, 450));
        jLoginPanel.setMinimumSize(new java.awt.Dimension(400, 450));
        jLoginPanel.setPreferredSize(new java.awt.Dimension(400, 450));
        jLoginPanel.setLayout(null);

        jLogin.setBackground(new java.awt.Color(51, 51, 255));
        jLogin.setForeground(new java.awt.Color(51, 51, 255));
        jLogin.setMaximumSize(new java.awt.Dimension(100, 450));

        javax.swing.GroupLayout jLoginLayout = new javax.swing.GroupLayout(jLogin);
        jLogin.setLayout(jLoginLayout);
        jLoginLayout.setHorizontalGroup(
            jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLoginLayout.setVerticalGroup(
            jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jLoginPanel.add(jLogin);
        jLogin.setBounds(0, 0, 100, 450);

        jSpPassword.setBackground(new java.awt.Color(0, 0, 0));
        jSpPassword.setMaximumSize(new java.awt.Dimension(220, 2));
        jSpPassword.setMinimumSize(new java.awt.Dimension(220, 2));

        javax.swing.GroupLayout jSpPasswordLayout = new javax.swing.GroupLayout(jSpPassword);
        jSpPassword.setLayout(jSpPasswordLayout);
        jSpPasswordLayout.setHorizontalGroup(
            jSpPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jSpPasswordLayout.setVerticalGroup(
            jSpPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLoginPanel.add(jSpPassword);
        jSpPassword.setBounds(140, 320, 220, 2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Account");
        jLoginPanel.add(jLabel1);
        jLabel1.setBounds(150, 20, 180, 40);

        jTxtPassword.setBackground(new java.awt.Color(0, 0, 0));
        jTxtPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTxtPassword.setForeground(new java.awt.Color(0, 0, 0));
        jTxtPassword.setText("Password");
        jLoginPanel.add(jTxtPassword);
        jTxtPassword.setBounds(140, 270, 70, 20);

        jTxtLogin.setBackground(new java.awt.Color(0, 0, 0));
        jTxtLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTxtLogin.setForeground(new java.awt.Color(0, 0, 0));
        jTxtLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTxtLogin.setText("Login");
        jTxtLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxtLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTxtLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTxtLoginMouseExited(evt);
            }
        });
        jLoginPanel.add(jTxtLogin);
        jTxtLogin.setBounds(220, 410, 50, 20);

        jTxtUsername.setBackground(new java.awt.Color(0, 0, 0));
        jTxtUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTxtUsername.setForeground(new java.awt.Color(0, 0, 0));
        jTxtUsername.setText("Username");
        jLoginPanel.add(jTxtUsername);
        jTxtUsername.setBounds(140, 80, 70, 20);

        jTfUsername.setBackground(new java.awt.Color(255, 255, 255));
        jTfUsername.setForeground(new java.awt.Color(147, 147, 147));
        jTfUsername.setText("Enter your username");
        jTfUsername.setBorder(null);
        jTfUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTfUsernameFocusGained(evt);
            }
        });
        jTfUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTfUsernameMousePressed(evt);
            }
        });
        jTfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfUsernameActionPerformed(evt);
            }
        });
        jLoginPanel.add(jTfUsername);
        jTfUsername.setBounds(140, 110, 220, 30);

        jPfPassword.setBackground(new java.awt.Color(255, 255, 255));
        jPfPassword.setForeground(new java.awt.Color(147, 147, 147));
        jPfPassword.setText("****************");
        jPfPassword.setBorder(null);
        jPfPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPfPasswordFocusGained(evt);
            }
        });
        jPfPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPfPasswordMousePressed(evt);
            }
        });
        jPfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPfPasswordActionPerformed(evt);
            }
        });
        jLoginPanel.add(jPfPassword);
        jPfPassword.setBounds(140, 290, 220, 30);

        jBtnLogin.setBackground(new java.awt.Color(51, 51, 255));
        jBtnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnLoginMouseExited(evt);
            }
        });

        jLbCrateAccount.setBackground(new java.awt.Color(255, 255, 255));
        jLbCrateAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLbCrateAccount.setForeground(new java.awt.Color(255, 255, 255));
        jLbCrateAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbCrateAccount.setText("Create");
        jLbCrateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbCrateAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLbCrateAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLbCrateAccountMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jBtnLoginLayout = new javax.swing.GroupLayout(jBtnLogin);
        jBtnLogin.setLayout(jBtnLoginLayout);
        jBtnLoginLayout.setHorizontalGroup(
            jBtnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLbCrateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jBtnLoginLayout.setVerticalGroup(
            jBtnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLbCrateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLoginPanel.add(jBtnLogin);
        jBtnLogin.setBounds(200, 370, 90, 30);

        jPanel1.setMaximumSize(new java.awt.Dimension(130, 2));
        jPanel1.setMinimumSize(new java.awt.Dimension(130, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLoginPanel.add(jPanel1);
        jPanel1.setBounds(140, 140, 220, 0);

        jSpEmail.setBackground(new java.awt.Color(0, 0, 0));
        jSpEmail.setMaximumSize(new java.awt.Dimension(220, 2));
        jSpEmail.setMinimumSize(new java.awt.Dimension(220, 2));
        jSpEmail.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jSpEmailLayout = new javax.swing.GroupLayout(jSpEmail);
        jSpEmail.setLayout(jSpEmailLayout);
        jSpEmailLayout.setHorizontalGroup(
            jSpEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jSpEmailLayout.setVerticalGroup(
            jSpEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLoginPanel.add(jSpEmail);
        jSpEmail.setBounds(140, 230, 220, 2);

        jTxtEmail.setBackground(new java.awt.Color(0, 0, 0));
        jTxtEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTxtEmail.setForeground(new java.awt.Color(0, 0, 0));
        jTxtEmail.setText("Email");
        jLoginPanel.add(jTxtEmail);
        jTxtEmail.setBounds(140, 180, 40, 20);

        jSpUsername.setBackground(new java.awt.Color(0, 0, 0));
        jSpUsername.setMaximumSize(new java.awt.Dimension(220, 2));
        jSpUsername.setMinimumSize(new java.awt.Dimension(220, 2));
        jSpUsername.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jSpUsernameLayout = new javax.swing.GroupLayout(jSpUsername);
        jSpUsername.setLayout(jSpUsernameLayout);
        jSpUsernameLayout.setHorizontalGroup(
            jSpUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jSpUsernameLayout.setVerticalGroup(
            jSpUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLoginPanel.add(jSpUsername);
        jSpUsername.setBounds(140, 140, 220, 2);

        jTfEmail.setBackground(new java.awt.Color(255, 255, 255));
        jTfEmail.setForeground(new java.awt.Color(147, 147, 147));
        jTfEmail.setText("Enter your email");
        jTfEmail.setBorder(null);
        jTfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTfEmailFocusGained(evt);
            }
        });
        jTfEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTfEmailMousePressed(evt);
            }
        });
        jTfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfEmailActionPerformed(evt);
            }
        });
        jLoginPanel.add(jTfEmail);
        jTfEmail.setBounds(140, 200, 220, 30);

        jTxtErrorPassword.setBackground(new java.awt.Color(255, 255, 255));
        jTxtErrorPassword.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTxtErrorPassword.setForeground(new java.awt.Color(255, 255, 255));
        jTxtErrorPassword.setText("xd2");
        jLoginPanel.add(jTxtErrorPassword);
        jTxtErrorPassword.setBounds(140, 330, 220, 14);

        jTxtErrorUsername.setBackground(new java.awt.Color(255, 255, 255));
        jTxtErrorUsername.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTxtErrorUsername.setForeground(new java.awt.Color(255, 255, 255));
        jTxtErrorUsername.setText("xd2");
        jLoginPanel.add(jTxtErrorUsername);
        jTxtErrorUsername.setBounds(140, 150, 220, 14);

        jTxtErrorEmail.setBackground(new java.awt.Color(255, 255, 255));
        jTxtErrorEmail.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTxtErrorEmail.setForeground(new java.awt.Color(255, 255, 255));
        jTxtErrorEmail.setText("xd2");
        jLoginPanel.add(jTxtErrorEmail);
        jTxtErrorEmail.setBounds(140, 240, 220, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtLoginMouseClicked
        this.dispose();
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
    }//GEN-LAST:event_jTxtLoginMouseClicked

    private void jTxtLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtLoginMouseEntered
        this.jTxtLogin.setForeground(new Color(51,51,255));
    }//GEN-LAST:event_jTxtLoginMouseEntered

    private void jTxtLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtLoginMouseExited
        this.jTxtLogin.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_jTxtLoginMouseExited

    private void jTfUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTfUsernameFocusGained
        jTfUsername.setText("");
    }//GEN-LAST:event_jTfUsernameFocusGained

    private void jTfUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTfUsernameMousePressed
        
        this.estheticTextField(jTfUsername);
        
        
    }//GEN-LAST:event_jTfUsernameMousePressed

    private void jTfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfUsernameActionPerformed

    private void jPfPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPfPasswordFocusGained
        jPfPassword.setText("");
    }//GEN-LAST:event_jPfPasswordFocusGained

    private void jPfPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPfPasswordMousePressed
        this.estheticTextField(jPfPassword);
    }//GEN-LAST:event_jPfPasswordMousePressed

    private void jPfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPfPasswordActionPerformed

    private void jLbCrateAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbCrateAccountMouseClicked

        jTxtErrorPassword.setForeground(new Color(255,255,255));
        jTxtErrorUsername.setForeground(new Color(255,255,255));
        jTxtErrorEmail.setForeground(new Color(255,255,255));
        jSpEmail.setBackground(new Color(0,0,0));
        jSpPassword.setBackground(new Color(0,0,0));
        jSpUsername.setBackground(new Color(0,0,0));
        try {
            this.checkUser(jTfUsername.getText(),jTfUsername.getText());
        } catch (IOException ex) {
            Logger.getLogger(FrmCreateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jLbCrateAccountMouseClicked

    private void jLbCrateAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbCrateAccountMouseEntered
        jBtnLogin.setBackground(new Color(51,86,236));
    }//GEN-LAST:event_jLbCrateAccountMouseEntered

    private void jLbCrateAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbCrateAccountMouseExited
        jBtnLogin.setBackground(new Color(51,51,255));
    }//GEN-LAST:event_jLbCrateAccountMouseExited

    private void jBtnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLoginMouseClicked

    }//GEN-LAST:event_jBtnLoginMouseClicked

    private void jBtnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLoginMouseEntered

    }//GEN-LAST:event_jBtnLoginMouseEntered

    private void jBtnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnLoginMouseExited

    }//GEN-LAST:event_jBtnLoginMouseExited

    private void jTfEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTfEmailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfEmailFocusGained

    private void jTfEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTfEmailMousePressed
        this.estheticTextField(jTfEmail);
        
    }//GEN-LAST:event_jTfEmailMousePressed

    private void jTfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfEmailActionPerformed

    private void checkUser(String username, String email) throws IOException{
        actualUser = new User(0,jTfUsername.getText(), jTfEmail.getText(), String.valueOf(jPfPassword.getPassword()), null);
                dUser.createUser(actualUser);
        
        dUser.getArrayByOneUser(actualUser).stream()
                            .filter(u -> dUser.existUserByUsername(u.getUserName()) == false)
                            .filter(u -> dUser.existUserByEmail(u.getUserEmail()) == false)
                            .forEach(u -> dUser.createUser(u));
        
        boolean usernameBoolean = true;
        boolean emailBoolean = true;
        
        if(dUser.existUserByUsername(username)){
            jTxtErrorUsername.setText("User already exist");
            jTxtErrorUsername.setForeground(Color.red);
            jSpUsername.setBackground(Color.red);
        }else{
            usernameBoolean = false;
        }
        
        if(dUser.existUserByEmail(email)){
                jTxtErrorEmail.setText("The user is being used by another");
                jTxtErrorEmail.setForeground(Color.red);
                jSpEmail.setBackground(Color.red);
                
        }else{
                emailBoolean = false;
        }
        
        if(usernameBoolean && emailBoolean){
            actualUser = new User(0,jTfUsername.getText(), jTfEmail.getText(), String.valueOf(jPfPassword.getPassword()), null);
                dUser.createUser(actualUser);
                this.dispose();
                FrmLogin frmLogin = new FrmLogin();
                frmLogin.setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCreateAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jBtnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbCrateAccount;
    private javax.swing.JPanel jLogin;
    private javax.swing.JPanel jLoginPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPfPassword;
    private javax.swing.JPanel jSpEmail;
    private javax.swing.JPanel jSpPassword;
    private javax.swing.JPanel jSpUsername;
    private javax.swing.JTextField jTfEmail;
    private javax.swing.JTextField jTfUsername;
    private javax.swing.JLabel jTxtEmail;
    private javax.swing.JLabel jTxtErrorEmail;
    private javax.swing.JLabel jTxtErrorPassword;
    private javax.swing.JLabel jTxtErrorUsername;
    private javax.swing.JLabel jTxtLogin;
    private javax.swing.JLabel jTxtPassword;
    private javax.swing.JLabel jTxtUsername;
    // End of variables declaration//GEN-END:variables
}
