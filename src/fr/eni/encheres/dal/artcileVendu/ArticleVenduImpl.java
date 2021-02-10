package fr.eni.encheres.dal.artcileVendu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DBConnection;

public class ArticleVenduImpl implements ArticleVenduDAO {

	private static final String AJOUTER = "insert into ARTICLES_VENDUS (nom_article, " + "description, " + "date_fin_encheres, "
			+ "prix_initial, " + "prix_vente, " + "no_utilisateur, " + "no_categorie)" + "values (?,?,?,?,?,?,?)";
	private static final String SUPPRIMER = "delete from ARTICLES_VENDUS where no_vente = ?";
	
	private static final String MODIFIER = "update ARTICLES_VENDUS set nom_article =?, description = ?, date_fin_encheres = ?, no_categorie = ? ," +
	  "where no_vente = ?";
	 
	private static final String MODIFIERPRIXVENTE = "update ARTICLES_VENDUS set prix_vente =? where no_article = ?";

	private static final String RECHERCHER = "select * from ARTICLES_VENDUS where no_article = ?";
	private static final String LISTER = "select * from ARTICLES_VENDUS ORDER BY no_article DESC";
	
	

	@Override
	public ArticleVendu selectByNo(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArticleVendu vente = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(RECHERCHER);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			// TODO : Methode a compléter
			
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
		return vente;
	}

	@Override
	public List<ArticleVendu> selectAll() throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<ArticleVendu> listVentes = new ArrayList<>();
		ArticleVendu vente = null;
		try {
			cnx = DBConnection.seConnecter();
			rs = stmt.executeQuery(LISTER);
			
			while(rs.next()) {
				Categorie categorie = new Categorie(rs.getString("libelle"));
				Utilisateur vendeur = new Utilisateur(rs.getString("pseudo"));
				Date dateDbt = rs.getDate("date_debut_enchere");
				Date dateFin = rs.getDate("date_fin_encheres");
				LocalDate dbtEnchere = dateDbt.toLocalDate();
				LocalDate finEnchere = dateFin.toLocalDate();
				Retrait retrait = new Retrait(rs.getInt("no_retrait"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
				vente = new ArticleVendu(rs.getInt("no_article"),
								  rs.getString("nom_article"),
								  rs.getString("description"),
								  dbtEnchere,
								  finEnchere,
								  rs.getInt("prix_initial"),
								  rs.getInt("prix_vente"),
								  categorie,
								  retrait,
								  vendeur);
				listVentes.add(vente);
				
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
		return listVentes;

	}

	@Override
	public void update(ArticleVendu data) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		cnx = DBConnection.seConnecter();
		try {
			stmt = cnx.prepareStatement(MODIFIER);
			stmt.setString(1, data.getNomArticle());
			stmt.setString(2, data.getDescription());
			stmt.setDate(3, Date.valueOf(data.getDateDebutEncheres()));
			stmt.setInt(4, data.getMiseAPrix());
			stmt.setInt(5, data.getMiseAPrix());
			stmt.setInt(6, data.getVendeur().getNoUtilisateur());
			stmt.setInt(7, data.getCategorie().getNoCategorie());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la modification de l'article : " + data);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la modification de l'article : " + data);
			}
		}

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
