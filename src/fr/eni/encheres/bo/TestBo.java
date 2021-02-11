package fr.eni.encheres.bo;

import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurImpl;

public class TestBo {

	public static void main(String[] args) {
	
		UtilisateurDAO user = new UtilisateurImpl();
		Utilisateur user1 = new Utilisateur();
		
		try {
			user.getUtilisateurPseudoMdp("LePanda", "bonjour");
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user);
	}
	

} 
// b8f6a049eeb602be9a5befde206af -> Mot de passe
// ffba2fdd52f559322a932da6f6d3d20 -> AAAAAAAAAAAJDNBHTOLMPSDCNJFOTI
// 2b92a04b9d66388452f1a0e551d05539 -> 'hrt&éàçeajzpdncàéjeaz,nqdscài


