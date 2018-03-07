package monprojet.factory.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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
@DiscriminatorValue(value = "Formateur")
public class Formateur extends Personne {
	
	@Size(min = 3)
	@NotNull
	@Column
	@JsonView(View.Common.class)
	private String competence;
	
	@Size(min = 3)
	@NotNull
	@Column
	@JsonView(View.Common.class)
	private String titre;
	/*-----------------------------------------------------------------------------------*/
	@OneToMany(mappedBy = "formateur", fetch = FetchType.EAGER)
	@JsonView(View.ProgrammeJSON.class)
	private Set<Programme> programmes = new HashSet<Programme>();
	
	@OneToMany(mappedBy = "formateur", fetch = FetchType.EAGER)
	@JsonView(View.EnseignementJSON.class)
	private Set<Enseignement> enseignements = new HashSet<Enseignement>();

	public Formateur() {
		super();
	}
	
	public Formateur(@Size(min = 3) @NotNull String nom, @Size(min = 3) @NotNull String prenom, Date dateNaissance,
			String adresse, @Email String email, String numTel, @Size(min = 3) @NotNull String competence, @Size(min = 3) @NotNull String titre) {
		super(nom, prenom, dateNaissance, adresse, email, numTel);
		this.competence = competence;
		this.titre = titre;
	}

	public String getCompetence() {
		return competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	public Set<Programme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(Set<Programme> programmes) {
		this.programmes = programmes;
	}

	public Set<Enseignement> getEnseignements() {
		return enseignements;
	}

	public void setEnseignements(Set<Enseignement> enseignements) {
		this.enseignements = enseignements;
	}

}
