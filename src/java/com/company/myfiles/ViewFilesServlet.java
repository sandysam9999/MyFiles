
package com.company.myfiles;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/viewfiles")
public class ViewFilesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");

        if (email == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<FileModel> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT * FROM files WHERE email=?")) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FileModel f = new FileModel();
                f.setId(rs.getInt("id"));
                f.setFilename(rs.getString("filename"));
                f.setFilepath(rs.getString("filepath"));
                list.add(f);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("files", list);
        request.getRequestDispatcher("viewfiles.jsp").forward(request, response);
    }
}