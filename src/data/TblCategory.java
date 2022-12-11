/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Category;

/**
 *
 * @author hebod
 */
public class TblCategory {
    private Connection conn = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;

    public void getReg() throws SQLException {
        try {
            conn = Conexion.getConnection();
            String tSQL = "Select * from [xProject].[dbo].[Category]";
            ps = conn.prepareStatement(tSQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                    + ResultSet.HOLD_CURSORS_OVER_COMMIT
            );
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros" + ex.getMessage());
        }
    }

    public ArrayList<Category> categoryList() {
        ArrayList<Category> list = new ArrayList<>();
        try {
            this.getReg();
            while (rs.next()) {
                list.add(new Category(
                        Integer.parseInt(rs.getString("CategoryID")),
                        rs.getString("Productdescription"),
                        rs.getString("Producttype"),
                        rs.getString("Productsize")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar la categoría: " + ex.getMessage());
        } finally {

           

            
        }

        return list;

    }

    public boolean addCategory(Category category) {
        boolean saved = false;
        try {
            this.getReg();
            rs.moveToInsertRow();
            rs.updateString("Productdescription", category.getProductDescription());
            rs.updateString("Producttype", category.getProductType());
            rs.updateString("Productsize", category.getProductSize());
            rs.insertRow();
            saved = true;
            rs.moveToCurrentRow();
        } catch (SQLException ex) {
            System.out.println("Error al guardar categoría" + ex.getMessage());
        } finally {

            

        }
        return saved;
    }

    public boolean existCategory(int idCategory) {
        boolean result = false;
        try {
            this.getReg();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("CategoryID")) == idCategory) {
                    result = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar categoría: " + ex.getMessage());
        } finally {

            

        }
        return result;
    }

    public boolean editCategory(Category category) {
        boolean result = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("CategoryID")) == category.getIdCategory()) {
                    rs.updateString("Productdescription", category.getProductDescription());
                    rs.updateString("Producttype", category.getProductType());
                    rs.updateString("Productsize", category.getProductSize());
                    rs.updateRow();
                    result = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al editar: " + ex.getMessage());
        } finally {

            
        }

        return result;
    }

    public boolean removeCategory(int idCategory) {
        boolean result = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("CategoryID")) == idCategory) {
                    rs.deleteRow();
                    result = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar categoría: " + ex.getMessage());
        } finally {

            
        }
        return result;
    }
    
    public Category getCategory(int idCategory) {
        Category category =  new Category();
        try {
            this.getReg();
            while (rs.next()) {
                if (rs.getInt("CategoryID") == idCategory) {
                    category = new Category(
                            rs.getInt("CategoryID"),
                            rs.getString("Productdescription"),
                            rs.getString("Producttype"),
                            rs.getString("Productsize")
                    );
                    
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar categoría: " + ex.getMessage());
        } 
        return category;
    }
    
    public Category findCategoryByName(String name) {
        Category category =  new Category();
        String actualName;
        try {
            this.getReg();
            while (rs.next()) {
                actualName = rs.getString("Producttype") + " " + rs.getString("Productsize");
                if (actualName.equals(name)) {
                    category = new Category(
                            rs.getInt("CategoryID"),
                            rs.getString("Productdescription"),
                            rs.getString("Producttype"),
                            rs.getString("Productsize")
                    );
                    return category;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar categoría: " + ex.getMessage());
        } finally {
          
        }
        return category;
    }
}
