package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.methode.ValidationChampsInscriptionModification;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String VUE = "/WEB-INF/jsp/creerProfil2.jsp";
	public static final String CHAMP_PSEUDO = "pseudo";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_TEL = "telephone";
	public static final String CHAMP_RUE = "rue";
	public static final String CHAMP_CP = "codePostal";
	public static final String CHAMP_VILLE = "ville";
    public static final String CHAMP_MDP = "password";
    public static final String CHAMP_VERIF_MDP = "passwordVerif";

	private static final String ATT_ERREURS = "erreurs";
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Afficher la page d'inscription
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Map d'erreurs
		Map<String, String> erreurs = new HashMap<String, String>();		
		
		boolean inscriptionOk;
		
		// Récupère les champs du formulaire
		String pseudo = request.getParameter(CHAMP_PSEUDO);
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String email = request.getParameter(CHAMP_EMAIL);
		String telephone = request.getParameter(CHAMP_TEL);
		String rue = request.getParameter(CHAMP_RUE);
		String codePostal = request.getParameter(CHAMP_CP);
		String ville = request.getParameter(CHAMP_VILLE);
		String password = request.getParameter(CHAMP_MDP);
		String passwordVerif = request.getParameter(CHAMP_VERIF_MDP);
		
		
		//Initialisation des crédit à 100 et admin à faux
		int credit = 100;
		boolean admin = false;
		
		UtilisateurDAO utilisateurDAO ;		
		utilisateurDAO = DAOFactory.getUtilisateurDAO();		
		
		//Test des champs rentrés par utilisateur via chaque méthode de test
		//Chaque méthode renvoit une erreur de la hasmap "erreurs" si elle en lève une
		try {
			
			try {
				ValidationChampsInscriptionModification.validationPseudo(pseudo);
			} catch (Exception e) {
				erreurs.put(CHAMP_PSEUDO, e.getMessage());
			}
			
			try {
				ValidationChampsInscriptionModification.validationNom(nom);
			} catch (Exception e) {
				erreurs.put(CHAMP_NOM, e.getMessage());
			}
			
			try {
				ValidationChampsInscriptionModification.validationPrenom(prenom);
			} catch (Exception e) {
				erreurs.put(CHAMP_PRENOM, e.getMessage());
			}
			
			try {
				ValidationChampsInscriptionModification.validationEmail(email);
			} catch (Exception e) {
				erreurs.put(CHAMP_EMAIL, e.getMessage());
			}
			
			try {
				ValidationChampsInscriptionModification.validationTelephone(telephone);
			} catch (Exception e) {
				erreurs.put(CHAMP_TEL, e.getMessage());
			}
			
			try {
				ValidationChampsInscriptionModification.validationRue(rue);
			} catch (Exception e) {
				erreurs.put(CHAMP_RUE, e.getMessage());
			}
			
			try {
				ValidationChampsInscriptionModification.validationCodePostal(codePostal);
			} catch (Exception e) {
				erreurs.put(CHAMP_CP, e.getMessage());
			}
			
			try {
				ValidationChampsInscriptionModification.validationVille(ville);
			} catch (Exception e) {
				erreurs.put(CHAMP_VILLE, e.getMessage());
			}
			
			try {
				ValidationChampsInscriptionModification.validationPassword(password, passwordVerif);
			} catch (Exception e) {
				erreurs.put(CHAMP_MDP, e.getMessage());
			}
			
			boolean verifMail = utilisateurDAO.verifMailUnique(email);
			if(verifMail) {
				erreurs.put(CHAMP_EMAIL, "Email déjà utilisé, veuillez en choisir un autre");
			}
			
			boolean verifPseudo = utilisateurDAO.verifPseudoUnique(pseudo);
			if(verifPseudo) {
				erreurs.put(CHAMP_PSEUDO, "Pseudo déjà utilisé, veuillez en choisir un autre");
			}
			
			request.setAttribute( ATT_ERREURS, erreurs );
	        
			//Redirection et chargement message echec ou réussite inscription
			if(erreurs.isEmpty()) {
				inscriptionOk = true;
			}else {
				inscriptionOk = false ;
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			}
			
			
	        
	       
		} catch (Exception e){
			throw new ServletException("Erreur sur un des champs" + e.getMessage());
		}
		
		if(inscriptionOk) {
			//Instanciation de l'utilisateur
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, password, credit, admin);
			
			//Insertion utilisateur en BDD
			try {
							
				utilisateurDAO.inserer(utilisateur);
				System.out.println("utilisateur ajouté");
				request.getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
			} catch (DALException e) {
				
			} catch (SQLException e) {
				
			}
		}
		
			
				
		
	}


}