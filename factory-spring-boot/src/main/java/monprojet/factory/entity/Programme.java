package monprojet.factory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@Table(name = "programme_tbl")
public class Programme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(View.Common.class)
	private Integer id;
	
	@Version
	private int version;
	
	@Column
	@NotNull
	@JsonView(View.Common.class)
	private int duree; //jour
	
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
	
	@Column
	@NotNull
	@JsonView(View.Common.class)
	private int ordre;
/*-----------------------------------------------------------------*/
	@ManyToOne
	@JoinColumn(name = "formation_id")
	@NotNull
	@JsonView(View.FormationJSON.class)
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name = "formateur_id")
	@NotNull
	@JsonView(View.FormateurJSON.class)
	private Formateur formateur;
	
	@ManyToOne
	@JoinColumn(name = "matiere_id")
	@NotNull
	@JsonView(View.MatiereJSON.class)
	private Matiere matiere;

	public Programme() {
		super();
	}

	public Programme(@NotNull int duree, @Size(min = 3) @NotNull String objectif,
			@Size(min = 3) @NotNull String prerequis, @Size(min = 3) @NotNull String contenu, @NotNull int ordre) {
		super();
		this.duree = duree;
		this.objectif = objectif;
		this.prerequis = prerequis;
		this.contenu = contenu;
		this.ordre = ordre;
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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
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

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

}
