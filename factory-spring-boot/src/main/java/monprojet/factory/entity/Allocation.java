package monprojet.factory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@Table(name = "allocation_tbl")
public class Allocation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(View.Common.class)
	private Integer id;
	
	@Version
	private int version;
/*-----------------------------------------------------------------*/
	//@NotNull
	@ManyToOne
	@JoinColumn(name = "formation_id")
	@JsonView(View.FormationJSON.class)
	private Formation formation;
	
	//@NotNull
	@ManyToOne
	@JoinColumn(name = "stagiaire_id")
	@JsonView(View.StagiaireJSON.class)
	private Stagiaire stagiaire;
	
	@ManyToOne
	@JoinColumn(name = "ordinateur_id")
	@JsonView(View.OrdinateurJSON.class)
	private Ordinateur ordinateur;

	public Allocation() {
		super();
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

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}
}
