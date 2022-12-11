/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import data.TblUser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.User;

/**
 *
 * @author hebod
 */
public class FrmMain extends javax.swing.JFrame {

    ArrayList<JPanel> panelsArray = new ArrayList<>();
    ArrayList<JLabel> labelsArray = new ArrayList<>();
    TblUser dUser = new TblUser();

    public FrmMain(String name) throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.addArrays();
        this.photo(name);
        this.jLbName.setText(name);
    }

    public void photo(String username) throws IOException {
        User user;
        user = dUser.getUser(username);
     
        byte[] bi = user.getImage();
        
        if(bi==null){
            ImageIcon noPhoto = new ImageIcon(getClass().getResource("/icons/noPhoto.png"));
            ImageIcon imageNull = new ImageIcon(noPhoto.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            jUserPhoto.setIcon(imageNull);
        }else{
            BufferedImage image = null;
            InputStream in = new ByteArrayInputStream(bi);
            image = ImageIO.read(in);
            ImageIcon imgi = new ImageIcon(image.getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            jUserPhoto.setIcon(imgi);  
        }
        
        

    }

    public void addArrays() {
        panelsArray.add(jIdentifierProducts);
        panelsArray.add(jIdentifierInputs);
        panelsArray.add(jIdentifierOutputs);
        panelsArray.add(jIdentifierCategories);
        panelsArray.add(jIdentifierSettings);

        labelsArray.add(jLbProducts);
        labelsArray.add(jLbInputs);
        labelsArray.add(jLbOutputs);
        labelsArray.add(jLbCategories);
        labelsArray.add(jLbSettings);
    }

    private void setColors(JPanel panel, JLabel label) {
        for (JPanel actualPanel : panelsArray) {
            if (actualPanel == panel) {
                actualPanel.setBackground(new Color(51, 51, 255));
            } else {
                actualPanel.setBackground(new Color(220, 220, 220));
            }
        }

        for (JLabel actualLabel : labelsArray) {
            if (actualLabel == label) {
                actualLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
            } else {
                actualLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanelMain = new javax.swing.JPanel();
        jMainBar = new javax.swing.JPanel();
        jPanelOptions = new javax.swing.JPanel();
        jLbName = new javax.swing.JLabel();
        jContainProducts = new javax.swing.JPanel();
        jIconProducts = new javax.swing.JLabel();
        jIdentifierProducts = new javax.swing.JPanel();
        jLbProducts = new javax.swing.JLabel();
        jContainInputs = new javax.swing.JPanel();
        jIconInputs = new javax.swing.JLabel();
        jIdentifierInputs = new javax.swing.JPanel();
        jLbInputs = new javax.swing.JLabel();
        jContainOutputs = new javax.swing.JPanel();
        jIconOutputs = new javax.swing.JLabel();
        jIdentifierOutputs = new javax.swing.JPanel();
        jLbOutputs = new javax.swing.JLabel();
        jContainCategories = new javax.swing.JPanel();
        jIconCategories = new javax.swing.JLabel();
        jIdentifierCategories = new javax.swing.JPanel();
        jLbCategories = new javax.swing.JLabel();
        jContainSettings = new javax.swing.JPanel();
        jIdentifierSettings = new javax.swing.JPanel();
        jIconSettings = new javax.swing.JLabel();
        jLbSettings = new javax.swing.JLabel();
        jUserPhoto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(880, 520));
        setSize(new java.awt.Dimension(880, 520));

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMain.setMaximumSize(new java.awt.Dimension(880, 520));
        jPanelMain.setMinimumSize(new java.awt.Dimension(880, 520));
        jPanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMainBar.setBackground(new java.awt.Color(51, 51, 255));
        jMainBar.setForeground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jMainBarLayout = new javax.swing.GroupLayout(jMainBar);
        jMainBar.setLayout(jMainBarLayout);
        jMainBarLayout.setHorizontalGroup(
            jMainBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jMainBarLayout.setVerticalGroup(
            jMainBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanelMain.add(jMainBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 20));

        jPanelOptions.setBackground(new java.awt.Color(220, 220, 220));
        jPanelOptions.setForeground(new java.awt.Color(220, 220, 220));

        jLbName.setForeground(new java.awt.Color(0, 0, 0));
        jLbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jContainProducts.setBackground(new java.awt.Color(220, 220, 220));
        jContainProducts.setForeground(new java.awt.Color(220, 220, 220));
        jContainProducts.setMaximumSize(new java.awt.Dimension(190, 50));
        jContainProducts.setMinimumSize(new java.awt.Dimension(190, 50));
        jContainProducts.setPreferredSize(new java.awt.Dimension(190, 50));
        jContainProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jContainProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jContainProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jContainProductsMouseExited(evt);
            }
        });

        jIconProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ProductsLogo.png"))); // NOI18N

        jIdentifierProducts.setBackground(new java.awt.Color(51, 51, 255));
        jIdentifierProducts.setForeground(new java.awt.Color(51, 51, 255));
        jIdentifierProducts.setMaximumSize(new java.awt.Dimension(5, 40));
        jIdentifierProducts.setMinimumSize(new java.awt.Dimension(5, 40));
        jIdentifierProducts.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout jIdentifierProductsLayout = new javax.swing.GroupLayout(jIdentifierProducts);
        jIdentifierProducts.setLayout(jIdentifierProductsLayout);
        jIdentifierProductsLayout.setHorizontalGroup(
            jIdentifierProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jIdentifierProductsLayout.setVerticalGroup(
            jIdentifierProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLbProducts.setBackground(new java.awt.Color(0, 0, 0));
        jLbProducts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLbProducts.setForeground(new java.awt.Color(0, 0, 0));
        jLbProducts.setText("Products");

        javax.swing.GroupLayout jContainProductsLayout = new javax.swing.GroupLayout(jContainProducts);
        jContainProducts.setLayout(jContainProductsLayout);
        jContainProductsLayout.setHorizontalGroup(
            jContainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainProductsLayout.createSequentialGroup()
                .addComponent(jIdentifierProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jIconProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbProducts)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jContainProductsLayout.setVerticalGroup(
            jContainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jContainProductsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jIdentifierProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jContainProductsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jContainProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLbProducts)
                    .addComponent(jIconProducts))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jContainInputs.setBackground(new java.awt.Color(220, 220, 220));
        jContainInputs.setForeground(new java.awt.Color(220, 220, 220));
        jContainInputs.setMaximumSize(new java.awt.Dimension(190, 50));
        jContainInputs.setMinimumSize(new java.awt.Dimension(190, 50));
        jContainInputs.setPreferredSize(new java.awt.Dimension(190, 50));
        jContainInputs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jContainInputsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jContainInputsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jContainInputsMouseExited(evt);
            }
        });

        jIconInputs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/InputLogo.png"))); // NOI18N

        jIdentifierInputs.setBackground(new java.awt.Color(220, 220, 220));
        jIdentifierInputs.setForeground(new java.awt.Color(220, 220, 220));
        jIdentifierInputs.setMaximumSize(new java.awt.Dimension(5, 40));
        jIdentifierInputs.setMinimumSize(new java.awt.Dimension(5, 40));
        jIdentifierInputs.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout jIdentifierInputsLayout = new javax.swing.GroupLayout(jIdentifierInputs);
        jIdentifierInputs.setLayout(jIdentifierInputsLayout);
        jIdentifierInputsLayout.setHorizontalGroup(
            jIdentifierInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jIdentifierInputsLayout.setVerticalGroup(
            jIdentifierInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLbInputs.setBackground(new java.awt.Color(0, 0, 0));
        jLbInputs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLbInputs.setForeground(new java.awt.Color(0, 0, 0));
        jLbInputs.setText("Inputs");

        javax.swing.GroupLayout jContainInputsLayout = new javax.swing.GroupLayout(jContainInputs);
        jContainInputs.setLayout(jContainInputsLayout);
        jContainInputsLayout.setHorizontalGroup(
            jContainInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainInputsLayout.createSequentialGroup()
                .addComponent(jIdentifierInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jIconInputs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbInputs)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jContainInputsLayout.setVerticalGroup(
            jContainInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jContainInputsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jIdentifierInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jContainInputsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jContainInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jIconInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLbInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jContainOutputs.setBackground(new java.awt.Color(220, 220, 220));
        jContainOutputs.setForeground(new java.awt.Color(220, 220, 220));
        jContainOutputs.setMaximumSize(new java.awt.Dimension(190, 50));
        jContainOutputs.setMinimumSize(new java.awt.Dimension(190, 50));
        jContainOutputs.setPreferredSize(new java.awt.Dimension(190, 50));
        jContainOutputs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jContainOutputsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jContainOutputsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jContainOutputsMouseExited(evt);
            }
        });

        jIconOutputs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/OutputLogo.png"))); // NOI18N

        jIdentifierOutputs.setBackground(new java.awt.Color(220, 220, 220));
        jIdentifierOutputs.setForeground(new java.awt.Color(220, 220, 220));
        jIdentifierOutputs.setMaximumSize(new java.awt.Dimension(5, 40));
        jIdentifierOutputs.setMinimumSize(new java.awt.Dimension(5, 40));
        jIdentifierOutputs.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout jIdentifierOutputsLayout = new javax.swing.GroupLayout(jIdentifierOutputs);
        jIdentifierOutputs.setLayout(jIdentifierOutputsLayout);
        jIdentifierOutputsLayout.setHorizontalGroup(
            jIdentifierOutputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jIdentifierOutputsLayout.setVerticalGroup(
            jIdentifierOutputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLbOutputs.setBackground(new java.awt.Color(0, 0, 0));
        jLbOutputs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLbOutputs.setForeground(new java.awt.Color(0, 0, 0));
        jLbOutputs.setText("Outputs");

        javax.swing.GroupLayout jContainOutputsLayout = new javax.swing.GroupLayout(jContainOutputs);
        jContainOutputs.setLayout(jContainOutputsLayout);
        jContainOutputsLayout.setHorizontalGroup(
            jContainOutputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainOutputsLayout.createSequentialGroup()
                .addComponent(jIdentifierOutputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jIconOutputs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbOutputs)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jContainOutputsLayout.setVerticalGroup(
            jContainOutputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jContainOutputsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jIdentifierOutputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jContainOutputsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jContainOutputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLbOutputs)
                    .addComponent(jIconOutputs))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jContainCategories.setBackground(new java.awt.Color(220, 220, 220));
        jContainCategories.setForeground(new java.awt.Color(220, 220, 220));
        jContainCategories.setMaximumSize(new java.awt.Dimension(190, 50));
        jContainCategories.setMinimumSize(new java.awt.Dimension(190, 50));
        jContainCategories.setPreferredSize(new java.awt.Dimension(190, 50));
        jContainCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jContainCategoriesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jContainCategoriesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jContainCategoriesMouseExited(evt);
            }
        });

        jIconCategories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/CategoriesLogo.png"))); // NOI18N

        jIdentifierCategories.setBackground(new java.awt.Color(220, 220, 220));
        jIdentifierCategories.setForeground(new java.awt.Color(220, 220, 220));
        jIdentifierCategories.setMaximumSize(new java.awt.Dimension(5, 40));
        jIdentifierCategories.setMinimumSize(new java.awt.Dimension(5, 40));
        jIdentifierCategories.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout jIdentifierCategoriesLayout = new javax.swing.GroupLayout(jIdentifierCategories);
        jIdentifierCategories.setLayout(jIdentifierCategoriesLayout);
        jIdentifierCategoriesLayout.setHorizontalGroup(
            jIdentifierCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jIdentifierCategoriesLayout.setVerticalGroup(
            jIdentifierCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLbCategories.setBackground(new java.awt.Color(0, 0, 0));
        jLbCategories.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLbCategories.setForeground(new java.awt.Color(0, 0, 0));
        jLbCategories.setText("Categories");

        javax.swing.GroupLayout jContainCategoriesLayout = new javax.swing.GroupLayout(jContainCategories);
        jContainCategories.setLayout(jContainCategoriesLayout);
        jContainCategoriesLayout.setHorizontalGroup(
            jContainCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainCategoriesLayout.createSequentialGroup()
                .addComponent(jIdentifierCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jIconCategories)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbCategories)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jContainCategoriesLayout.setVerticalGroup(
            jContainCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jContainCategoriesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jIdentifierCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jContainCategoriesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jContainCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbCategories)
                    .addComponent(jIconCategories))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jContainSettings.setBackground(new java.awt.Color(220, 220, 220));
        jContainSettings.setForeground(new java.awt.Color(220, 220, 220));
        jContainSettings.setMaximumSize(new java.awt.Dimension(190, 50));
        jContainSettings.setMinimumSize(new java.awt.Dimension(190, 50));
        jContainSettings.setPreferredSize(new java.awt.Dimension(190, 50));
        jContainSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jContainSettingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jContainSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jContainSettingsMouseExited(evt);
            }
        });

        jIdentifierSettings.setBackground(new java.awt.Color(220, 220, 220));
        jIdentifierSettings.setForeground(new java.awt.Color(220, 220, 220));
        jIdentifierSettings.setMaximumSize(new java.awt.Dimension(5, 40));
        jIdentifierSettings.setMinimumSize(new java.awt.Dimension(5, 40));
        jIdentifierSettings.setPreferredSize(new java.awt.Dimension(5, 40));

        javax.swing.GroupLayout jIdentifierSettingsLayout = new javax.swing.GroupLayout(jIdentifierSettings);
        jIdentifierSettings.setLayout(jIdentifierSettingsLayout);
        jIdentifierSettingsLayout.setHorizontalGroup(
            jIdentifierSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jIdentifierSettingsLayout.setVerticalGroup(
            jIdentifierSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jIconSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Settings.png"))); // NOI18N
        jIconSettings.setName(""); // NOI18N

        jLbSettings.setBackground(new java.awt.Color(0, 0, 0));
        jLbSettings.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLbSettings.setForeground(new java.awt.Color(0, 0, 0));
        jLbSettings.setText("Settings");

        javax.swing.GroupLayout jContainSettingsLayout = new javax.swing.GroupLayout(jContainSettings);
        jContainSettings.setLayout(jContainSettingsLayout);
        jContainSettingsLayout.setHorizontalGroup(
            jContainSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainSettingsLayout.createSequentialGroup()
                .addComponent(jIdentifierSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jIconSettings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbSettings)
                .addGap(0, 86, Short.MAX_VALUE))
        );
        jContainSettingsLayout.setVerticalGroup(
            jContainSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jContainSettingsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jIdentifierSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jContainSettingsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jContainSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLbSettings)
                    .addComponent(jIconSettings))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jUserPhoto.setMaximumSize(new java.awt.Dimension(70, 70));
        jUserPhoto.setMinimumSize(new java.awt.Dimension(70, 70));
        jUserPhoto.setPreferredSize(new java.awt.Dimension(70, 70));
        jUserPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUserPhotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelOptionsLayout = new javax.swing.GroupLayout(jPanelOptions);
        jPanelOptions.setLayout(jPanelOptionsLayout);
        jPanelOptionsLayout.setHorizontalGroup(
            jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelOptionsLayout.createSequentialGroup()
                .addGroup(jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jContainProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jContainInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jContainOutputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jContainCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jContainSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelOptionsLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jUserPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOptionsLayout.setVerticalGroup(
            jPanelOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionsLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jUserPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbName)
                .addGap(24, 24, 24)
                .addComponent(jContainProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jContainInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jContainOutputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jContainCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jContainSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jPanelMain.add(jPanelOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 520));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jContainProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainProductsMouseEntered
        this.jContainProducts.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jContainProductsMouseEntered

    private void jContainProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainProductsMouseExited
        this.jContainProducts.setBackground(new Color(220, 220, 220));
    }//GEN-LAST:event_jContainProductsMouseExited

    private void jContainInputsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainInputsMouseEntered
        this.jContainInputs.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jContainInputsMouseEntered

    private void jContainInputsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainInputsMouseExited
        this.jContainInputs.setBackground(new Color(220, 220, 220));
    }//GEN-LAST:event_jContainInputsMouseExited

    private void jContainOutputsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainOutputsMouseEntered
        this.jContainOutputs.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jContainOutputsMouseEntered

    private void jContainOutputsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainOutputsMouseExited
        this.jContainOutputs.setBackground(new Color(220, 220, 220));
    }//GEN-LAST:event_jContainOutputsMouseExited

    private void jContainCategoriesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainCategoriesMouseEntered
        this.jContainCategories.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jContainCategoriesMouseEntered

    private void jContainCategoriesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainCategoriesMouseExited
        this.jContainCategories.setBackground(new Color(220, 220, 220));
    }//GEN-LAST:event_jContainCategoriesMouseExited

    private void jContainSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainSettingsMouseEntered
        this.jContainSettings.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jContainSettingsMouseEntered

    private void jContainSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainSettingsMouseExited
        this.jContainSettings.setBackground(new Color(220, 220, 220));
    }//GEN-LAST:event_jContainSettingsMouseExited

    private void jContainProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainProductsMouseClicked
        this.setColors(jIdentifierProducts, jLbProducts);
    }//GEN-LAST:event_jContainProductsMouseClicked

    private void jContainInputsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainInputsMouseClicked
        this.setColors(jIdentifierInputs, jLbInputs);
    }//GEN-LAST:event_jContainInputsMouseClicked

    private void jContainOutputsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainOutputsMouseClicked
        this.setColors(jIdentifierOutputs, jLbOutputs);
    }//GEN-LAST:event_jContainOutputsMouseClicked

    private void jContainCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainCategoriesMouseClicked
        this.setColors(jIdentifierCategories, jLbCategories);
    }//GEN-LAST:event_jContainCategoriesMouseClicked

    private void jContainSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jContainSettingsMouseClicked
        this.setColors(jIdentifierSettings, jLbSettings);
    }//GEN-LAST:event_jContainSettingsMouseClicked

    private void jUserPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUserPhotoMouseClicked
        FrmChangePhoto photo = null;
        try {
            photo = new FrmChangePhoto(this.jLbName.getText());
        } catch (IOException ex) {
            Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        photo.setVisible(true);
    }//GEN-LAST:event_jUserPhotoMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        this.jUserPhoto.repaint();
    }//GEN-LAST:event_jPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmMain("xd").setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jContainCategories;
    private javax.swing.JPanel jContainInputs;
    private javax.swing.JPanel jContainOutputs;
    private javax.swing.JPanel jContainProducts;
    private javax.swing.JPanel jContainSettings;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jIconCategories;
    private javax.swing.JLabel jIconInputs;
    private javax.swing.JLabel jIconOutputs;
    private javax.swing.JLabel jIconProducts;
    private javax.swing.JLabel jIconSettings;
    private javax.swing.JPanel jIdentifierCategories;
    private javax.swing.JPanel jIdentifierInputs;
    private javax.swing.JPanel jIdentifierOutputs;
    private javax.swing.JPanel jIdentifierProducts;
    private javax.swing.JPanel jIdentifierSettings;
    private javax.swing.JLabel jLbCategories;
    private javax.swing.JLabel jLbInputs;
    private javax.swing.JLabel jLbName;
    private javax.swing.JLabel jLbOutputs;
    private javax.swing.JLabel jLbProducts;
    private javax.swing.JLabel jLbSettings;
    private javax.swing.JPanel jMainBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelOptions;
    private javax.swing.JLabel jUserPhoto;
    // End of variables declaration//GEN-END:variables
}
