<%
String user = (String) session.getAttribute("user");

if (user == null) {
    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
    <div class="container">

<h2>Welcome, <%= user %></h2>

<form action="addfile.jsp">
    <button type="submit">Add Files</button>
</form>

<form action="viewfiles">
    <button type="submit">View Files</button>
</form>

<form action="viewfiles">
    <button type="submit">Remove Files</button>
</form>

<form action="logout">
    <button type="submit">Logout</button>
</form>
    </div>
</body>
</html>