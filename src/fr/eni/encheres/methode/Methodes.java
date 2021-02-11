package fr.eni.encheres.methode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

public class Methodes {
	
	/**
	 * Cryptage du mot de passe avant enregistrement en BDD
	 * @param mdp
	 * @return
	 */
	public static String doHashing(String mdp) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			messageDigest.update(mdp.getBytes());
			
			byte[] result = messageDigest.digest();
			
			StringBuilder sb = new StringBuilder();
			
			for (byte b : result) {
				sb.append(String.format("%x", b));
			}
			mdp = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return mdp;
	}
	
	/**
	 * Conversion de la classe Date de Java en Date SQL
	 * @param date
	 * @return
	 */
	public static java.sql.Date dateJavaVersSql(java.util.Date date){
		if (date != null)
			return new java.sql.Date(date.getTime());
		else
			return null;
	}
	
	/**
	 * Conversion de Date SQL en Date Java
	 * @param date
	 * @return
	 */
	public static java.util.Date dateSQLVersJava(java.sql.Date date){
		if (date != null)
			return new java.util.Date(date.getTime());
		else
			return null;
	}
	
	/**
	 * Conversion de date récupérer en String en Date Java
	 * @param dateJSP
	 * @return
	 * @throws Exception
	 */
	public static java.util.Date dateJSPVersJava(String dateJSP) throws Exception{
		java.util.Date dateJava=null;
		if (dateJSP != null){
			try{
				dateJava = new SimpleDateFormat("yyyy-MM-dd").parse(dateJSP);
			}catch (Exception e){
				throw new Exception("Date non valide !");
			}
		}
		return dateJava;
	}
}
