package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@DiscriminatorValue(value = "Projecteur")
public class Projecteur extends Materiel {
	
	@OneToMany(mappedBy = "projecteur", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonView(View.FormationJSON.class)
	private Set<Formation> formations = new HashSet<Formation>();
	
	public Projecteur() {
		super();
	}
	
	public Projecteur(@Size(min = 3) @NotNull String code, @Size(min = 3) @NotNull String nom, Double coutJournalier) {
		super(code, nom, coutJournalier);
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
	
}
