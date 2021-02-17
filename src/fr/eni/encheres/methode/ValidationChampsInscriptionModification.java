package fr.eni.encheres.methode;

public class ValidationChampsInscriptionModification {


	///////////////////////////////////////////////////////////////////
	//Ensemble des m�thodes permettant de tester la validit� des donn�es de l'utilisateur
	/**
	 * Valide le nom .
	 */
	public static void validationNom( String nom ) throws Exception {
		if(nom.trim().isEmpty()) {
			throw new Exception("Veuillez renseigner votre Nom");
		}
		if (  nom.trim().length() < 1 || nom.trim().length() > 30 ) {
			throw new Exception( "Le nom d'utilisateur doit contenir entre 1 et 30 caractères." );
		}
		if(nom.matches("[a-zA-Z'éàèê ëûüîï]*") == false) {
			throw new Exception( "Caractère interdit" );
		}
	}

	/**
	 * Valide le prenom .
	 */
	public static void validationPrenom( String prenom ) throws Exception {
		if(prenom.trim().isEmpty()) {
			throw new Exception("Veuillez renseigner votre Prénom");
		}
		if (prenom.trim().length() < 1 && prenom.trim().length() > 30) {
			throw new Exception( "Le prenom d'utilisateur doit contenir entre 1 et 30 caractères." );

		}
		if(prenom.matches("[a-zA-Z'éàèêëûüîï]*") == false) {
			throw new Exception( "Caractère interdit" );
		}
	}

	/**
	 * Valide le nom de rue .
	 */
	public static void validationRue( String rue ) throws Exception {
		if(rue.trim().isEmpty()) {
			throw new Exception("Veuillez renseigner le nom de votre rue");
		}
		if ( rue.trim().length() < 1 && rue.trim().length() > 30) {
			throw new Exception( "Le nom de la rue doit contenir entre 1 et 30 caractères." );

		}
		if(rue.matches("[a-zA-Z'éàèêëûüîï ']*") == false) {
			throw new Exception( "Caractère interdit" );
		}
	}

	/**
	 * Valide le nom de la ville .
	 */
	public static void validationVille( String ville ) throws Exception {
		if(ville.trim().isEmpty()) {
			throw new Exception("Veuillez renseigner le nom de votre Ville");
		}
		if (ville.trim().length() < 1 && ville.trim().length() > 30) {
			throw new Exception( "Le nom de la ville doit contenir entre 1 et 30 caractères." );

		}
		if(ville.matches("[a-zA-Z''éàèêëûüîï ]*") == false) {
			throw new Exception( "Caractère interdit" );
		}
	}

	/**
	 * Valide l'adresse mail saisie.
	 */
	public static void validationEmail( String email ) throws Exception {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				throw new Exception( "Merci de saisir une adresse mail valide." );
			}
		} else {
			throw new Exception( "Merci de saisir une adresse mail." );
		}
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	public static void validationPassword( String password, String passwordVerif ) throws Exception{
		if (password != null && password.trim().length() != 0 && passwordVerif != null && passwordVerif.trim().length() != 0) {
			if (!password.equals(passwordVerif)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} 
			if (password.trim().length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
		}
		if(password.trim().isEmpty() || passwordVerif.trim().isEmpty()) {
			throw new Exception ("Veuillez remplir tous les champs mot de passe");
		}
	}

	/**
	 * Valide le pseudo d'utilisateur saisi.
	 */
	public static void validationPseudo( String pseudo ) throws Exception {
		if(pseudo.trim().isEmpty()) {
			throw new Exception("Veuillez renseigner un pseudo");
		}
		if (pseudo.trim().length() < 3 ||  pseudo.trim().length() > 30 ) {
			throw new Exception( "Le pseudo doit contenir au moins 3 caractères." );
		}
		if(pseudo.matches("[a-zA-Z0-9]*") == false) {
			throw new Exception( "Caractère interdit" );
		}
	}

	/**
	 * Valide le codePostal d'utilisateur saisi.
	 */
	public static void validationCodePostal( String codePostal ) throws Exception {
		if(codePostal.trim().isEmpty()) {
			throw new Exception("Veuillez renseigner un code postal");
		}
		if (codePostal.trim().length() != 5 ) {
			throw new Exception( "Le code postal doit contenir 5 chiffres." );
		}
		if(!codePostal.matches("[0-9]*")){
			throw new Exception("lettre dans champ code postal");
		}
	}

	/**
	 * Valide le numéro de téléphone d'utilisateur saisie. --> peut etre null
	 */
	public static void validationTelephone( String telephone ) throws Exception {
		if ( telephone.trim().length() != 0 && (telephone.trim().length() != 10 && telephone.trim().length() != 12 )) {
			throw new Exception( "Le numéro de téléphone doit contenir 10 chiffres (12 avec indicatif)");
		}
	}

}
