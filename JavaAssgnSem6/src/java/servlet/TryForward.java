/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
import java.util.Date;
/**
 *
 * @author Tang Chun Xuan
 */
public class TryForward extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
         LocalDate currentdate = LocalDate.now();
//         Calender.get(Calender.MONTH);
        LocalDateTime now = LocalDateTime.now();
//        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        // Add 7 days to the current date and time
     LocalDateTime sevenDaysLater = now.plusDays(7);
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String nowString = now.format(formatter);
    String sevenDaysLaterString = sevenDaysLater.format(formatter);
    int currentDay = currentdate.getDayOfMonth();
//    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM");
//    String month = now.format(formatter1).toString();
//    int numMonth=Integer.parseInt(month);
//     DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy");     
//     String year = now.format(formatter2).toString();
//     int numYear=Integer.parseInt(year);
     
     
        // Set the LocalDateTime object as an attribute of the request object
      request.setAttribute("currentDateTime", nowString);
//      request.setAttribute("sevenDaysLater", sevenDaysLaterString);
        HttpSession httpSession1=request.getSession();
        httpSession1.setAttribute("SevenDays",sevenDaysLaterString);
        httpSession1.setAttribute("CurrentDay",currentDay);
//        httpSession1.setAttribute("nowMonth",numMonth);
//        httpSession1.setAttribute("nowYear",numYear);
        
        
      
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Credit.jsp");
    dispatcher.forward(request, response);
//          RequestDispatcher dispatcher1 = request.getRequestDispatcher("/insert.jsp");
//      dispatcher1.forward(request, response);
    
    out.println("<br>");
            out.println("<a href=\"Credit.jsp\">Credit Card Form</a>");
       

        

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
