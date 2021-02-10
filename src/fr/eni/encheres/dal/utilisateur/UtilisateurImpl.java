package fr.eni.encheres.dal.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DBConnection;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;

public class UtilisateurImpl implements UtilisateurDAO {

	private final static String RECHERCHER = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville FROM UTILISATEURS WHERE pseudo = '?';";
	private final static String INSERER = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, administrateur)"
			+ " values ('?','?','?','?','?','?','?','?','?','?','?');";
	private final static String SUPPRIMER = "DELETE FROM UTILISATEURS WHERE pseudo = '?';";
	private final static String MODIFIER = " UPDATE UTILISATEURS set pseudo = '?', nom = '?', prenom = '?', email = '?', telephone = '?', rue ='?',"
			+ " code_postal = '?', ville = '?', mot_de_passe = '?', administrateur = '?' WHERE no_utilisateur = '?'";
	private final static String PSEUDOMDP = "SELECT * FROM UTILISATEURS WHERE (pseudo = ? OR email = ?) AND mot_de_passe = ?";
	private final static String SELECTBYNO = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";

	/**
	 * Methode pour selectionner un utilisateur avec tous les parametres
	 * 
	 * @param pseudo
	 * @return un utilisateur
	 * @finally libere les connexions ouvertes
	 */
	@Override
	public Utilisateur rechercherProfilParPseudo(String pseudo) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = null;

		cnx = DBConnection.seConnecter();

		try {
			pstmt = cnx.prepareStatement(RECHERCHER);
			pstmt.setString(1, pseudo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			throw new DALException("echec de rechercheProfilAvecMotDePasse");
		} finally {
			DBConnection.seDeconnecter(cnx, pstmt);
		}

		return utilisateur;
	}

	/**
	 * Methode pour inserer un utilisateur
	 * 
	 * @param une instance d'utilisateur
	 * @finally libere les connexions ouvertes
	 */
	@Override
	public void inserer(Utilisateur utilisateur) throws DALException, SQLException {

		Connection cnx = null;
		PreparedStatement pstmt = null;

		cnx = DBConnection.seConnecter();
		cnx.setAutoCommit(false);

		try {
			pstmt = cnx.prepareStatement(INSERER);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.isAdministrateur());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("Probleme methode inserer - " + e);
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, pstmt);
		}

	}

	/**
	 * Methode pour supprimer un utilisateur
	 * 
	 * @param une instance d'utilisateur
	 * @finally libere les connexions ouvertes
	 */

	@Override
	public void supprimer(Utilisateur utilisateur) throws DALException, SQLException {
		Connection cnx = null;
		PreparedStatement pstmt = null;

		cnx = DBConnection.seConnecter();
		cnx.setAutoCommit(false);

		try {
			pstmt = cnx.prepareStatement(SUPPRIMER);
			pstmt.setString(1, utilisateur.getPseudo());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("erreur suppression utilisateur");
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, pstmt);
		}

	}

	/**
	 * Methode pour modifier un utilisateur
	 * 
	 * @param une instance d'utilisateur
	 * @finally libere les connexions ouvertes
	 */
	@Override
	public void modifier(Utilisateur utilisateur) throws DALException, SQLException {
		Connection cnx = null;
		PreparedStatement pstmt = null;

		cnx = DBConnection.seConnecter();
		cnx.setAutoCommit(false);

		try {
			pstmt = cnx.prepareStatement(MODIFIER);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, utilisateur.isAdministrateur());
			pstmt.setInt(12, utilisateur.getNoUtilisateur());
		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("erreur modification utilisateur");
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, pstmt);
		}

	}
	
	public Utilisateur getUtilisateurPseudoMdp(String login, String motDePasse) throws DALException {
		Utilisateur unUtilisateur = new Utilisateur();
		Connection cnx = null;
		PreparedStatement pstmt = null;

		cnx = DBConnection.seConnecter();
		
		try {
			 pstmt = cnx.prepareStatement(PSEUDOMDP);
			 pstmt.setString(1, login);
			 pstmt.setString(2, login);
			 pstmt.setString(3, motDePasse);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
            	unUtilisateur = getUtilisateurByNo(rs.getInt("no_utilisateur"));
            }
		}
		catch (SQLException e) {
			throw new DALException("Erreur recherche mot de passe et pseudo");
		} finally {
			DBConnection.seDeconnecter(cnx, pstmt);
		}
		
		
		return unUtilisateur;
	}
	
	public Utilisateur getUtilisateurByNo(int no) throws DALException {
		Utilisateur unUtilisateur = new Utilisateur();
		Connection cnx = null;
		PreparedStatement pstmt = null;

		cnx = DBConnection.seConnecter();
		
		try {
			pstmt = cnx.prepareStatement(SELECTBYNO);
			pstmt.setInt(1, no);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next())
            {
            	unUtilisateur = creerUtilisateur(rs);
            }
		}
		catch (SQLException e) {
			throw new DALException("echec de récupération utilisateur");
		} finally {
			DBConnection.seDeconnecter(cnx, pstmt);
		}
		
		return unUtilisateur;
	}

	public Utilisateur creerUtilisateur(ResultSet rs) throws SQLException {

		Utilisateur resultat = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
				rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
				rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"),
				rs.getBoolean("administrateur"));

		return resultat;
	}
}
