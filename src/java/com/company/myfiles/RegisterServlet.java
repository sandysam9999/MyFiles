/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.myfiles;

import com.company.myfiles.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author sandy
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String username = request.getParameter("username");
String email = request.getParameter("email");
String password = request.getParameter("password");

// create user object
User user = new User(username, email, password);

// generate OTP
String otp = OTPUtil.generateOTP();
System.out.println("Generated OTP: " + otp);
// store temporarily in session
HttpSession session = request.getSession();
session.setAttribute("otp", otp);
session.setAttribute("tempUser", user);

// send OTP email
EmailUtil.sendOTP(email, otp);

// go to OTP page
response.sendRedirect("verify.jsp");
		    }
}

	

