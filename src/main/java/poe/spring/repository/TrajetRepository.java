package poe.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import poe.spring.domain.Trajet;

public interface TrajetRepository extends CrudRepository <Trajet, Long>{

	// Methode simple de recherche, au plus près de l'objet
	public List<Trajet> findByVilleDepartLike (String VilleDepart);
	
	public List<Trajet> findByVilleArriveeLike (String VilleArrivee);
	
}
