package fr.eni.encheres.dal.artcileVendu;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;

public interface ArticleVenduDAO {

	//Sélectionner un article par son noArticle
	public ArticleVendu selectByNo(int id) throws DALException; //
	
	//Sélectionner tous les articles 
	public List<ArticleVendu> selectAll() throws DALException; //
	
	//Modifier les attributs d'un article connu en BDD
	public void update(ArticleVendu data) throws DALException; //
	
	//Insérer un nouvel article a vendre en BDD
	public void insert(ArticleVendu data) throws DALException; //
	
	//Supprimer un article en vente en BDD
	public void delete(int id) throws DALException; //
	
	// Modifier le prix de vente en fonction des propositions
	public void modifierPrixVente (ArticleVendu articleVendu, int proposition) throws DALException; //

}
