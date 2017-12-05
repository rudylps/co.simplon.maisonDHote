package co.simplon.maisonDHote.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResaServlet
 */
@WebServlet("/ResaServlet")
public class ResaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	request.setAttribute("tickets", TicketManager.getInstance().getTickets().values());
		
		getServletContext().getRequestDispatcher("/listeResa.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupération des informations saisies par l'utilisateur
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		
		Resa resa = new Resa();
		resa.setNom(nom);
		resa.setPrenom(prenom);
		resa.setMail(mail);
		resa.setTel(tel);
		// L'ajout du ticket s'est bien passé => Affichage de la page de récapitulation
		request.setAttribute("resa", resa);
		getServletContext().getRequestDispatcher("/listeResa.jsp").forward(request, response);
	}

}
