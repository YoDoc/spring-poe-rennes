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

import poe.spring.domain.Trajet;
import poe.spring.form.TrajetForm;
import poe.spring.service.TrajetManagerService;

@Controller
@RequestMapping("/index")
public class TrajetControlleur {

	@Autowired
	TrajetManagerService trajetManagerService;
	
	@GetMapping("/nouveauTrajet")
	public String formulaire(Model model) {
		return "nouveauTrajet";
	}
	
	@PostMapping("/nouveauTrajet") 
	public String proposerTrajet(@Valid TrajetForm trajetForm, BindingResult bindRes, RedirectAttributes attr) throws Exception {

		Trajet nouveauTrajet = trajetManagerService.creation(
				trajetForm.getUserId(), trajetForm.getVilleDepart(), 
				trajetForm.getVilleArrivee(), trajetForm.getDateDepart(), 
				trajetForm.getPrixTrajet(), trajetForm.getNbPlaces());
		
		System.out.println("Trajet enregistré: \n id: "+nouveauTrajet.getId()+"\n Ville départ: " + nouveauTrajet.getVilleDepart() +
				"\n ville arrivée: "+ nouveauTrajet.getVilleArrivee() + "\n nb places: "+ nouveauTrajet.getNbPlaces()+ 
				"\n prix: "+ nouveauTrajet.getPrixTrajet() + "\n");
		return "trajetValide" ;

	}
	
	
	
	@GetMapping("/trajetValide")
	public String validation() {
		return "trajetValide";

	}
}















