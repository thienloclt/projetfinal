package monprojet.scolaire.validator;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import monprojet.scolaire.entity.Professeur;

public class ProfesseurValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Professeur.class.equals(paramClass);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "nom_rong", "Nom is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "remarque_rong", "prenom is required");
		Professeur professeur = (Professeur) obj;
		
		if(((new GregorianCalendar()).get(Calendar.YEAR) - professeur.getDateDeNaissance().getYear()) < 20)
			errors.rejectValue("annee", "abc", "Anne......");
//		if(professeur.getDateDeNaissance() < 1970 || professeur.getDateDeNaissance() > ) {
//			errors.rejectValue("annee", "abc", "Annee:  >1970 et inferieur � l'ann�e en cours");
//		}
	}
}