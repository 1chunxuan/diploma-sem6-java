/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

/**
 *
 * @author Tang Chun Xuan
 */
public class Mavenproject2 extends JFrame{
   private JPanel panel1=new JPanel();
    private JLabel label1=new JLabel("number 1");
    private JTextField tx1=new JTextField();
    private JLabel label2=new JLabel("number 2");
    private JTextField tx2=new JTextField();
    private JLabel label3=new JLabel("result");
    private JTextField tx3=new JTextField();
            
    private JPanel panel2=new JPanel();
    private JButton add=new JButton("add");
    private JButton subtract=new JButton("subtract");
    private JButton multiple=new JButton("multiple");
    private JButton divide=new JButton("divide");
    private JPanel panel3=new JPanel();
    
    public Mavenproject2(){
        panel3.setLayout(new BorderLayout());
        
        panel1.setLayout(new GridLayout(3,2));
        panel1.add(label1);
        panel1.add(tx1);
        panel1.add(label2);
        panel1.add(tx2);
        panel1.add(label3);
        panel1.add(tx3);
        add(panel1);
        
        tx3.setEditable(false);
        
        add.addActionListener(new ButtonListener());
        subtract.addActionListener(new ButtonListener());
        multiple.addActionListener(new ButtonListener());
        divide.addActionListener(new ButtonListener());
        
        panel2.setLayout(new FlowLayout());
        panel2.add(add);
        panel2.add(subtract);
        panel2.add(multiple);
        panel2.add(divide);
        panel3.add(panel2);
        add(panel3,BorderLayout.SOUTH);
        setTitle("Calculator");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new Mavenproject2();
    }
    
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            double firstVal;
            double secondVal;
            double result=0;
            String result1="";
            
            try{
            firstVal=Double.parseDouble(tx1.getText());
            secondVal=Double.parseDouble(tx2.getText());
            
            if(e.getSource()==add){
                result=firstVal+secondVal;
            }
            else if(e.getSource()==subtract){
                result=firstVal-secondVal;
            }
            else if(e.getSource()==multiple){
                result=firstVal*secondVal;
            }
            else if(e.getSource()==divide){
                result=firstVal/secondVal;
            }
            result1=Double.toString(result);  
//            tx3.setText(result+"");       to use this line or upper line
            tx3.setText(result1);
            }catch(NumberFormatException ex){
                tx3.setText("Please enter only integer!");
            }
            
            
        }
        
    }
 

}
