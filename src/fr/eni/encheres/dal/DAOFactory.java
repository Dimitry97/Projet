package fr.eni.encheres.dal;

import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurImpl;

public class DAOFactory {

	
	public static UtilisateurDAO getUtilisateurDAO() {
		UtilisateurDAO utilisateurDAO =null;
		
		utilisateurDAO = new UtilisateurImpl();
		
		return utilisateurDAO;
	}
}
