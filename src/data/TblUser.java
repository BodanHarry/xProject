package data;

import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TblUser {

    private Connection conn = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    
    public ArrayList<User> temporalUserArray = new ArrayList<>();
    public User temporalUser = new User();

    public void getReg() throws SQLException {
        try {
            conn = Conexion.getConnection();
            String tSQL = "Select * from [xProject].[dbo].[User]";
            ps = conn.prepareStatement(tSQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                    + ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error getting user records" + ex.getMessage());
        }
    }

    public ArrayList<User> userList() {
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
            System.out.println("Error listing user records" + ex.getMessage());
        }
        return list;
    }

    public boolean createUser(User user) {
        boolean saved = false;
        try {
            this.getReg();
            rs.moveToInsertRow();
            rs.updateString("Username", user.getUserName());
            rs.updateString("Useremail", user.getUserEmail());
            rs.updateString("Userpassword", user.getUserPassword());
            rs.insertRow();
            saved = true;
            rs.moveToCurrentRow();
            System.out.println("Se guardó mijo");
        } catch (SQLException ex) {
            System.out.println("Error adding user" + ex.getMessage());
        }
        return saved;
    }

    public boolean editUser(User user) {
        boolean result = false;
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
                    result = true;
                    break;

                }
            }
        } catch (SQLException ex) {
            System.out.println("Error editing user: " + ex.getMessage());
        }

        return result;
    }
    
    public boolean removeUser(String username) {
        boolean result = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("Username").equals(username)) {
                    rs.deleteRow();
                    result = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error removing user: " + ex.getMessage());
        } 
        
        return result;
    }
    
    public boolean existUserByUsername(String username) {
        return userList().stream()
                         .anyMatch(u -> u.getUserName().equals(username));
    }
    
    public boolean existUserByEmail(String email) {
        return userList().stream()
                         .anyMatch(u -> u.getUserEmail().equals(email));
    }

    public User getUser(String username) {
        return (User) userList().stream()
                              .filter(u -> u.getUserName().equals(username));                     
    }
    
    public String getUserPassword(String username) {
        temporalUser = (User) userList().stream()
                    .filter(u -> u.getUserName().equals(username));
  
        return temporalUser.getUserPassword();
    }
    
    public User getUserByID(int idUser) {
        return (User) userList().stream()
                    .filter(u -> u.getIdUser()==idUser);
    }
    
    public User getUserByEmail(String email) {
        return (User) userList().stream()
                    .filter(u -> u.getUserEmail().equals(email));
    }
    
    public ArrayList<User> getArrayByOneUser(User user){
        temporalUserArray.clear();
        temporalUserArray.add(user);
        return temporalUserArray;
    }
}