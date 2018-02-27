package monprojet.cheval.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Voiture {
	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	private String marque;
	private String model;
	private String serie;
	private int annee;
	private Couleur couleur;

	public Voiture() {
		super();
	}

	public Voiture(String marque, String model, String serie, int annee, Couleur couleur) {
		super();
		this.marque = marque;
		this.model = model;
		this.serie = serie;
		this.annee = annee;
		this.couleur = couleur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

}
