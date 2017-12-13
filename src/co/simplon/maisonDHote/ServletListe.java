package co.simplon.maisonDHote;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletListe
 */
@WebServlet("/ServletListe")
public class ServletListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Connecté à : ").append(request.getContextPath());
	}

	/**
	 * @param newReservation 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, Reservation newReservation) throws ServletException, IOException {
		// envoie la requete vers l'affichage
				request.setAttribute("reservation", newReservation);
				ResaManager.getInstance().getResas(newReservation);
				request.setAttribute("resas", ResaManager.getInstance().getResas().values());
				getServletContext().getRequestDispatcher("/ListeResas.jsp").forward(request, response);
	}

}
