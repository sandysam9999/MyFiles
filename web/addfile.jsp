<%
String user = (String) session.getAttribute("user");
if (user == null) {
    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Add File</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
    <div class="container">

<h2>Add File</h2>

<form action="upload" method="post" enctype="multipart/form-data">
    
    <label>Select File:</label><br><br>
    <input type="file" name="file" required><br><br>
    
    <button type="submit">Upload File</button>

</form>

<br>
<a href="welcome.jsp">Back to Dashboard</a>
    </div>>
</body>
</html>