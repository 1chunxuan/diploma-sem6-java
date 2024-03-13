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
import domain.Loan;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tang Chun Xuan
 */
public class ComputeLoanPayment extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        String amount=request.getParameter("amount");
        String interest=request.getParameter("Interest");
        String years=request.getParameter("years");
        
        if(amount.length()==0){
            out.println("Loan amount required");
        }
        else{
            double loanAmount=Double.parseDouble(amount);
            double interestRate=Double.parseDouble(interest);
            int numberOfYears=Integer.parseInt(years);
            
            Loan loan=new Loan(loanAmount,interestRate,numberOfYears);
            
            //define/get httpsession
            HttpSession httpSession=request.getSession();
            //store loan object into session
            httpSession.setAttribute("loan",loan);
            httpSession.setAttribute("numYear",numberOfYears);
            
            out.println("You entered the following data<br>");
            out.println("Loan Amount:"+loanAmount);
            out.println("<br>Annual Interest Value:"+interestRate);
            out.println("<br>Number Of Years:"+numberOfYears);
            
            //create post form
            out.println("<form method=\"post\" action=\"ComputeLoanPayment\">");
            out.println("<input type=\"submit\" value=\"Confirm\">");
            out.println("</form>");
            out.close();
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        HttpSession httpSession=request.getSession();
        Loan loan=(Loan)(httpSession.getAttribute("loan"));
//        NumYear numYear=(httpSession.getAttribute("numYear"));
        
        out.println("Loan Amount:"+loan.getLoanAmount());
        out.println("Annual Interest Rate:"+loan.getInterestRate());
        out.println("Number of Years:"+loan.getNumberOfYear());
        out.println("Monthly Payment:"+loan.getMonthlyPayment());
        out.println("Total Payment:"+loan.getTotalPayment());
        out.close();
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
