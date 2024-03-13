/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import domain.Price;
/**
 *
 * @author Tang Chun Xuan
 */
public class Payment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("Hi<br>");
        String totalPrice=null;
        double TotalPrice=0;
        
        //get totalprice from cookie
        Cookie[] cookies=request.getCookies();
        for(Cookie cookieTotal:cookies){
            if(cookieTotal.getName().equals("cookiesTotalPrice")){
                totalPrice=cookieTotal.getValue();
            }
            
        }
        
       
        TotalPrice=Double.parseDouble(totalPrice);
        out.println(TotalPrice);
        out.println("<div>");
        if(TotalPrice<200){
            TotalPrice+=25;
            out.println("Since your order has not exceeded RM200,We will charge you extra RM25 for delivery charge");
        }
        else{
            out.println("Since your order has exceeded or equal to RM200,your delivery changes will be free");
        }
        
        
        try  {
            out.println("<h3>The total price for the products is shown below:</h3>");
            out.println("RM"+TotalPrice+" ");
            out.println("Do you want to pay using cash or credit card?If credit card,choose the button ");
            out.println("<br>");
            out.println("<a href=\"TryForward\">Credit Card Payment</a>");
            out.println("<a href=\"Cash\">Cash Payment</a>");
          
//            to show hidden field
//            out.println("<button onclick=\"myFunction()\">Click Me</button>");
            
        }
        catch(Exception ex){
            out.println("Error");
        }
        out.println("</div>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
