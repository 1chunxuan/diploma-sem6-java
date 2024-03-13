/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical3sem6;

/**
 *
 * @author chanw
 */
public class Password {
    private String passwordStr;
    public Password(String passwordStr) throws InvalidPasswordException {
        if (passwordStr == null || passwordStr.equals("")){
            throw new InvalidPasswordException("Invalid Password. Password cannot be empty");
        }else{
            int digitCount = 0, letterCount = 0;
            
            for(int i = 0; i < passwordStr.length(); i++){
                char ch = passwordStr.charAt(i);
                
                if(Character.isDigit(ch))
                    digitCount++;
                else if(Character.isLetter(ch))
                    letterCount++;
            }
            
            int totalAlphaNumeric = digitCount + letterCount;
            String errorMsg = "";
            
            if(digitCount == 0){
                errorMsg += "Your password should have at least 1 digit";
            }
            
            if(letterCount == 0){
                errorMsg += "Your password should have at least 1 letter";
            }
            
            if(totalAlphaNumeric < 7){
                errorMsg += "Your password should have at least 7 alpha numeric";
            }
            
            if(!errorMsg.equals("")){
                throw new InvalidPasswordException(errorMsg);
            }
        }
        this.passwordStr = passwordStr;
    }
}