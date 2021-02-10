package fr.eni.encheres.bo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.DBConnection;
import fr.eni.encheres.dal.categorie.CategorieImpl;

public class TestBo {

	public static void main(String[] args) {
		System.out.println(doHashing("'hrt&éàçeajzpdncàéjeaz,nqdscài"));
		
		List<Categorie> listeCategories = new ArrayList<>();
		
		
	}
		
		public int selectArticleByNo(String libelle) throws DALException {
			Connection cnx = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArticleVendu selection = new ArticleVendu();
			int noCat;
			try {
				cnx = DBConnection.seConnecter();
				stmt = cnx.prepareStatement("");
				stmt.setString(1, libelle);
				rs = stmt.executeQuery();
				if (rs.next()) {
					
					selection.setMiseAPrix(rs.getInt("prix_initial"));
					
					noCat = selection.getMiseAPrix();
					
				} else {
					throw new DALException("Pas d'article avec ce numéro");
				}
			} catch (SQLException e) {
				throw new DALException("Erreur lors de la selection");
			} finally {
				DBConnection.seDeconnecter(cnx, stmt);
			}
			return noCat;
		}

	private static String doHashing(String mdp) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			messageDigest.update(mdp.getBytes());
			
			byte[] result = messageDigest.digest();
			
			StringBuilder sb = new StringBuilder();
			
			for (byte b : result) {
				sb.append(String.format("%x", b));
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

} 
// b8f6a049eeb602be9a5befde206af -> Mot de passe
// ffba2fdd52f559322a932da6f6d3d20 -> AAAAAAAAAAAJDNBHTOLMPSDCNJFOTI
// 2b92a04b9d66388452f1a0e551d05539 -> 'hrt&éàçeajzpdncàéjeaz,nqdscài


