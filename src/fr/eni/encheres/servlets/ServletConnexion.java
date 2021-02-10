package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.utilisateur.UtilisateurImpl;
import fr.eni.encheres.methode.CryptageMdp;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/Connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConnexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("displayNav", false); // On ne veux pas afficher de menu sur cette page
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = CryptageMdp.doHashing(request.getParameter("pass"));

		boolean exception = false;

		UtilisateurImpl user = new UtilisateurImpl();

		try {
			user.getUtilisateurPseudoMdp(login, pass);

			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		} catch (DALException e) {
			exception = true;
		}

		if (exception = true) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);

		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
		}
	}

}
