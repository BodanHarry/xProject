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
import models.Product;

/**
 *
 * @author hebod
 */
public class TblProduct {

    private Connection conn = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;

    public void getReg() throws SQLException {
        try {
            conn = Conexion.getConnection();
            String tSQL = "Select * from [xProject].[dbo].[Product]";
            ps = conn.prepareStatement(tSQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                    + ResultSet.HOLD_CURSORS_OVER_COMMIT
            );
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener registros" + ex.getMessage());
        }
    }

    public ArrayList<Product> listProduct() {
        ArrayList<Product> list = new ArrayList<>();
        TblCategory categories = new TblCategory();
        Category category;
        
        try {
            this.getReg();
            while (rs.next()) {
                int idCategory = rs.getInt("CategoryID");
                category = categories.getCategory(idCategory);
                list.add(new Product(
                        rs.getString("Productname"),
                        rs.getString("Productcolor"),
                        rs.getInt("ProductID"),
                        rs.getDouble("Productprice"),
                        category,
                        rs.getInt("Productquantity")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar el producto: " + ex.getMessage());
        } finally {

        }

        return list;

    }

    public boolean addProduct(Product product) {
        boolean saved = false;
        try {
            this.getReg();
            rs.moveToInsertRow();
            rs.updateString("Productname", product.getProductName());
            rs.updateString("Productcolor", product.getProductColor());
            rs.updateDouble("ProductPrice", product.getProductPrice());
            rs.updateInt("CategoryID", product.getM_Category().getIdCategory());
            rs.updateInt("Productquantity", product.getProductQuantity());
            rs.insertRow();
            rs.moveToCurrentRow();
            saved = true;
        } catch (SQLException ex) {
            System.out.println("Error al guardar el producto" + ex.getMessage());
        } finally {

           

        }
        return saved;
    }

    public boolean existProduct(int idProduct) {
        boolean result = false;
        try {
            this.getReg();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("ProductID")) == idProduct) {
                    result = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar el producto: " + ex.getMessage());
        } finally {

            

        }
        return result;
    }

    public boolean editProduct(Product product) {
        boolean result = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getInt("ProductID") == product.getIdProduct()) {
                    rs.updateString("Productname", product.getProductName());
                    rs.updateString("Productcolor", product.getProductColor());
                    rs.updateDouble("Productprice", product.getProductPrice());
                    rs.updateInt("CategoryID", product.getM_Category().getIdCategory());
                    rs.updateInt("Productquantity", product.getProductQuantity());
                    rs.updateRow();
                    result = true;
                    return result;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al editar: " + ex.getMessage());
        } finally {

            
        }

        return result;
    }

    public boolean removeProduct(int idProduct) {
        boolean result = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("ProductID")) == idProduct) {
                    rs.deleteRow();
                    result = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar Producto: " + ex.getMessage());
        } finally {

            
        }
        return result;
    }
    
    public Product getProduct(int idProduct) {
        Product product =  new Product();
        TblCategory category = new TblCategory();
        try {
            this.getReg();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("ProductID")) == idProduct) {
                    product = new Product(
                            rs.getString("Productname"),
                            rs.getString("Productcolor"),
                            rs.getInt("ProductID"),
                            rs.getDouble("Productprice"),
                            category.getCategory(Integer.parseInt(rs.getString("CategoryID"))),
                            rs.getInt("Productquantity")
                    );
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar producto: " + ex.getMessage());
        } finally {

            

        }
        return product;
    }
    
    public Product getProductByName(String name){
        TblCategory dCategory = new TblCategory();
        Product product = new Product();
       try {
            this.getReg();
            while (rs.next()) {
                Category actualCategory = dCategory.getCategory(rs.getInt("CategoryID"));
                String actualProductName = rs.getString("Productname") + " " + actualCategory.getProductType() + " " + actualCategory.getProductSize() + " " + rs.getString("Productcolor");
                if (name.equals(actualProductName)) {
                    product = new Product(
                            rs.getString("Productname"),
                            rs.getString("Productcolor"),
                            rs.getInt("ProductID"),
                            rs.getDouble("Productprice"),
                            actualCategory,
                            rs.getInt("Productquantity")
                    );
                    return product;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar producto: " + ex.getMessage());
        }
       return product;
    }
    
    
}
