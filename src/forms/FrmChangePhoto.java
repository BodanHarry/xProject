/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import data.TblUser;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import models.User;

/**
 *
 * @author hebod
 */
public class FrmChangePhoto extends javax.swing.JFrame {

    TblUser dUser = new TblUser();
    FileInputStream input;
    FileOutputStream output;
    String userName;

    public FrmChangePhoto(String username) throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        userName = username;
        this.jLbUserName.setText(userName);
        this.setPhoto(userName);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jChangePhoto = new javax.swing.JPanel();
        jLbChangePhoto = new javax.swing.JLabel();
        jLbUserName = new javax.swing.JLabel();
        jPhoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 200));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 200));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 200));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jChangePhoto.setBackground(new java.awt.Color(51, 51, 255));
        jChangePhoto.setForeground(new java.awt.Color(51, 51, 255));
        jChangePhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChangePhotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jChangePhotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jChangePhotoMouseExited(evt);
            }
        });

        jLbChangePhoto.setBackground(new java.awt.Color(255, 255, 255));
        jLbChangePhoto.setForeground(new java.awt.Color(255, 255, 255));
        jLbChangePhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbChangePhoto.setText("Change Photo");
        jLbChangePhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbChangePhotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jChangePhotoLayout = new javax.swing.GroupLayout(jChangePhoto);
        jChangePhoto.setLayout(jChangePhotoLayout);
        jChangePhotoLayout.setHorizontalGroup(
            jChangePhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jChangePhotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbChangePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jChangePhotoLayout.setVerticalGroup(
            jChangePhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jChangePhotoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLbChangePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jChangePhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLbUserName.setBackground(new java.awt.Color(0, 0, 0));
        jLbUserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLbUserName.setForeground(new java.awt.Color(0, 0, 0));
        jLbUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbUserName.setText("Usuario");
        jPanel1.add(jLbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jPhoto.setBackground(new java.awt.Color(0, 0, 0));
        jPhoto.setForeground(new java.awt.Color(0, 0, 0));
        jPhoto.setMaximumSize(new java.awt.Dimension(70, 70));
        jPhoto.setMinimumSize(new java.awt.Dimension(70, 70));
        jPhoto.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel1.add(jPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setPhoto(String username) throws IOException{
        User user;
        user = dUser.getUser(username);
     
        byte[] bi = user.getImage();
        
        if(bi==null){
            ImageIcon noPhoto = new ImageIcon(getClass().getResource("/icons/noPhoto.png"));
            ImageIcon imageNull = new ImageIcon(noPhoto.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            jPhoto.setIcon(imageNull);
        }else{
            BufferedImage image = null;
            InputStream in = new ByteArrayInputStream(bi);
            image = ImageIO.read(in);
            ImageIcon imgi = new ImageIcon(image.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            jPhoto.setIcon(imgi);  
        }
    
       
    }
    
    private void jChangePhotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangePhotoMouseEntered
        this.jChangePhoto.setBackground(new Color(51, 51, 180));
    }//GEN-LAST:event_jChangePhotoMouseEntered

    private void jChangePhotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangePhotoMouseExited
        this.jChangePhoto.setBackground(new Color(51, 51, 255));
    }//GEN-LAST:event_jChangePhotoMouseExited

    private void jLbChangePhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbChangePhotoMouseClicked
        InputStream inputStream = null;
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int statement = fileChooser.showOpenDialog(null);
        if(statement == JFileChooser.APPROVE_OPTION){
            try {
                inputStream = new FileInputStream(fileChooser.getSelectedFile());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FrmChangePhoto.class.getName()).log(Level.SEVERE, null, ex);
            }
            try{
                User user;
                user = dUser.getUser(userName);
                byte[] byteArray = inputStream.readAllBytes();
                inputStream.close();
                user.setImage(byteArray);
                dUser.changePhoto(user);
                this.setPhoto(userName);
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
       
    }//GEN-LAST:event_jLbChangePhotoMouseClicked


    private void jChangePhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangePhotoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jChangePhotoMouseClicked


    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FrmChangePhoto("a").setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(FrmChangePhoto.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jChangePhoto;
    private javax.swing.JLabel jLbChangePhoto;
    private javax.swing.JLabel jLbUserName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jPhoto;
    // End of variables declaration//GEN-END:variables
}
