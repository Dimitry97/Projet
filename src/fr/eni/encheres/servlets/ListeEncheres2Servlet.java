package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.artcileVendu.ArticleVenduDAO;
import fr.eni.encheres.dal.categorie.CategorieDAO;

/**
 * Servlet implementation class ListeEncheres2Servlet
 */
@WebServlet("/ListeEncheres2Servlet.html")
public class ListeEncheres2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeEncheres2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		ArticleVenduDAO articleVenduDAO = null;
		CategorieDAO categorieDAO = null;
		
		//
		String categorieChoisie = request.getParameter("categorie");
		List<ArticleVendu> listeArticlesEnVente = null;

		Categorie rechNoCategorie;
		int noCategorie = 0;
		try {
			rechNoCategorie = categorieDAO.rechercheNoCategorie(categorieChoisie);
			noCategorie = rechNoCategorie.getNoCategorie();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // convertir en int
		
		
		// RECHERCHER ARTICLE // 

		String nomArticleRecherche = request.getParameter("rechercheArticle"); // "rechercheArticle" = mot cl� saisie dans jsp
		

		
		
		// rechercher article via barre de recherche (si contient mot cl�) et aucune categorie choisie
		if(nomArticleRecherche != null && categorieChoisie == null) {
			try {
				listeArticlesEnVente = articleVenduDAO.rechercheParMotCle(nomArticleRecherche);
				// affiche article correspondant au mot cl� saisi
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				} else {
					// si aucun article correspondant au mot cl� saisi
					String messageAucunResultat = "Aucun article correspondant � votre recherche n'a �t� trouv� !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		
		// rechercher article si aucun mot cl� et categorie choisie
		if(nomArticleRecherche == null && categorieChoisie != null) {
			try {
				listeArticlesEnVente = articleVenduDAO.rechercheParNoCategorie(noCategorie);

				// affiche article correspondant au mot cl� saisi
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				} else {
					// si aucun article correspondant � la categorie choisie
					String messageAucunResultat = "Aucun article correspondant � votre recherche n'a �t� trouv� !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		
		// rechercher article si aucun mot cl� et aucune categorie choisie (afficher tous les articles � la vente)
		if(nomArticleRecherche != null && categorieChoisie != null) {
			try {
				listeArticlesEnVente = articleVenduDAO.rechercheParMotCleEtCategorie(nomArticleRecherche, noCategorie);

				// affiche article correspondant au mot cl� saisi
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				} else {
					// si aucun article correspondant � la categorie choisie
					String messageAucunResultat = "Aucun article correspondant � votre recherche n'a �t� trouv� !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		
		
		
	}

}
