package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class consulterProfilServlet
 */
@WebServlet("/ConsulterMonProfilServlet")
public class ConsulterMonProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static final String VUE = "/WEB-INF/jsp/consulterMonProfil.jsp";
	public static final String CHAMP_PSEUDO = "pseudo";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_TEL = "telephone";
	public static final String CHAMP_RUE = "rue";
	public static final String CHAMP_CP = "codePostal";
	public static final String CHAMP_VILLE = "ville";


	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterMonProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Afficher la page Mon profil
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		// Recuperer les champs du formulaire
		String pseudo = request.getParameter(CHAMP_PSEUDO);
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String email = request.getParameter(CHAMP_EMAIL);
		String telephone = request.getParameter(CHAMP_TEL);
		String rue = request.getParameter(CHAMP_RUE);
		String codePostal = request.getParameter(CHAMP_CP);
		String ville = request.getParameter(CHAMP_VILLE);


		
		request.setAttribute("pseudo", pseudo);
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("email", email);
		request.setAttribute("telephone", telephone);
		request.setAttribute("rue", rue);
		request.setAttribute("codePostal", codePostal);
		request.setAttribute("ville", ville);
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/monProfil2.jsp").forward( request, response );
		
		
		
		
	}

}
