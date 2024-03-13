/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical2sem6;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;
/**
 *
 * @author Tang Chun Xuan
 */
public class P2Q4 extends JFrame{
    public static ArrayList<String> studentList = new ArrayList<>();
    public static String inputStr;
    private JPanel panel1=new JPanel();
    private JButton create=new JButton("Create");
    private JButton retrieve=new JButton("Retrieve");
    private JButton update=new JButton("Update");
    private JButton delete=new JButton("Delete");
    
    public P2Q4(){
        
        create.addActionListener(new Listener());
        retrieve.addActionListener(new Listener());
        update.addActionListener(new Listener());
        delete.addActionListener(new Listener());
        
        panel1.setLayout(new FlowLayout());
        panel1.add(create);
        panel1.add(retrieve);
        panel1.add(update);
       panel1. add(delete);
       add(panel1);
        setTitle("Primary Colors");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new P2Q4();
    }
    
    private class Listener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            inputStr=JOptionPane.showInputDialog(null,"Enter new students name.");
            if(e.getSource()==create){
                studentList.add(inputStr);
            }
            else if(e.getSource()==retrieve){
                JOptionPane.showMessageDialog(null, studentList);
                for (String a:studentList){
                    
                }
            }
            else if(e.getSource()==delete){
                inputStr=JOptionPane.showInputDialog(null,"Enter students name.");
                
                for (String a:studentList){
                    if(inputStr==a){
                        
                    }
                }
            }
            else if(e.getSource()==update){
                inputStr=JOptionPane.showInputDialog(null,"Enter students name.");
                
                for (String a:studentList){
                    if(inputStr==a){
                        a=inputStr;
                    }
                }
            }
            
        }
    }
   
}
