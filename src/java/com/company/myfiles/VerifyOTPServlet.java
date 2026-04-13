package com.company.myfiles;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/verifyOTP")
public class VerifyOTPServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {

    String enteredOtp = request.getParameter("otp");

    HttpSession session = request.getSession();
    String realOtp = (String) session.getAttribute("otp");

    if (enteredOtp != null && enteredOtp.equals(realOtp)) {

        User user = (User) session.getAttribute("tempUser");

        if (user == null) {
            System.out.println("User is NULL");
            response.sendRedirect("verify.jsp?error=session");
            return;
        }

        UserDaoImp dao = new UserDaoImp();
        boolean status = dao.addUser(user);

        if (status) {
            System.out.println("User inserted successfully");
            response.sendRedirect("login.jsp");
        } else {
            System.out.println("DB insert failed");
            response.sendRedirect("verify.jsp?error=db");
        }

    } else {
        response.sendRedirect("verify.jsp?error=invalid");
    }
}
}