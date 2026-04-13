package com.company.myfiles;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.sql.*;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection con = DBUtil.getConnection()) {

            // get file path
            PreparedStatement ps1 = con.prepareStatement(
                    "SELECT filepath FROM files WHERE id=?");
            ps1.setInt(1, id);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                String path = rs.getString("filepath");

                // delete file from folder
                File file = new File(path);
                if (file.exists()) {
                    file.delete();
                }
            }

            // delete from DB
            PreparedStatement ps2 = con.prepareStatement(
                    "DELETE FROM files WHERE id=?");
            ps2.setInt(1, id);
            ps2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewfiles");
    }
}