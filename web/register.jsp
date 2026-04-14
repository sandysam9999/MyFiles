<%-- 
    Document   : register
    Created on : Apr 11, 2026, 6:54:10 PM
    Author     : sandy
--%>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
         <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
   <body>
    <div class="container">
        <h1>Register</h1>
        <form action="<%= request.getContextPath() %>/RegisterServlet" method="post">
    <label>Username:</label>
    <input type="text" name="username" required><br>

    <label>Email:</label>
    <input type="text" name="email" required><br>

    <label>Password:</label>
    <input type="password" name="password" required><br>

    <button type="submit">Register</button>
</form>
            <button type="submit">Register</button>
        
    
        <p><a href="index.html">Back to Home</a></p>
    
        <%-- Display error message if registration fails --%>
        <% String error = request.getParameter("error");
           if (error != null && error.equals("1")) { %>
            <p style="color: red;">Registration failed. Please try again.</p>
        <% } %>
      </div>
      
</body>
 
</html>
