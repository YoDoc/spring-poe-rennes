package poe.spring.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.api.dto.ProposerUnTrajetDTO;
import poe.spring.domain.Trajet;
import poe.spring.repository.TrajetRepository;
import poe.spring.service.TrajetManagerService;

@RestController
@RequestMapping("/api/trajet") // je crée/déclare cette url qui sera affiché à l'appel
public class TrajetRestControlleur {

	@Autowired
	TrajetManagerService trajetManagerService;

	@Autowired
	private TrajetRepository trajetRepository;

	// Creer un trajet DTO, temporaire, rendu obligatoire par le besoin de l'ID
	// conducteur en attribut
	@PostMapping
	public Trajet save(@RequestBody ProposerUnTrajetDTO nouveauTrajetDTO) throws Exception {
		Trajet nouveauTrajet = trajetManagerService.creationRest(nouveauTrajetDTO.getConducteurId(),
				nouveauTrajetDTO.getVilleDepart(), nouveauTrajetDTO.getVilleArrivee(), nouveauTrajetDTO.getDateDepart(),
				nouveauTrajetDTO.getPrixTrajet(), nouveauTrajetDTO.getNbPlaces());
		return nouveauTrajet;
	}

	// Lister tous les trajets
	@GetMapping("/list")
	public List<Trajet> lister() {
		List<Trajet> listeTrajet = trajetManagerService.lister();
		return listeTrajet;
	}

	// Rechercher un Trajet par Id
	@GetMapping("/{trajetId}")
	public Trajet visualiserTrajet(@PathVariable("trajetId") Long trajetId, HttpServletResponse response) {
		System.out.println("entree RestController du Trajet");
		Trajet trajet = trajetManagerService.visualiserTrajet(trajetId);
		System.out.println("Sortie RestController du Trajet");
		return trajet;
	}

	// Recherche de trajets par ville de depart/arrivee
	@GetMapping("/search/{ville}")
	public List<Trajet> searchByVille(@PathVariable("ville") String ville) {
		
		//List <Trajet> trajetVilleDepart = trajetRepository.findByVilleDepartLike(ville + '%');
		//List <Trajet> trajetVilleArrivee = trajetRepository.findByVilleArriveeLike(ville + '%');
		
		List <Trajet> trajets = new ArrayList<>();
		trajets.addAll(trajetRepository.findByVilleDepartLike(ville + '%'));
		trajets.addAll(trajetRepository.findByVilleArriveeLike(ville + '%'));


		return trajets;
	}

	
}
