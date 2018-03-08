package monprojet.factory.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue(value = "Technicien")
public class Technicien extends Personne {
	
	public Technicien() {
		super();
	}

	public Technicien(@Size(min = 3) @NotNull String nom, @Size(min = 3) @NotNull String prenom, Date dateNaissance,
			String adresse, @Email String email, String numTel) {
		super(nom, prenom, dateNaissance, adresse, email, numTel);
	}
}
