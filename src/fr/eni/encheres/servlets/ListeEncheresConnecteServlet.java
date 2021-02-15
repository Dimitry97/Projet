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
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.artcileVendu.ArticleVenduDAO;
import fr.eni.encheres.dal.artcileVendu.ArticleVenduImpl;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurImpl;

/**
 * Servlet implementation class ListeEncheres2Servlet
 */
@WebServlet("/ListeEncheresConnecteServlet.html")
public class ListeEncheresConnecteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeEncheresConnecteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
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

		String nomArticleRecherche = request.getParameter("rechercheArticle"); // "rechercheArticle" = mot cl� saisie dans jsp




		// rechercher article via barre de recherche (si contient mot cl�) et aucune categorie choisie
		if(nomArticleRecherche != null && categorieChoisie == null) {
			try {
				listeArticlesEnVente = DAOFactory.getArticleDAO().rechercheParMotCle(nomArticleRecherche);
				// affiche article correspondant au mot cl� saisi
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				} else {
					// si aucun article correspondant au mot cl� saisi
					String messageAucunResultat = "Aucun article correspondant � votre recherche n'a �t� trouv� !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
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
				listeArticlesEnVente = DAOFactory.getArticleDAO().rechercheParNoCategorie(noCategorie);

				// affiche article correspondant au mot cl� saisi
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				} else {
					// si aucun article correspondant � la categorie choisie
					String messageAucunResultat = "Aucun article correspondant � votre recherche n'a �t� trouv� !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
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
				listeArticlesEnVente = DAOFactory.getArticleDAO().rechercheParMotCleEtCategorie(nomArticleRecherche, noCategorie);

				// affiche article correspondant au mot cl� saisi
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				} else {
					// si aucun article correspondant � la categorie choisie
					String messageAucunResultat = "Aucun article correspondant � votre recherche n'a �t� trouv� !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}


		// RECHERCHE VIA BOUTONS RADIO ET CHECKBOX 
		List<Enchere> listeEncheres = null;


		// recuperer l'identifiant de l'utilisateur connect�
		HttpSession session = request.getSession();
		int noUtilisateurConnecte = (int) session.getAttribute("noUtilisateur");

		// AJOUTER CRITERES DATE (ajouter methode dans EnchereDAOImpl)
		// "SELECT * FROM ENCHERES INNER JOIN ARTICLES_VENDUS WHERE ENCHERES.date_enchere > ARTICLES_VENDUS.date_debut_encheres AND ENCHERES.date_enchere < ARTICLES_VENDUS.date_fin_encheres "
		// affiche tous les encheres ouvertes
		if(! request.getParameter("encheresOuvertes").isEmpty()) { 
			try {
				listeEncheres = DAOFactory.getEnchereDAO().getAll();

				// affiche liste des encheres
				if (listeEncheres != null) {
					request.setAttribute("listeEncheres", listeEncheres);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp//WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				} else {
					// si aucun article correspondant
					String messageAucunResultat = "Vous n'avez actuellement aucun article en vente !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} 
		}

		// recherche articles "mesEncheres"
		if(! request.getParameter("mesEncheres").isEmpty()) { // comment v�rifier si autre que utilisateur connect�
			try {
				listeEncheres = DAOFactory.getEnchereDAO().getByEncherisseur(noUtilisateurConnecte);

				// affiche article
				if (listeEncheres != null) {
					request.setAttribute("listeEncheres", listeEncheres);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				} else {
					// si aucun article correspondant
					String messageAucunResultat = "Vous n'avez actuellement aucun article en vente !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} 
		}

		// recherche articles "mesEncheresRemportees"
		if(! request.getParameter("mesEncheresRemportees").isEmpty()) { // comment v�rifier si autre que utilisateur connect�
			try {
				listeEncheres = DAOFactory.getEnchereDAO().getRemportesParEncherisseur(noUtilisateurConnecte);

				// affiche article
				if (listeEncheres != null) {
					request.setAttribute("listeEncheres", listeEncheres);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				} else {
					// si aucun article correspondant
					String messageAucunResultat = "Vous n'avez actuellement aucun article en vente !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} 
		}



		//




		// rechercher ventes en cours de l'utilisateur connect�
		if (! request.getParameter("venteEnCours").isEmpty()) {
			try {
				listeArticlesEnVente = DAOFactory.getArticleDAO().rechercheVentesEnCoursParUtilisateur(noUtilisateurConnecte);

				// affiche article
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				} else {
					// si aucun article correspondant
					String messageAucunResultat = "Vous n'avez actuellement aucun article en vente !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}

		// rechercher ventes non d�but�es de l'utilisateur connect�
		if (! request.getParameter("ventesNonDebutees").isEmpty()) {
			try {
				listeArticlesEnVente = DAOFactory.getArticleDAO().rechercheVentesNonDebuteesParUtilisateur(noUtilisateurConnecte);

				// affiche article
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				} else {
					// si aucun article correspondant
					String messageAucunResultat = "Aucune vente en attente n'a �t� trouv� !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}

		// rechercher ventes termin�es de l'utilisateur connect�
		if (! request.getParameter("ventesTermin�es").isEmpty()) {
			try {
				listeArticlesEnVente = DAOFactory.getArticleDAO().rechercheVentesTermineesParUtilisateur(noUtilisateurConnecte);

				// affiche article
				if (listeArticlesEnVente != null) {
					request.setAttribute("listeArticlesEnVente", listeArticlesEnVente);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				} else {
					// si aucun article correspondant
					String messageAucunResultat = "Aucune vente en attente n'a �t� trouv� !";
					request.setAttribute("messageAucunResultat", messageAucunResultat);
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
				}
			} catch (DALException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}









	}

}
