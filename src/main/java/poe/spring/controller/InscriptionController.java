package poe.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.domain.User;
import poe.spring.service.UserManagerService;

@Controller
@RequestMapping("/index")
public class InscriptionController {

	@Autowired
	UserManagerService userManagerService;

	@GetMapping("/inscription")
	public String inscription(Model model) {
		return "inscription";
	}

	@PostMapping("/inscription")
	public String save(String login, RedirectAttributes attr) {
		System.out.println("Hello " + login);
		// TODO faire la sauvegarde de l'utilisateur
		attr.addAttribute("login", login);

		return "redirect:/index/hello"; // Le return me REDIRIGE vers la page index/hello suivie du nom du login entré
	}

	@GetMapping("/hello")
	public String hello(String login, Model model) {
		model.addAttribute("name", login);
		return "hello";

	}

	@GetMapping("/formulaire")
	public String formulaire(Model model) {
		return "formulaire";
	}

	/* @Valid pour vérifier que les données demandées dans l'objet User sont là
	En l'occurence, vérif que pwd est de taille 1 mini
	
	Du coup besoin aussi du BindingResust en attribut
	et une condition si y'a une erreur
	
	*/
	@PostMapping("/formulaire") 
	public String saveLogin(@Valid User user, BindingResult bindingResult, RedirectAttributes attr) {
		System.out.println("donnée recup " + user.getLogin() + user.getPwd());

		if (bindingResult.hasErrors()) {
			return "formulaire";}
		
		User savedUser = userManagerService.signup(user.getLogin(), user.getPwd());
		attr.addAttribute("login", savedUser.getLogin());
		System.out.println("user enregistré: " + savedUser.getLogin() + ", pass: " + savedUser.getPwd() + ", id :"
				+ savedUser.getId());
		return "redirect:/index/confirmationInscription" ;

	}
	
	@GetMapping("/confirmationInscription")
	public String confirm (String login, Model model) {
		model.addAttribute("name", login);
		return "confirmationInscription";

	}
}
