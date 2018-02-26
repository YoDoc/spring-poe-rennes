package poe.spring.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import poe.spring.domain.User;

public class TrajetForm {
	private String villeDepart;
	private String villeArrivee;
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date dateDepart;
	private int prixTrajet;
	private int nbPlaces;
	private long userId;
		
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
