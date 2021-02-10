package fr.eni.encheres.dal.artcileVendu;

import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;

public interface ArticleVenduDAO {

	//Sélectionner un article par son noArticle
	public ArticleVendu selectArticleByNo(int id) throws DALException; //
	
	//Sélectionner tous les articles 
	public List<ArticleVendu> selectAllArticle() throws DALException; //
	
	//Modifier les attributs d'un article connu en BDD
	public void modifArticle(ArticleVendu data) throws DALException, SQLException; //
	
	//Insérer un nouvel article a vendre en BDD
	public void nouvelArticle(ArticleVendu data) throws DALException, SQLException; //
	
	//Supprimer un article en vente en BDD
	public void suppArticle(int id) throws DALException, SQLException; //
	
	// Modifier le prix de vente en fonction des propositions
	public void modifierPrixVente (ArticleVendu articleVendu, int proposition) throws DALException, SQLException; //

}
