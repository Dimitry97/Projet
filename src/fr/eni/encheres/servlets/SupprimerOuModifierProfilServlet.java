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
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.methode.ValidationChampsInscriptionModification;

/**
 * Servlet implementation class AfficherOuModifierProfilServlet
 */
@WebServlet("/SupprimerOuModifierProfilServlet")
public class SupprimerOuModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE = "/WEB-INF/jsp/monProfil2.jsp";
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
	public SupprimerOuModifierProfilServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		


		//Condition en fonction du choix du bouton mise à jour ou suppression
		String action = request.getParameter("action");
		if (action.equals("Update")) { //---------------------------------------->UPDATE profil

			UtilisateurDAO utilisateurDAO ;		
			utilisateurDAO = DAOFactory.getUtilisateurDAO();
			Utilisateur utilisateur = new Utilisateur();

			//Map d'erreurs
			Map<String, String> erreurs = new HashMap<String, String>();	
			boolean modifOk;
			//////////Récupération du pseudo de la session en cours
			HttpSession session = request.getSession();
			String pseudo = (String) session.getAttribute("pseudo");

			try {
				utilisateur = utilisateurDAO.rechercherProfilParPseudoAvecCredit(pseudo);

			} catch (DALException e1) {
				e1.printStackTrace();
			}
			int id = utilisateur.getNoUtilisateur();
			String emailOrigine = utilisateur.getEmail();
			String pseudoOrgine = utilisateur.getPseudo();
			String passwordOrigine = utilisateur.getMotDePasse();
			String credit = String.valueOf(utilisateur.getCredit());
			System.out.println("crdt:" + credit);
			request.setAttribute("credit", credit);
			
			// Récupère les champs du formulaire
			String pseudoChamp = request.getParameter(CHAMP_PSEUDO);
			String nom = request.getParameter(CHAMP_NOM);
			String prenom = request.getParameter(CHAMP_PRENOM);
			String email = request.getParameter(CHAMP_EMAIL);
			String telephone = request.getParameter(CHAMP_TEL);
			String rue = request.getParameter(CHAMP_RUE);
			String codePostal = request.getParameter(CHAMP_CP);
			String ville = request.getParameter(CHAMP_VILLE);
			String password = request.getParameter(CHAMP_MDP);
			String passwordVerif = request.getParameter(CHAMP_VERIF_MDP);

			//Verification de la validité des nouveux champs rentrés par l'utilisateur
			//Chaque méthode renvoit une erreur de la hasmap "erreurs" si elle en lève une
			try {

				try {
					ValidationChampsInscriptionModification.validationPseudo(pseudoChamp);
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
					erreurs.put(CHAMP_VERIF_MDP, e.getMessage());
				}

				boolean verifMail = utilisateurDAO.verifMailUnique(email);
				if(verifMail && (email.matches(emailOrigine) == false )) {
					System.out.println(verifMail);
					erreurs.put(CHAMP_EMAIL, "Email déjà utilisé, veuillez en choisir un autre");
				}

				boolean verifPseudo = utilisateurDAO.verifPseudoUnique(pseudoChamp);
				if(verifPseudo && (pseudoChamp.matches(pseudoOrgine) == false )) {
					System.out.println("verifpseudo" + verifPseudo);
					erreurs.put(CHAMP_PSEUDO, "Pseudo déjà utilisé, veuillez en choisir un autre");
				}
				
				if(password.trim().isEmpty()) {
					erreurs.put(CHAMP_MDP, "Veuillez entrer votre mot de passe");
				}else if(password != passwordOrigine) {
					erreurs.put(CHAMP_MDP, "Mot de passe erroné");
				}
				
				request.setAttribute( ATT_ERREURS, erreurs );
				//Redirection et chargement message echec ou réussite inscription
				if(erreurs.isEmpty()) {
					modifOk = true;
				}else {
					modifOk = false;
					this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
				}

			} catch (Exception e){
				throw new ServletException("Erreur sur un des champs" + e.getMessage());
			}

		if(modifOk) {
			utilisateur.setPseudo(request.getParameter("pseudo"));
			utilisateur.setNom(request.getParameter("nom"));
			utilisateur.setPrenom(request.getParameter("prenom"));
			utilisateur.setEmail(request.getParameter("email"));
			utilisateur.setTelephone(request.getParameter("telephone"));
			utilisateur.setRue(request.getParameter("rue"));
			utilisateur.setCodePostal(request.getParameter("codePostal"));
			utilisateur.setVille(request.getParameter("ville"));
			utilisateur.setMotDePasse(request.getParameter("password"));
			utilisateur.setNoUtilisateur(id);
			System.out.println(utilisateur);
			try {
				utilisateurDAO.modifier(utilisateur);

				System.out.println("après");
			} catch (DALException e) {

			} catch (SQLException e) {

			}
		}
			
			

		}else{//------------------------------------------------------------------>DELETE profil
		}
	}

}
