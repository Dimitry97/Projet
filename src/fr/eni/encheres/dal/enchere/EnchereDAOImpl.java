package fr.eni.encheres.dal.enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.DBConnection;
import fr.eni.encheres.dal.artcileVendu.ArticleVenduDAO;
import fr.eni.encheres.dal.artcileVendu.ArticleVenduImpl;
import fr.eni.encheres.dal.utilisateur.UtilisateurDAO;
import fr.eni.encheres.dal.utilisateur.UtilisateurImpl;
import fr.eni.encheres.methode.Methodes;

public class EnchereDAOImpl implements EnchereDAO {

	private static final String INSERT = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur, remporte) VALUES(?,?,?,?,?)";
	private static final String GET_ALL = "SELECT * FROM ENCHERES";
	private static final String UPDATE = "UPDATE ENCHERES SET date_enchere=?, montant_enchere=?,"
			+ "no_article=?, no_utilisateur=?, remporte=? WHERE no_enchere=?";
	private static final String DELETE = "DELETE ENCHERES WHERE no_enchere=?";
	private static final String GET_BY_ENCHERISSEUR = "SELECT * FROM ENCHERES WHERE no_utilisateur=?";
	private static final String GET_REMPORTES_PAR_ENCHERISSEUR = "SELECT * FROM ENCHERES WHERE no_utilisateur=? AND remporte=?";

	@Override
	public void inserer(Enchere enchere) throws DALException, SQLException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
        try {
        	cnx = DBConnection.seConnecter();
        	cnx.setAutoCommit(false);
			stmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			  stmt.setDate(1, Methodes.dateJavaVersSql(enchere.getDateEnchere()));
		        stmt.setInt(2, enchere.getMontantEnchere());
		        stmt.setInt(3, enchere.getArticleVendu().getNoArticle());
		        stmt.setInt(4, enchere.getEncherisseur().getNoUtilisateur());
		        stmt.setBoolean(5, enchere.isRemporte());
		       
		        stmt.executeUpdate();
		        
		        rs = stmt.getGeneratedKeys();
		        
		        if (rs.next()) {
					enchere.setIdEnchere(rs.getInt(1));
		        }
		} catch (SQLException e) {
			cnx.rollback();
			throw new DALException("Erreur lors de l'ajout du l'enchere ");
		} finally {
			cnx.setAutoCommit(true);
			DBConnection.seDeconnecter(cnx, stmt);
		}
        
      
		}

	@Override
	public List<Enchere> getAll() throws DALException {
		List<Enchere> list = new ArrayList<>();
		Connection cnx = null;
		cnx = DBConnection.seConnecter();
		
		 
	
		return list;
	}

	@Override
	public void update(Enchere enchere) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Enchere> getByEncherisseur(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getRemportesParEncherisseur(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
