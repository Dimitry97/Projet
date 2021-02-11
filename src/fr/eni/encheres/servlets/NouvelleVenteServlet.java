package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.artcileVendu.ArticleVenduDAO;
import fr.eni.encheres.dal.artcileVendu.ArticleVenduImpl;
import fr.eni.encheres.dal.retrait.RetraitDAO;
import fr.eni.encheres.methode.Methodes;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduDAO nouvelVente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NouvelleVenteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation la session utlisateur
		HttpSession session = request.getSession();
		
		// recuperation des données de la session (données utilisateurs connecté)
		String nvRue = (String) session.getAttribute("rue");
		String nvCP = (String) session.getAttribute("codePostal");
		String nvVille = (String) session.getAttribute("ville");


		// ajoute les données récuperées à des variable utilisable dans le doPost
		session.setAttribute("rue", nvRue);
		session.setAttribute("codePostal", nvCP);
		session.setAttribute("ville", nvVille);

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/nouvelleVente2.jsp").forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récuperer les données pour ajouter un nouvel article à la vente (nvXXX = nouvelle vente XXX)
		String nvArticle = request.getParameter("article");
		String nvDescription = request.getParameter("description");
		//
		String nvCategorie = request.getParameter("categorie"); 
		//   ////String nvPhoto = request.getParameter("photo"); // attention, objet image
		int nvMiseAPrix = (Integer.parseInt(request.getParameter("miseAPrixArticle")));
		String dateDebut = request.getParameter("debutEnchere"); // attention, ne veut pas de LocalDate, propose String, à vérifier
		String dateFin = request.getParameter("finEnchere");
		String nvRue = request.getParameter("rue");
		String nvCP = request.getParameter("codePostal");
		String nvVille = request.getParameter("ville");
		

		Date nvDateDebut = null, nvDateFin = null;
		try {
			nvDateDebut = (Date) Methodes.dateJSPVersJava(dateDebut);
			nvDateFin = (Date) Methodes.dateJSPVersJava(dateFin);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		
		ArticleVenduDAO noC = new ArticleVenduImpl();
		try {
			int noCat = noC.rechercheNoCategorie(nvCategorie);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		ArticleVendu nvArticleAVendre = new ArticleVendu();
		nvArticleAVendre.setNomArticle(nvArticle);
		nvArticleAVendre.setDescription(nvDescription);
		nvArticleAVendre.setDateDebutEncheres(nvDateDebut);
		nvArticleAVendre.setDateFinEncheres(nvDateFin);
		nvArticleAVendre.setMiseAPrix(nvMiseAPrix);
		nvArticleAVendre.setPrixVente(nvMiseAPrix);

		HttpSession session = request.getSession();
		int nvNoUtilisateur = (int) session.getAttribute("noUtilisateur");
	
		nvArticleAVendre.getVendeur().setNoUtilisateur(nvNoUtilisateur);
		nvArticleAVendre.getCategorie().setNoCategorie(1); //noCat
		
		
		
		ArticleVenduDAO nouvelleVente = null;
		try {
			try {
				nouvelleVente.nouvelArticle(nvArticleAVendre);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		Retrait nvRetrait = new Retrait();
		nvRetrait.setCodePostal(nvCP);
		nvRetrait.setRue(nvRue);
		nvRetrait.setVille(nvVille);
		
		RetraitDAO retraitDAO = null;
		try {
			retraitDAO.ajoutRetrait(nvRetrait);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente2.jsp").forward(request, response);
		
		
	}

}
