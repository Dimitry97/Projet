package fr.eni.encheres.dal.artcileVendu;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;

public interface ArticleVenduDAO {

	//SÃ©lectionner un article par son noArticle
	public ArticleVendu selectArticleByNo(int id) throws DALException; //
	
	//SÃ©lectionner tous les articles 
	public List<ArticleVendu> selectAllArticle() throws DALException; //
	
	//Modifier les attributs d'un article connu en BDD
	public void modifArticle(ArticleVendu data) throws DALException, SQLException; //
	
	//InsÃ©rer un nouvel article a vendre en BDD
	public ArticleVendu nouvelArticle(ArticleVendu data) throws DALException, SQLException; //
	
	//Supprimer un article en vente en BDD
	public void suppArticle(int id) throws DALException, SQLException; //
	
	// Modifier le prix de vente en fonction des propositions
	public void modifierPrixVente (ArticleVendu articleVendu, int proposition) throws DALException, SQLException; //

	// recherche d'un article par mot clé
	public List<ArticleVendu> rechercheParMotCle(String nomArticleRecherche) throws DALException, SQLException;

	// recherche d'un article par categorie
	public List<ArticleVendu> rechercheParNoCategorie(int noCategorieChoisie) throws DALException, SQLException;

	// recherche d'un article par mot clé et categorie
	public List<ArticleVendu> rechercheParMotCleEtCategorie(String nomArticleRecherche, int noCategorieChoisie) throws DALException, SQLException;
	
	

}
