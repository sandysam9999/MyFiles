package com.company.myfiles;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/sendDeleteOTP")
public class SendDeleteOTPServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();

        String email = (String) session.getAttribute("user");
        String fileId = request.getParameter("id");

        // generate OTP
        String otp = OTPUtil.generateOTP();

        // store in session
        session.setAttribute("deleteOtp", otp);
        session.setAttribute("deleteFileId", fileId);

        // send email
        EmailUtil.sendOTP(email, otp);

        // redirect to OTP page
        response.sendRedirect("delete-verify.jsp");
    }
}