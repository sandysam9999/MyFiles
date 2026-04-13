package com.company.myfiles;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/verifyDeleteOTP")
public class VerifyDeleteOTPServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String enteredOtp = request.getParameter("otp");

        HttpSession session = request.getSession();
        String realOtp = (String) session.getAttribute("deleteOtp");
        String fileId = (String) session.getAttribute("deleteFileId");

        if (enteredOtp != null && enteredOtp.equals(realOtp)) {

            try {
                Connection con = DBUtil.getConnection();
                String query = "DELETE FROM files WHERE id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(fileId));

                ps.executeUpdate();

                System.out.println("File deleted successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }
            session.removeAttribute("deleteOtp");
            session.removeAttribute("deleteFileId");

            response.sendRedirect("viewfiles");

        } else {
            response.sendRedirect("delete-verify.jsp?error=invalid");
        }
    }
}