/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hebod
 */
public class TblMode {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void getReg() throws SQLException {
        try {
            conn = Conexion.getConnection();
            String tSQL = "Select * from [xProject].[dbo].[ColorIdentifier]";
            ps = conn.prepareStatement(tSQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                    + ResultSet.HOLD_CURSORS_OVER_COMMIT
            );
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al obtener colores" + ex.getMessage());

        }
    }
    
    public int identifier() {
        int identifier = 0;
        try {
            this.getReg();
            while (rs.next()) {
                identifier = rs.getInt("ColorID");
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
        return identifier;
    }
    
    public boolean changeMode(int mode){
        boolean result = false;
        try {
            this.getReg();
            rs.beforeFirst();
            while (rs.next()) {
                    rs.updateInt("ColorID", mode);
                    rs.updateRow();
                    result = true;
                    return result;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al cambiar el color: " + ex.getMessage());
        } finally {

            
        }
        return result;
    }
}
