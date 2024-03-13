/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical1sem6;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.*;

/**
 *
 * @author Tang Chun Xuan
 */
public class OneFrame extends JFrame{
     private JButton jbtHello=new JButton("Hello");
     
     public OneFrame(){
           add(jbtHello);
           setTitle("OneFrame");
//           jbtHello.setTitle("OneFrame");
           setSize(500,600);
           setLocationRelativeTo(null);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setVisible(true);
       }
     
     public static void main(String args[]){
         new OneFrame();
     }
}
