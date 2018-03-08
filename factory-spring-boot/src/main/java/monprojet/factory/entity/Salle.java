package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@DiscriminatorValue(value = "Salle")
public class Salle extends Materiel{
	
	@NotNull
	@Column
	@JsonView(View.Common.class)
	private Integer capacite;
/*-----------------------------------------------------------------*/
	@OneToMany(mappedBy = "salle", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonView(View.FormationJSON.class)
	private Set<Formation> formations = new HashSet<Formation>();

	public Salle() {
		super();
	}
	
	public Salle(@Size(min = 3) @NotNull String code, @Size(min = 3) @NotNull String nom, Double coutJournalier,
			@NotNull Integer capacite) {
		super(code, nom, coutJournalier);
		this.capacite = capacite;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
}
