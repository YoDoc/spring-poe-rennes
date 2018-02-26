package poe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

@Service
public class UserManagerService {

	@Autowired
	private UserRepository userRepository;

	
	/*
	 * 
	 * public boolean doesLoginExist (String login) {
		boolean doesLoginExist = false;
		
		if (userRepository.findByLogin(login)==null) doesLoginExist=true;
			
		return doesLoginExist;
	}
	*
	*
	*/
	
	public User signup(String login, String pwd) {
		System.out.println("Entree SignUp Service");
	
		User user = null;
		if (userRepository.findByLogin(login)==null) {
		
		user = new User();
		user.setLogin(login);
		user.setPwd(pwd);

		userRepository.save(user);
		
		System.out.println("sortie SignUp Service");
		}
		return user;
	}

	public List<User> creerListe() {
		List<User> liste = (List<User>) userRepository.findAll();
		return liste;
	}

	public User visualiserUser (Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	public void delete(Long userId) {
		userRepository.delete(userId);
	}

	public long count() {
		return userRepository.count();
	}

	/* Methode boolean qui ne sert a rien
	 
	public boolean singleLogin(String userLogin, String loginExistant) {
		boolean unique = false;
		if (userLogin != loginExistant) {
			unique = true;
		}
		return unique;
	}
	*/
	
	
	
	
}
