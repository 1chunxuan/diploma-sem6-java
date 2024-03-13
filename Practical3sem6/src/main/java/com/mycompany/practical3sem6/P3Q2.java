/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical3sem6;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.Random;   

/**
 *
 * @author Tang Chun Xuan
 */
public class P3Q2 extends JFrame{
     private JPanel panel1=new JPanel();
    private JLabel label1=new JLabel("Array Index");
    private JTextField tx1=new JTextField();
    private JLabel label2=new JLabel("Array Element");
    private JTextField tx2=new JTextField();
            
    private JPanel panel2=new JPanel();
    private JButton add=new JButton("Show Element");
    private JPanel panel3=new JPanel();
    public static int[] numList=new int[100];
    public static Random random = new Random();  
    
    public P3Q2(){
        panel3.setLayout(new BorderLayout());
        
        panel1.setLayout(new GridLayout(3,2));
        panel1.add(label1);
        panel1.add(tx1);
        panel1.add(label2);
        panel1.add(tx2);
        add(panel1);
        
        tx2.setEditable(false);
        
        add.addActionListener(new ButtonListener());
        
        panel2.setLayout(new FlowLayout());
        panel2.add(add);
        panel3.add(panel2);
        add(panel3,BorderLayout.SOUTH);
        setTitle("Display: Show Bounds error");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        for(int i=0;i<100;i++){
            numList[i]=random.nextInt(1000);   
        }
        new P3Q2();
    }
    
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer firstVal;
            Integer result=0;
            String result1="";
            
            try{
            firstVal=Integer.parseInt(tx1.getText());
            
            if(e.getSource()==add){
                result=numList[firstVal];
            }
            
            result1=Integer.toString(result);  
//            tx3.setText(result+"");       to use this line or upper line
            tx2.setText(result1);
            }catch(ArrayIndexOutOfBoundsException ex){
                tx2.setText("Out of Bound!");
            }
            
            
        }
        
    }
}
