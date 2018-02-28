package monprojet.factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Technicien")
public class Technicien extends Personne {
	
	public Technicien() {
		super();
	}
}
