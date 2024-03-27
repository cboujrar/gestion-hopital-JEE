<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CRUD</title>
  <link rel="stylesheet" href="css/amiri.css">
  <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>
  <div class="container">
    <div class="header">
      <span>CRUD Table</span>
      <form action="sub" method="get">
      
      
        <input type="text" name="nom"  placeholder="Nom complet">
        <input type="text" name="spe"  placeholder="Spesiality" >
        <input type="text" name="ville" placeholder="Ville">
        <input type="text" name="malade" placeholder="nombre de malade">

     
        <button type="submit" id="new">Add Item</button>
      </form>
    </div>

    <div class="divTable">
      <table>
        <thead>
          <tr>
            <th>Nom Complet</th>
            <th>Speciality</th>
            <th>Ville</th>
            <th>Nombre de malade</th>
            <th class="acao">Edite</th>
            <th class="acao">Delect</th>
          </tr>
         
        </thead>
        <tbody>
          <%
        
          Connection con    ;
        PreparedStatement prepared  ;
        ResultSet resultat ;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/devoir","root","");
          String sqll ="SELECT * FROM doctors";
          
        prepared = con.prepareStatement(sqll);
        resultat = prepared.executeQuery();
            
        while(resultat.next()) {
          
        
          %>
          <tr>

            <td>  <%= resultat.getString("nom") %></td>
            <td>  <%=  resultat.getString("spe")  %></td>
            <td>  <%= resultat.getString("ville") %></td>
            <td>  <%= resultat.getString("malade") %></td> 
            <td >  <a href="Updet.jsp?id=<%= resultat.getString("id") %>" > <i class='bx bx-edit' style="color:#FFA500" ></i></a></td>
          <td><a href="su?id=<%= resultat.getString("id") %>" onclick="return confirm('WACH BRITI TEMSE7')"><i class='bx bx-trash' style="color:#FF0000" ></i></a></td>
         
   
           </tr>
           <%
        
    	}
        
        %>
        </tbody>
      </table>
    </div>

    
  </div>
  
</body>

</html>
