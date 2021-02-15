package fr.eni.encheres.servlets;

import java.io.IOException;
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

/**
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/ModifierProfilServlet")
public class AffichageModifierProfilServlet extends HttpServlet {
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
	public static final String CHAMP_CREDIT = "credit";
	public static final String ATT_RESULTAT = "champsProfil";
	
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageModifierProfilServlet() {
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
		

		//Map des valeurs des champs du profil à afficher 
		Map<String, String> champsProfil = new HashMap<String, String>();
		
		// Recuperer les champs du formulaire
		
				/////////*********************************************************************************/////////
				//////////////////
				String pseudo = "chichi2022"; // --> String de !!!TEST!!! pseudo à remplir avec pseudo user présent en BDD
				//////////////////////////// --> Methode ci-dessous à décommenter lorsque navigation terminée
				//////////////////
				/////////**********************************************************************************////////
				/**
				--> Récuperer le pseudo de la session en cours <--
				--> à modifier
				**/
				
				UtilisateurDAO utilisateurDAO ;		
				utilisateurDAO = DAOFactory.getUtilisateurDAO();
				Utilisateur utilisateur;
				try {
					utilisateur = utilisateurDAO.rechercherProfilParPseudoAvecCredit(pseudo);
					
				} catch (DALException e) {
					throw new ServletException("pseudo inexistant");
				}
				
				if(utilisateur.getTelephone().isEmpty()) {
					utilisateur.setTelephone("Aucun numéro renseigné");
				}
				
				
				champsProfil.put(CHAMP_PSEUDO, utilisateur.getPseudo());
				champsProfil.put(CHAMP_NOM, utilisateur.getNom());
				champsProfil.put(CHAMP_PRENOM, utilisateur.getPrenom());
				champsProfil.put(CHAMP_EMAIL, utilisateur.getEmail());
				champsProfil.put(CHAMP_TEL, utilisateur.getTelephone());
				champsProfil.put(CHAMP_RUE, utilisateur.getRue());
				champsProfil.put(CHAMP_CP, utilisateur.getCodePostal());
				champsProfil.put(CHAMP_VILLE, utilisateur.getVille());
				champsProfil.put(CHAMP_CREDIT, String.valueOf(utilisateur.getCredit()));
					
				request.setAttribute( ATT_RESULTAT, champsProfil );
				
				this.getServletContext().getRequestDispatcher(VUE).forward( request, response );

}
}
