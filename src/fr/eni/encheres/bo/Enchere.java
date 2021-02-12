package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.util.Date;

public class Enchere {

	//////////ATTRIBUTS //////////
	
	private Date dateEnchere;
	private int montantEnchere;
	
	private ArticleVendu articleVendu;
	private Utilisateur utilisateur;
	
	
	////////// CONSTRUCTEUR ////////// 
	
	/**
	 * Constructeur par défault ne prenant aucun parametre
	 */
	public Enchere() {
		
	}

	/**
	 * Constructeur permettant de créer une enchère
	 * @param dateEncheres
	 * @param montantEnchere
	 * @param articleVendu
	 * @param utilisateur
	 */
	public Enchere(Date dateEnchere, int montantEnchere, ArticleVendu articleVendu, Utilisateur utilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
	}
	
	public Enchere(Date dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}



	/**
	 * Methode permettant de récupérer la date des encheres effectuer par les utilisateurs
	 * @return 
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * Methode permettant de récupérer le montant de l'enchère effectuer par un utilisateur
	 * @return
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}



	/**
	 * Methode permettant de mettre a jour l'enchère effectuer par un utilisateur
	 * @param montantEnchere
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}



	/**
	 * Methode parmettant de récupérer un article vendu
	 * @return
	 */
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}



	/**
	 * Methode parmettant de récupérer un utilisateur vendant un article
	 * @return
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
}
