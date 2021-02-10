package fr.eni.encheres.dal.retrait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DBConnection;

public class RetraitImpl implements RetraitDAO {

	private static final String AJOUTER = "INSERT INTO RETRAITS (rue, code_postal, ville) VALUES (?,?,?)";
	private static final String SUPPRIMER = "DELETE FROM RETRAITS WHERE no_vente = ?";
	private static final String MODIFIER = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_vente = ?";
	private static final String LISTER = "SELECT * FROM RETRAITS";

	@Override
	public void ajoutRetrait(Retrait retrait) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(AJOUTER);
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCodePostal());
			stmt.setString(3, retrait.getVille());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de l'ajout");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}

	}

	@Override
	public void modifRetrait(Retrait retrait) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(MODIFIER);
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCodePostal());
			stmt.setString(3, retrait.getVille());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la modification de l'ajout");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
	}

	@Override
	public ArrayList<Retrait> listerRetrait() throws DALException {
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Retrait> listeRetraits = new ArrayList<>();
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.createStatement();
			rs = stmt.executeQuery(LISTER);
			Retrait retrait;
			while (rs.next()) {
				retrait = new Retrait(rs.getInt("no_Vente"), rs.getString("rue"), rs.getString("code_postal"),
						rs.getString("ville"));
				listeRetraits.add(retrait);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
		return listeRetraits;
	}

	@Override
	public int suppRetrait(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		int nbreEnrgt = 0;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(SUPPRIMER);
			stmt.setInt(1, id);
			nbreEnrgt = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la suppression");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
		return nbreEnrgt;
	}

}
