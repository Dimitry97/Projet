package fr.eni.encheres.dal.utilisateur;

import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;

/**
 * Interface UtilisateurDAO pour gerer le le modele Utilisateur
 */

public interface UtilisateurDAO {

	
	
	/**
	 * M�thode abstraite pour rechercher un profil en vue de le modifier --> ressort le mot de passe
	 * @param pseudo
	 * @return
	 * @throws DALException
	 */
	Utilisateur rechercherProfilParPseudo(String pseudo)throws DALException;
	
	/**
	 * M�thode abstraite pour ajouter un utilisateur
	 * @param utilisateur
	 * @throws DALException
	 * @throws SQLException
	 */
	void inserer (Utilisateur utilisateur) throws DALException, SQLException;
	
	/**
	 * M�thode abstraite pour supprimer un utilisateur
	 * @param pseudo
	 * @throws DALException
	 * @throws SQLException
	 */
	void supprimer (Utilisateur utilisateur) throws DALException, SQLException;
	
	/**
	 * M�thode abstraite pour modifier un utilisateur
	 * @param utilisateur
	 * @throws DALException
	 * @throws SQLException
	 */
	void modifier(Utilisateur utilisateur) throws DALException,SQLException;
	
	/**
	 * M�thode v�rifiant l'existance d'une adresse mail en BDD
	 * @param mail
	 * @return
	 * @throws DALException
	 * @throws SQLException
	 */
	boolean verifMailUnique(String mail) throws DALException, SQLException;
	
	/**
	 * M�thode v�rifirnat l'existance d'un pseudo en BDD
	 * @param pseudo
	 * @return
	 * @throws DALException
	 * @throws SQLException
	 */
	public boolean verifPseudoUnique(String pseudo) throws DALException, SQLException;
	
	Utilisateur getUtilisateurPseudoMdp(String pseudo, String motDePasse) throws DALException;
}