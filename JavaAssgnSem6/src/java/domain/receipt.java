/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;
import java.sql.*;
import java.time.LocalDate; // import the LocalDate class
import java.time.LocalDateTime; // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.io.Serializable;
import java.util.Objects;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Tang Chun Xuan
 */
public class receipt implements Serializable {
    private int transNum=1;
    private String custName;
    private String custAddress;
    private LocalDateTime myObj;
    private double total=0.0;
    
    public receipt(){
     transNum+=1;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getMyObj() {
        return myObj;
    }

    public void setMyObj(LocalDateTime myObj) {
        this.myObj = myObj;
    }
    
    public receipt(String custName,String custAddress){
        transNum+=1;
//        LocalDateTime myObj = LocalDateTime.now(); // Create a date object
//         DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//         String formattedDate = myObj.format(myFormatObj);
//        System.out.println(formattedDate); // Display the current date
        this.custName=custName;
        this.custAddress=custAddress;
    }
    
    

    public int getTransNum() {
        return transNum;
    }

    public void setTransNum(int transNum) {
        this.transNum = transNum;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    
}  

