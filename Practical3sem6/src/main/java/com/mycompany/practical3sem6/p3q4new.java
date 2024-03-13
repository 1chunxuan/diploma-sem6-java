/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical3sem6;

/**
 *
 * @author Tang Chun Xuan
 */
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

/**
 *
 * @author chanw
 */
public class p3q4new extends JFrame {
    private JPanel upperPanel = new JPanel(new GridLayout(2,2));
    private JPasswordField passwordTextField = new JPasswordField();
    private JButton submitButton  = new JButton ("Submit");
    private JTextArea outputTextArea= new JTextArea();
    
    public p3q4new() {
        upperPanel.add(new JLabel("Enter your password"));
        upperPanel.add(passwordTextField);
        upperPanel.add(new JLabel());
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    Password pw = new Password(passwordTextField.getText());
                    outputTextArea.setForeground(Color.BLUE);
                    outputTextArea.setText("Congratulation! Your password is valid");
                }catch(InvalidPasswordException ex){
                    outputTextArea.setForeground(Color.RED);
                    outputTextArea.setText(ex.getMessage());
                }
            }
        });
    
        upperPanel.add(submitButton);
        this.add(upperPanel, BorderLayout.NORTH);
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setEditable(false);
        this.add(outputTextArea, BorderLayout.CENTER);
        
        setTitle("Set Password");
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new p3q4new();
    }
    
}
