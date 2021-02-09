package fr.eni.encheres.dal.artcileVendu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DBConnection;

public class ArticleVenduImpl implements ArticleVenduDAO {

	private static final String AJOUTER = "insert into VENTES (nom_article, " + "description, " + "date_fin_encheres, "
			+ "prix_initial, " + "prix_vente, " + "no_utilisateur, " + "no_categorie)" + "values (?,?,?,?,?,?,?)";
	private static final String SUPPRIMER = "delete from VENTES where no_vente = ?";
	
	private static final String MODIFIER = "update VENTES set nom_article =?, description = ?, date_fin_encheres = ?, no_categorie = ? ," +
	  "where no_vente = ?";
	 
	private static final String MODIFIERPRIXVENTE = "update VENTES set prix_vente =? where no_vente = ?";

	private static final String RECHERCHER = "select * from VENTES where no_vente = ?";
	private static final String LISTER = "select * from VENTES ORDER BY no_vente DESC";

	@Override
	public ArticleVendu selectByNo(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectAll() throws DALException {
		return null;
	}

	@Override
	public void update(ArticleVendu data) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(ArticleVendu data) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		cnx = DBConnection.seConnecter();
		try {
			stmt = cnx.prepareStatement(AJOUTER);
			stmt.setString(1, data.getNomArticle());
			stmt.setString(2, data.getDescription());
			// rqt.setDate(3, new LocalDate(data.getDateFinEncheres().now());
			stmt.setInt(4, data.getMiseAPrix());
			stmt.setInt(5, data.getMiseAPrix());
			stmt.setInt(6, data.getVendeur().getNoUtilisateur());
			stmt.setInt(7, data.getCategorie().getNoCategorie());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la creation de l'article : " + data);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la creation de l'article : " + data);
			}
		}

	}

	@Override
	public void delete(int no) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DBConnection.seConnecter();
			stmt = connection.prepareStatement(SUPPRIMER);

			stmt.setInt(1, no);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Erreur lors de la suppression de l'article : " + no);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la suppression de l'article : " + no);
			}
		}

	}

	@Override
	public void modifierPrixVente(ArticleVendu articleVendu, int proposition) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(MODIFIERPRIXVENTE);
			stmt.setInt(1, proposition);
			stmt.setInt(2, articleVendu.getNoArticle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la modification du prix de vente de l'article : " + articleVendu);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la modification du prix de vente de l'article : " + articleVendu);
			}
		}

	}
}
