package com.company.myfiles;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");

        if (email == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        fileName = new File(fileName).getName();

        String uploadPath = "C:/uploads/";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File file = new File(uploadPath + fileName);
        filePart.write(file.getAbsolutePath());

        // Save in DB
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO files(email, filename, filepath) VALUES (?, ?, ?)")) {

            ps.setString(1, email);
            ps.setString(2, fileName);
            ps.setString(3, file.getAbsolutePath());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("welcome.jsp");
    }
}