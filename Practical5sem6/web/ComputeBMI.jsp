<%-- 
    Document   : ComputeBMI
    Created on : 20 Mar 2023, 5:22:28 pm
    Author     : Tang Chun Xuan
--%>
<%@page import="model.BMI"  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BMI Calculation</title>
    </head>
<%--<jsp:useBean id="bmi1" class="BMI"/>--%>
    
    <body>
        <h1>BMI Calculation</h1>
        <% double height=Double.parseDouble(request.getParameter("height"));
         double weight=Double.parseDouble(request.getParameter("weight"));
         BMI bmi=new BMI(weight,height);
         
        %>
        Height:<%= height %>cm<br>
        Weight:<%= weight %>kg<br>
        BMI:<%= bmi.getBMI() %><br>
        Category:<%=bmi.getCategory() %>
    </body>
</html>
