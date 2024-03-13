<%-- 
    Document   : insert
    Created on : 30 Apr 2023, 3:54:31 pm
    Author     : Tang Chun Xuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.receipt"%>
<%@page import="javax.sql.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="javax.servlet.*" %>
<%@page import="javax.servlet.http.*" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@page import ="java.time.LocalDateTime"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="domain.Price"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank you for Your Patronage!</title>
    </head>
    <body>
        <h1>Thank you for your purchase!</h1>
        
        <%!int num=0;
        int transNum=0;
        String transParse;
        double totalPrice=0.0;
        String transTotal;
        String sevenDays;
        int nowMonth=0;
        int nowYear=0;
        int check=0;
        %>
        
        <%HttpSession httpSession=request.getSession();%>
        <%Price price=(Price)(httpSession.getAttribute("price"));%>

        <%sevenDays=(String) httpSession.getAttribute("SevenDays");%>
        <% //nowMonth=(int) httpSession.getAttribute("nowMonth");%>
        <% //nowYear=(int) httpSession.getAttribute("nowYear");%>
        <% //httpSession.setAttribute("Status","invalid");%>
        
        <%
            out.println("Your purchase total price is RM"+price.getPrice());
            PreparedStatement stmt=null;
            ResultSet rs=null;
            ResultSet rs1=null;
            String host="jdbc:derby://localhost:1527/assignment";
            String password="nbuser";
            String tablename="Invoice";
            String user="nbuser";
            Connection conn=null;
            String custName=request.getParameter("custName");
            String address=request.getParameter("address");
            int expireMon=Integer.parseInt(request.getParameter("expireMon"));
            int expireYear=Integer.parseInt(request.getParameter("expireYear"));
            
//            if(expireMon>nowMonth||expireYear>nowYear){
//                check=0;
//                httpSession.setAttribute("Status",check);
//            }
            conn=DriverManager.getConnection(host,user,password);
            String selectSql="Select * from "+tablename;
            stmt=conn.prepareStatement(selectSql);
//            stmt.setString(1, transNum);
            rs=stmt.executeQuery();
            while(rs.next()){
               num+=1;
            }
            out.println("<br>The total number of record is "+num);
        %>    
            <%transNum=num;%>
            <%transParse=Integer.toString(transNum);%>
            
        <%    
//            totalPrice=price.getPrice();
//            if(totalPrice<200){
//             totalPrice+=25;
//            }
//            else{
//            totalPrice+=0;
//            }
            transTotal=Double.toString(totalPrice);
            String sql="INSERT into "+tablename+" VALUES(?,?,?,?)"; 
            stmt=conn.prepareStatement(sql);
            stmt.setInt(1, transNum);
            stmt.setString(2, custName);
            stmt.setDouble(3, totalPrice);
            stmt.setString(4, address);
            stmt.executeUpdate();
            
              out.println("<br>Thank you for your patronage<br>");
              out.println("Your order has been submitted successfully,your transaction number is "+num);
              out.println("<br>Your product will be arriving to you at this date: "+sevenDays);
            
        %>
        <br>
        <br>
        <a href="productstatus.jsp">check product status</a>
    </body>
</html>
