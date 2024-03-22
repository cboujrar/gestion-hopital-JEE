package gestion_hopital;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    // Adding serialVersionUID
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password2"); // Assuming the form field is named "password2"

        boolean isAuthenticated = authenticateUser(email, password);

        if (isAuthenticated) {
            // Redirect to home page or user dashboard after successful login
            response.sendRedirect("home.html");
        } else {
            // Optional: set an attribute to show an error message on the login page
            request.setAttribute("errorMessage", "Invalid email or password");
            // Forward back to the login page (or jsp) so the user can try again
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    private boolean authenticateUser(String email, String password) {
        final String QUERY = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = get_connection.getconnection();
             PreparedStatement stmt = conn.prepareStatement(QUERY)) {
            
            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // User exists
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Log error or handle it
        }
        return false;
    }
}
