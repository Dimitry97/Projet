package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String VUE = "/WEB-INF/creerProfil.jsp";
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
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// Recuperer les champs du formulaire
		String pseudo = request.getParameter(CHAMP_PSEUDO);
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String email = request.getParameter(CHAMP_EMAIL);
		String telephone = request.getParameter(CHAMP_TEL);
		String rue = request.getParameter(CHAMP_RUE);
		String codePostal = request.getParameter(CHAMP_RUE);
		String ville = request.getParameter(CHAMP_VILLE);
		String password = request.getParameter(CHAMP_MDP);
		String passwordVerif = request.getParameter(CHAMP_VERIF_MDP);
		
		
		
		int credit = 100;
		boolean admin = false;
		UtilisateurDAO utilisateurDAO ;
		
		boolean verifOk = false;
		
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
		
		try {
			
			validationPseudo(pseudo);
			validationNom(nom);
			validationPrenom(prenom);
			validationEmail(email);
			validationTelephone(telephone);
			validationRue(rue);
			validationCodePostal(codePostal);
			validationVille(ville);
			validationPassword(password, passwordVerif);
			verifOk = true;
		} catch (Exception e){
			throw new ServletException("Erreur sur un des champs" + e.getMessage());
		}
		
		if(verifOk) {
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, password, credit, admin);
			
			try {
				utilisateurDAO.inserer(utilisateur);
				System.out.println("utilisateur ajouté");
				request.getRequestDispatcher("/WEB-INF/jsp/listeEncheresConnecte.jsp").forward(request, response);
			} catch (DALException e) {
				
			} catch (SQLException e) {
				
			}
			
		}
		
		
	}

	/**
	 * Valide le nom .
	 */
	private void validationNom( String nom ) throws Exception {
	    if ( nom != null && nom.trim().length() < 1 && nom.trim().length() > 30) {
	        throw new Exception( "Le nom d'utilisateur doit contenir entre 1 et 30 caractères." );
	        
	    }
	}
	
	/**
	 * Valide le prenom .
	 */
	private void validationPrenom( String prenom ) throws Exception {
	    if ( prenom != null && prenom.trim().length() < 1 && prenom.trim().length() > 30) {
	        throw new Exception( "Le prenom d'utilisateur doit contenir entre 1 et 30 caractères." );
	    
	    }
	}
	
	/**
	 * Valide le nom de rue .
	 */
	private void validationRue( String rue ) throws Exception {
	    if ( rue != null && rue.trim().length() < 1 && rue.trim().length() > 30) {
	        throw new Exception( "Le nom de la rue doit contenir entre 1 et 30 caractères." );
	    
	    }
	}
	
	/**
	 * Valide le nom de la ville .
	 */
	private void validationVille( String ville ) throws Exception {
	    if ( ville != null && ville.trim().length() < 1 && ville.trim().length() > 30) {
	        throw new Exception( "Le nom de la ville doit contenir entre 1 et 30 caractères." );
	    
	    }
	}
	
	/**
	 * Valide l'adresse mail saisie.
	 */
	private void validationEmail( String email ) throws Exception {
	    if ( email != null && email.trim().length() != 0 ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	private void validationPassword( String password, String passwordVerif ) throws Exception{
	    if (password != null && password.trim().length() != 0 && passwordVerif != null && passwordVerif.trim().length() != 0) {
	        if (!password.equals(passwordVerif)) {
	            throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à  nouveau.");
	        } else if (password.trim().length() < 3) {
	            throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
	        }
	    } else {
	        throw new Exception("Merci de saisir et confirmer votre mot de passe.");
	    }
	}

	/**
	 * Valide le pseudo d'utilisateur saisi.
	 */
	private void validationPseudo( String pseudo ) throws Exception {
	    if ( pseudo != null || pseudo.trim().length() < 3 && pseudo.trim().length() > 10 || pseudo.matches("[a-zA-Z0-9]+")) {
	    	System.out.println("erreur");
	        throw new Exception( "Le pseudo doit contenir au moins 3 caractÃ¨res." );
	    }
	}
	
	/**
	 * Valide le codePostal d'utilisateur saisi.
	 */
	private void validationCodePostal( String codePostal ) throws Exception {
	    if ( codePostal != null && codePostal.trim().length() > 5 ) {
	        throw new Exception( "Le code postal doit contenir 5 caractÃ¨res." );
	    }
	}
	
	/**
	 * Valide le numéro de téléphone d'utilisateur saisie. --> peut etre null
	 */
	private void validationTelephone( String telephone ) throws Exception {
	    if ( telephone.trim().length() != 0 && telephone.trim().length() != 10 && telephone.trim().length() != 12 ) {
	        throw new Exception( "Le numÃ©ro de tÃ©lÃ©phone doit contenir 10 chiffres (ou 12 avec indicatif)." );
	    }
	}

}
