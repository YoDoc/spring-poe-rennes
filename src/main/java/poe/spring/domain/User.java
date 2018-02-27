package poe.spring.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id @GeneratedValue
	private long id;
	private String login;
	@Size(min=1)
	private String pwd;
	
	@OneToMany(mappedBy="conducteur")
	private List<Trajet> trajets = new ArrayList<>();
	
	public List<Trajet> getTrajets() {
		return trajets;
	}
	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
