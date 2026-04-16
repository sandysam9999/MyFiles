/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.company.myfiles;

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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionVID=1L;
    private static UserDao userDao=new UserDaoImp();

  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Login servlet called");	       
            String email = request.getParameter("email");
		        String password = request.getParameter("password");

		        if (userDao.isValidUser(email, password)) {
		            HttpSession session = request.getSession();
		            session.setAttribute("user", email);
		            response.sendRedirect("welcome.jsp");
		            //System.out.println("Hi - "+username);
		        } else {
		            response.sendRedirect("login.jsp?error=1");
		        	System.out.println("Error A gya");
		        }
	}

	
 
}
