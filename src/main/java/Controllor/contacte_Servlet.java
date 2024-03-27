package Controllor;

import jakarta.servlet.ServletException;

import java.sql.Connection;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet(name ="contacte", urlPatterns ={"/contacte"})

/**
 * Servlet implementation class contacte_Servlet
 */
public class contacte_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contacte_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html; charset=UTF-8");

	    try (PrintWriter out = response.getWriter()) {
	        String nom = request.getParameter("txtName");
	        String email = request.getParameter("txtEmail");
	        String number = request.getParameter("txtPhone");
	        String message = request.getParameter("txtMsg");

	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital", "root", "CH=ima0708")) {
	            String sql = "INSERT INTO contacte (name, message, number, email) VALUES (?, ?, ?, ?)";
	            try (PreparedStatement statement = conn.prepareStatement(sql)) {
	                statement.setString(1, nom);
	                statement.setString(2, message);
	                statement.setString(3, number);
	                statement.setString(4, email);

	                int rowsInserted = statement.executeUpdate();
	                if (rowsInserted > 0) {
	                    out.println("<p>The message was sent successfully!</p>");
	                } else {
	                    out.println("<p>There was a problem sending your message. Please try again.</p>");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace(out);
	        }
	    }
	}

}


