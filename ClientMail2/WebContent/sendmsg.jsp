<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Envoi d'un Message</title>
</head>
<body>
<div><a href="First.jsp"><h4>Home</h4> </a></div>
<center>

	<div> <p><b>Envoiyer Votre Message</b></p>
	 <form action="sendc" method="POST">
		 <table>
		 <tr>
			 <td>To :</td>
			 <td><input type="text" name="cpt1" size="26"></td>
		 </tr>
		 <tr>
			 <td>Message :</td>
			 <td><textarea type="text" value="area"name="cpt2" ></textarea></td>
		 </tr>
		 
			 
			 
			
		 </table>
		 <input type="submit" "name="valider" value="valider" id="valider">
	 </form>
	 </div>
 </center>
</body>
</html>