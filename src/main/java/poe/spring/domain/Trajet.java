package poe.spring.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trajet {

	@Id @GeneratedValue
	private long id;
	private String villeDepart;
	private String villeArrivee;
	private Date dateDepart;
	private int prixTrajet;
	private int nbPlaces;
	
	@ManyToOne
	@JsonIgnore // sinon un get user t'emmene dans trajet qui t'emmene ici, ou il va rechercher un user.... boucle infinie
	
	private User conducteur;
	
	public User getConducteur() {
		return conducteur;
	}
	public void setConducteur(User conducteur) {
		this.conducteur = conducteur;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	
	public int getPrixTrajet() {
		return prixTrajet;
	}
	public void setPrixTrajet(int prixTrajet) {
		this.prixTrajet = prixTrajet;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	
	
}
