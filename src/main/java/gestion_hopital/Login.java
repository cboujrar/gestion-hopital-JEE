package gestion_hopital;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Login
 */
import java.io.IOException;

import jakarta.servlet.ServletException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests if needed (e.g., show login page)
        // For simplicity, let's redirect to the login page
        response.sendRedirect("home.html");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password2");

        // Here you can perform your login authentication logic
        // For example, you can validate the email and password against your database
        
        // For simplicity, let's just print out the received data
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        
        // Redirect to another page after successful login
        response.sendRedirect("home.html");
    }
}

