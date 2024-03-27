package Controllor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connextion_Sql.Connextion;



@WebServlet("/su")
public class Delet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection cnx=null ;
	PreparedStatement prepared=null ;
	ResultSet resultat=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pr =response.getWriter();
		
		
		try {
			cnx =Connextion.ConnecrDb();
			
	            int id = Integer.parseInt(request.getParameter("id"));
                System.out.print("id"+id);
	            String sql = "DELETE FROM `doctors` WHERE id= ?";
	            prepared = cnx.prepareStatement(sql);
	            prepared.setInt(1, id);
	            prepared.executeUpdate();
                response.sendRedirect(request.getContextPath() + "/AddDoctor.jsp");
               
		} catch (SQLException e) {
			pr.print("errrrr");
			e.printStackTrace();
		}
		

	}

}
