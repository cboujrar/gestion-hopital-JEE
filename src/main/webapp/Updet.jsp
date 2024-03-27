<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
if(request.getParameter("id") != null && request.getParameter("submit") != null){
    String id = request.getParameter("id");
     String nom = request.getParameter("nom");
    String spe = request.getParameter("spe");
    String ville = request.getParameter("ville");
    String malade = request.getParameter("malade"); 
    
    Connection con    = null;
    PreparedStatement prepared  = null;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/devoir","root","");
        String sql ="UPDATE doctors SET nom=?, spe=?, ville=?, malade=? WHERE id=?";
        prepared = con.prepareStatement(sql);
        prepared.setString(1,nom);
        prepared.setString(2,spe);
        prepared.setString(3,ville);
        prepared.setString(4,malade);
        prepared.setString(5,id);
        prepared.executeUpdate();
/*         response.sendRedirect(request.getContextPath() + "/update_success.jsp");
 */
    } catch (Exception e) {
        e.printStackTrace();
    } 
    
/*     response.sendRedirect(request.getContextPath() + "/update_success.jsp");
 */
%>



<!-- <script>
  alert("klsjqklhsqklhdlskqhdsklqhkl");
</script>
 -->

  <%
        
    	}
        
        %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier Table</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #0062cc;
        }
        header {
            background-color: #0062cc;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
        header h1 {
            margin: 0;
        }
        form {
            text-align: center;
            margin-top: 20px;
        }
        input[type="text"] {
            padding: 12px 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            width: 300px;
            margin-bottom: 10px;
            display: block;
            box-sizing: border-box;
        }
        button[type="submit"] {
            padding: 12px 20px;
            background-color: #1877f2;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            width: 300px;
            display: block;
            box-sizing: border-box;
        }
        button[type="submit"]:hover {
            background-color: #0062cc;
        }
        .form-container {
            max-width: 20%;
            max-height:300vh;
            margin: auto;
            padding: 20px;
            background-color: #0062cc;
            border-radius: 8px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <header>
        <h1>Modifier Table</h1>
    </header>
    <div class="form-container">
        <%
            Connection con = null;
            PreparedStatement prepared = null;
            ResultSet resultat = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/devoir", "root", "");
                String id = request.getParameter("id");
                String sql = "SELECT * FROM doctors WHERE id = ?";
                prepared = con.prepareStatement(sql);
                prepared.setString(1, id);
                resultat = prepared.executeQuery();
                while (resultat.next()) {
        %>
        <form action="sub" method="get">
            <input type="hidden" name="id" value="<%=resultat.getInt("id")%>">
            <input type="text" name="nom" value="<%=resultat.getString("nom")%>">
            <input type="text" name="spe" value="<%=resultat.getString("spe")%>">
            <input type="text" name="ville" value="<%=resultat.getString("ville")%>">
            <input type="text" name="malade" value="<%=resultat.getString("malade")%>">
            <button type="submit">Modifier</button>
        </form>
        <% 
             }
            } catch (Exception e) {
                e.printStackTrace();
            } 
        %>
    </div>
</body>
</html>
