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

	public Programme(@NotNull int ordre) {
		super();
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

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

}
