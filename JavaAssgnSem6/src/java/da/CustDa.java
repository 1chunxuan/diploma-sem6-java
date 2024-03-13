/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package da;
import java.sql.*;
/**
 *
 * @author Tang Chun Xuan
 */
public class CustDa {
    private Connection conn;
    private String host="jdbc:derby://localhost:1527/assignment";
    private String tablename="invoice";
    private String user="nbuser";
    private String password="nbuser";
    private PreparedStatement stmt;
    
    public CustDa(){
        createConnection();
        
    }
    
    public ResultSet selectRecord(String code) {
        String queryStr = "SELECT * FROM " + tablename + " WHERE Code = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
        
        }
        return rs;
    }
    
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            System.out.println("not connected");
        }
    }
}
