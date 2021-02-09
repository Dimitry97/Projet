package fr.eni.encheres.bo;

import java.util.List;

public class Utilisateur {
	
	////////// ATTRIBUTS //////////
	
	private String noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;
	
	private List<ArticleVendu> articleVendu;
	private List<Enchere> enchere;
	
	////////// CONSTRUCTEURS //////////
	
	/**
	 * Constructeur par défault ne prenant aucun parametre
	 */
	public Utilisateur() {
		
	}
	/**
	 * Constructeur avec tous les parametres necessaire a la creation d'un utilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	
	/**
	 * Constructeur avec tous les parametres OBLIGATOIRE a la creation d'un utilisateur
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 * @param articleVendu
	 * @param enchere
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String rue,
			String codePostal, String ville, String motDePasse, int credit, boolean administrateur,
			List<ArticleVendu> articleVendu, List<Enchere> enchere) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.articleVendu = articleVendu;
		this.enchere = enchere;
	}


	////////// GETTERS AND SETTERS ////////// 
	

	/**
	 * Methode permettant de récupérer le numero de l'utilisateur
	 * @return le numero de l'utilisateur
	 */
	public String getNoUtilisateur() {
		return noUtilisateur;
	}

	/**
	 * Methode permettant de recuperer le pseudo de l'utilisateur
	 * @return le pseudo de l'utilisateur
	 */
	public String getPseudo() {
		return pseudo;
	}


	/**
	 * Methode permettant de modifier le pseudo de l'utilisateur
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	/**
	 * Methode permettant de recuperer le nom de l'utilisateur
	 * @return
	 */
	public String getNom() {
		return nom;
	}


	/**
	 *  Methode permettant de modifier le nom de l'utilisateur
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * Methode permettant de recuperer le prenom de l'utilisateur
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 *  Methode permettant de modifier le prenom de l'utilisateur
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * Methode permettant de recuperer l'email de l'utilisateur
	 * @return
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Methode permettant de modifier l'email de l'utilisateur
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * Methode permettant de recuperer le numero de l'utilisateur
	 * @return
	 */
	public String getTelephone() {
		return telephone;
	}


	/**
	 * Methode permettant de modifier le numero de telephone de l'utilisateur
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	/**
	 * Methode permettant de recuperer la rue ou habite l'utilisateur
	 * @return
	 */
	public String getRue() {
		return rue;
	}


	/**
	 * Methode permettant de modifier la rue ou l'habite de l'utilisateur
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}


	/**
	 * Methode permettant de recuperer le code postal de l'utilisateur
	 * @return
	 */
	public String getCodePostal() {
		return codePostal;
	}


	/**
	 * Methode permettant de modifier le code postal de l'utilisateur
	 * @param codePostal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	/**
	 * Methode permettant de recuperer la ville d'habitation de l'utilisateur
	 * @return
	 */
	public String getVille() {
		return ville;
	}


	/**
	 * Methode permettant de modifier la ville d'habitation de l'utilisateur
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}


	/**
	 * Methode permettant de recuperer le mot de passe de l'utilisateur (afin de vérifier qu'il est différent en cas de modification)
	 * @return
	 */
	public String getMotDePasse() {
		return motDePasse;
	}


	/**
	 * Methode permettant de modifier le mot de passe de l'utilisateur
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	/**
	 * Methode permettant de recuperer le credit disponible de l'utilisateur
	 * @return
	 */
	public int getCredit() {
		return credit;
	}


	/**
	 * Methode permettant de modifier le credit disponible de l'utilisateur
	 * @param credit
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}


	/**
	 * Methode permettant de savoir si l'utilisateur est administrateur ou pas
	 * @return
	 */
	public boolean isAdministrateur() {
		return administrateur;
	}


	/**
	 * Methode permettant dajouter les droits d'administrateur a l'utilisateur
	 * @param administrateur
	 */
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}


	/**
	 * Methode permettant de recuperer la liste des article vendu par l'utilisateur
	 * @return
	 */
	public List<ArticleVendu> getArticleVendu() {
		return articleVendu;
	}


	/**
	 * Methode permettant d'ajouter un article a liste des articles vendus par l'utilisateur
	 * @param articleVendu
	 */
	public void setArticleVendu(List<ArticleVendu> articleVendu) {
		this.articleVendu = articleVendu;
	}


	/**
	 * Methode permettant de recuperer la liste des enchères réalisées par l'utilisateur
	 * @return
	 */
	public List<Enchere> getEnchere() {
		return enchere;
	}


	/**
	 * Methode permettant d'ajouter une enchere à la liste des enchères réalisées par l'utilisateur
	 * @param enchere
	 */
	public void setEnchere(List<Enchere> enchere) {
		this.enchere = enchere;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur \nnoUtilisateur: ");
		builder.append(noUtilisateur);
		builder.append("\n");
		builder.append("Pseudo : ");
		builder.append(pseudo);
		builder.append("\n");
		builder.append("Nom : ");
		builder.append(nom);
		builder.append("\n");
		builder.append("Prenom : ");
		builder.append(prenom);
		builder.append("\n");
		builder.append("Email : ");
		builder.append(email);
		builder.append("\n");
		builder.append("Telephone : ");
		builder.append(telephone);
		builder.append("\n");
		builder.append("Rue ");
		builder.append(rue);
		builder.append("\n");
		builder.append(codePostal);
		builder.append("\n");
		builder.append(ville);
		builder.append("\n");
		builder.append("Credit : ");
		builder.append(credit);
		builder.append("\n");
		builder.append("Administrateur : ");
		builder.append(administrateur);
		builder.append("\n");
		builder.append("Articles Vendus : ");
		builder.append(articleVendu);

		return builder.toString();
	}
	
	
	
}
