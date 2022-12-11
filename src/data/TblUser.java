/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author bradl
 */
public class TblUser {

    private Connection conn = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;

    public void getReg() throws SQLException {
        try {
            conn = Conexion.getConnection();
            String tSQL = "Select * from [xProject].[dbo].[User]";
            ps = conn.prepareStatement(tSQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                    + ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros" + ex.getMessage());
        }
    }

    public ArrayList<User> listaUser() {
        ArrayList<User> list = new ArrayList<>();
        try {
            this.getReg();
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Useremail"),
                        rs.getString("Userpassword"),
                        rs.getBytes("UserPhoto")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar al usuario: " + ex.getMessage());
        } finally {

           
        }

        return list;

    }

    public boolean addUser(User user) {
        boolean guardado = false;
        try {
            this.getReg();
            rs.moveToInsertRow();
            rs.updateString("Username", user.getUserName());
            rs.updateString("Useremail", user.getUserEmail());
            rs.updateString("Userpassword", user.getUserPassword());
            rs.insertRow();
            guardado = true;
            rs.moveToCurrentRow();
            System.out.println("Se guardó mijo");
        } catch (SQLException ex) {
            System.out.println("Error al guardar autor" + ex.getMessage());
        } finally {


        }
        return guardado;
    }

    public boolean existUser(String username) {
        boolean resp = false;
        try {
            this.getReg();
            while (rs.next()) {
                if (rs.getString("Username").equals(username)) {
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario: " + ex.getMessage());
        } finally {

            

        }
        return resp;
    }

    public boolean editUser(User user) {
        boolean resp = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("Username").equals(user.getUserName())) {
                    rs.updateString("Useremail", user.getUserEmail());
                    rs.updateString("Username", user.getUserName());
                    rs.updateString("Userpassword", user.getUserPassword());
                    rs.updateRow();
                    resp = true;
                    break;

                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al editar al usuario: " + ex.getMessage());
        } finally {

            
        }

        return resp;
    }

    public boolean removeUser(String username) {
        boolean resp = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("Username").equals(username)) {
                    rs.deleteRow();
                    resp = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar al usuario: " + ex.getMessage());
        } finally {

            
        }
        return resp;
    }

    public User getUser(String username) {
        User user = new User();
        try {
            this.getReg();
            while (rs.next()) {
                if (rs.getString("Username").equals(username)) {
                    user = new User(
                            rs.getInt("UserID"),
                            rs.getString("Username"),
                            rs.getString("Useremail"),
                            rs.getString("Userpassword"),
                            rs.getBytes("UserPhoto")
                    );
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario: " + ex.getMessage());
        } finally {

          

        }
        return user;
    }

    public String getUserName(String username) {
        String value = " ";
        try {

            this.getReg();
            while (rs.next()) {
                if (rs.getString("Username").equals(username)) {
                    value = rs.getString("Username");
                    break;

                }
            }
            

        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "El correo es invalido ");
        } finally {

           

        }

        return value;
    }

    public String getUserPassword(String username) {
        String value = " ";
        try {
            this.getReg();
            while (rs.next()) {
                if (rs.getString("Username").equals(username)) {
                    value = rs.getString("Userpassword");
                    
                    break;
                } 
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "La contraseña es invalida ");
        } finally {

         

        }

        return value;
    }
    
    public User getUserByID(int idUser) {
        User user = new User();
        
        try {
            this.getReg();
            while (rs.next()) {
                if (rs.getInt("UserID") == idUser) {
                    user = new User(
                            rs.getInt("UserID"),
                            rs.getString("Username"),
                            rs.getString("Useremail"),
                            rs.getString("Userpassword"),
                            rs.getBytes("UserPhoto")
                    );
                    
                    break;
                } 
                
                
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar usuario: " + ex.getMessage());
        } finally {

         

        }

        return user;
    }
    
    public boolean changePhoto(User user) {
        boolean resp = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("Username").equals(user.getUserName())) {
                    rs.updateString("Useremail", user.getUserEmail());
                    rs.updateString("Username", user.getUserName());
                    rs.updateString("Userpassword", user.getUserPassword());
                    rs.updateBytes("UserPhoto", user.getImage());
                    rs.updateRow();
                    resp = true;
                    break;

                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al editar al usuario: " + ex.getMessage());
        } finally {
            
        }

        return resp;
    }
    
}
