package fr.eni.encheres.methode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptageMdp {
	
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
}
