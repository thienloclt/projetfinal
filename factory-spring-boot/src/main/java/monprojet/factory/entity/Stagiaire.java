package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@DiscriminatorValue(value = "Stagiaire")
public class Stagiaire extends Personne {
	
	@ManyToMany(mappedBy = "stagiaires", fetch = FetchType.EAGER)
	@JsonView(View.FormationJSON.class)
	private Set<Formation> formations = new HashSet<Formation>();
	
	@ManyToOne
	@JoinColumn(name = "ordinateur_id")
	@JsonView(View.OrdinateurJSON.class)
	private Ordinateur ordinateur;

	public Stagiaire() {
		super();
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}
	
}
