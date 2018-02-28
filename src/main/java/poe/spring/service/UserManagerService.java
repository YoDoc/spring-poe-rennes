package poe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import poe.spring.domain.User;
import poe.spring.repository.UserRepository;


@Service
public class UserManagerService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;

	public User signup(String login, String pwd) {
		System.out.println("Entree SignUp Service");

		User user = null;
		if (userRepository.findByLogin(login) == null) {

			user = new User();
			user.setLogin(login);
			user.setPwd(pwd);

			userRepository.save(user);

			/*
			 * Ajout de l'enregistrement du user créé dans la security
			 */

			inMemoryUserDetailsManager.createUser(new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPwd(), new ArrayList<GrantedAuthority>()));

			System.out.println("sortie SignUp Service");
		}
		return user;
	}

	public List<User> creerListe() {
		List<User> liste = (List<User>) userRepository.findAll();
		return liste;
	}

	public User visualiserUser(Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	public void delete(Long userId) {
		userRepository.delete(userId);
	}

	public long count() {
		return userRepository.count();
	}

}
