package fr.eni.encheres.bo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestBo {

	public static void main(String[] args) {
		System.out.println(doHashing("'hrt&éàçeajzpdncàéjeaz,nqdscài"));
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


