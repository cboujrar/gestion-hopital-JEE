package Controllor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connextion_Sql.Connextion;
import Model.Personne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inscreption")
public class Regester_logine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection cnx=null ;
	PreparedStatement prepared=null ;
	ResultSet resultat=null;
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        cnx =Connextion.ConnecrDb();
		PrintWriter pr =response.getWriter();
		String sql ="INSERT INTO person(nom,prenom,email,pass) VALUES (?, ?, ?, ?)";
		
try {
			
			prepared=cnx.prepareStatement(sql);
			prepared.setString(1,request.getParameter("nom"));
			prepared.setString(2,request.getParameter("prenom"));
			prepared.setString(3,request.getParameter("email"));
			prepared.setString(4,request.getParameter("passs"));
			
			prepared.execute();
			
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String pass = request.getParameter("passs");
			
			String message;
			
			        if(nom.trim().isEmpty()||
					   prenom.trim().isEmpty()||
					   email.trim().isEmpty()||
					   pass.trim().isEmpty()
					   )
			           {
						message="3amar asa7bi Formeee";
						
						request.setAttribute("messagee", message);
						this.getServletContext().getRequestDispatcher
						("/Regester.jsp").forward(request, response);
					    }
					else{
						
					/*	message= " welcom broo" ;
						request.setAttribute("TEST", message);*/
						
					
						Personne persson = new Personne();
						persson.setNom(nom);
						persson.setPrenom(prenom);
						persson.setEmail(email);
						persson.setPass(pass);
						
						request.setAttribute("client", persson);
						
						this.getServletContext().getRequestDispatcher("/Logine.jsp")
						.forward(request, response);
						}	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			pr.println("pas de message sorry");}
		
	}

}
