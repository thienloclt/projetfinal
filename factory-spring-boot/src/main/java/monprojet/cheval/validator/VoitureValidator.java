package monprojet.cheval.validator;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import monprojet.cheval.model.Voiture;

public class VoitureValidator implements Validator {
	// which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Voiture.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Voiture voiture = (Voiture) obj;
		if (voiture.getMarque().length() < 5 || voiture.getMarque().length() > 20) {
			errors.rejectValue("marque", "abc", "Marque: entre 5 et 20car");
		}
		
		if (voiture.getModel().length() < 3 || voiture.getModel().length() > 20) {
			errors.rejectValue("model", "abc", "Model: entre 3 et 20car");
		}
		
        Matcher matcher = (Pattern.compile("^[a-zA-Z]{2}+\\d{3}")).matcher(voiture.getSerie());
        if(!matcher.matches())
			errors.rejectValue("serie", "abc", "Serie: 2 caractere puis 3 chiffre");
		
		if(voiture.getAnnee() < 1970 || voiture.getAnnee() > (new GregorianCalendar()).get(Calendar.YEAR)) {
			errors.rejectValue("annee", "abc", "Annee:  >1970 et inferieur � l'ann�e en cours");
		}
	}
}