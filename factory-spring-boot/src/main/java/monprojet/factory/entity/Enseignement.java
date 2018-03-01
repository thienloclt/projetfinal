package monprojet.factory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.factory.entity.enumeration.Niveau;
import monprojet.framework.model.View;

@Entity
@Table(name = "enseignement_tbl")
public class Enseignement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(View.Common.class)
	private Integer id;
	
	@Version
	private int version;
	
	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
/*-----------------------------------------------------------------*/
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

	public Enseignement() {
		super();
	}

	public Enseignement(@NotNull Niveau niveau) {
		super();
		this.niveau = niveau;
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

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
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
