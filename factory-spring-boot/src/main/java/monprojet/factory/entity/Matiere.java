package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@Table(name = "matiere_tbl")
public class Matiere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(View.Common.class)
	private Integer id;

	@Version
	private int version;
	
	@Column
	@Size(min = 2)
	@NotNull
	@JsonView(View.Common.class)
	private String nom;
	
	@Column
	@NotNull
	@JsonView(View.Common.class)
	private @NotNull String couleur;
	
	@Column
	@NotNull
	@JsonView(View.Common.class)
	private Integer duree; //jour
	
	@Column
	@Size(min = 3)
	@NotNull
	@JsonView(View.Common.class)
	private String objectif;
	
	@Column
	@Size(min = 3)
	@NotNull
	@JsonView(View.Common.class)
	private String prerequis;
	
	@Column
	@Size(min = 3)
	@NotNull
	@JsonView(View.Common.class)
	private String contenu;
/*-----------------------------------------------------------------*/
	@OneToMany(mappedBy = "matiere", fetch = FetchType.EAGER)
	@JsonView(View.ProgrammeJSON.class)
	private Set<Programme> programmes = new HashSet<Programme>();
	
	@OneToMany(mappedBy = "matiere", fetch = FetchType.EAGER)
	@JsonView(View.EnseignementJSON.class)
	private Set<Enseignement> enseignements = new HashSet<Enseignement>();

	public Matiere() {
		super();
	}

	public Matiere(@Size(min = 2) @NotNull String nom, @NotNull String couleur, @NotNull Integer duree,
			@Size(min = 3) @NotNull String objectif, @Size(min = 3) @NotNull String prerequis,
			@Size(min = 3) @NotNull String contenu) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.duree = duree;
		this.objectif = objectif;
		this.prerequis = prerequis;
		this.contenu = contenu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Set<Programme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(Set<Programme> programmes) {
		this.programmes = programmes;
	}

	public Set<Enseignement> getEnseignements() {
		return enseignements;
	}

	public void setEnseignements(Set<Enseignement> enseignements) {
		this.enseignements = enseignements;
	}
	
}
