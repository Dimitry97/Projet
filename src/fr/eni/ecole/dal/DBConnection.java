package fr.eni.ecole.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {

	/**
	 * Methode pour obtenir une connection à la BDD par la pool de connection
	 * @return une instance de type Connection
	 * @throws DALException
	 * 
	 */
	
	public static Connection seConnecter() throws DALException{
		Connection cnx = null;
		InitialContext jndi = null;
		DataSource ds = null;
		
		
		try {
			jndi = new InitialContext();
		} catch (NamingException e) {
			throw new DALException("Erreur accés contexte initial JNDI - " + e.getMessage());
		}
		
		try {
			ds = (DataSource) jndi.lookup("java:comp/env/Encheres_cnx");
		} catch (NamingException e) {
			throw new DALException("Objet introuvable dans l'arbre JNDI - " + e.getMessage());
		}
		
		try {
			cnx = ds.getConnection();
			return cnx;
		} catch (SQLException e) {
			throw new DALException("Connexion impossible - " + e.getMessage());
		}		
		
		
	}
	
	/**
	 * Méthode pour libérer connection et la remettre dans la pool de connection
	 * @param cnx -une instance de Connection
	 * @throws DALException
	 */
	
	public static void seDeconnecter(Connection cnx) throws DALException{
		
		try {
			cnx.close();
		} catch (SQLException e1) {
			throw new DALException("Fermeture de la connection impossible - " + e1.getMessage());
		}
		
	}
	
	/**
	 * Methode surchargée pour liberer la connexion et la remettre dans le pool de connexion en fermant le statement
	 * @param cnx - une instance de Connection
	 * @param stmt - une instance de Statement
	 * @throws DALException
	 */
	public static void seDeconnecter(Connection cnx, Statement stmt) throws DALException{
		
		try {
			stmt.close();
		} catch (SQLException e1) {
			throw new DALException("Impossible d'obtenir le Statement : "+e1.getMessage());
		}
		seDeconnecter(cnx);
	}
	
	
	/**
	 * Méthode surchargée pour liberer la connexion et  la remettre dans la pool de connection en fermant le PreparedStatement
	 * @param cnx - une instance de Connection
	 * @param pstmt - une instance de PreparedStatement
	 * @throws DALException
	 */
	public static void seDeconnecter(Connection cnx, PreparedStatement pstmt) throws DALException{
		
		try {
			pstmt.close();
		} catch (SQLException e1) {
			throw new DALException("Impossible d'obtenir le PreparedStatement -" + e1.getMessage());
		}
		seDeconnecter(cnx);
	}
}
