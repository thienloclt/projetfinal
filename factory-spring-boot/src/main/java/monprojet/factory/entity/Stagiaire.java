package monprojet.factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Stagiaire")
public class Stagiaire extends Personne {
	
//	@JsonView(View.Common.class)
//	private String nom;
//	
//	@JsonView(View.Common.class)
//	private String remarque;

//	@ManyToOne
//	@JoinColumn(name = "centreEquestre_id")
//	@JsonView(View.CentreEquestre.class)
//	private CentreEquestre centreEquestre;
//
//	@OneToOne
//	@JoinColumn(name = "registre_id")
//	private Registre registre;

	public Stagiaire() {
		super();
	}
}
