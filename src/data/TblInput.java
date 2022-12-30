/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import models.Input;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import models.Product;
import models.User;

/**
 *
 * @author MSI DRAGON
 */
public class TblInput {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void getReg() throws SQLException {
        try {
            conn = Conexion.getConnection();
            String tSQL = "Select * from [xProject].[dbo].[Input]";
            ps = conn.prepareStatement(tSQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                    + ResultSet.HOLD_CURSORS_OVER_COMMIT
            );
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener entradas" + ex.getMessage());

        }
    }

    public ArrayList<Input> inputList() {
        ArrayList<Input> list = new ArrayList<>();
        TblProduct products = new TblProduct();
        Product product;
        TblUser users = new TblUser();
        User user;

        try {

            this.getReg();
            while (rs.next()) {
                int idProduct = Integer.parseInt(rs.getString("ProductID"));
                product = products.getProductByID(idProduct);
                int idUser = rs.getInt("UserID");
                user = users.getUserByID(idUser);
                list.add(new Input(
                        rs.getInt("InputID"),
                        rs.getString("Inputdate"),
                        rs.getDouble("Inputprice"),
                        rs.getInt("Inputquantity"),
                        product,
                        user
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar las entradas" + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }

                if (conn != null) {
                    Conexion.closeConexion(conn);

                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        return list;
    }

    public boolean addInput(Input input) {
        boolean saved = false;
        try {
            this.getReg();
            rs.moveToInsertRow();
            rs.updateString("Inputdate", input.getInputDate());
            rs.updateDouble("Inputprice", input.getInputPrice());
            rs.updateInt("Inputquantity", input.getInputQuantity());
            rs.updateString("ProductID", String.valueOf(input.getM_Product().getIdProduct()));
            rs.updateString("UserID", String.valueOf(input.getM_User().getIdUser()));
            rs.insertRow();
            rs.moveToCurrentRow();
            saved = true;
        } catch (SQLException ex) {
            System.out.println("Error al guardar la entrada" + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (rs != null) {
                    ps.close();
                }

                if (rs != null) {
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        return saved;
    }

    public boolean existInput(int idInput) {
        boolean result = false;
        try {
            this.getReg();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("InputID")) == idInput) {
                    result = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar la entrada: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (rs != null) {
                    ps.close();
                }

                if (rs != null) {
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;

    }

    public boolean removeInput(int idInput) {
        boolean result = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("InputID")) == idInput) {
                    rs.deleteRow();
                    result = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar entrada: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (rs != null) {
                    ps.close();
                }

                if (rs != null) {
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;

    }

    public Input getInput(int idInput) {
        Input input = new Input();
        TblProduct products = new TblProduct();
        Product product;
        TblUser users = new TblUser();
        User user;
        try {
            this.getReg();
            while (rs.next()) {
                String inputDate = rs.getString("Inputdate");
                int idProduct = Integer.parseInt(rs.getString("ProductID"));
                product = products.getProductByID(idProduct);
                String username = rs.getString("Username");
                if (Integer.parseInt(rs.getString("InputID")) == idInput) {
                    user = users.getUser(username);
                    input = new Input(
                            Integer.parseInt(rs.getString("InputID")),
                            inputDate,
                            Double.parseDouble(rs.getString("Inputprice")),
                            Integer.parseInt(rs.getString("Inputquantity")),
                            product,
                            user
                    );
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar entrada: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (rs != null) {
                    ps.close();
                }

                if (rs != null) {
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return input;

    }

}
