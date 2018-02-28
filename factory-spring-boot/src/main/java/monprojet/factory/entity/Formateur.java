package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@DiscriminatorValue(value = "Formateur")
public class Formateur extends Personne {
	
	@ManyToMany(mappedBy = "formateurs", fetch = FetchType.EAGER)
	@JsonView(View.FormationJSON.class)
	private Set<Formation> formations = new HashSet<Formation>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "formateur_matiere_tbl", joinColumns = @JoinColumn(name = "formateur_id"), inverseJoinColumns = @JoinColumn(name = "matiere_id"))
	@NotNull
	@JsonView(View.MatiereJSON.class)
	private Set<Matiere> matieres = new HashSet<Matiere>();

	public Formateur() {
		super();
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}
}
