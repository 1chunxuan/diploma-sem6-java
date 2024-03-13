/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testing;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Tang Chun Xuan
 */
public class Testing extends JFrame{
    
    private String host="jdbc:derby://localhost:1527/testing [nbuser on NBUSER]";
    private String name="nbuser";
    private String password="nbuser";
    private String tablename="student";
    private Connection conn;
    private PreparedStatement stmt;
 
    private JTextField tx1=new JTextField(8);
    private JTextField tx2=new JTextField(8);
    private JButton add=new JButton("add student");
    private JButton retrieve=new JButton("retrieve student");
    private JButton update=new JButton("update student");
    private JButton delete=new JButton("delete student");
    
    
    public Testing(){
        JPanel topPane=new JPanel(new GridLayout(3,2));
        topPane.add(new JLabel ("id"));
        topPane.add(tx1);
        topPane.add(new JLabel ("name"));
        topPane.add(tx2);
        add(topPane);
        
        add.addActionListener(new buttonListener());
        retrieve.addActionListener(new buttonListener());
        update.addActionListener(new buttonListener());
        delete.addActionListener(new buttonListener()); 
        
        JPanel bottomPane=new JPanel(new FlowLayout());
        bottomPane.add(add);
        bottomPane.add(retrieve);
        bottomPane.add(update);
        bottomPane.add(delete);
        add(bottomPane);
        
       
           
        setTitle("Testing");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public ResultSet selectRecord(String id){
        String queryStr="SELECT * FROM "+tablename+"WHERE ID =?";
        ResultSet rs=null;
        try{
            stmt=conn.prepareStatement(queryStr);
            stmt.setString(1,id);
            
            rs=stmt.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    private class buttonListener implements ActionListener{

          @Override
        public void actionPerformed(ActionEvent e) {
            String id=tx1.getText();
            ResultSet rs=selectRecord(id);
            if(e.getSource()==add){
                try{
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "This programme code already exists.", "DUPLICATE RECORD", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                    String insertStr="INSERT INTO TABLE"+tablename+"VALUES(?,?)";
                    stmt=conn.prepareStatement(insertStr);
                    stmt.setString(1, id);
                    stmt.setString(2,tx2.getText());
                    
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "New Student added.");
                    clearText();

                    }
                }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
              }
            }else if(e.getSource()==retrieve){
                try{
                    if(rs.next()){
                        tx2.setText(name);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }else if(e.getSource()==update){
              try{
                  if(rs.next()){
                      String name=tx2.getText();
                      String updateStr="UPDATE "+tablename+"SET NAME =? WHERE ID=?";
                      stmt=conn.prepareStatement(updateStr);
                      stmt.setString(1,name);
                      stmt.executeUpdate();
                      JOptionPane.showMessageDialog(null, "Record updated.");
                      clearText();
                  }
              }catch(SQLException ex){
                  
              }
            }
        }
            
    }
    
    private void clearText(){
        tx1.setText("");
        tx2.setText("");
        
    }
    
    private void CreateConnection(){
       try{
         conn=DriverManager.getConnection(host,name,password);
         JOptionPane.showMessageDialog(null, "connected");
       }catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
       }
    }
    
    private void shutDown(){
        if(conn!=null){
            try{
                conn.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
    public static void main(String[] args) {
        new Testing();
    }
}
