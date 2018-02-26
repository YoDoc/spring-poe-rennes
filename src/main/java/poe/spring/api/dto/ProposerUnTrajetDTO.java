package poe.spring.api.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;


public class ProposerUnTrajetDTO {
	private long id;
	private String villeDepart;
	private String villeArrivee;
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date dateDepart;
	private int prixTrajet;
	private int nbPlaces;
	private long conducteurId;
	
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
	public long getConducteurId() {
		return conducteurId;
	}
	public void setConducteurId(long conducteurId) {
		this.conducteurId = conducteurId;
	}
	
}
