<%-- 
    Document   : viewfiles
    Created on : Apr 12, 2026, 2:45:30 PM
    Author     : sandy
--%>
        <%@ page import="java.util.List" %>
<%@ page import="com.company.myfiles.FileModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view files</title>
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>

        <div class="conatiner">
<h2>Your Files</h2>

<table border="1">
<tr>
    <th>File Name</th>
    <th>Action</th>
</tr>

<%
List<FileModel> files = (List<FileModel>) request.getAttribute("files");

if (files != null && !files.isEmpty()) {
    for (FileModel f : files) {
%>
<tr>
    <td><%= f.getFilename() %></td>
    <td>
        <a href="sendDeleteOTP?id=<%= f.getId() %>">Delete</a>
    </td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="2">No files found</td>
</tr>
<%
}
%>
</table>

<br>
<a href="welcome.jsp">Back</a>
        </div>
    </body>
</html>
