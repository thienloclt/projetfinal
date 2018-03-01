package monprojet.factory.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import monprojet.framework.model.View;

@Entity
@DiscriminatorValue(value = "Ordinateur")
public class Ordinateur extends Materiel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonView(View.Common.class)
	private Integer id;

	@Version
	private int version;
	
	@Column
	@JsonView(View.Common.class)
	private String processeur;
	
	@Column
	@JsonView(View.Common.class)
	private String ram;
	
	@Column
	@JsonView(View.Common.class)
	private String disqueDur;
	
	@Column
	@JsonView(View.Common.class)
	private int anneeAchat;
/*--------------------------------------------------------------------------*/
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
