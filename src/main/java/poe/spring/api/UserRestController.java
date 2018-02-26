package poe.spring.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.domain.User;
import poe.spring.service.UserManagerService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	// Je récupère le service userManagerService
	@Autowired
	UserManagerService userManagerService;

	@PostMapping
	public User save(@RequestBody User user) {
		//System.out.println("entree Save Controller");
		User savedUser = userManagerService.signup(user.getLogin(), user.getPwd());
		//System.out.println("Sortie Save controller");
		return savedUser;
	}

	@GetMapping
	public List<User> lister() {
		List<User> liste = userManagerService.creerListe();
		return liste;
	}

	// se visualise sur http://localhost:8080/api/user/3
	@GetMapping("/{userId}")
		public User visualiser(@PathVariable("userId") Long userId, HttpServletResponse response) {
//		System.out.println("entree Controller");
		User existsUser = userManagerService.visualiserUser(userId);
//		System.out.println("Sortie Controller");
		return existsUser;
	}
	
	@DeleteMapping("/{userId}")
	public void delete (@PathVariable ("userId") Long userId) {
//		System.out.println("Delete in Controller");
		userManagerService.delete(userId);
		
	}
	
	
	

}
