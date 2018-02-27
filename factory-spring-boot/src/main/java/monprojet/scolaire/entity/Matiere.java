package monprojet.scolaire.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "matiere_tbl")
public class Matiere {
	
	@Id
	@GeneratedValue
	private Long id;

	@Version
	private int version;

	private String nom;
	
	@Enumerated(EnumType.STRING)
	private Couleur couleur;

	@ManyToMany(mappedBy="matieres", fetch=FetchType.EAGER)
	private Set<Salle> salles = new HashSet<Salle>();

	@ManyToMany(mappedBy = "matieres", fetch = FetchType.EAGER)
	private Set<Professeur> professeurs = new HashSet<>();

	public Matiere() {
		super();
	}

	public Matiere(String nom, Couleur couleur) {
		super();
		this.nom = nom;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", version=" + version + ", nom=" + nom + ", couleur=" + couleur + "]";
	}

	public Set<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(Set<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	public Set<Salle> getSalles() {
		return salles;
	}

	public void setSalles(Set<Salle> salles) {
		this.salles = salles;
	}
}
