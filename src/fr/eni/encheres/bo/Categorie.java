package fr.eni.encheres.bo;

import java.util.List;

public class Categorie {

	//////////ATTRIBUTS //////////
	
	private int noCategorie;
	private String libelle;
	
	private List<ArticleVendu> articleVendu;
	
	////////// CONSTRUCTEUR //////////
	
	/**
	 * Constructeur par défault ne prenant aucun parametre
	 */
	public Categorie() {
		
	}
	
	/**
	 * Constructeur permettant de créer une catégorie
	 * @param noCategorie
	 * @param libelle
	 * @param articleVendu
	 */
	public Categorie(int noCategorie, String libelle, List<ArticleVendu> articleVendu) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.articleVendu = articleVendu;
		
	}



	/**
	 * Methode permettant de récupérer l'id d'une catégorie
	 * @return
	 */
	public int getNoCategorie() {
		return noCategorie;
	}


	/**
	 * Methode permettant de récupérer le libelle d'une catégorie
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}



	/**
	 * Methode permettant de modifier le libelle d'une catégorie
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	/**
	 * Methode permettant de récupérer la liste d'article appartenant a une catégorie
	 * @return
	 */
	public List<ArticleVendu> getArticleVendu() {
		return articleVendu;
	}
	
	
	
	
}
