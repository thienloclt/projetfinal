package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.factory.entity.enumeration.Couleur;
import monprojet.framework.model.View;

@Entity
@Table(name = "matiere_tbl")
public class Matiere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(View.Common.class)
	private Long id;

	@Version
	private int version;
	
	@Column
	@Size(min = 2)
	@NotNull
	@JsonView(View.Common.class)
	private String nom;
	
	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private Couleur couleur;
	
	@ManyToMany(mappedBy = "matieres", fetch = FetchType.EAGER)
	@JsonView(View.FormationJSON.class)
	private Set<Formation> formations = new HashSet<Formation>();
	
	@ManyToMany(mappedBy = "matieres", fetch = FetchType.EAGER)
	@JsonView(View.FormateurJSON.class)
	private Set<Formateur> formateurs = new HashSet<Formateur>();

	public Matiere() {
		super();
	}
	
	public Matiere(@Size(min = 2) @NotNull String nom, @NotNull Couleur couleur) {
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

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public Set<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(Set<Formateur> formateurs) {
		this.formateurs = formateurs;
	}
	
}
