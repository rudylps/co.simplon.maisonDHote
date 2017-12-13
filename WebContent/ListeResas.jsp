<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.simplon.maisonDHote.Reservation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des réservations</title>
<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen" />
</head>
<body style="text-align:center;">
		<h5>Liste des reservations :</h5>
		<br></br>
		<table class="highlight responsive-table">
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Mail</th>
			<th>Téléphone</th>
			<th>Nb de personnes</th>
			<th>Origine</th>
			<th>Date d'arrivée</th>
			<th>Nb nuit</th>
			<th>Animal</th>
			<th>Parking</th>
			<th>Petit Déj</th>
			<th>Loisir</th>
			<th>Pro</th>
			<!-- <th>Date</th> -->
		</tr>
		<%
			/* SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); */
			Collection<Reservation> resas = (Collection<Reservation>) request.getAttribute("resas");
			if(resas != null)
			{
				Iterator it = resas.iterator() ;
			    while (it.hasNext())
			    {
			    	Reservation serveur=(Reservation) it.next() ;
		%>
					<tr>
						<td><%=serveur.getNom()%></td>
						<td><%=serveur.getPrenom()%></td>
						<td><%=serveur.getMail()%></td>
						<td><%=serveur.getTel()%></td>
						<td><%=serveur.getNbPersonne()%></td>
						<td><%=serveur.getRegion()%></td>
						<td><%=serveur.getDateArrivee()%></td>
						<td><%=serveur.getNbNuit()%></td>
						<td><%=serveur.isAnimal()%></td>
						<td><%=serveur.isParking()%></td>
						<td><%=serveur.isDej()%></td>
						<td><%=serveur.getLoisir()%></td>
						<td><%=serveur.getProfessionnel()%></td>
						<%-- <td><%=dateFormater.format(serveur.getDateEnregistrement())%></td> --%>
					</tr>
		<%      }
			}
		%>
		</table>
		
		<br><a href="http://localhost:8080/co.simplon.maisonDHote/reservation.html">Retour à la réservation</a></br>

</body>
</html>