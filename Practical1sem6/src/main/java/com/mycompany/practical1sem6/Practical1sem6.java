/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practical1sem6;

import javax.swing.JOptionPane;


//q2
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 *
 * @author Tang Chun Xuan
 */
public class Practical1sem6 extends JFrame{
      //q2
      
       
       
    
    public static void main(String[] args) {
         //q1
        int option=JOptionPane.YES_OPTION;
        do{
            String inputStr=JOptionPane.showInputDialog(null,"Enter a temperature in Fahrenheit.");
            double fahrenheit=Double.parseDouble(inputStr);
            double celsius=5.0/9.0*(fahrenheit-32);
            JOptionPane.showMessageDialog(null, "Temperature converted to Celsius is "+celsius);
            
            option=JOptionPane.showConfirmDialog(null,"Enter another temperature?");
            
        }while(option==JOptionPane.YES_OPTION);
        
        
        
    }
}


//q2
