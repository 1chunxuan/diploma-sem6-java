<%-- 
    Document   : login
    Created on : 6 May 2023, 4:00:49 pm
    Author     : Tang Chun Xuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
    </head>
    <body>
        <h1>login</h1>
        <form action="j_security_check" method="post">
            username:<input type="text" name="j_username">
            password:<input type="password" name="j_password">
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
