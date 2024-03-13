/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical1sem6;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
/**
 *
 * @author Tang Chun Xuan
 */
public class studentinfoFrameGrid extends JFrame{
    private JPanel panel1=new JPanel();
    private JLabel label1=new JLabel("Registration number");
    private JTextField tx1=new JTextField(8);
    private JLabel label2=new JLabel("Name");
    private JTextField tx2=new JTextField(20);
    private JLabel label3=new JLabel("Programme Code");
    private JTextField tx3=new JTextField(3);
    private JButton bt1=new JButton("Submit");
    private JPanel panel2=new JPanel();
    
    public studentinfoFrameGrid(){
        
        panel1.setLayout(new GridLayout(3,3));
        panel1.add(label1);
        panel1.add(tx1);
        panel1.add(label2);
        panel1.add(tx2);
        panel1.add(label3);
        panel1.add(tx3);
        add(panel1);
        panel2.setLayout(new BorderLayout());
        panel2.add(bt1);
        add(panel2,BorderLayout.SOUTH);
        
        setTitle("Student info frame");
         setSize(500, 500);
         setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
    }
    
    public static void main(String[] args){
        new studentinfoFrameGrid();
;        
    }
}
