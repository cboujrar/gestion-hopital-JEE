package Controllor;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

 
import jakarta.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connextion_Sql.Connextion;
import Model.Personne;
 


@WebServlet("/logine")
public class Logine_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection cnx=null ;
	PreparedStatement prepared=null ;
	ResultSet resultat=null;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		cnx =Connextion.ConnecrDb();
		PrintWriter pr =response.getWriter();
		
		HttpSession session = request.getSession();
		
		
		
		String email = request.getParameter("email");
		String pass = request.getParameter("passs");
		
		
		
		

		String sql ="select * from person ";
		
		try {
			
			prepared=cnx.prepareStatement(sql);
			resultat=prepared.executeQuery();
			
			while(resultat.next()) {
				
				String AZ = resultat.getString("email");
				String AE = resultat.getString("pass");
				
				//les sesion
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				
				
				if(AZ.equals(email)&& AE.equals(pass)) {
					
					
			this.getServletContext().getRequestDispatcher("/WEB-INF/Home2.jsp").forward(request, response);
			
				}
				Personne persson = new Personne();
				
				persson.setNom(nom);
				persson.setNom(prenom);
		
				session.setAttribute("client",nom);
				session.setAttribute("clientt",prenom);
				
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			pr.println("pas de message sorry");}
		
		try {
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

