package co.simplon.maisonDHote;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.maisonDHote.ResaManager;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
//		response.getWriter().append("Connecté à : ").append(request.getContextPath());
		
		// Récupération des tickets actifs
		request.setAttribute("resas", ResaManager.getInstance().getResas().values());
				
				
				getServletContext().getRequestDispatcher("/ListeResas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String mail=request.getParameter("mail");
		String tel=request.getParameter("tel");
		int nbPersonne=Integer.parseInt(request.getParameter("nbPersonne"));
		String region=request.getParameter("region");
		String dateArrivee=request.getParameter("dateArrivee");
		int nbNuit=Integer.parseInt(request.getParameter("nbNuit"));
		boolean animal=request.getParameter("animal") != null;
		boolean parking=request.getParameter("parking") != null;
		boolean dej = request.getParameter("dej") != null;
		String typeSejour = request.getParameter("group1");
		
		// calcul prix
		int prixDeBase = 60 * (nbPersonne * nbNuit);
		int prixOption = 0;
		if (animal) {
				prixOption =+ 10;
		}
		if (parking) {
				prixOption =+ 10;
			}
		if (dej) {
				prixOption =+ 10;
			}
		int prixTotal = prixOption + prixDeBase;
		
		
		//création d'une résa
		Reservation newReservation = new Reservation();
		
		newReservation.setNom(nom);
		newReservation.setPrenom(prenom);
		newReservation.setMail(mail);
		newReservation.setTel(tel);
		newReservation.setNbPersonne(nbPersonne);
		newReservation.setRegion(region);
		newReservation.setDateArrivee(dateArrivee);
		newReservation.setNbNuit(nbNuit);
		newReservation.setAnimal(animal);
		newReservation.setParking(parking);
		newReservation.setDej(dej);
		newReservation.setTypeSejour(typeSejour);
		newReservation.setPrixTotal(prixTotal);
		
		ConnexionSQL connexion = new ConnexionSQL(); //cree obj connexion
		try {
			connexion.initConnexion(); //méthode pr init connexion
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			connexion.insertData(nom, prenom, mail, tel, region, dateArrivee); //va inserer les donnees au niveau de la base
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// envoie la requete vers l'affichage
		request.setAttribute("reservation", newReservation);
		ResaManager.getInstance().getResas(newReservation); //revoie l'instance de mon singleton
		request.setAttribute("resas", ResaManager.getInstance().getResas().values());
		getServletContext().getRequestDispatcher("/Affichage.jsp").forward(request, response);
	}

}
