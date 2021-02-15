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
 * Servlet implementation class AfficherOuModifierProfilServlet
 */
@WebServlet("/SupprimerOuModifierProfilServlet")
public class SupprimerOuModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String CHAMP_PSEUDO = "pseudo";
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_PRENOM = "prenom";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_TEL = "telephone";
	public static final String CHAMP_RUE = "rue";
	public static final String CHAMP_CP = "codePostal";
	public static final String CHAMP_VILLE = "ville";
	public static final String CHAMP_MDP = "motDePasse";
       
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
		
		UtilisateurDAO utilisateurDAO ;		
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
		Utilisateur utilisateur = new Utilisateur();
		
		
		String action = request.getParameter("action");
		if (action.equals("Update")) { /////////////////UPDATE
		    System.out.println("Updte btn pressed");
		    
		    
		    utilisateur.setPseudo(request.getParameter("pseudo"));
		    utilisateur.setNom(request.getParameter("nom"));
		    utilisateur.setPrenom(request.getParameter("prenom"));
		    utilisateur.setEmail(request.getParameter("email"));
		    utilisateur.setTelephone(request.getParameter("telephone"));
		    utilisateur.setRue(request.getParameter("rue"));
		    utilisateur.setCodePostal(request.getParameter("codePostal"));
		    utilisateur.setVille(request.getParameter("ville"));
		    utilisateur.setMotDePasse(request.getParameter("password"));
		    
		    System.out.println("modif" + utilisateur);
		    try {
				utilisateurDAO.modifier(utilisateur);
			} catch (DALException e) {
				System.out.println("echec modif DALException");
			} catch (SQLException e) {
				System.out.println("echec modif SQLException");
			}
		    
		}else{//////////////////////////////////////////DELETE
		    System.out.println("Dlt btn pressed");
		}
	}

}
