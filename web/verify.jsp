<%-- 
    Document   : verify
    Created on : Apr 12, 2026, 3:41:39 PM
    Author     : sandy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>
        <div class="container">
       <h2>Enter OTP</h2>

<form action="verifyOTP" method="post">
    <input type="text" name="otp" placeholder="Enter OTP" required>
    <button type="submit">Verify</button>
</form>
       </div>
    </body>
</html>
