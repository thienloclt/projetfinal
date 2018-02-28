package monprojet.factory.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Projecteur")
public class Projecteur extends Materiel {
	
	public Projecteur() {
		super();
	}
}
