package poe.spring.delegate;

import poe.spring.repository.UserRepository;

public class LoginCreationDelegate {
	/*
	 * 
	 * 
	 * 
	 */

	// ce sont des constantes, variable qui sont static donc Finales aussi (obligé)
	public static final int MIN_LOGIN_LENGTH = 4;
	public static final int MAX_LOGIN_LENGTH = 10;

	// Constante tableau de String comprenant 3 login non acceptés
	public static final String[] FORBIDDEN_LOGIN = { "toto", "tata", "titi" };

	// Boolean methode de test de taille
	public static boolean isSizeValid(String login) {

		boolean isValid;

		isValid = login.length() >= MIN_LOGIN_LENGTH && login.length() <= MAX_LOGIN_LENGTH;
		return isValid;
	}

	/*
	 * Autre facon d'ecrire une méthode boolean, retour directement la valeur :
	 * 
	 * public static boolean isSizeValid2(String login) { return login.length() >=
	 * MIN_LOGIN_LENGTH && login.length() <= MAX_LOGIN_LENGTH; }
	 * 
	 */

	// Boolean methode de test de string valide
	public static boolean isAuthorized(String login) {

		boolean isAuthorized = true;

		for (int i = 0; i < FORBIDDEN_LOGIN.length && isAuthorized; i++) {
			if (FORBIDDEN_LOGIN[i].equals(login)) {
				isAuthorized = false;
			}
		}
		return isAuthorized;
	}

}
