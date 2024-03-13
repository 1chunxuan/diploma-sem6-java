<%-- 
    Document   : retrieveForm
    Created on : 29 Apr 2023, 6:26:50 pm
    Author     : Tang Chun Xuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="retrieve.jsp" style="border:1px solid black">
            Enter the transaction number to retrieve sales:<input type="text" name="transNum" value=""><br>
            <input type="submit" value="retrieve">
         <input type="reset" value="reset">
        </form>
        

    </body>
</html>
