<%-- 
    Document   : Credit
    Created on : 25 Apr 2023, 4:11:11 pm
    Author     : Tang Chun Xuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Credit Card Payment</title>
    </head>
    <body>
        <%!int currentDay=0;%>
        <%HttpSession httpSession=request.getSession();%>
        <p>Today date and time is: <%=request.getAttribute("currentDateTime")%></p>
        <p id="demo">HI</p>
        <p id="demo2">HI</p>
        
<!--        CreditCard-->
        <form action="insert.jsp" method="get" style="border:1px black solid;margin:auto" onsubmit="return validateForm()" name="myForm">
        Your name:<input type="text" name="custName" value="" required><br><br>
        Your Credit card Number(just type the number):<input type="text" name="CreditCardNum" value="" required maxlength=""16><br><br>
        <strong>In this form,January is 0 and December will be 11 in our month.Please be aware.</strong><br><br>
        
        Credit card expiration month:<input type="text" name="expireMon" value="" required><br><br>
        Credit card expiration Year:<input type="text" name="expireYear" value="" required><br><br>
        CVV or security code:<input type="text" name="securityCode" value="" required maxlength="3"><br><br>
        Your address:<input type="text" name="address" value="" required><br><br>
         <input type="submit" value="submit">
         <input type="reset" value="reset">
        </form>

     <script>
               let re = /^[\w ]+$/;
              const d = new Date();
              let month = d.getMonth();
                document.getElementById("demo").innerHTML = month;
                const d1 = new Date();
                let year = d1.getFullYear();
                document.getElementById("demo2").innerHTML = year;
		function validateForm() {
			var x = document.forms["myForm"]["expireMon"].value;
                        var y = document.forms["myForm"]["expireYear"].value; 
                        var z = document.forms["myForm"]["CreditCardNum"].value; 
			if ( x <month||y<year) {
				alert("Your credit card expired!");
				return false;
			}
                        if(!re.test(z)){
                            alert("Your credit card number should only has number!");
                            return false;
                        }
		}
	</script>
        
        <h3>Your order will be shipped to the location you entered in 1 week after you payment.</h3>
    </body>
</html>
