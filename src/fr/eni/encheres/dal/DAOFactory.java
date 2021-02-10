package fr.eni.encheres.dal;

import fr.eni.encheres.dal.artcileVendu.ArticleVenduDAO;
import fr.eni.encheres.dal.artcileVendu.ArticleVenduImpl;
import fr.eni.encheres.dal.categorie.CategorieDAO;
import fr.eni.encheres.dal.categorie.CategorieImpl;
import fr.eni.encheres.dal.retrait.RetraitDAO;
import fr.eni.encheres.dal.retrait.RetraitImpl;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurImpl;

public class DAOFactory {

	
	public static UtilisateurDAO getUtilisateurDAO() {
		UtilisateurDAO utilisateurDAO =null;
		
		utilisateurDAO = new UtilisateurImpl();
		
		return utilisateurDAO;
	}
	
	public static ArticleVenduDAO getArticleDAO() {
		ArticleVenduDAO articleDAO = null;
		
		articleDAO = new ArticleVenduImpl();
		
		return articleDAO;
	}
	
	public static CategorieDAO getCategorieDAO() {
		CategorieDAO categorieDAO = null;
		
		categorieDAO = new CategorieImpl();
		
		return categorieDAO;
	}
	
	public static RetraitDAO getRetraitDAO() {
		RetraitDAO retraitDAO = null;
		
		retraitDAO = new RetraitImpl();
		
		return retraitDAO;
	}
	
}
