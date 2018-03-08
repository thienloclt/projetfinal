package monprojet.factory.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@DiscriminatorValue(value = "Gestionnaire")
public class Gestionnaire extends Personne {
	
	@OneToMany(mappedBy = "gestionnaire", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonView(View.FormationJSON.class)
	private Set<Formation> formations = new HashSet<Formation>();

	public Gestionnaire() {
		super();
	}
	
	public Gestionnaire(@Size(min = 3) @NotNull String nom, @Size(min = 3) @NotNull String prenom, Date dateNaissance,
			String adresse, @Email String email, String numTel) {
		super(nom, prenom, dateNaissance, adresse, email, numTel);
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
	
}
