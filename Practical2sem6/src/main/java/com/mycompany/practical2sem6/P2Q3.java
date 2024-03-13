/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practical2sem6;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Tang Chun Xuan
 */
public class P2Q3 extends JFrame{

    private JPanel panelColour=new JPanel();
    private JLabel colorLabel=new JLabel("Colour");
    
    private JPanel panelButton=new JPanel();
    private JButton button1=new JButton("Red");
    private JButton button2=new JButton("Green");
    private JButton button3=new JButton("Blue");
    
    public P2Q3(){
        colorLabel.setFont(new Font("Arial",Font.BOLD,22));
        colorLabel.setHorizontalAlignment(JLabel.CENTER);
        
        //either first 2 line or single line below to choose ,same effect
        panelColour.add(colorLabel);
        add(panelColour,BorderLayout.NORTH);
        
        //        add(colorLabel,BorderLayout.NORTH);
       
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                colorLabel.setForeground(Color.red);
            }
            
        });
        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                colorLabel.setForeground(Color.green);
            }
            
        });
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                colorLabel.setForeground(Color.blue);
            }
            
        });
        panelButton.add(button1);
        panelButton.add(button2);
        panelButton.add(button3);
        add(panelButton,BorderLayout.SOUTH);

        setTitle("Primary Colors");
        setSize(300,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new P2Q3();
    }
    
    
//    private class redButtonListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            colorLabel.setForeground(Color.red);
//        }
//    }
//    
//    private class greenButtonListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            colorLabel.setForeground(Color.green);
//        }
//    }
//    
//    private class blueButtonListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            colorLabel.setForeground(Color.blue);
//        }
//    }
}

