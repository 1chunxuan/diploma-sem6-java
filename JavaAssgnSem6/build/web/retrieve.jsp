<%-- 
    Document   : retrieve
    Created on : 28 Apr 2023, 5:53:26 pm
    Author     : Tang Chun Xuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.receipt"%>
<%@page import="javax.sql.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="javax.servlet.*" %>
<%@page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retrieve sales</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%!receipt Receipt=new receipt();%>
        <%=Receipt.getTransNum() %>
        <%!receipt Receipt1=new receipt();%>   
        <%=Receipt1.getTransNum() %>
        <%!receipt Receipt2=new receipt();%>   
        <%=Receipt2.getTransNum() %>
        
    
        <%
            String transNum = request.getParameter("transNum");
            String host="jdbc:derby://localhost:1527/assignment";
            String password="nbuser";
            String tablename="Invoice";
            String user="nbuser";
            Connection conn=null;
            conn=DriverManager.getConnection(host,user,password);
            String sql="select * from "+tablename+" where transNum=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, transNum);
            ResultSet rs=stmt.executeQuery();
            out.println("<h1>The transaction number is "+transNum+"</h1>");
            while(rs.next()){
            String ename=rs.getString("custName");
            String spent=rs.getString("totalPrice");
            String adt=rs.getString("Address");
               out.println("<h1>The customer name is "+ename +" and he spent " +spent+" address is "+adt +"</h1><br>");
            }
            
        %>
    </body>
</html>
