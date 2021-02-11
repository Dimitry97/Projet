package fr.eni.encheres.dal.utilisateur;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Interface UtilisateurDAO pour gerer le le modele Utilisateur
 */

public interface UtilisateurDAO {

	
	
	/**
	 * Methode abstraite pour rechercher un profil en vue de le modifier --> ressort le mot de passe
	 * @param pseudo
	 * @return
	 * @throws DALException
	 */
	Utilisateur rechercherProfilParPseudo(String pseudo)throws DALException;
	
	/**
	 * Methode abstraite pour ajouter un utilisateur
	 * @param utilisateur
	 * @throws DALException
	 * @throws SQLException
	 */
	void inserer (Utilisateur utilisateur) throws DALException, SQLException;
	
	/**
	 * Methode abstraite pour supprimer un utilisateur
	 * @param pseudo
	 * @throws DALException
	 * @throws SQLException
	 */
	void supprimer (Utilisateur utilisateur) throws DALException, SQLException;
	
	/**
	 * Methode abstraite pour modifier un utilisateur
	 * @param utilisateur
	 * @throws DALException
	 * @throws SQLException
	 */
	void modifier(Utilisateur utilisateur) throws DALException,SQLException;

	void getUtilisateurPseudoMdp(String pseudo, String motDePasse) throws DALException;
	
	
}