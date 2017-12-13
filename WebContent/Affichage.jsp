<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Chez R. - venez profiter du bon R.</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen" />
</head>

<body>


	<!--  bannière -->
	<div id="index-banner" class="parallax-container">
		<div class="section no-pad-bot">
			<div class="banniere">
				<div class="">
					<h1 class="header center teal-text text-grey darken-4">Chez R.</h1>
					<div class="row center">
						<i class="center teal-text text-grey medium material-icons">grade
							grade grade grade</i>
					</div>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img src="images/background1.jpg" alt="Unsplashed background img 1">
		</div>
	</div>

	<nav class="white">
	<div class="nav-wrapper container">

		<!-- <a id="logo-container" href="#" class="brand-logo">Logo</a> -->

		<!--  menu  -->
		<ul class="center hide-on-med-and-down">
			<li><a href="index.html">LA MAISON</a></li>
			<li><a href="region.html">LA REGION</a></li>
			<li class="active"><a href="reservation.html">RESERVATION</a></li>
		</ul>

		<ul id="nav-mobile" class="side-nav">
			<li><a href="index.html">LA MAISON</a></li>
			<li><a href="region.html">LA REGION</a></li>
			<li class="active"><a href="reservation.html">RESERVATION</a></li>
		</ul>
		<a href="#" data-activates="nav-mobile" class="button-collapse"><i
			class="material-icons">menu</i></a>
	</div>
	</nav>

	<div class="row">
		<div class="col s12 center">
			<p>
			<h4>Récapitulatif de votre réservation :</h4>
			</p>

			<div class="col s12 m4 center">
				<h5 class="center">Vous</h5>
				<!-- champs obligatoires -->
				<p>
					Nom : <b><%=request.getParameter("nom")%></b>
				</p>
				<p>
					Prénom : <b><%=request.getParameter("prenom")%></b>
				</p>
				<p>
					Mail : <b><%=request.getParameter("mail")%></b>
				</p>
				<p>
					Téléphone : <b><%=request.getParameter("tel")%></b>
				</p>
			</div>

			<div class="col s12 m4 center">
				<h5 class="center">Les options ( + 10€ )</h5>
				<!-- checkbox -->
				<p>
					Animal :
					<%
					String affichage;
					if (request.getParameter("animal") == null)
						affichage = "non";
					else
						affichage = "oui";
				%>
					<b><%=affichage%></b>
				</p>
				<p>
					Parking :
					<%
					if (request.getParameter("parking") == null)
						affichage = "non";
					else
						affichage = "oui";
				%>
					<b><%=affichage%></b>
				</p>
				<p>
					Petit déjeuner :
					<%
					if (request.getParameter("dej") == null)
						affichage = "non";
					else
						affichage = "oui";
				%>
					<b><%=affichage%></b>
				</p>
			</div>


			<div class="col s12 m4 center">
				<h5 class="center">Confirmation</h5>
				<p>
					Vous avez commandé un séjour de type <b><%=request.getParameter("group1")%></b>
					pour <b><%=request.getParameter("nbPersonne")%></b> personne(s)
					pendant <b><%=request.getParameter("nbNuit")%></b> nuit(s), à
					partir du <b><%=request.getParameter("dateArrivee")%></b>.
				</p>
				<p>Vous pouvez régler la somme de ... dès à présent pour
					réserver votre séjour.</p>
			</div>
			<!-- affichage du devis, bouton confirmation, bouton impression de la facture -->

			<!-- bouton pour afficher la liste des resas -->
			<!-- <form action="ServletListe" method="post">
<div class="input-field col s12 m6">
					<button class="btn waves-effect waves-light" type="submit" value="envoyer">Liste des réservations
					<i class="material-icons right">send</i>
					</button>
				</div>
				</form> -->

			<a href="IndexServlet">Liste des réservations</a>


		</div>
	</div>

	<footer class="page-footer teal">
	<div class="container">
		<div class="row center">
			<div class="col l4 s12">
				<h5 class="white-text">Partenaires</h5>
				<ul>
					<li><a class="white-text" href="#!">Resto "A la gamelle"</a></li>
					<li><a class="white-text" href="#!">Accro'banches</a></li>
				</ul>
			</div>
			<div class="col l4 s12">
				<h5 class="white-text">Contact</h5>
				<ul>
					<li><a class="white-text" href="#!">Chez R.</a></li>
					<li><a class="white-text" href="#!">55, rue de Vincennes</a></li>
					<li><a class="white-text" href="#!">33333
							Thune-sur-Gironde</a></li>
					<li><a class="white-text" href="#!">05 55 55 55 55</a></li>
				</ul>
			</div>
			<div class="col l4 s12">
				<h5 class="white-text">Suivez-nous</h5>
			</div>
			<div>
				<a class="mt-facebook mt-share-inline-bar-sm"
					href="https://www.facebook.com/sharer/sharer.php?u="> <img
					src="http://mojotech-static.s3.amazonaws.com/facebook@2x.png"
					alt="Suivez-nous!">
				</a> <a class="mt-twitter mt-share-inline-bar-sm"
					href="http://twitter.com/intent/tweet?text=&amp;url="> <img
					src="http://mojotech-static.s3.amazonaws.com/twitter@2x.png"
					alt="Suivez-nous!">
				</a> <a class="mt-google mt-share-inline-bar-sm"
					href="https://plus.google.com/share?url="> <img
					src="http://mojotech-static.s3.amazonaws.com/google@2x.png"
					alt="Suivez-nous!">
				</a>
			</div>
		</div>
	</div>
	<!--  Copyright -->
	<div class="footer-copyright">
		<div class="container">
			Copié-colled by <a class="brown-text text-lighten-3"
				href="https://www.youtube.com/watch?v=BgoOihBb78w">Rudy</a>
		</div>
	</div>
	</footer>


	<!-- bouton flottant remonter, merci Sylvain-->
	<div class="fixed-action-btn">
		<a class="waves-effect btn-floating btn-medium z-depth-4" href="#top"><i
			class="medium material-icons">arrow_upward</i></a>
	</div>


	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>
	<script src="js/select.js"></script>
	<script src="js/pickdate.js"></script>

</body>

</html>