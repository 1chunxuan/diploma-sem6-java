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
import javax.servlet.http.HttpSession;
import domain.Price;

/**
 *
 * @author Tang Chun Xuan
 */
public class CheckOut extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckOut</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOut at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        

        
        try{
        int carNum=Integer.parseInt(request.getParameter("car"));
        int doorNum=Integer.parseInt(request.getParameter("door"));
        int electronicNum=Integer.parseInt(request.getParameter("electronic"));
        int tableNum=Integer.parseInt(request.getParameter("table"));
        int chairNum=Integer.parseInt(request.getParameter("chair"));
        int puzzleNum=Integer.parseInt(request.getParameter("puzzle"));
        int bookNum=Integer.parseInt(request.getParameter("book"));
        int gameboyNum=Integer.parseInt(request.getParameter("gameboy"));
        int psNum=Integer.parseInt(request.getParameter("ps"));
        
        String cookieCar=Integer.toString(carNum);
        String cookieDoor=Integer.toString(doorNum);
        String cookieElectronic=Integer.toString(electronicNum);
        String cookieTable=Integer.toString(tableNum);
        String cookieChair=Integer.toString(chairNum);
        String cookiePuzzle=Integer.toString(puzzleNum);
        String cookieBook=Integer.toString(bookNum);
        String cookieGameboy=Integer.toString(gameboyNum);
        String cookiePs=Integer.toString(psNum);
        //create cookie
      Cookie cookie1=new Cookie("cookieCar",cookieCar);
      //add new cookie into response
      response.addCookie(cookie1);
      Cookie cookie2=new Cookie("cookieDoor",cookieDoor);
      response.addCookie(cookie2);
        
        double carPrice=carNum*5.0;
        double doorPrice=doorNum*5.0;
        double electronicPrice=electronicNum*5.0;
        double tablePrice=tableNum*10.0;
        double chairPrice=chairNum*10.0;
        double puzzlePrice=puzzleNum*10.0;
        double bookPrice=bookNum*15.0;
        double gameboyPrice=gameboyNum*15.0;
        double psPrice=psNum*15.0;
        double totalPrice=carPrice+doorPrice+electronicPrice+tablePrice+chairPrice+puzzlePrice+bookPrice+gameboyPrice+psPrice; 
        double dummy=0.0;
        dummy=totalPrice;
        String cookieTotalPrice=Double.toString(totalPrice);
        
                //create cookie
      Cookie cookieTotal=new Cookie("cookiesTotalPrice",cookieTotalPrice);
      //add new cookie into response
      response.addCookie(cookieTotal);
      
      if(totalPrice<200.0){
          totalPrice+=25;
      }else{
          totalPrice+=0;
      }
      
      Price price=new Price(totalPrice);
      HttpSession httpSession=request.getSession();
      httpSession.setAttribute("price",price);

        out.println("Total price of car toy: <b>"+carPrice+"</b><br>");
        out.println("Total price of door toy: <b>"+doorPrice+"</b><br>");
        out.println("Total price of electronic toy: <b>"+electronicPrice+"</b><br>");
        out.println("Total price of table toy: <b>"+tablePrice+"</b><br>");
        out.println("Total price of chair toy: <b>"+chairPrice+"</b><br>");
        out.println("Total price of puzzle toy: <b>"+puzzlePrice+"</b><br>");
        out.println("Total price of book toy: <b>"+bookPrice+"</b><br>");
        out.println("Total price of gameboy toy: <b>"+gameboyPrice+"</b><br>");
        out.println("Total price of ps toy: <b>"+psPrice+"</b><br>");
        out.println("total price is "+dummy);
        out.println("Do you want to continue to your payment?If yes,please click yes button below");
        
        out.println("<br>");
      out.println("<a href=\"Payment\">Click Here</a>");
        }catch(NumberFormatException ex){
            out.println("Please type 0 in the field even if you dont want order.Thank you");
        }
        
//close PrintWriter 
       out.close();
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
