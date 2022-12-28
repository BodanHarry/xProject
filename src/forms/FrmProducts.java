package forms;

import javax.swing.JPanel;

public class FrmProducts extends javax.swing.JFrame {

    public FrmProducts() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMainProduct = new javax.swing.JPanel();
        jTxtProduct = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 470));
        setSize(new java.awt.Dimension(670, 470));

        jMainProduct.setBackground(new java.awt.Color(255, 255, 255));
        jMainProduct.setMaximumSize(new java.awt.Dimension(670, 470));
        jMainProduct.setMinimumSize(new java.awt.Dimension(670, 470));
        jMainProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTxtProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTxtProduct.setForeground(new java.awt.Color(0, 0, 0));
        jTxtProduct.setText("Product");
        jMainProduct.add(jTxtProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JPanel getBackgroundPanel() {
        return jMainProduct;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmProducts().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jMainProduct;
    private javax.swing.JLabel jTxtProduct;
    // End of variables declaration//GEN-END:variables
}
