package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@DiscriminatorValue(value = "Ordinateur")
public class Ordinateur extends Materiel {
	
	@OneToMany(mappedBy = "ordinateur", fetch = FetchType.EAGER)
	@JsonView(View.StagiaireJSON.class)
	private Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();
	
	public Ordinateur() {
		super();
	}

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	
}
