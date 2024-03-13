<%-- 
    Document   : updateStud
    Created on : 28 Apr 2023, 6:46:20 pm
    Author     : Tang Chun Xuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.sql.*" %>
<%@page import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page import="javax.servlet.*" %>
<%@page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String id = request.getParameter("id");
            String host="jdbc:derby://localhost:1527/collegedb";
            String password="1234";
            String tablename="Student";
            String user="nbuser";
            Connection conn=null;
            conn=DriverManager.getConnection(host,user,password);
            String sql="select * from "+tablename+" where id=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
             stmt.setString(1, id);
            ResultSet rs=stmt.executeQuery();
            out.println("<h1>"+id+"</h1>");
            while(rs.next()){
            String ename=rs.getString("name");
            String ic=rs.getString("ic");
               out.println("<h1>"+ename +" " +ic+"</h1><br>");
            }
            
        %>
    </body>
</html>
