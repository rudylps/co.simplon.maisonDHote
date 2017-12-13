package co.simplon.maisonDHote;

import java.io.IOException;
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
		
		//création d'une résa
		Reservation newReservation = new Reservation();
		newReservation.setNom(request.getParameter("nom"));
		newReservation.setPrenom(request.getParameter("prenom"));
		newReservation.setMail(request.getParameter("mail"));
		newReservation.setTel(request.getParameter("tel"));
		
		try {
		// newReservation.setNbPersonne(request.getParameter("nbPersonne"));
		newReservation.setNbPersonne(Integer.parseInt(request.getParameter("nbPersonne")));
		} catch (Exception e) {
			newReservation.setNbPersonne(0);
		}
		
		newReservation.setRegion(request.getParameter("region"));
		newReservation.setDateArrivee(request.getParameter("dateArrivee"));
		
		try {
		// newReservation.setNbNuit(request.getParameter("nbNuit"));
		newReservation.setNbNuit(Integer.parseInt(request.getParameter("nbNuit")));
		} catch (Exception e) {
			newReservation.setNbPersonne(0);
		}
		
		try {
			newReservation.setAnimal(Boolean.parseBoolean(request.getParameter("animal")));
		} catch (Exception e) {
			newReservation.setAnimal(false);
		}
		
		try {
			newReservation.setParking(Boolean.parseBoolean(request.getParameter("parking")));
		} catch (Exception e) {
			newReservation.setParking(false);
		}
		
		try {
			newReservation.setDej(Boolean.parseBoolean(request.getParameter("dej")));
		} catch (Exception e) {
			newReservation.setDej(false);
		}
		
		newReservation.setLoisir(request.getParameter("loisir"));
		newReservation.setProfessionnel(request.getParameter("professionnel"));
		
		
		// envoie la requete vers l'affichage
		request.setAttribute("reservation", newReservation);
		ResaManager.getInstance().getResas(newReservation);
		request.setAttribute("resas", ResaManager.getInstance().getResas().values());
		getServletContext().getRequestDispatcher("/Affichage.jsp").forward(request, response);
	}

}
