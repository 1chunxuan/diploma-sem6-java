/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical1sem6;
import javax.swing.*;
import java.awt.FlowLayout;
/**
 *
 * @author Tang Chun Xuan
 */
public class P1Q5 extends JFrame{
    
    private JPanel panel1=new JPanel();
    private JButton bt1=new JButton("bt1");
    private JButton bt2=new JButton("bt2");
    
    private JPanel panel2=new JPanel();
    private JButton bt3=new JButton("bt3");
    private JButton bt4=new JButton("bt4");
    
    public P1Q5(){
        setLayout(new FlowLayout());
        panel1.setLayout(new FlowLayout());
        panel1.add(bt1);
        panel1.add(bt2);
        add(panel1);
        panel2.setLayout(new FlowLayout());
        panel2.add(bt3);
        panel2.add(bt4);
        add(panel2);
        setTitle("2 panels");
         setSize(500, 500);
         setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
    }
    public static void main(String[] args){
        new P1Q5();
    }
}
