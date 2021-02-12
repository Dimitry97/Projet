package fr.eni.encheres.bo;

import java.util.Date;

public class Enchere {

	//////////ATTRIBUTS //////////
	private int idEnchere;
	private Date dateEnchere;
	private int montantEnchere;
	
	private ArticleVendu articleVendu;
	private Utilisateur encherisseur;
	private boolean remporte = false;
	
	
	
	////////// CONSTRUCTEUR ////////// 
	
	/**
	 * Constructeur par défault ne prenant aucun parametre
	 */
	public Enchere() {
		
	}




	public Enchere(int idEnchere, Date dateEnchere, int montantEnchere, ArticleVendu articleVendu,
			Utilisateur encherisseur, boolean remporte) {
		super();
		this.idEnchere = idEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articleVendu = articleVendu;
		this.encherisseur = encherisseur;
		this.setRemporte(false);
	}




	public Enchere(Date dateEnchere, int montantEnchere, ArticleVendu articleVendu, Utilisateur encherisseur,
			boolean remporte) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articleVendu = articleVendu;
		this.encherisseur = encherisseur;
		this.setRemporte(false);
	}




	public int getIdEnchere() {
		return idEnchere;
	}

	public void setIdEnchere(int idEnchere) {
		this.idEnchere = idEnchere;
	}

	/**
	 * Methode permettant de récupérer la date des encheres effectuer par les encherisseurs
	 * @return 
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * Methode permettant de récupérer le montant de l'enchère effectuer par un encherisseur
	 * @return
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}



	/**
	 * Methode permettant de mettre a jour l'enchère effectuer par un encherisseur
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
	 * Methode parmettant de récupérer un encherisseur vendant un article
	 * @return
	 */
	public Utilisateur getUtilisateur() {
		return encherisseur;
	}
	
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	public void setUtilisateur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}

	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}

	public boolean isRemporte() {
		return remporte;
	}

	public void setRemporte(boolean remporte) {
		this.remporte = remporte;
	}
	

	
	
}
