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

/**
 *
 * @author Tang Chun Xuan
 */
public class GetStudentDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //preparing response
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        //parameter passing
      String id=request.getParameter("id");  
      String ic=request.getParameter("ic"); 
      String name=request.getParameter("name"); 
      String level=request.getParameter("level"); 
      String programme=request.getParameter("programme"); 
      String yearStudy=request.getParameter("yearStudy"); 
      
      //create html that give response
      out.println("Student ID: <b>"+id+"</b><br>");
      out.println("IC Number: <b>"+ic+"</b><br>");
      out.println("Name: <b>"+name+"</b><br>");
      out.println("Level: <b>"+level+"</b><br>");
      out.println("Programme Code: <b>"+programme+"</b><br>");
      out.println("Year of Study: <b>"+yearStudy+"</b><br>");
      
       //close PrintWriter 
       out.close();
 
    }



}
