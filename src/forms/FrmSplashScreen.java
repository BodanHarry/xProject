package forms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class FrmSplashScreen extends javax.swing.JFrame {
    private Timer timer;
    private final ActionListener actionListener;
    
    public FrmSplashScreen() {
        this.setLocationRelativeTo(null);
        actionListener = (ActionEvent e) -> {
            if(jProgressBar.getValue() < 100){
                jProgressBar.setValue(jProgressBar.getValue()+5);
            }else{
                timer.stop();
                this.showFrm();
            }
        };
        timer = new Timer(80,actionListener);
        initComponents();
        timer.start();
        this.setBackground(new Color(0,0,0,0));
        
    }

    public void showFrm(){
    
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        this.dispose();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jProgressBar.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar.setForeground(new java.awt.Color(153, 153, 255));
        getContentPane().add(jProgressBar);
        jProgressBar.setBounds(150, 350, 200, 10);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/splashScreen.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 500, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmSplashScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar;
    // End of variables declaration//GEN-END:variables
}
