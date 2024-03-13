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
public class P2Q2_AnonymousInnerClass extends JFrame{

    private JPanel panelColour=new JPanel();
    private JLabel colorLabel=new JLabel("Colour");
    
    private JPanel panelButton=new JPanel();
    private JButton button1=new JButton("Red");
    private JButton button2=new JButton("Green");
    private JButton button3=new JButton("Blue");
    
    public P2Q2_AnonymousInnerClass(){
        colorLabel.setFont(new Font("Arial",Font.BOLD,22));
        colorLabel.setHorizontalAlignment(JLabel.CENTER);
        
        //either first 2 line or single line below to choose ,same effect
        panelColour.add(colorLabel);
        add(panelColour,BorderLayout.NORTH);
        
        //        add(colorLabel,BorderLayout.NORTH);
        
        //use ButtonListener listener=new ButtonListener(); and use listener to replace new ButtonListener()
       
        button1.addActionListener(new ButtonListener());
        button2.addActionListener(new ButtonListener());
        button3.addActionListener(new ButtonListener());
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
        new P2Q2_AnonymousInnerClass();
    }
    
    
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1){
                colorLabel.setForeground(Color.red);
            }
            else if(e.getSource()==button2){
                colorLabel.setForeground(Color.green);
            }
            else if(e.getSource()==button3){
                colorLabel.setForeground(Color.blue);
            }
            
            colorLabel.setForeground(Color.red);
        }
    }
    
}

