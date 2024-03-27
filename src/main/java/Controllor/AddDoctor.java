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
import Model.Doctor;



@WebServlet("/sub")
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection cnx=null ;
	PreparedStatement prepared=null ;
	ResultSet resultat=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		cnx =Connextion.ConnecrDb();
		
		PrintWriter pr =response.getWriter();
		
		String nom = request.getParameter("nom");
		String spe = request.getParameter("spe");
	    String ville = request.getParameter("ville");
	    String malade = request.getParameter("malade");

		
	     System.out.print("nom"+nom);
	     System.out.print("nom"+spe);
	     System.out.print("nom"+ville);
		
	    String sql ="INSERT INTO doctors(nom,spe,ville,malade) VALUES (?,?,?,?)";
		
try {
			
			prepared=cnx.prepareStatement(sql);
			prepared.setString(1,request.getParameter("nom"));
			prepared.setString(2,request.getParameter("spe"));
			prepared.setString(3,request.getParameter("ville"));
			prepared.setString(4,request.getParameter("malade"));
			
			prepared.execute();	
			
			response.sendRedirect(request.getContextPath() + "/AddDoctor.jsp?message=Donee");
			pr.print("<script >"); 
			pr.print("alter(\"welcoom \");");   
			pr.print(" </script>"); 
			
	        refresh();

	}catch (SQLException e) {
		e.printStackTrace();
		pr.println("pas de message sorry");}




	
	}

	private void refresh() {
		// TODO Auto-generated method stub
		
	}
}
