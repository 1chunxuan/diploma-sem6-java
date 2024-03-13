/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical3sem6;

/**
 *
 * @author chanw
 */
public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("Involid Password Exception.");
    }

    public InvalidPasswordException(String message) {
        super(message);
    }
    
}