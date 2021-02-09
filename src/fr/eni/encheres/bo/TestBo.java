package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.time.ZoneId;

public class TestBo {

	public static void main(String[] args) {

		Utilisateur user1 = new Utilisateur();
		
		user1.setNom("Dimitri");
		user1.setPrenom("Germany");
		user1.setPseudo("DG");
		
		System.out.println(user1.toString());
		
		System.out.println();
		ArticleVendu article = new ArticleVendu();
		article.setDateDebutEncheres(LocalDate.now(ZoneId.of("Europe/Paris")));
		
		System.out.println(article.toString());
		
	}

}
