package monprojet.scolaire.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "salle_tbl")
public class Salle {

	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	private String nom;
	
	private Integer capacite;

	@ManyToMany(fetch=FetchType.EAGER)
	private List<Matiere> matieres = new ArrayList<Matiere>();

	public Salle() {
		super();
	}

	public Salle(String nom, Integer capacite, List<Matiere> matieres) {
		super();
		this.nom = nom;
		this.capacite = capacite;
		this.matieres = matieres;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", version=" + version + ", nom=" + nom + ", capacite=" + capacite + ", matieres="
				+ matieres + "]";
	}
	
	
	
}
