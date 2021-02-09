package fr.eni.encheres.dal.categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DBConnection;

public class CategorieImpl implements CategorieDAO {
	
	private static final String AJOUTER = "insert into CATEGORIES libelle values (?)";
	private static final String SUPPRIMER = "delete from CATEGORIES where no_categorie = ?";
	private static final String MODIFIER = "update CATEGORIES set libelle =? where no_categorie = ?";
	private static final String RECHERCHER = "select * from CATEGORIES where no_categorie = ?";
	private static final String LISTER 	="select * from CATEGORIES ";	

	@Override
	public void ajouter(Categorie categorie) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(AJOUTER);
			stmt.setString(1, categorie.getLibelle());
			stmt.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de l'ajouter du libelle");
		}finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("Erreur lors de l'ajouter du libelle");
			}
		}
	}

	@Override
	public void modifier(Categorie categorie) throws DALException {
		Connection cnx =  null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt =cnx.prepareStatement(MODIFIER);
			stmt.setString(1, categorie.getLibelle());
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la modification du libelle");
		}finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la modification du libelle");
			}
		}
	}

	@Override
	public int supprimer(Categorie categorie) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		int nbSupprime = 0;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(SUPPRIMER);
			stmt.setString(1, categorie.getLibelle());
			nbSupprime =stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de suppession du libelle");
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("Erreur lors de suppression du libelle");
			}
		}
		return nbSupprime;
	}

	@Override
	public ArrayList<Categorie> lister() throws DALException {
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Categorie> listeCategorie = new ArrayList<Categorie>();
		try {
			cnx= DBConnection.seConnecter();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(LISTER);
			Categorie categorie;
			while (rs.next()) {
				categorie = new Categorie(rs.getInt("no_Categorie"),rs.getString("libelle"));
				listeCategorie.add(categorie);
			} 
		} catch (SQLException e) {
				throw new DALException("Erreur lors de la creation de la liste des catégories");
			} try {
					if (stmt != null) {
						stmt.close();
					}
					if (cnx != null) {
						cnx.close();
					}
				} catch (SQLException e) {
					throw new DALException("Erreur lors de la creation de la liste des catégories");
				}
		return listeCategorie;
	}
		
	@Override
	public Categorie recherche(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Categorie categorie = null;
		try {
			cnx =DBConnection.seConnecter();
			stmt =cnx.prepareStatement(RECHERCHER);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (categorie == null) categorie = new Categorie();
				categorie.setNoCategorie(Integer.parseInt(rs.getString("no_categorie")));
				categorie.setLibelle(rs.getString("libelle"));
			} 
		} catch (SQLException e) {
				throw new DALException("Erreur lors de la recherche avec : " + id);
			} try {
					if (stmt != null) {
						stmt.close();
					}
					if (cnx != null) {
						cnx.close();
					}
				} catch (SQLException e) {
					throw new DALException("Erreur lors de la recherche avec : " + id);
				}
		return categorie;
	}

}
