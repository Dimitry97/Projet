package fr.eni.encheres.dal.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DBConnection;

public class UtilisateurImpl  implements UtilisateurDAO{
	
	
	private final static String RECHERCHER = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville FROM UTILISATEURS WHERE pseudo = ?;";
	private final static String INSERER = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values (?,?,?,?,?,?,?,?,?,?,?);";
	private final static String SUPPRIMER = "DELETE FROM UTILISATEURS WHERE pseudo = ?;";
	private final static String  MODIFIER = " UPDATE UTILISATEURS set pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue =?,"
			+ " code_postal = ?, ville = ?, mot_de_passe = ?, administrateur = ? WHERE no_utilisateur = ?";
	private final static String SELECTPSEUDOANDMDP = "SELECT pseudo, mot_de_passe FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
	
	
	
	/**
	 * Methode pour selectionner un utilisateur avec tous les parametres
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
			if(rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
		} catch (SQLException e) {
			throw new DALException("echec de rechercheProfilAvecMotDePasse");
		}finally {
			DBConnection.seDeconnecter(cnx, pstmt);
		}
				
		return utilisateur;
	}
	
	/**
	 * Methode pour inserer un utilisateur
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
			
			pstmt = cnx.prepareStatement(INSERER, Statement.RETURN_GENERATED_KEYS);
			System.out.println("ici");
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
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				int noUtilisateur = rs.getInt(1);
				utilisateur.setNoUtilisateur(noUtilisateur);
			}
						
		} catch (SQLException e) {
			cnx.rollback();
			throw new SQLException("Probleme methode inserer - "+e);
		}finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, pstmt);
		}
		
		
		
		
	}
	/**
	 * Methode pour supprimer un utilisateur
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
		}finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, pstmt);
		}
		
		
		
		
	}
	
	/**
	 * Methode pour modifier un utilisateur
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

	/**
	 * Méthode vérifiant l'existance d'une adresse mail en BDD
	 * @param mail
	 * @return
	 * @throws DALException
	 * @throws SQLException
	 */
	public boolean verifMailUnique(String mail) throws DALException, SQLException{
		Connection cnx = null;
		PreparedStatement pstmt = null;
		Boolean unique = false;
		ResultSet rs = null;
		cnx = DBConnection.seConnecter();
		
		try {
			pstmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE email = ? ;");
			System.out.println("test mail");
			System.out.println(mail);
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				unique = true;
			}
			
		} catch (SQLException e) {
			throw new DALException("erreur verification mail unique");
		}finally {
			DBConnection.seDeconnecter(cnx, pstmt);
		}
		
		
		
		return unique;
	}
	
	/**
	 * Méthode vérifiant l'existance d'un pseudo en BDD
	 * @param pseudo
	 * @return
	 * @throws DALException
	 * @throws SQLException
	 */
	public boolean verifPseudoUnique(String pseudo) throws DALException, SQLException{
		Connection cnx = null;
		PreparedStatement pstmt = null;
		Boolean unique = false;
		ResultSet rs = null;
		cnx = DBConnection.seConnecter();
		
		try {
			pstmt = cnx.prepareStatement("SELECT * FROM UTILISATEURS WHERE pseudo = ? ;");
			pstmt.setString(1, pseudo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				unique = true;
			}
			
		} catch (SQLException e) {
			throw new DALException("erreur verification pseudo unique");
		}finally {
			DBConnection.seDeconnecter(cnx, pstmt);
		}
		return unique;
	
	}
	
	@Override
	public void getUtilisateurPseudoMdp(String pseudo, String motDePasse) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = null;
		
		cnx = DBConnection.seConnecter();
		try {
			pstmt = cnx.prepareStatement(SELECTPSEUDOANDMDP);
			pstmt.setString(1, pseudo);
			pstmt.setString(2, motDePasse);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("mot_de_passe"));
			}
		} catch (SQLException e) {
			throw new DALException("echec de rechercheProfilAvecMotDePasse");
		}finally {
			DBConnection.seDeconnecter(cnx, pstmt);
		}
				
	}

}
