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
import fr.eni.encheres.methode.Methodes;

public class ArticleVenduImpl implements ArticleVenduDAO {

	private static final String AJOUTER = "INSERT INTO ARTICLES_VENDUS(nom_article, description,"
			+ " date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, no_retrait)"
			+ " VALUES(?,?,?,?,?,?,?,?,?) ;";
	private static final String SUPPRIMER = "delete from ARTICLES_VENDUS where no_vente = ?";

	private static final String MODIFIER = "UPDATE ARTICLES_VENDUS SET  nom_article=?, description=?, date_debut_encheres=?,"
			+ " date_fin_encheres=?, prix_initial=?, prix_vente=?,  no_utilisateur=?, no_categorie=?  WHERE no_article=? ";

	private static final String MODIFIERPRIXVENTE = "update ARTICLES_VENDUS set prix_vente =? where no_article = ?";

	private static final String RECHERCHER = "select * from ARTICLES_VENDUS where no_article = ?";
	private static final String LISTER = "select * from ARTICLES_VENDUS ORDER BY no_article DESC";

	@Override
	public ArticleVendu selectArticleByNo(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArticleVendu selection = new ArticleVendu();
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(RECHERCHER);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				selection.setNomArticle(rs.getString("nom_article"));
				selection.setDescription(rs.getString("description"));
				selection.setDateDebutEncheres(rs.getDate("date_debut_encheres"));
				selection.setDateFinEncheres(rs.getDate("date_fin_encheres"));
				selection.setMiseAPrix(rs.getInt("prix_initial"));
				selection.setPrixVente(rs.getInt("prix_vente"));
			} else {
				throw new DALException("Pas d'article avec ce numéro");
			}
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la selection");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
		return selection;
	}

	@Override
	public List<ArticleVendu> selectAllArticle() throws DALException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ArticleVendu> listVentes = new ArrayList<>();
		ArticleVendu vente = null;
		try {
			cnx = DBConnection.seConnecter();
			rs = stmt.executeQuery(LISTER);

			while (rs.next()) {
				Categorie categorie = new Categorie(rs.getString("libelle"));
				Utilisateur vendeur = new Utilisateur(rs.getString("pseudo"));
				Date dbtEnchere = rs.getDate("date_debut_enchere");
				Date finEnchere = rs.getDate("date_fin_encheres");
				
				Retrait retrait = new Retrait(rs.getInt("no_retrait"), rs.getString("rue"), rs.getString("code_postal"),
						rs.getString("ville"));
				vente = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), dbtEnchere, finEnchere, rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), categorie, retrait, vendeur);
				listVentes.add(vente);

			}
		} catch (SQLException e) {
			throw new DALException("Erreur lors de la selection");
		} finally {
			DBConnection.seDeconnecter(cnx, stmt);
		}
		return listVentes;

	}

	@Override
	public void modifArticle(ArticleVendu article) throws DALException, SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		
		try {
			cnx = DBConnection.seConnecter();
			cnx.setAutoCommit(false);
			stmt = cnx.prepareStatement(MODIFIER);
			
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, Methodes.dateJavaVersSql(article.getDateFinEncheres()));
			stmt.setDate(4, Methodes.dateJavaVersSql(article.getDateFinEncheres()));
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getVendeur().getNoUtilisateur());
			stmt.setInt(8, article.getCategorie().getNoCategorie());
			stmt.setInt(9, article.getNoArticle());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("Erreur lors de la modification de l'article");
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, stmt);
		}

	}

	@Override
	public ArticleVendu nouvelArticle(ArticleVendu article) throws DALException, SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		
		try {
			cnx = DBConnection.seConnecter();
			cnx.setAutoCommit(false);
			
			stmt = cnx.prepareStatement(AJOUTER, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, Methodes.dateJavaVersSql(article.getDateFinEncheres()));
			stmt.setDate(4, Methodes.dateJavaVersSql(article.getDateFinEncheres()));
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getVendeur().getNoUtilisateur());
			stmt.setInt(8, article.getCategorie().getNoCategorie());
			stmt.setInt(9, article.getLieuRetrait().getNoRetrait());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}
		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("Erreur lors de l'ajout du nouvel article");
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, stmt);
		}
		return article;
	}

	@Override
	public void suppArticle(int no) throws DALException, SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;

		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(SUPPRIMER);

			stmt.setInt(1, no);

			stmt.executeUpdate();

		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("erreur suppression article");
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, stmt);
		}

	}

	@Override
	public void modifierPrixVente(ArticleVendu articleVendu, int proposition) throws DALException, SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		try {
			cnx = DBConnection.seConnecter();
			stmt = cnx.prepareStatement(MODIFIERPRIXVENTE);
			stmt.setInt(1, proposition);
			stmt.setInt(2, articleVendu.getNoArticle());
			stmt.executeUpdate();
		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("erreur modification prix de vente");
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, stmt);
		}

	}
	
	
}
