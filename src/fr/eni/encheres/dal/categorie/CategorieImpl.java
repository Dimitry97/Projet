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
	private static final String LISTER = "select * from CATEGORIES ";
	private final static String RECHERCHE_CODE_CATEGORIE = "SELECT no_categorie FROM categories WHERE libelle = ?;";

	@Override
	public void ajouterNewCat(Categorie categorie) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(AJOUTER);
			stmt.setString(1, categorie.getLibelle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de l'ajouter du libelle");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
	}

	@Override
	public void modifCat(Categorie categorie) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(MODIFIER);
			stmt.setString(1, categorie.getLibelle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la modification du libelle");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
	}

	@Override
	public int suppCat(Categorie categorie) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		int nbSupprime = 0;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(SUPPRIMER);
			stmt.setString(1, categorie.getLibelle());
			nbSupprime = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de suppession du libelle");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
		return nbSupprime;
	}

	@Override
	public ArrayList<Categorie> listerCat() throws DALException {
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Categorie> listeCategorie = new ArrayList<Categorie>();
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(LISTER);
			Categorie categorie;
			while (rs.next()) {
				categorie = new Categorie(rs.getInt("no_Categorie"), rs.getString("libelle"));
				listeCategorie.add(categorie);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la creation de la liste des catégories");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
		return listeCategorie;
	}

	@Override
	public Categorie rechCatByNo(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Categorie categorie = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(RECHERCHER);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				if (categorie == null)
					categorie = new Categorie();
				categorie.setNoCategorie(Integer.parseInt(rs.getString("no_categorie")));
				categorie.setLibelle(rs.getString("libelle"));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la recherche avec : " + id);
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
		return categorie;
	}

	// ajout pour recherche no_categorie en fonction du libelle choisi par
	// l'utilisateur
	@Override
	public Categorie rechercheNoCategorie(String libelle) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Categorie categorie = null;
		int noCate = 0;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(RECHERCHE_CODE_CATEGORIE);
			stmt.setString(1, libelle);
			;
			rs = stmt.executeQuery();

			while (rs.next()) {
				if (categorie == null)
					categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(libelle);
			}

		} catch (SQLException e) {
			throw new DALException("Erreur lors de la selection");
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la selection");
			}
		}
		return categorie;
	}

}
