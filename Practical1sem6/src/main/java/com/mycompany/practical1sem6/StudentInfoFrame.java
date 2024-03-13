/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical1sem6;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

/**
 *
 * @author Tang Chun Xuan
 */
public class StudentInfoFrame extends JFrame{
            JPanel panel1=new JPanel();
  
            
    private JFrame frame1=new JFrame();
    private JButton button=new JButton("submit");
    private JLabel label1=new JLabel("registration number:");
    private JTextField tx1=new JTextField("2222222");
    private JLabel label2=new JLabel("name:");
    private JTextField tx2=new JTextField("aaaaaa");
    private JLabel label3=new JLabel("programme code:");
    private JTextField tx3=new JTextField("wwww");
    
    JPanel panel2=new JPanel();
    
    public StudentInfoFrame(){

        panel1.setLayout(new FlowLayout());
         panel1.add(label1);
           panel1.add(tx1);     
           panel1.add(label2);
           panel1.add(tx2);
           panel1.add(label3);
           panel1.add(tx3);
           add(panel1);
           panel2.setLayout(new BorderLayout());
           panel2.add(button);
           add(panel2,BorderLayout.SOUTH);
        setTitle("Student Information");      
        setSize(500,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
          
           
        
    }
    public static void main(String[] args){
        new StudentInfoFrame();
        
    }
}
