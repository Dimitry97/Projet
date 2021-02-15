package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;

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
		

		
		
		
		
		//
		String categorieChoisie = request.getParameter("categorie");
		List<ArticleVendu> listeArticlesEnVente = null;
		Categorie rechNoCategorie;
		
		int noCategorie = 0;
		try {
			
			
			rechNoCategorie = DAOFactory.getCategorieDAO().rechercheNoCategorie(categorieChoisie);
			noCategorie = rechNoCategorie.getNoCategorie();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // convertir en int
		
		
		// RECHERCHER ARTICLE // 

		String nomArticleRecherche = request.getParameter("rechercheArticle"); // "rechercheArticle" = mot clé saisie dans jsp
		

		
		
		// rechercher article via barre de recherche (si contient mot clé) et aucune categorie choisie
		if(nomArticleRecherche != null && categorieChoisie == null) {
			try {
				listeArticlesEnVente = DAOFactory.getArticleDAO().rechercheParMotCle(nomArticleRecherche);
				// affiche article correspondant au mot clé saisi
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				} else {
					// si aucun article correspondant au mot clé saisi
					String messageAucunResultat = "Aucun article correspondant à votre recherche n'a été trouvé !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		
		// rechercher article si aucun mot clé et categorie choisie
		if(nomArticleRecherche == null && categorieChoisie != null) {
			try {
				listeArticlesEnVente = DAOFactory.getArticleDAO().rechercheParNoCategorie(noCategorie);

				// affiche article correspondant au mot clé saisi
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				} else {
					// si aucun article correspondant à la categorie choisie
					String messageAucunResultat = "Aucun article correspondant à votre recherche n'a été trouvé !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		
		// rechercher article si aucun mot clé et aucune categorie choisie (afficher tous les articles à la vente)
		if(nomArticleRecherche != null && categorieChoisie != null) {
			try {
				listeArticlesEnVente = DAOFactory.getArticleDAO().rechercheParMotCleEtCategorie(nomArticleRecherche, noCategorie);

				// affiche article correspondant au mot clé saisi
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheres2.jsp").forward(request, response);
				} else {
					// si aucun article correspondant à la categorie choisie
					String messageAucunResultat = "Aucun article correspondant à votre recherche n'a été trouvé !";
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
