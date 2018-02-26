package poe.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.domain.User;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerServiceTests {

	@Autowired
	UserManagerService userManagerService;

	@Test
	public void checkUserCreation() {

		// enregistre un nouvel utilisateur en BDD
		User newUser = userManagerService.signup("John", "ea3sy");
		System.out.println("User crée: \n id: " + newUser.getId() + "\n login: " + newUser.getLogin() + "\n password: "
				+ newUser.getPwd() + "\n  ");
		
		// Test que ce user n'est pas nul
		assertThat(newUser).isNotNull();

		// Visualise le user créé.
		userManagerService.visualiserUser(newUser.getId());
		System.out.println(userManagerService.visualiserUser(newUser.getId()));
	}

	@Test
	public void checkdelete() {
		// enregistre un nouvel utilisateur en BDD
		User newUser2 = userManagerService.signup("Joe", "Bo");
		System.out.println("User crée: \n id: " + newUser2.getId() + "\n login: " + newUser2.getLogin() + "\n password: "
				+ newUser2.getPwd() + "\n  ");

		// Appel de la methode delete sur cet user
		userManagerService.delete(newUser2.getId());
		System.out.println("test de delete, user: " + userManagerService.visualiserUser(newUser2.getId()));

		// Test du resultat de Delete
		assertThat(userManagerService.visualiserUser(newUser2.getId())).isNull();

	}

	
}
