/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import models.Output;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import models.Product;
import models.User;

/**
 *
 * @author Administrador
 */
public class TblOutput {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void getReg() throws SQLException {
        try {
            conn = Conexion.getConnection();
            String tSQL = "Select * from [xProject].[dbo].[Output]";
            ps = conn.prepareStatement(tSQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                    + ResultSet.HOLD_CURSORS_OVER_COMMIT
            );
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener salidas" + ex.getMessage());
        }
    }

    public ArrayList<Output> outputList() {
        ArrayList<Output> list = new ArrayList<>();
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
                list.add(new Output(
                        Integer.parseInt(rs.getString("OutputID")),
                        rs.getString("Outputdate"),
                        rs.getDouble("Outputprice"),
                        rs.getInt("Outputquantity"),
                        product,
                        user
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar las salidas" + ex.getMessage());
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

    public boolean addOutput(Output output) {
        boolean saved = false;
        try {
            this.getReg();
            rs.moveToInsertRow();
            rs.updateString("Outputdate", output.getOutputDate());
            rs.updateDouble("Outputprice", output.getOutputPrice());
            rs.updateInt("Outputquantity", output.getOutputQuantity());
            rs.updateString("ProductID", String.valueOf(output.getM_Product().getIdProduct()));
            rs.updateString("UserID", String.valueOf(output.getM_User().getIdUser()));
            rs.insertRow();
            rs.moveToCurrentRow();
            saved = true;

        } catch (SQLException ex) {
            System.out.println("Error al guardar la salida" + ex.getMessage());
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

    public boolean existOuput(int idOutput) {
        boolean result = false;
        try {
            this.getReg();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("OutputID")) == idOutput) {
                    result = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar la salida: " + ex.getMessage());
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

    public boolean removeOutput(int idOutput) {
        boolean result = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                if (Integer.parseInt(rs.getString("OutputID")) == idOutput) {
                    rs.deleteRow();
                    result = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar la salida: " + ex.getMessage());
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

    public Output getOutput(int idOutput)  {
        Output output = new Output();
        TblProduct products = new TblProduct();
        Product product;
        TblUser users = new TblUser();
        User user;
        try {
            this.getReg();
            while (rs.next()) {  
                int idProduct = Integer.parseInt(rs.getString("ProductID"));
                product = products.getProductByID(idProduct);
                String username = rs.getString("Username");
                if (Integer.parseInt(rs.getString("OutputID")) == idOutput) {
                    user = users.getUser(username);
                    output = new Output(
                            Integer.parseInt(rs.getString("OutputID")),
                            rs.getString("Outputdate"),
                            Double.parseDouble(rs.getString("Outputprice")),
                            Integer.parseInt(rs.getString("Outputquantity")),
                            product,
                            user
                    );
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar salida: " + ex.getMessage());
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
        return output;
    }
}
