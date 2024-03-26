package gestion_hopital;

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


public class contacte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contacte() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");

	        String nom = request.getParameter("txtName");
	        String email = request.getParameter("txtEmail");
	        String number = request.getParameter("txtPhone");
	        String message = request.getParameter("txtMsg");
	        int nb = 0;
	        try {
	            nb = Integer.parseInt(number);
	        } catch (NumberFormatException e) {
	            out.println("Number format exception for input number: " + number);
	            return; 
	        }

	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_hopital?useSSL=false&serverTimezone=UTC", "root", "CH=ima0708")) {
	            String sql = "INSERT INTO contacte (name, message, number, email) VALUES (?, ?, ?, ?)";
	            try (PreparedStatement statement = conn.prepareStatement(sql)) {
	                statement.setString(1, nom);
	                statement.setString(2, message);
	                statement.setInt(3, nb); 
	                statement.setString(4, email);

	                int rowsInserted = statement.executeUpdate();
	                if (rowsInserted > 0) {
	                    out.println("The message was sent successfully!");
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        out.println("Error inserting the message: " + e.getMessage());
	    }
	}

}
