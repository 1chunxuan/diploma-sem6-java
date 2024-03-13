/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.receipt;
import java.time.LocalDate; // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.time.LocalDateTime;
/**
 *
 * @author Tang Chun Xuan
 */
public class CreditCard extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        int transNum=0;
        int total=0;
        LocalDateTime myObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myObj.format(myFormatObj);
        try{
            out.println(formattedDate);
            String name=request.getParameter("name");
            String creditCardNum=request.getParameter("name");
            String address=request.getParameter("address");
            receipt Receipt=new receipt(name,address);
            if(name!=""&&creditCardNum!=""&&address!=""){
                transNum+=1;
                total=transNum;
            }else{
                out.println("Please dont leave the fields blank.thank you.");
            }
            out.println(Receipt.getTransNum());
            out.println("HI<br>");
            out.println("Thank you for your payment<br>");
            out.println("Your transaction Number is "+transNum);
            
            
        }catch(Exception ex){
            out.println(ex);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
