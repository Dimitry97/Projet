package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurImpl;
import fr.eni.encheres.methode.Methodes;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/connexion.html")
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp");
		Utilisateur utilisateur = new Utilisateur();
		PrintWriter out = response.getWriter();

		String erreur = null;
		HttpSession session = request.getSession();

		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("password");

		boolean exception = false;

		// Verification que le login et le mot de passe récupéré ne sont pas null

		if (pseudo.length() == 0 || pseudo.isEmpty()) {
			request.setAttribute("erreur", "<p><strong>Veuillez renseigner votre pseudo</strong></p>");
			erreur = (String) session.getAttribute("erreur");
			out.print(erreur);

			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);

		} else if (motDePasse.length() == 0 || motDePasse.isEmpty()) {
			request.setAttribute("erreur", "Veuillez renseigner votre mot de passe");
			erreur = (String) session.getAttribute("erreur");
			out.print(erreur);

			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request, response);

		} else {
			try {
				UtilisateurDAO user = new UtilisateurImpl();
				System.out.println("ok");
				utilisateur = user.getUtilisateurPseudoMdp(pseudo, motDePasse);
				System.out.println("ok");
				session.setAttribute("pseudo", pseudo);
				if (utilisateur == null) {
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request,
							response);
				} else {

					System.out.println("utilisateur ok");
					
					
/////////////////////////////////////////////////////////Modifier adresse dispatcher
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/nouvelleVente2.jsp").forward(request,
							response);
				}
			} catch (DALException e) {
				exception = true;
				request.setAttribute("erreur",
						"pseudo et/ou mot de passe incorrect(s)! Veuillez ressaisir vos identifiants!");
				erreur = (String) session.getAttribute("erreur");
				out.println(erreur);
			}

			if (exception = true) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request,
						response);

			} else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp").forward(request,
						response);
			}
		}

	}
}
