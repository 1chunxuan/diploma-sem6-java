<%-- 
    Document   : factorialTable
    Created on : 20 Mar 2023, 4:17:07 pm
    Author     : Tang Chun Xuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Factorial table</title>
    </head>
    <body>
        <h1>Factorial Table</h1>
        <table>
            <th>Number</th>
            <th>Factorial</th>
            <%! int result=1; %>
            <% for(int i=1;i<10;i++) {
                result *=i;
            %>
            <tr>
                <td><%= i %></td>
                <td><%= result %></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
