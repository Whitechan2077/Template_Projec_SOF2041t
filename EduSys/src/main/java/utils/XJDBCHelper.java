/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author buidu
 */
public class XJDBCHelper {
    private static final String connectionUrl =
    "jdbc:sqlserver://localhost:1433;databaseName=EduSys;user=sa;password=06122004;encrypt=true;trustServerCertificate=true";
    static{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XJDBCHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static PreparedStatement getPreparedStatement(String sql,Object ... agrs) throws SQLException{
        Connection connection = DriverManager.getConnection(connectionUrl);
        PreparedStatement pstm = null;
        if (sql.trim().startsWith("{")) {
            pstm = connection.prepareCall(sql);
        }
        else{
            pstm = connection.prepareStatement(sql);
        }
        for (int i = 0; i < agrs.length; i++) {
            pstm.setObject(i+1,agrs[i] );
        }
        return pstm;
    }
    public static int update(String sql , Object ... agrs){
        try {
            PreparedStatement ps = getPreparedStatement(sql, agrs);
            try {
                return ps.executeUpdate();
            } finally{
                ps.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static ResultSet query(String sql, Object ... agrs){
        try {
            PreparedStatement ps = getPreparedStatement(sql, agrs);
            return ps.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static Object value(String sql, Object ... agrs){
        try {
            ResultSet rs = query(sql, agrs);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }
}
