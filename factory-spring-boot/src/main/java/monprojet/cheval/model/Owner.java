package monprojet.cheval.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "owner_tbl")
public class Owner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String prenom;
	private String adresse;
	private String codepostal;
	
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	
	@OneToMany(mappedBy="owner", fetch=FetchType.EAGER)
	private List<CentreEquestre> centreEquestres = new ArrayList<CentreEquestre>();
	

	public Owner() {}
	
	public Owner(String nom, String prenom, String adresse, String codepostal, Date dateDeNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codepostal = codepostal;
		this.dateDeNaissance = dateDeNaissance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public List<CentreEquestre> getCentreEquestres() {
		return centreEquestres;
	}

	public void setCentreEquestres(List<CentreEquestre> centreEquestres) {
		this.centreEquestres = centreEquestres;
	}

}
